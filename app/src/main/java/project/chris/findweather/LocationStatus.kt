package project.chris.findweather

import android.location.Address

/**
 * Created by chris.chang on 2019/2/11.
 */
interface LocationStatus {
    fun onLocationReady(address:List<Address>)
}