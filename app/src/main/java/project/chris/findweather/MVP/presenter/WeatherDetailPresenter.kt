package project.chris.findweather.MVP.presenter

import android.support.v4.app.FragmentActivity
import project.chris.findweather.MVP.view.WeatherDetailView
import project.chris.findweather.Network.FiveDaysThreeHoursBean
import project.chris.findweather.Network.WeatherAPIManager
import java.util.concurrent.Executors

/**
 * Created by chris on 2019/2/12.
 */
class WeatherDetailPresenter(val view: WeatherDetailView, val activity: FragmentActivity) {

    fun getCurrentLocationWeatherFromAPI(lat: String, lon: String) {
        val executorService = Executors.newSingleThreadExecutor()
        executorService.submit {
            val result = WeatherAPIManager.getCurrentLocationWeatherData(lat, lon)
            activity.runOnUiThread {
                if (result.isSuccess && result.resultBean != null)
                    view.onCurrentLocationDataReceived(result.resultBean)
                else
                    view.onCurrentLocationDataReceived(null)
            }
        }
        executorService.shutdown()
    }

    fun getFiveDaysWeatherFromAPI(lat: String, lon: String) {
        val executorService = Executors.newSingleThreadExecutor()
        executorService.submit {
            val result = WeatherAPIManager.get5Days3HoursWeatherData(lat, lon)
            if (result.isSuccess && result.resultBean != null) {
                val fiveDaysList = sortFiveDifferentDate(result.resultBean!!)
                activity.runOnUiThread {
                    if (fiveDaysList != null && fiveDaysList.size != 0)
                        view.onFiveDaysDataReceived(fiveDaysList)
                    else
                        view.onFiveDaysDataReceived(null)
                }

            }
        }
        executorService.shutdown()
    }

    private fun sortFiveDifferentDate(resultBean: FiveDaysThreeHoursBean): ArrayList<FiveDaysThreeHoursBean.ListBean> {
        resultBean.getList()
        val list = ArrayList<FiveDaysThreeHoursBean.ListBean>()
        for (i in 0 until resultBean.getList()!!.size) {
            if (resultBean.getList()!![i].dt_txt != null && resultBean.getList()!![i].dt_txt!!.contains("12:00"))
                list.add(resultBean.getList()!![i])
        }
        return list
    }
}