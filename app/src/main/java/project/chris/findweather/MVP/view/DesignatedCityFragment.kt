package project.chris.findweather.MVP.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import project.chris.findweather.Constants
import project.chris.findweather.MVP.presenter.WeatherDetailPresenter
import project.chris.findweather.R

class DesignatedCityFragment : Fragment() {
    lateinit var presenter: WeatherDetailPresenter

    companion object {
        fun newInstance(city: String): DesignatedCityFragment {
            val fragment = DesignatedCityFragment()
            val bundle = Bundle()
            bundle.putString(Constants.CITY, city)
            fragment.arguments = bundle
            return fragment
        }
    }

    var city: String? = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.gps_weather_fragment, null)
        city = arguments.getString(Constants.CITY)
        return view
    }
}
