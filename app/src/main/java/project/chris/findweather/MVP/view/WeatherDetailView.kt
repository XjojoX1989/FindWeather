package project.chris.findweather.MVP.view

import project.chris.findweather.Network.CurrentLocationBean
import project.chris.findweather.Network.FiveDaysThreeHoursBean

/**
 * Created by chris on 2019/2/12.
 */
interface WeatherDetailView {
    fun onCurrentLocationDataReceived(result: CurrentLocationBean?, weatherIconId: Int = 0)
    fun onFiveDaysDataReceived(result: ArrayList<FiveDaysThreeHoursBean.ListBean>?)
}