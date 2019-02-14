package project.chris.findweather.MVP

import android.annotation.SuppressLint
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import project.chris.findweather.Network.FiveDaysThreeHoursBean
import project.chris.findweather.R
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by chris on 2019/2/14.
 */
class FiveDaysWeatherAdapter(var context: Context, var fiveDaysList: ArrayList<FiveDaysThreeHoursBean.ListBean>) : BaseAdapter() {
    lateinit var tvDate: TextView
    lateinit var ivWeatherCondition: ImageView
    lateinit var tvMaxMinTemp: TextView
    lateinit var tvWeatherCondition: TextView
    @SuppressLint("SetTextI18n", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val grid: View
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (convertView == null) {
            grid = layoutInflater.inflate(R.layout.five_day_item, null)
            findViewsById(grid)
            if (fiveDaysList[position].dt_txt != null)
                tvDate.text = dateToDay(fiveDaysList[position].dt_txt!!)
            if (fiveDaysList[position].main != null)
                tvMaxMinTemp.text = DecimalFormat("#").format(fiveDaysList[position].main!!.temp_max + 1.0) + "/" + DecimalFormat("#").format(fiveDaysList[position].main!!.temp_min - 1.0) + "°C"
            if (fiveDaysList[position].weather != null && fiveDaysList[position].weather!![0].description != null)
                tvWeatherCondition.text = fiveDaysList[position].weather!![0].description
        } else
            grid = convertView
        return grid
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return 5
    }

    @Throws(ParseException::class)
    fun dateToDay(dateString: String): String {
        val dateStringFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        val date = dateStringFormat.parse(dateString)

        val date2DayFormat = SimpleDateFormat("u")
        return when (date2DayFormat.format(date)) {
            "1" -> "星期一"
            "2" -> "星期二"
            "3" -> "星期三"
            "4" -> "星期四"
            "5" -> "星期五"
            "6" -> "星期六"
            "7" -> "星期日"
            else -> ""
        }
    }

    private fun findViewsById(grid: View?) {
        if (grid != null) {
            tvDate = grid.findViewById(R.id.tvDate) as TextView
            ivWeatherCondition = grid.findViewById(R.id.ivWeatherCondition) as ImageView
            tvMaxMinTemp = grid.findViewById(R.id.tvMaxMinTemp) as TextView
            tvWeatherCondition = grid.findViewById(R.id.tvWeatherCondition) as TextView
        }
    }
}