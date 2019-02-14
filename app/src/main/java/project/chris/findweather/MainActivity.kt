package project.chris.findweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createFragment()
    }

    private fun createFragment() {
        val newFragment = BaseFragment();
        val transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.flContainer, newFragment);
        transaction.commit();
    }
}
