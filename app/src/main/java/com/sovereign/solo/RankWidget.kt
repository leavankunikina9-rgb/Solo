package com.sovereign.solo

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

class RankWidget : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (id in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.widget)
            views.setTextViewText(R.id.w_head, "[!] STATUS")
            views.setTextViewText(R.id.w_rank, "LEVEL ${Store.level(Store.xp(context))}")
            appWidgetManager.updateAppWidget(id, views)
        }
    }
}
