package me.melnikov.kotlintest

import android.app.Application
import android.arch.lifecycle.*
import android.content.Context
import me.melnikov.kotlintest.analytics.Analytics
import me.melnikov.kotlintest.dagger.component.AppComponent
import me.melnikov.kotlintest.dagger.component.DaggerAppComponent
import me.melnikov.kotlintest.dagger.module.AppModule
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by melniqw on 01.08.2018.
 */
class ApplicationLoader : Application(), LifecycleObserver {

    companion object {
        lateinit var instance: ApplicationLoader

        fun get(context: Context) : ApplicationLoader {
            return context.applicationContext as ApplicationLoader
        }
    }

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var analytics: Analytics

    override fun onCreate() {
        super.onCreate()

        instance = this

        appComponent = buildAppComponent()
        appComponent.inject(this)

        Timber.plant(Timber.DebugTree())

        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycle())

    }

    protected fun buildAppComponent() : AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

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