package project.chris.findweather.MVP

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.gps_weather_fragment.*
import project.chris.findweather.Constants
import project.chris.findweather.MVP.presenter.WeatherDetailPresenter
import project.chris.findweather.MVP.view.WeatherDetailView
import project.chris.findweather.Network.CurrentLocationBean
import project.chris.findweather.Network.FiveDaysThreeHoursBean
import project.chris.findweather.R
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by chris on 2019/2/12.
 */
class GPSWeatherDetailFragment : Fragment(), WeatherDetailView {

    private lateinit var presenter: WeatherDetailPresenter

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

    private var address: String = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = WeatherDetailPresenter(this, activity)
        val lat = arguments.getString(Constants.LATITUDE)
        val lon = arguments.getString(Constants.LONGITUDE)
        address = arguments.getString(Constants.ADDRESS)
        presenter.getCurrentLocationWeatherFromAPI(lat, lon)
        presenter.getFiveDaysWeatherFromAPI(lat, lon)
        return inflater.inflate(R.layout.gps_weather_fragment, null)
    }

    @SuppressLint("SetTextI18n")
    override fun onCurrentLocationDataReceived(result: CurrentLocationBean?) {
        if (result != null) {
            tvLocation.text = address
            tvUpdateDate.text = millisecondsToTimeFormat(result.getDt() * 1000.toLong(), "YYYY-MM-dd")
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