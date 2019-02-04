package project.chris.findweather.Network

/**
 * Created by chris on 2019/2/5.
 */
class ThirtySixHourCityBean {
    /**
     * success : true
     * records : {
     * "datasetDescription":"三十六小時天氣預報",
     * "location":[{"locationName":"臺北市",
     * "weatherElement":[{
     *
     * "elementName":"Wx",
     * "time":[
     * {"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"陰天","parameterValue":"7"}},
     * {"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"陰時多雲","parameterValue":"6"}},
     * {"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"陰天","parameterValue":"7"}}
     * ]
     * },
     *
     * {"elementName":"PoP",
     * "time":[
     * {"startTime":"2019-02-05 00:00:00", "endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"20","parameterUnit":"百分比"}},
     * {"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"20","parameterUnit":"百分比"}},
     * {"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"20","parameterUnit":"百分比"}}
     * ]
     * },
     *
     * {"elementName":"MinT",
     * "time":[
     * {"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}},
     * {"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}},
     * {"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}}]},
     *
     * {"elementName":"CI",
     * "time":[
     * {"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"稍有寒意"}},
     * {"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"稍有寒意至舒適"}},
     * {"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"稍有寒意至舒適"}}]},
     *
     * {"elementName":"MaxT",
     * "time":[
     * {"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}},
     * {"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"23","parameterUnit":"C"}},
     * {"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"20","parameterUnit":"C"}}]}]}]}
     */

    private var success: String? = null
    private var records: RecordsBean? = null
    private var result: ResultBean? = null
    fun getResult(): ResultBean? {
        return result
    }

    fun setResult(result: ResultBean) {
        this.result = result
    }


    class ResultBean {
        /**
         * resource_id : F-C0032-001
         * fields : [{"id":"datasetDescription","type":"String"},{"id":"locationName","type":"String"},{"id":"parameterName","type":"String"},{"id":"parameterValue","type":"String"},{"id":"parameterUnit","type":"String"},{"id":"startTime","type":"Timestamp"},{"id":"endTime","type":"Timestamp"}]
         */

        var resource_id: String? = null
        var fields: List<FieldsBean>? = null

        class FieldsBean {
            /**
             * id : datasetDescription
             * type : String
             */

            var id: String? = null
            var type: String? = null
        }
    }
    fun getSuccess(): String? {
        return success
    }

    fun setSuccess(success: String) {
        this.success = success
    }

    fun getRecords(): RecordsBean? {
        return records
    }

    fun setRecords(records: RecordsBean) {
        this.records = records
    }

    class RecordsBean {
        /**
         * datasetDescription : 三十六小時天氣預報
         * location : [{"locationName":"臺北市","weatherElement":[{"elementName":"Wx","time":[{"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"陰天","parameterValue":"7"}},{"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"陰時多雲","parameterValue":"6"}},{"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"陰天","parameterValue":"7"}}]},{"elementName":"PoP","time":[{"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"20","parameterUnit":"百分比"}},{"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"20","parameterUnit":"百分比"}},{"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"20","parameterUnit":"百分比"}}]},{"elementName":"MinT","time":[{"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}},{"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}},{"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}}]},{"elementName":"CI","time":[{"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"稍有寒意"}},{"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"稍有寒意至舒適"}},{"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"稍有寒意至舒適"}}]},{"elementName":"MaxT","time":[{"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}},{"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"23","parameterUnit":"C"}},{"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"20","parameterUnit":"C"}}]}]}]
         */

        var datasetDescription: String? = null
        var location: List<LocationBean>? = null

        class LocationBean {
            /**
             * locationName : 臺北市
             * weatherElement : [{"elementName":"Wx","time":[{"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"陰天","parameterValue":"7"}},{"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"陰時多雲","parameterValue":"6"}},{"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"陰天","parameterValue":"7"}}]},{"elementName":"PoP","time":[{"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"20","parameterUnit":"百分比"}},{"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"20","parameterUnit":"百分比"}},{"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"20","parameterUnit":"百分比"}}]},{"elementName":"MinT","time":[{"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}},{"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}},{"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}}]},{"elementName":"CI","time":[{"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"稍有寒意"}},{"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"稍有寒意至舒適"}},{"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"稍有寒意至舒適"}}]},{"elementName":"MaxT","time":[{"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"17","parameterUnit":"C"}},{"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"23","parameterUnit":"C"}},{"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"20","parameterUnit":"C"}}]}]
             */

            var locationName: String? = null
            var weatherElement: List<WeatherElementBean>? = null

            class WeatherElementBean {
                /**
                 * elementName : Wx
                 * time : [{"startTime":"2019-02-05 00:00:00","endTime":"2019-02-05 06:00:00","parameter":{"parameterName":"陰天","parameterValue":"7"}},{"startTime":"2019-02-05 06:00:00","endTime":"2019-02-05 18:00:00","parameter":{"parameterName":"陰時多雲","parameterValue":"6"}},{"startTime":"2019-02-05 18:00:00","endTime":"2019-02-06 06:00:00","parameter":{"parameterName":"陰天","parameterValue":"7"}}]
                 */

                var elementName: String? = null
                var time: List<TimeBean>? = null

                class TimeBean {
                    /**
                     * startTime : 2019-02-05 00:00:00
                     * endTime : 2019-02-05 06:00:00
                     * parameter : {"parameterName":"陰天","parameterValue":"7"}
                     */

                    var startTime: String? = null
                    var endTime: String? = null
                    var parameter: ParameterBean? = null

                    class ParameterBean {
                        /**
                         * parameterName : 陰天
                         * parameterValue : 7
                         */

                        var parameterName: String? = null
                        var parameterValue: String? = null
                    }
                }
            }
        }
    }
}