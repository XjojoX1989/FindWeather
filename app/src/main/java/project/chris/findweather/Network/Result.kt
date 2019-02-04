package project.chris.findweather.Network

import java.io.Serializable

/**
 * Created by chris on 2019/2/5.
 */
class Result<T>:Serializable {
    var isSuccess:Boolean = false
    var resultBean:T? = null

}