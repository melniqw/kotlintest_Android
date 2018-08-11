package me.melnikov.kotlintest.analytics

import android.content.Context
import timber.log.Timber

/**
 * Created by melniqw on 10.08.2018.
 */
class MultiAnalytics : Analytics {

    private val firebaseAnalytics: FirebaseAnalytics

    private lateinit var currentUserId: String

    constructor(context : Context) {
        firebaseAnalytics = FirebaseAnalytics(context)
    }

    override fun setUserId(userId: String) {
        currentUserId = userId
        firebaseAnalytics.setUserId(userId)
    }

    override fun logEvent(event: Analytics.Event, suffix: String) {
        Timber.d("logEvent " + event.value)

        firebaseAnalytics.logEvent(event, suffix)
    }
}