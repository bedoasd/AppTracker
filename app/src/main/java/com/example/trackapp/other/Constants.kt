package com.example.trackapp.other

import android.graphics.Color

class Constants {
    companion object{

        // Database
        const val DATABASE_NAME = "running_db"

        const val REQUEST_CODE_LOCATION_PERMISSION=0

        const val MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey"

        // Service Intent Actions
        const val ACTION_SHOW_TRACKING_FRAGMENT = "ACTION_SHOW_TRACKING_FRAGMENT"
        const val ACTION_START_OR_RESUME_SERVICE = "ACTION_START_SERVICE"
        const val ACTION_PAUSE_SERVICE = "ACTION_PAUSE_SERVICE"
        const val ACTION_STOP_SERVICE = "ACTION_STOP_SERVICE"

        // Notifications
        const val NOTIFICATION_CHANNEL_ID = "tracking_channel"
        const val NOTIFICATION_CHANNEL_NAME = "Tracking"
        const val NOTIFICATION_ID = 1

        // Tracking Options
        const val LOCATION_UPDATE_INTERVAL = 5000L
        const val FASTEST_LOCATION_UPDATE_INTERVAL = 2000L
        // Map Options
        const val POLYLINE_COLOR = Color.RED
        const val POLYLINE_WIDTH = 8f
        const val MAP_ZOOM = 15f

        // Timer
        const val TIMER_UPDATE_INTERVAL = 50L

    }
}