package project.chris.findweather.Network

import com.google.gson.annotations.SerializedName

/**
 * Created by chris on 2019/2/12.
 */
class FiveDaysThreeHoursBean {

    /**
     * cod : 200
     * message : 0.008
     * cnt : 40
     * list : [{"dt":1549918800,"main":{"temp":290.71,"temp_min":290.71,"temp_max":290.961,"pressure":1030.67,"sea_level":1039.75,"grnd_level":1030.67,"humidity":100,"temp_kf":-0.25},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":4.36,"deg":54.0008},"rain":{"3h":0.595},"sys":{"pod":"n"},"dt_txt":"2019-02-11 21:00:00"},{"dt":1549929600,"main":{"temp":291.53,"temp_min":291.53,"temp_max":291.693,"pressure":1031.72,"sea_level":1040.79,"grnd_level":1031.72,"humidity":100,"temp_kf":-0.17},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":4.32,"deg":63.0004},"rain":{"3h":0.52},"sys":{"pod":"d"},"dt_txt":"2019-02-12 00:00:00"},{"dt":1549940400,"main":{"temp":292.74,"temp_min":292.74,"temp_max":292.825,"pressure":1031.06,"sea_level":1040.19,"grnd_level":1031.06,"humidity":99,"temp_kf":-0.08},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":80},"wind":{"speed":4.66,"deg":88.5026},"rain":{"3h":0.25},"sys":{"pod":"d"},"dt_txt":"2019-02-12 03:00:00"},{"dt":1549951200,"main":{"temp":293.696,"temp_min":293.696,"temp_max":293.696,"pressure":1028.42,"sea_level":1037.45,"grnd_level":1028.42,"humidity":95,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":76},"wind":{"speed":5.27,"deg":106.002},"rain":{"3h":0.025},"sys":{"pod":"d"},"dt_txt":"2019-02-12 06:00:00"},{"dt":1549962000,"main":{"temp":293.758,"temp_min":293.758,"temp_max":293.758,"pressure":1027.44,"sea_level":1036.41,"grnd_level":1027.44,"humidity":95,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":68},"wind":{"speed":4.77,"deg":120.003},"rain":{"3h":0.03},"sys":{"pod":"d"},"dt_txt":"2019-02-12 09:00:00"},{"dt":1549972800,"main":{"temp":292.66,"temp_min":292.66,"temp_max":292.66,"pressure":1027.25,"sea_level":1036.48,"grnd_level":1027.25,"humidity":97,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":36},"wind":{"speed":3.55,"deg":138.504},"rain":{"3h":0.035},"sys":{"pod":"n"},"dt_txt":"2019-02-12 12:00:00"},{"dt":1549983600,"main":{"temp":291.627,"temp_min":291.627,"temp_max":291.627,"pressure":1027.78,"sea_level":1036.86,"grnd_level":1027.78,"humidity":98,"temp_kf":0},"weather":[{"id":801,"main":"Clouds","description":"few clouds","icon":"02n"}],"clouds":{"all":24},"wind":{"speed":2.67,"deg":197.504},"rain":{},"sys":{"pod":"n"},"dt_txt":"2019-02-12 15:00:00"},{"dt":1549994400,"main":{"temp":290.619,"temp_min":290.619,"temp_max":290.619,"pressure":1027.56,"sea_level":1036.63,"grnd_level":1027.56,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":56},"wind":{"speed":2.88,"deg":283.506},"rain":{"3h":0.055},"sys":{"pod":"n"},"dt_txt":"2019-02-12 18:00:00"},{"dt":1550005200,"main":{"temp":290.116,"temp_min":290.116,"temp_max":290.116,"pressure":1027.78,"sea_level":1036.73,"grnd_level":1027.78,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":68},"wind":{"speed":3.32,"deg":296.006},"rain":{"3h":0.07},"sys":{"pod":"n"},"dt_txt":"2019-02-12 21:00:00"},{"dt":1550016000,"main":{"temp":290.298,"temp_min":290.298,"temp_max":290.298,"pressure":1029.33,"sea_level":1038.28,"grnd_level":1029.33,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":56},"wind":{"speed":3.32,"deg":335.5},"rain":{"3h":0.08},"sys":{"pod":"d"},"dt_txt":"2019-02-13 00:00:00"},{"dt":1550026800,"main":{"temp":292.082,"temp_min":292.082,"temp_max":292.082,"pressure":1029.53,"sea_level":1038.39,"grnd_level":1029.53,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":68},"wind":{"speed":2.87,"deg":3.00568},"rain":{"3h":0.095},"sys":{"pod":"d"},"dt_txt":"2019-02-13 03:00:00"},{"dt":1550037600,"main":{"temp":293.062,"temp_min":293.062,"temp_max":293.062,"pressure":1026.94,"sea_level":1035.92,"grnd_level":1026.94,"humidity":97,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":68},"wind":{"speed":4.07,"deg":27.5005},"rain":{"3h":0.07},"sys":{"pod":"d"},"dt_txt":"2019-02-13 06:00:00"},{"dt":1550048400,"main":{"temp":292.494,"temp_min":292.494,"temp_max":292.494,"pressure":1026.72,"sea_level":1035.72,"grnd_level":1026.72,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":80},"wind":{"speed":4.38,"deg":35.506},"rain":{"3h":0.09},"sys":{"pod":"d"},"dt_txt":"2019-02-13 09:00:00"},{"dt":1550059200,"main":{"temp":292.156,"temp_min":292.156,"temp_max":292.156,"pressure":1027.18,"sea_level":1036.25,"grnd_level":1027.18,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":3.56,"deg":51.0072},"rain":{"3h":0.14},"sys":{"pod":"n"},"dt_txt":"2019-02-13 12:00:00"},{"dt":1550070000,"main":{"temp":292.297,"temp_min":292.297,"temp_max":292.297,"pressure":1027.02,"sea_level":1036.09,"grnd_level":1027.02,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":2.96,"deg":71.5029},"rain":{"3h":0.16},"sys":{"pod":"n"},"dt_txt":"2019-02-13 15:00:00"},{"dt":1550080800,"main":{"temp":292.151,"temp_min":292.151,"temp_max":292.151,"pressure":1025.8,"sea_level":1034.88,"grnd_level":1025.8,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":2.67,"deg":82.5022},"rain":{"3h":0.71},"sys":{"pod":"n"},"dt_txt":"2019-02-13 18:00:00"},{"dt":1550091600,"main":{"temp":292.253,"temp_min":292.253,"temp_max":292.253,"pressure":1025.08,"sea_level":1034.01,"grnd_level":1025.08,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":2.01,"deg":65.0011},"rain":{"3h":0.72},"sys":{"pod":"n"},"dt_txt":"2019-02-13 21:00:00"},{"dt":1550102400,"main":{"temp":292.301,"temp_min":292.301,"temp_max":292.301,"pressure":1026.09,"sea_level":1035.06,"grnd_level":1026.09,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":0.81,"deg":7.32422E-4},"rain":{"3h":1.51},"sys":{"pod":"d"},"dt_txt":"2019-02-14 00:00:00"},{"dt":1550113200,"main":{"temp":292.278,"temp_min":292.278,"temp_max":292.278,"pressure":1026.52,"sea_level":1035.49,"grnd_level":1026.52,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":2.11,"deg":318.504},"rain":{"3h":1.21},"sys":{"pod":"d"},"dt_txt":"2019-02-14 03:00:00"},{"dt":1550124000,"main":{"temp":292.42,"temp_min":292.42,"temp_max":292.42,"pressure":1024.84,"sea_level":1033.84,"grnd_level":1024.84,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":2.98,"deg":329},"rain":{"3h":0.42},"sys":{"pod":"d"},"dt_txt":"2019-02-14 06:00:00"},{"dt":1550134800,"main":{"temp":291.538,"temp_min":291.538,"temp_max":291.538,"pressure":1024.33,"sea_level":1033.36,"grnd_level":1024.33,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":2.66,"deg":315.002},"rain":{"3h":0.15},"sys":{"pod":"d"},"dt_txt":"2019-02-14 09:00:00"},{"dt":1550145600,"main":{"temp":290.589,"temp_min":290.589,"temp_max":290.589,"pressure":1024.93,"sea_level":1033.98,"grnd_level":1024.93,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":2.56,"deg":313.501},"rain":{"3h":0.08},"sys":{"pod":"n"},"dt_txt":"2019-02-14 12:00:00"},{"dt":1550156400,"main":{"temp":290.576,"temp_min":290.576,"temp_max":290.576,"pressure":1025.06,"sea_level":1034.12,"grnd_level":1025.06,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":88},"wind":{"speed":2.66,"deg":307.001},"rain":{"3h":0.02},"sys":{"pod":"n"},"dt_txt":"2019-02-14 15:00:00"},{"dt":1550167200,"main":{"temp":290.438,"temp_min":290.438,"temp_max":290.438,"pressure":1024.46,"sea_level":1033.46,"grnd_level":1024.46,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":3.12,"deg":297.002},"rain":{"3h":0.050000000000001},"sys":{"pod":"n"},"dt_txt":"2019-02-14 18:00:00"},{"dt":1550178000,"main":{"temp":290.151,"temp_min":290.151,"temp_max":290.151,"pressure":1024.19,"sea_level":1033.33,"grnd_level":1024.19,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":3.48,"deg":305.001},"rain":{"3h":0.24},"sys":{"pod":"n"},"dt_txt":"2019-02-14 21:00:00"},{"dt":1550188800,"main":{"temp":290.402,"temp_min":290.402,"temp_max":290.402,"pressure":1025.91,"sea_level":1034.96,"grnd_level":1025.91,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":32},"wind":{"speed":2.07,"deg":280},"rain":{"3h":0.11},"sys":{"pod":"d"},"dt_txt":"2019-02-15 00:00:00"},{"dt":1550199600,"main":{"temp":292.658,"temp_min":292.658,"temp_max":292.658,"pressure":1026.4,"sea_level":1035.38,"grnd_level":1026.4,"humidity":98,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":36},"wind":{"speed":2.41,"deg":358.005},"rain":{"3h":0.0099999999999998},"sys":{"pod":"d"},"dt_txt":"2019-02-15 03:00:00"},{"dt":1550210400,"main":{"temp":292.192,"temp_min":292.192,"temp_max":292.192,"pressure":1024.41,"sea_level":1033.42,"grnd_level":1024.41,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":48},"wind":{"speed":3.1,"deg":19.5015},"rain":{"3h":0.02},"sys":{"pod":"d"},"dt_txt":"2019-02-15 06:00:00"},{"dt":1550221200,"main":{"temp":291.775,"temp_min":291.775,"temp_max":291.775,"pressure":1023.91,"sea_level":1032.9,"grnd_level":1023.91,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":2.86,"deg":21.0044},"rain":{"3h":0.13},"sys":{"pod":"d"},"dt_txt":"2019-02-15 09:00:00"},{"dt":1550232000,"main":{"temp":291.431,"temp_min":291.431,"temp_max":291.431,"pressure":1025.26,"sea_level":1034.14,"grnd_level":1025.26,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":3.27,"deg":28.0004},"rain":{"3h":0.86},"sys":{"pod":"n"},"dt_txt":"2019-02-15 12:00:00"},{"dt":1550242800,"main":{"temp":291.386,"temp_min":291.386,"temp_max":291.386,"pressure":1025.48,"sea_level":1034.48,"grnd_level":1025.48,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":4.41,"deg":38.5004},"rain":{"3h":1.19},"sys":{"pod":"n"},"dt_txt":"2019-02-15 15:00:00"},{"dt":1550253600,"main":{"temp":291.316,"temp_min":291.316,"temp_max":291.316,"pressure":1024.6,"sea_level":1033.52,"grnd_level":1024.6,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":3.81,"deg":40.5},"rain":{"3h":0.79},"sys":{"pod":"n"},"dt_txt":"2019-02-15 18:00:00"},{"dt":1550264400,"main":{"temp":291.096,"temp_min":291.096,"temp_max":291.096,"pressure":1023.98,"sea_level":1032.95,"grnd_level":1023.98,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":3.81,"deg":35.5061},"rain":{"3h":0.99},"sys":{"pod":"n"},"dt_txt":"2019-02-15 21:00:00"},{"dt":1550275200,"main":{"temp":291.225,"temp_min":291.225,"temp_max":291.225,"pressure":1025.13,"sea_level":1034.09,"grnd_level":1025.13,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":4.11,"deg":37.5014},"rain":{"3h":0.38},"sys":{"pod":"d"},"dt_txt":"2019-02-16 00:00:00"},{"dt":1550286000,"main":{"temp":291.622,"temp_min":291.622,"temp_max":291.622,"pressure":1025.03,"sea_level":1034.02,"grnd_level":1025.03,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":3.86,"deg":38.5005},"rain":{"3h":0.22},"sys":{"pod":"d"},"dt_txt":"2019-02-16 03:00:00"},{"dt":1550296800,"main":{"temp":291.915,"temp_min":291.915,"temp_max":291.915,"pressure":1022.11,"sea_level":1031.17,"grnd_level":1022.11,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":3.52,"deg":47.0022},"rain":{"3h":0.17},"sys":{"pod":"d"},"dt_txt":"2019-02-16 06:00:00"},{"dt":1550307600,"main":{"temp":291.863,"temp_min":291.863,"temp_max":291.863,"pressure":1021.35,"sea_level":1030.26,"grnd_level":1021.35,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":2.88,"deg":38.0001},"rain":{"3h":0.32},"sys":{"pod":"d"},"dt_txt":"2019-02-16 09:00:00"},{"dt":1550318400,"main":{"temp":291.467,"temp_min":291.467,"temp_max":291.467,"pressure":1021.62,"sea_level":1030.55,"grnd_level":1021.62,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":2.51,"deg":21.0001},"rain":{"3h":0.55},"sys":{"pod":"n"},"dt_txt":"2019-02-16 12:00:00"},{"dt":1550329200,"main":{"temp":291.325,"temp_min":291.325,"temp_max":291.325,"pressure":1022.05,"sea_level":1030.96,"grnd_level":1022.05,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":3.36,"deg":343.003},"rain":{"3h":1.06},"sys":{"pod":"n"},"dt_txt":"2019-02-16 15:00:00"},{"dt":1550340000,"main":{"temp":290.865,"temp_min":290.865,"temp_max":290.865,"pressure":1021.3,"sea_level":1030.24,"grnd_level":1021.3,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":4.56,"deg":338},"rain":{"3h":1.8},"sys":{"pod":"n"},"dt_txt":"2019-02-16 18:00:00"}]
     * city : {"id":1668341,"name":"Taipei","coord":{"lat":25.0478,"lon":121.5319},"country":"TW","population":7871900}
     */

    private var cod: String? = null
    private var message: Double = 0.toDouble()
    private var cnt: Int = 0
    private var city: CityBean? = null
    private var list: List<ListBean>? = null

    fun getCod(): String? {
        return cod
    }

    fun setCod(cod: String) {
        this.cod = cod
    }

    fun getMessage(): Double {
        return message
    }

    fun setMessage(message: Double) {
        this.message = message
    }

    fun getCnt(): Int {
        return cnt
    }

    fun setCnt(cnt: Int) {
        this.cnt = cnt
    }

    fun getCity(): CityBean? {
        return city
    }

    fun setCity(city: CityBean) {
        this.city = city
    }

    fun getList(): List<ListBean>? {
        return list
    }

    fun setList(list: List<ListBean>) {
        this.list = list
    }

    inner class CityBean {
        /**
         * id : 1668341
         * name : Taipei
         * coord : {"lat":25.0478,"lon":121.5319}
         * country : TW
         * population : 7871900
         */

        var id: Int = 0
        var name: String? = null
        var coord: CoordBean? = null
        var country: String? = null
        var population: Int = 0

        inner class CoordBean {
            /**
             * lat : 25.0478
             * lon : 121.5319
             */

            var lat: Double = 0.toDouble()
            var lon: Double = 0.toDouble()
        }
    }

    inner class ListBean {
        /**
         * dt : 1549918800
         * main : {"temp":290.71,"temp_min":290.71,"temp_max":290.961,"pressure":1030.67,"sea_level":1039.75,"grnd_level":1030.67,"humidity":100,"temp_kf":-0.25}
         * weather : [{"id":500,"main":"Rain","description":"light rain","icon":"10n"}]
         * clouds : {"all":100}
         * wind : {"speed":4.36,"deg":54.0008}
         * rain : {"3h":0.595}
         * sys : {"pod":"n"}
         * dt_txt : 2019-02-11 21:00:00
         */

        var dt: Int = 0
        var main: MainBean? = null
        var clouds: CloudsBean? = null
        var wind: WindBean? = null
        var rain: RainBean? = null
        var sys: SysBean? = null
        var dt_txt: String? = null
        var weather: List<WeatherBean>? = null

        inner class MainBean {
            /**
             * temp : 290.71
             * temp_min : 290.71
             * temp_max : 290.961
             * pressure : 1030.67
             * sea_level : 1039.75
             * grnd_level : 1030.67
             * humidity : 100
             * temp_kf : -0.25
             */

            var temp: Double = 0.toDouble()
            var temp_min: Double = 0.toDouble()
            var temp_max: Double = 0.toDouble()
            var pressure: Double = 0.toDouble()
            var sea_level: Double = 0.toDouble()
            var grnd_level: Double = 0.toDouble()
            var humidity: Int = 0
            var temp_kf: Double = 0.toDouble()
        }

        inner class CloudsBean {
            /**
             * all : 100
             */

            var all: Int = 0
        }

        inner class WindBean {
            /**
             * speed : 4.36
             * deg : 54.0008
             */

            var speed: Double = 0.toDouble()
            var deg: Double = 0.toDouble()
        }

        inner class RainBean {
            /**
             * 3h : 0.595
             */

            @SerializedName("3h")
            var `_$3h`: Double = 0.toDouble()
        }

        inner class SysBean {
            /**
             * pod : n
             */

            var pod: String? = null
        }

        inner class WeatherBean {
            /**
             * id : 500
             * main : Rain
             * description : light rain
             * icon : 10n
             */

            var id: Int = 0
            var main: String? = null
            var description: String? = null
            var icon: String? = null
        }
    }
}