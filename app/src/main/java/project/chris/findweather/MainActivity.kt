package project.chris.findweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.Request
import project.chris.findweather.Network.WeatherAPIManager
import java.io.IOException
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    var okHttpClient: OkHttpClient? = null
    lateinit var btRequest: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        okHttpClient = OkHttpClient()
        btRequest = findViewById(R.id.btRequest)
        btRequest.setOnClickListener(clickListener)
    }

    private val clickListener = View.OnClickListener {
        when (it.id) {
            R.id.btRequest -> {
                sendRequest()
            }
        }
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
