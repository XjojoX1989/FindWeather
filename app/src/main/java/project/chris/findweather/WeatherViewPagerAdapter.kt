package project.chris.findweather

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log
import android.view.View
import android.view.ViewGroup

/**
 * Created by chris on 2019/2/5.
 */
class WeatherViewPagerAdapter : FragmentStatePagerAdapter {
    private var mFragmentHashMap: ArrayList<HashMap<String, Any>>

    constructor(fm: FragmentManager?, fragmentHashMap:ArrayList<HashMap<String, Any>>) : super(fm) {
        mFragmentHashMap = fragmentHashMap
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentHashMap[position][Constants.FRAGMENT_TAG] as Fragment
    }

    override fun getItemPosition(`object`: Any?): Int {
        return FragmentPagerAdapter.POSITION_NONE
    }

    override fun getCount(): Int {
        Log.e("＊＊＊ " , mFragmentHashMap.size.toString())
        return if (mFragmentHashMap.size==0)
            1
        else
            mFragmentHashMap.size
    }

}