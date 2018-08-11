package me.melnikov.kotlintest.analytics

import android.content.Context

/**
 * Created by melniqw on 10.08.2018.
 */
class FirebaseAnalytics(val context: Context) : Analytics {

    override fun setUserId(userId: String) {
        // todo
    }

    override fun logEvent(event: Analytics.Event, suffix: String) {
        // todo
    }
}