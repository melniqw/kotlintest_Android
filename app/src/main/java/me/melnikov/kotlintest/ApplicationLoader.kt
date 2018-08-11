package me.melnikov.kotlintest

import android.app.Application
import android.arch.lifecycle.*
import me.melnikov.kotlintest.analytics.Analytics
import me.melnikov.kotlintest.analytics.MultiAnalytics
import me.melnikov.kotlintest.dagger.component.AppComponent
import me.melnikov.kotlintest.dagger.component.DaggerAppComponent
import me.melnikov.kotlintest.dagger.module.AppModule
import timber.log.Timber

/**
 * Created by melniqw on 01.08.2018.
 */
class ApplicationLoader : Application(), LifecycleObserver {

    companion object {
        lateinit var appComponent: AppComponent
    }
    private lateinit var analytics: Analytics

    override fun onCreate() {
        super.onCreate()

        initAnalytics()

        initAppComponent()

        initTimber()

        initLifecycle()

    }

    private fun initAnalytics() {
        analytics = MultiAnalytics(this)
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        appComponent.inject(this)
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initLifecycle() {
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycle())
    }

    fun getAnalytics() : Analytics = analytics

    inner class ApplicationLifecycle : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onStartApp() {
            analytics.logEvent(Analytics.Event.APP_OPEN)

            // todo start websocket here
            Timber.d("onStartApp")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onStopApp() {
            analytics.logEvent(Analytics.Event.APP_CLOSE)

            // todo stop websocket here
            Timber.d("onStopApp")
        }
    }
}