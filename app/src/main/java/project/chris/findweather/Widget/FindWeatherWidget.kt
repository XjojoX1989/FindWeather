package project.chris.findweather.Widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import project.chris.findweather.R

/**
 * Created by chris on 2019/2/17.
 */
class FindWeatherWidget : AppWidgetProvider() {
    override fun onEnabled(context: Context) {
        super.onEnabled(context)
        Log.e("＊＊＊", "onEnabled")
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        Log.e("＊＊＊", "onReceive")
    }

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        Log.e("＊＊＊", "onUpdate")
        for (i in 0 until appWidgetIds.size) {
            val remoteView = RemoteViews(context.packageName, R.layout.find_weather_widget)
            remoteView.setTextViewText(R.id.wTvDate, "2018/02/17")
            appWidgetManager.updateAppWidget(appWidgetIds[i], remoteView)
        }
    }


    override fun onDisabled(context: Context) {
        super.onDisabled(context)
        Log.e("＊＊＊", "onDisabled")
    }


    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        super.onDeleted(context, appWidgetIds)
        Log.e("＊＊＊", "onDeleted")
    }
}