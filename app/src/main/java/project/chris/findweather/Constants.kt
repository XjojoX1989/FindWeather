package project.chris.findweather

/**
 * Created by chris on 2019/2/2.
 */
class Constants {

    companion object {
        const val BASE_API_URL = "https://api.openweathermap.org/data/2.5/weather?"
        const val API_KEY = "a4b3e8dc1f231428a8ab640104fe6961"
        const val FRAGMENT_TAG = "fragment_tag"
        const val LATITUDE = "latitude"
        const val LONGITUDE = "longitude"
        const val ADDRESS = "address"
        const val CITY = "city"
        const val GPS = "gps"

        fun getWeatherConditionIconId(cod: Int): Int {
            when (cod) {
                200, 201, 202, 210, 211, 212, 221, 230, 231, 232 -> {
                    return R.drawable.weather_storm_icon
                }
                300, 301, 302, 310, 311, 312, 313, 314, 321 -> {
                    return R.drawable.weather_drizzle_icon
                }
                500, 501, 502, 503, 504, 511, 520, 521, 522, 531 -> {
                    return R.drawable.weather_showers_rain_icon
                }
                600, 601, 602, 611, 612, 615, 616, 620, 621, 622 -> {
                    return R.drawable.weather_snow_icon
                }
                701, 711, 721, 731, 741, 751, 761, 762, 771, 781 -> {
                    return R.drawable.weather_fog_icon
                }
                800 -> {
                    return R.drawable.weather_sun_icon
                }
                801 -> {
                    return R.drawable.weather_few_clouds_icon
                }
                802, 803, 804 -> {
                    return R.drawable.weather_many_clouds_icon
                }
                else -> {
                    return 0
                }
            }
        }
    }
}