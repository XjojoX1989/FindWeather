package project.chris.findweather.Network

import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.Request
import project.chris.findweather.Constants
import java.io.IOException

/**
 * Created by chris on 2019/2/4.
 */

val okHttpClient: OkHttpClient = OkHttpClient()

//一般天氣預報-今明 36 小時天氣預報"
val GET_THIRTY_SIX_HOUR_CITY_DATA = "/v1/rest/datastore/F-C0032-001?"

object WeatherAPIManager : BaseAPIManager() {


    private fun generateRequest(apiUrl: String): Request {
        return Request.Builder().url(apiUrl).build()
    }

    fun getThirtySixHourCityData(): Result<ThirtySixHourCityBean> {
        val result = Result<ThirtySixHourCityBean>()
        val url = Constants.genHttpsBaseApiUrl(GET_THIRTY_SIX_HOUR_CITY_DATA)
        val response = okHttpClient.newCall(generateRequest(url)).execute().body().string()
        val thirtySixHourCityBean = parser(response, ThirtySixHourCityBean::class.java)
        if (thirtySixHourCityBean != null) {
            result.isSuccess = true
            result.resultBean = thirtySixHourCityBean
        } else {
            result.isSuccess = false
            result.resultBean = null
        }
        return result
    }

}