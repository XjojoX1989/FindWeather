package project.chris.findweather

/**
 * Created by chris on 2019/2/2.
 */
class Constants {
    companion object {
        val HTTPS = "https://"
        val BASE_API_URL = "opendata.cwb.gov.tw/api"
        val API_AUTHORIZATION = "CWB-1037E291-DD11-4922-A949-32452D0CBB8F"

        fun genHttpsBaseApiUrl(requestUrl: String): String {
            return HTTPS + BASE_API_URL + requestUrl + "Authorization=" + API_AUTHORIZATION
        }
    }
}