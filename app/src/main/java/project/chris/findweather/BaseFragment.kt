package project.chris.findweather

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.text.TextUtils
import android.widget.LinearLayout
import java.util.*
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
import project.chris.findweather.MVP.GPSWeatherDetailFragment
import project.chris.findweather.MVP.view.DesignatedCityFragment


@Suppress("IMPLICIT_CAST_TO_ANY")
class BaseFragment : Fragment(), LocationStatus {


    private lateinit var mPagerAdapter: WeatherViewPagerAdapter
    private lateinit var mViewPager: ViewPager
    private lateinit var mLinearLayout: LinearLayout
    private var locationStatus = this
    private var mFragmentList: ArrayList<HashMap<String, Any>>? = null
    private val FRAGMENT_TAG = "fragment_tag"
    private val UUID_TAG = "uuid_tag"
    private val TAB_TAG = "tab_tag"
    private var district = ""
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    var googleApiClient: GoogleApiClient? = null
    var address: MutableList<Address>? = null
    override fun onLocationReady(location: Location, address: MutableList<Address>) {
        initialization(location, address)
        if (mPagerAdapter.count > 0) {
            set(0)
        }
    }

    private fun showNoGPSAlert() {
        val builder = AlertDialog.Builder(mContext)
        builder.setMessage("偵測不到定位，是否開啟GPS?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    startActivity(Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.cancel()
                }
        val alert = builder.create()
        alert.show()
    }

    val connectionCallback = object : GoogleApiClient.ConnectionCallbacks {
        override fun onConnected(p0: Bundle?) {
            requestPermission()
        }

        override fun onConnectionSuspended(p0: Int) {
            Log.i("＊＊＊", "Connection Suspended")
            if (googleApiClient != null)
                googleApiClient!!.connect()
        }
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val hasPermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mActivity.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            } else {
                //do nothing
            }
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        SystemPermissionCheckTool.MY_PERMISSIONS_ACCESS_FINE_LOCATION)
                return
            }
        }
        processLocation()
    }

    var lastLocation: Location? = null
    @SuppressLint("MissingPermission")
    private fun processLocation() {
        if (lastLocation == null) {
            lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient)
            if (lastLocation != null) {
                val geoCoder = Geocoder(mContext, Locale.TRADITIONAL_CHINESE)
                val address = geoCoder.getFromLocation(lastLocation!!.latitude, lastLocation!!.longitude, 1)
                this.address = address
                locationStatus.onLocationReady(lastLocation!!, address)
            } else
                showNoGPSAlert()
        }
    }

    private val onConnectionFailedListener = GoogleApiClient.OnConnectionFailedListener { result ->
        Log.i("＊＊＊", "Connection failed: ConnectionResult.getErrorCode() = " + result.errorCode)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == SystemPermissionCheckTool.MY_PERMISSIONS_ACCESS_FINE_LOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                processLocation()
            else
                showNoGPSAlert()
        } else
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = context
        mActivity = activity
        setHasOptionsMenu(true)
        mFragmentList = ArrayList<HashMap<String, Any>>()
    }

    private fun initialGoogleApiClient() {
        if (googleApiClient == null) {
            googleApiClient = GoogleApiClient.Builder(mContext)
                    .addConnectionCallbacks(connectionCallback)
                    .addOnConnectionFailedListener(onConnectionFailedListener)
                    .addApi(LocationServices.API)
                    .build()
        }
    }

    override fun onStart() {
        super.onStart()
        if (googleApiClient != null)
            googleApiClient!!.connect()
    }

    override fun onStop() {
        super.onStop()
        if (googleApiClient != null && googleApiClient!!.isConnected)
            googleApiClient!!.disconnect()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e("＊＊＊", "onCreateView start")
        val mView = inflater.inflate(R.layout.base_fragment, null)
        mViewPager = mView.findViewById(R.id.vpContainer)
        mLinearLayout = mView.findViewById(R.id.llIndicator)
        mPagerAdapter = WeatherViewPagerAdapter(fragmentManager, mFragmentList!!)
        mViewPager.adapter = mPagerAdapter
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                set(position)
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

        initialGoogleApiClient()
        Log.e("＊＊＊", "onCreateView end")
        return mView
    }

    private fun initialization(location: Location, address: MutableList<Address>) {
        addView(GPSWeatherDetailFragment.newInstance(
                location.latitude.toString(),
                location.longitude.toString(),
                address[0].getAddressLine(0))
                , loadIndicatorView(address[0].locality))
        mPagerAdapter.notifyDataSetChanged()
    }

    private fun addView(fragment: Fragment, indicatorView: View) {
        val map = HashMap<String, Any>()
        val uuid = UUID.randomUUID()
        map[UUID_TAG] = uuid

        map[FRAGMENT_TAG] = fragment

        indicatorView.setBackgroundColor(Color.GRAY)
        indicatorView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        indicatorView.tag = uuid
        mLinearLayout.addView(indicatorView)
        indicatorView.setOnClickListener {
            setIndicatorViewSelected(it)
        }

        map[TAB_TAG] = indicatorView
        mFragmentList!!.add(map)
    }

    private fun setIndicatorViewSelected(v: View) {
        val uuid = v.tag as UUID

        for (i in 0 until mFragmentList!!.size) {
            val map = mFragmentList!!.get(i)
            if (uuid === map[UUID_TAG]) {
                set(i)
            }
        }

    }

    fun set(position: Int) {
        mViewPager.setCurrentItem(position, true)
        setIndicatorViewSelectedColor(position)
    }

    private fun setIndicatorViewSelectedColor(position: Int) {
        for (i in 0 until mFragmentList!!.size) {
            val map = mFragmentList!![i]
            val view = map.get(TAB_TAG) as View

            if (i == position)
                view.setBackgroundColor(Color.RED)
            else
                view.setBackgroundColor(Color.GRAY)
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_add -> {
                createSearchDialog()
            }
            R.id.action_dele -> {
                delete(mViewPager.currentItem)
                set(mViewPager.currentItem)
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun createSearchDialog() {
        val searchView = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null)
        AlertDialog.Builder(context)
                .setView(searchView)
                .setPositiveButton("搜尋", DialogInterface.OnClickListener { dialog, which ->
                    val etSearchCity = searchView.findViewById<EditText>(R.id.etSearchCity)
                    val city = etSearchCity.text.toString()
                    if (TextUtils.isEmpty(city))
                        Toast.makeText(context, "請輸入搜尋城市或地區", Toast.LENGTH_SHORT).show();
                    else
                        onActionAdd(city)
                })
                .setNegativeButton("取消", DialogInterface.OnClickListener { dialog, which ->

                })
                .show()
    }

    private fun delete(currentItem: Int) {

        val uuid = mFragmentList!!.get(currentItem).get(UUID_TAG) as UUID
        val view = mLinearLayout.findViewWithTag<View>(uuid)
        mLinearLayout.removeView(view)

        mFragmentList!!.removeAt(currentItem)
        mPagerAdapter.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
    }

    private fun loadIndicatorView(district: String): View {
        val tv = TextView(mContext)
        tv.gravity = Gravity.CENTER
        tv.text = district
        tv.setTextColor(Color.WHITE)
        return tv
    }

    protected fun onActionAdd(city: String) {
        val latLonAddressTriple = getGeoInfoByCityName(city)
        addView(GPSWeatherDetailFragment.newInstance(
                latLonAddressTriple.first, latLonAddressTriple.second, latLonAddressTriple.third), loadIndicatorView(city))
        mPagerAdapter.notifyDataSetChanged()
    }

    private fun getGeoInfoByCityName(city: String): Triple<String, String, String> {
        val gc = Geocoder(context);
        val addresses = gc.getFromLocationName(city, 1); // get the found Address Objects
        return Triple(addresses[0].latitude.toString(), addresses[0].longitude.toString(), addresses[0].getAddressLine(0))

    }

    annotation class inLineFunction
}