package project.chris.findweather

import android.location.Address
import android.location.Location

/**
 * Created by chris.chang on 2019/2/11.
 */
interface LocationStatus {
    fun onLocationReady(address: Location, address1: MutableList<Address>)
}