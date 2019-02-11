package project.chris.findweather

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.widget.LinearLayout
import java.util.*
import android.util.Log
import android.view.*
import android.widget.TextView
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices


/**
 * Created by chris on 2019/2/5.
 */
class WeatherFragment : Fragment(), LocationStatus {


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
    val REQUEST_LOCATION_PERMISSION = 100

    override fun onLocationReady(address: List<Address>) {
        initialization(address[0].locality)
        if (mPagerAdapter.count > 0) {
            set(0)
        }
    }

    @SuppressLint("MissingPermission")
    private fun startLocationTask() {
        val lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient)
        if (lastLocation != null) {
            Log.i("＊＊＊latitude", lastLocation.latitude.toString())
            Log.i("＊＊＊longitude", lastLocation.longitude.toString())
            val geoCoder = Geocoder(mContext, Locale.TRADITIONAL_CHINESE)
            val address = geoCoder.getFromLocation(lastLocation.latitude, lastLocation.longitude, 1)
            locationStatus.onLocationReady(address)

        } else {
            gpsStatusCheck()
        }
    }

    private fun gpsStatusCheck() {
        val locationManager = mActivity.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
            showNoGPSAlert()
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
            if (SystemPermissionCheckTool.checkAccessLocationState(mContext))
                startLocationTask()
            else
                SystemPermissionCheckTool.checkLocationPermission(mContext, mActivity)
        }

        override fun onConnectionSuspended(p0: Int) {
            Log.i("＊＊＊", "Connection Suspended")
            if (googleApiClient != null)
                googleApiClient!!.connect()
        }
    }

    private val onConnectionFailedListener = GoogleApiClient.OnConnectionFailedListener { result ->
        Log.i("＊＊＊", "Connection failed: ConnectionResult.getErrorCode() = " + result.errorCode)
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
        val mView = inflater.inflate(R.layout.viewpager_fragment, null)
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

    private fun initialization(locality: String) {
        val fragment = Fragment()
        addView(fragment, loadIndicatorView(locality))

    }

    private fun addView(fragment: Fragment, indicatorView: View) {
        val map = HashMap<String, Any>()
        val uuid = UUID.randomUUID()
        map[UUID_TAG] = uuid

        val bundle = Bundle()
        fragment.arguments = bundle
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
                onActionAdd()
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

    private fun loadFragment(): Fragment {
        return TestFragment()
    }

    private fun loadIndicatorView(district: String): View {
        val tv = TextView(mContext)

        tv.gravity = Gravity.CENTER
        tv.text = district
        return tv
    }

    protected fun onActionAdd() {
        addView(loadFragment(), loadIndicatorView("測試區"))
        mPagerAdapter.notifyDataSetChanged()
    }

    class TestFragment : Fragment() {

        private val seq = Random().nextInt(20)

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            val tv = TextView(context)

            var str = "Fragment Seq : $seq\n"
            for (i in 0..499)
                str = "$str$i--"
            tv.setTextColor(Color.LTGRAY)
            tv.text = str

            return tv
        }
    }

}