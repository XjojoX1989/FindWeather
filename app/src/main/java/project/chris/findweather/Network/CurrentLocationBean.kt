package project.chris.findweather.Network

/**
 * Created by chris on 2019/2/5.
 */
class CurrentLocationBean {
    /**
     * coord : {"lon":121.56,"lat":25.04}
     * weather : [{"id":300,"main":"Drizzle","description":"light intensity drizzle","icon":"09n"}]
     * base : stations
     * main : {"temp":290.15,"pressure":1024,"humidity":93,"temp_min":290.15,"temp_max":290.15}
     * visibility : 10000
     * wind : {"speed":9.8,"deg":50}
     * clouds : {"all":75}
     * dt : 1549906200
     * sys : {"type":1,"id":7950,"message":0.0044,"country":"TW","sunrise":1549837852,"sunset":1549878325}
     * id : 1668341
     * name : Taipei
     * cod : 200
     */
//    coord
//    coord.lon 城市地理位置，經度
//    coord.lat 城市地理位置，緯度
//    weather （更多信息天氣狀況代碼）
//    weather.id 天氣狀況id
//    weather.main 一組天氣參數（雨，雪，極端等）
//    weather.description 集團內的天氣狀況
//    weather.icon 天氣圖標ID
//    base 內部參數
//    main
//    main.temp溫度。單位默認值：開爾文，公制：攝氏度，英制：華氏度。
//    main.pressure 大氣壓力（在海平面，如果沒有sea_level或grnd_level數據），hPa
//    main.humidity 濕度，％
//    main.temp_min目前的最低溫度。這是大城市和地理位置擴展的特大城市可能的當前溫度的偏差（可選地使用這些參數）。單位默認值：開爾文，公制：攝氏度，英制：華氏度。
//    main.temp_max目前的最高溫度。這是大城市和地理位置擴展的特大城市可能的當前溫度的偏差（可選地使用這些參數）。單位默認值：開爾文，公制：攝氏度，英制：華氏度。
//    main.sea_level 海平面上的大氣壓力，hPa
//    main.grnd_level 地面上的大氣壓力，hPa
//    wind
//    wind.speed風速。單位默認值：米/秒，公制：米/秒，英制：英里/小時。
//    wind.deg 風向，度（氣象）
//    clouds
//    clouds.all 雲量，％
//    rain
//    rain.1h 最後1小時的雨量，mm
//    rain.3h 最近3小時的雨量，毫米
//    snow
//    snow.1h 雪量為最後1小時，mm
//    snow.3h 雪量最近3小時，mm
//    dt 數據計算時間，unix，UTC
//    sys
//    sys.type 內部參數
//    sys.id 內部參數
//    sys.message 內部參數
//    sys.country 國家代碼（GB，JP等）
//    sys.sunrise 日出時間，unix，UTC
//    sys.sunset 日落時間，unix，UTC
//    id 城市ID
//    name 城市名稱
//    cod 內部參數
    private var coord: CoordBean? = null
    private var base: String? = null
    private var main: MainBean? = null
    private var visibility: Int = 0
    private var wind: WindBean? = null
    private var clouds: CloudsBean? = null
    private var dt: Int = 0
    private var sys: SysBean? = null
    private var id: Int = 0
    private var name: String? = null
    private var cod: Int = 0
    private var weather: List<WeatherBean>? = null

    fun getCoord(): CoordBean? {
        return coord
    }

    fun setCoord(coord: CoordBean) {
        this.coord = coord
    }

    fun getBase(): String? {
        return base
    }

    fun setBase(base: String) {
        this.base = base
    }

    fun getMain(): MainBean? {
        return main
    }

    fun setMain(main: MainBean) {
        this.main = main
    }

    fun getVisibility(): Int {
        return visibility
    }

    fun setVisibility(visibility: Int) {
        this.visibility = visibility
    }

    fun getWind(): WindBean? {
        return wind
    }

    fun setWind(wind: WindBean) {
        this.wind = wind
    }

    fun getClouds(): CloudsBean? {
        return clouds
    }

    fun setClouds(clouds: CloudsBean) {
        this.clouds = clouds
    }

    fun getDt(): Int {
        return dt
    }

    fun setDt(dt: Int) {
        this.dt = dt
    }

    fun getSys(): SysBean? {
        return sys
    }

    fun setSys(sys: SysBean) {
        this.sys = sys
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getCod(): Int {
        return cod
    }

    fun setCod(cod: Int) {
        this.cod = cod
    }

    fun getWeather(): List<WeatherBean>? {
        return weather
    }

    fun setWeather(weather: List<WeatherBean>) {
        this.weather = weather
    }

    inner class CoordBean {
        /**
         * lon : 121.56
         * lat : 25.04
         */

        var lon: Double = 0.toDouble()
        var lat: Double = 0.toDouble()
    }

    inner class MainBean {
        /**
         * temp : 290.15
         * pressure : 1024
         * humidity : 93
         * temp_min : 290.15
         * temp_max : 290.15
         */

        var temp: Double = 0.toDouble()
        var pressure: Int = 0
        var humidity: Int = 0
        var temp_min: Double = 0.toDouble()
        var temp_max: Double = 0.toDouble()
    }

    inner class WindBean {
        /**
         * speed : 9.8
         * deg : 50
         */

        var speed: Double = 0.toDouble()
        var deg: Int = 0
    }

    inner class CloudsBean {
        /**
         * all : 75
         */

        var all: Int = 0
    }

    inner class SysBean {
        /**
         * type : 1
         * id : 7950
         * message : 0.0044
         * country : TW
         * sunrise : 1549837852
         * sunset : 1549878325
         */

        var type: Int = 0
        var id: Int = 0
        var message: Double = 0.toDouble()
        var country: String? = null
        var sunrise: Int = 0
        var sunset: Int = 0
    }

    inner class WeatherBean {
        /**
         * id : 300
         * main : Drizzle
         * description : light intensity drizzle
         * icon : 09n
         */

        var id: Int = 0
        var main: String? = null
        var description: String? = null
        var icon: String? = null
    }


}