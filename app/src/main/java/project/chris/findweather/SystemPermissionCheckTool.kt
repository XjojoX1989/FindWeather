package project.chris.findweather

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat.requestPermissions
import android.support.v4.content.ContextCompat
import android.content.Intent


/**
 * Created by chris on 2019/2/10.
 */
object SystemPermissionCheckTool {
    val MY_PERMISSIONS_ACCESS_FINE_LOCATION = 3

    fun checkAccessLocationState(context: Context?): Boolean {
        if (context == null)
            return false
        return ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    fun checkLocationPermission(context: Context, activity: Activity) {
        if (ContextCompat.checkSelfPermission(context,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    MY_PERMISSIONS_ACCESS_FINE_LOCATION)
        }
    }


}