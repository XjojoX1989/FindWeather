package project.chris.findweather.Network

import okhttp3.OkHttpClient
import okhttp3.Request
import project.chris.findweather.Constants.Companion.API_KEY

/**
 * Created by chris on 2019/2/4.
 */

val okHttpClient: OkHttpClient = OkHttpClient()

//經緯度查詢現在天氣
const val Get_Current_Location_Weather = "https://api.openweathermap.org/data/2.5/weather?appid="
const val Get_5Days_3Hours_Weather = "https://api.openweathermap.org/data/2.5/forecast?appid="

object WeatherAPIManager : BaseAPIManager() {


    private fun generateRequest(apiUrl: String): Request {
        return Request.Builder().url(apiUrl).build()
    }

    fun getCurrentLocationWeatherData(latitude: String, longitude: String): Result<CurrentLocationBean> {
        val result = Result<CurrentLocationBean>()

        val url = "$Get_Current_Location_Weather$API_KEY&lat=$latitude&lon=$longitude&units=metric"
        val response = okHttpClient.newCall(generateRequest(url)).execute().body().string()

        val resultBean = parser(response, CurrentLocationBean::class.java)

        if (resultBean != null) {
            result.isSuccess = true
            result.resultBean = resultBean
        } else {
            result.isSuccess = false
            result.resultBean = null
        }
        return result
    }


    fun get5Days3HoursWeatherData(latitude: String, longitude: String): Result<FiveDaysThreeHoursBean> {
        val result = Result<FiveDaysThreeHoursBean>()

        val url = "$Get_5Days_3Hours_Weather$API_KEY&lat=$latitude&lon=$longitude&units=metric"
        val response = okHttpClient.newCall(generateRequest(url)).execute().body().string()

        val resultBean = parser(response, FiveDaysThreeHoursBean::class.java)

        if (resultBean != null) {
            result.isSuccess = true
            result.resultBean = resultBean
        } else {
            result.isSuccess = false
            result.resultBean = null
        }
        return result
    }
}