package project.chris.findweather.MVP

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextClock
import kotlinx.android.synthetic.main.gps_weather_fragment.*
import project.chris.findweather.Constants
import project.chris.findweather.MVP.presenter.WeatherDetailPresenter
import project.chris.findweather.MVP.view.WeatherDetailView
import project.chris.findweather.Network.CurrentLocationBean
import project.chris.findweather.Network.FiveDaysThreeHoursBean
import project.chris.findweather.R
import project.chris.findweather.WeatherBaseFragment
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by chris on 2019/2/12.
 */
class GPSWeatherDetailFragment : WeatherBaseFragment(), WeatherDetailView {
    override fun lazyLoad() {
        if (!isViewVisible)
            return
        startLoadGPSWeatherTask(lat!!, lon!!)
    }

    private lateinit var presenter: WeatherDetailPresenter
    private var address: String? = ""
    private var lat: String? = ""
    private var lon: String? = ""

    companion object {
        fun newInstance(lat: String, lon: String, address: String): GPSWeatherDetailFragment {
            val fragment = GPSWeatherDetailFragment()
            val bundle = Bundle()
            bundle.putString(Constants.LATITUDE, lat)
            bundle.putString(Constants.LONGITUDE, lon)
            bundle.putString(Constants.ADDRESS, address)
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.gps_weather_fragment, null)
        presenter = WeatherDetailPresenter(this, activity, mContext)
        lat = arguments.getString(Constants.LATITUDE)
        lon = arguments.getString(Constants.LONGITUDE)
        address = arguments.getString(Constants.ADDRESS)
        lazyLoad()
        setSwipeRefresh(view)
        setTextClock(view)
        return view
    }

    private fun setTextClock(view: View) {
        (view.findViewById(R.id.textClock) as TextClock).format24Hour = "hh:mm aa"
    }

    private fun startLoadGPSWeatherTask(lat: String, lon: String) {
        if (lat == "" || lon == "")
            return
        presenter.getCurrentLocationWeatherFromAPI(lat, lon)
        presenter.getFiveDaysWeatherFromAPI(lat, lon)
    }

    lateinit var swipeRefresh: SwipeRefreshLayout
    private fun setSwipeRefresh(view: View) {
        swipeRefresh = view.findViewById(R.id.swipeRefresh)
        swipeRefresh.setColorSchemeResources(android.R.color.holo_red_light,
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light)
        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = true
            startLoadGPSWeatherTask(lat!!, lon!!)
        }

    }

    @SuppressLint("SetTextI18n")
    override fun onCurrentLocationDataReceived(result: CurrentLocationBean?, weatherIconId: Int) {
        if (result != null) {
            swipeRefresh.isRefreshing = false
            if(weatherIconId!=0)
                ivCurrentWeather.setImageDrawable(mContext.resources.getDrawable(weatherIconId))
            tvLocation.text = address
            tvUpdateDate.text = millisecondsToTimeFormat(result.getDt() * 1000.toLong(), "yyyy-MM-dd")
            tvCurrentDegree.text = DecimalFormat("#").format(result.getMain()!!.temp) + "°C"
            tvHighLowDegree.text = DecimalFormat("#").format(result.getMain()!!.temp_max + 1.0) + "/" + DecimalFormat("#").format(result.getMain()!!.temp_min - 1.0) + "°C"
            tvBodyDegree.text = calculateTemp(result.getMain()!!.temp, result.getWind()!!.speed)
            tvDescripe.text = result.getWeather()!![0].description
            tvVisibility.text = (result.getVisibility() / 1000).toString() + " km"
            tvPressure.text = result.getMain()!!.pressure.toString() + " hPa"
            tvHumidity.text = result.getMain()!!.humidity.toString() + " %"
            tvWindSpeed.text = result.getWind()!!.speed.toString() + " m/s"
            tvSunrise.text = millisecondsToTimeFormat(result.getSys()!!.sunrise * 1000.toLong(), "hh:mm") + " AM"
            tvSunset.text = millisecondsToTimeFormat(result.getSys()!!.sunset * 1000.toLong(), "hh:mm") + " PM"
        }
    }

    override fun onFiveDaysDataReceived(result: ArrayList<FiveDaysThreeHoursBean.ListBean>?) {
        if (result != null) {
            val adapter = FiveDaysWeatherAdapter(context, result)
            gvFiveDays.adapter = adapter
        }
    }

    private fun calculateTemp(temp: Double, speed: Double): String {
        val speedDouble = (temp - (2 * Math.sqrt(speed)))
        val df = DecimalFormat("#")
        return df.format(speedDouble) + "°C"
    }

    private fun millisecondsToTimeFormat(millisecond: Long, format: String): String {
        val formatter = SimpleDateFormat(format)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = millisecond
        return formatter.format(calendar.time)
    }
}