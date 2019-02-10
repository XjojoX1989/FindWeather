package project.chris.findweather

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPager
import android.widget.LinearLayout
import java.util.*
import android.support.design.widget.CoordinatorLayout.Behavior.setTag
import android.view.*
import android.widget.TextView
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices


/**
 * Created by chris on 2019/2/5.
 */
class WeatherFragment : Fragment(), GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private lateinit var mPagerAdapter: WeatherViewPagerAdapter
    private lateinit var mViewPager: ViewPager
    private lateinit var mLinearLayout: LinearLayout
    private var mFragmentList: ArrayList<HashMap<String, Any>>? = null
    private val FRAGMENT_TAG = "fragment_tag"
    private val UUID_TAG = "uuid_tag"
    private val TAB_TAG = "tab_tag"

    var googleApiClient: GoogleApiClient? = null
    val REQUEST_LOCATION_PERMISSION = 100

    override fun onConnected(p0: Bundle?) {
//        checkLocationPermission()
    }

    override fun onConnectionSuspended(p0: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        initialGoogleApiClient()
        mFragmentList = ArrayList<HashMap<String, Any>>()
    }

    private fun initialGoogleApiClient() {
        if (googleApiClient == null) {
            googleApiClient = GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
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
        if (googleApiClient != null)
            googleApiClient!!.disconnect()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
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
        initialization()

        if (mPagerAdapter.count > 0) {
            set(0);
        }

        return mView
    }

    private fun initialization() {
        val fragment = Fragment()
        val view = View(context)
        addView(fragment, view)

    }

    private fun addView(fragment: Fragment, indicatorView: View) {
        val map = HashMap<String, Any>()
        val uuid = UUID.randomUUID()
        map[UUID_TAG] = uuid

        val bundle = Bundle()
        fragment.arguments = bundle
        map[FRAGMENT_TAG] = fragment

        indicatorView.setBackgroundColor(Color.GRAY)
        val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 5F)
        indicatorView.tag = uuid
        mLinearLayout.addView(indicatorView, params)
        indicatorView.setOnClickListener {
            setindicatorViewSelected(it)
        }

        map[TAB_TAG] = indicatorView
        mFragmentList!!.add(map)
    }

    private fun setindicatorViewSelected(v: View) {
        val uuid = v.tag as UUID

        for (i in 0 until mFragmentList!!.size) {
            val map = mFragmentList!!.get(i)
            if (uuid === map.get(UUID_TAG)) {
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

    private fun loadIndicatorView(pos: Int): View {
        val tv = TextView(activity)
        tv.gravity = Gravity.CENTER
        tv.text = "Tab $pos"
        return tv
    }

    protected fun onActionAdd() {
        addView(loadFragment(), loadIndicatorView(mPagerAdapter.count))
        mPagerAdapter.notifyDataSetChanged()
    }

    class TestFragment : Fragment() {

        private val seq = Random().nextInt(20)

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            val tv = TextView(activity)

            var str = "Fragment Seq : $seq\n"
            for (i in 0..499)
                str = "$str$i--"
            tv.setTextColor(Color.LTGRAY)
            tv.text = str

            return tv
        }
    }

}