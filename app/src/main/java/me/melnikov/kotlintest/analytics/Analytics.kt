package me.melnikov.kotlintest.analytics

/**
 * Created by melniqw on 10.08.2018.
 */
interface Analytics {

    enum class Event(val value: String) {
        UNKNOWN("unknown"),

        APP_OPEN("app_open"),
        APP_CLOSE("app_close"),
        APP_REMOVE("app_remove"), // unused
        APP_UPDATE("app_update"), // unused
    }

    fun setUserId(userId: String)

    fun logEvent(event: Event) = logEvent(event, "")

    fun logEvent(event: Event, suffix: String)


}