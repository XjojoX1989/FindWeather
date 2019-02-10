package project.chris.findweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import project.chris.findweather.Network.WeatherAPIManager
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createFragment()

    }

    private fun createFragment() {
        val newFragment = WeatherFragment();
        val transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.flContainer, newFragment);
        transaction.commit();

    }


    private fun sendRequest() {
        val executorService = Executors.newSingleThreadExecutor()
        executorService.submit {
            val result = WeatherAPIManager.getThirtySixHourCityData()
            if (result.isSuccess && result.resultBean != null) {

                runOnUiThread {
                    Toast.makeText(this, result.resultBean!!.getRecords()!!.datasetDescription, Toast.LENGTH_SHORT).show()
                }

            }
        }
        executorService.shutdown()

    }
}
