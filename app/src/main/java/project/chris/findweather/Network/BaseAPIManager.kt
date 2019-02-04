package project.chris.findweather.Network

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser

/**
 * Created by chris on 2019/2/5.
 */
open class BaseAPIManager {
    val gson = Gson()
    val jsonParser = JsonParser()

    fun <T> parser(paramString: String, paramClass: Class<T>): T? {
        if (TextUtils.isEmpty(paramString))
            return null
        try {
            val localJsonObject = jsonParser.parse(paramString) as JsonObject

            return gson.fromJson(localJsonObject, paramClass)
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }

    }
}