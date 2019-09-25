package project.chris.findweather

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Created by chris on 2019/2/16.
 */
abstract class WeatherBaseFragment : Fragment() {
    protected var isViewVisible: Boolean = false
    lateinit var mContext: Context
    private var myIsVisibleToUser: Boolean = false
    lateinit var mActivity: Activity

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mContext = context
        mActivity = activity
        myIsVisibleToUser = true
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        isViewVisible = isVisibleToUser
        if (userVisibleHint) {
            isViewVisible = true
            if (myIsVisibleToUser)
                onVisible()
        } else {
            isViewVisible = false
            onInvisible()
        }
    }

    /**
     * 可見
     */
    protected fun onVisible() {
        lazyLoad()
    }

    /**
     * 不可見
     */
    protected fun onInvisible() {


    }

    /**
     * 延遲加載
     */
    protected abstract fun lazyLoad()
}