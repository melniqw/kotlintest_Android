package me.melnikov.kotlintest.dagger.module

import android.content.Context
import dagger.Module
import dagger.Provides
import me.melnikov.kotlintest.analytics.Analytics
import me.melnikov.kotlintest.analytics.MultiAnalytics
import javax.inject.Singleton

/**
 * Created by melniqw on 22.08.2018.
 */
@Module(includes = [
    AppModule::class
])
open class AnalyticsModule {

    @Provides
    @Singleton
    open fun provideAnalytics(context: Context) : Analytics = MultiAnalytics(context)
}