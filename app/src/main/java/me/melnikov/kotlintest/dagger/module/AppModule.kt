package me.melnikov.kotlintest.dagger.module

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import dagger.Module
import dagger.Provides
import me.melnikov.kotlintest.ApplicationLoader
import me.melnikov.kotlintest.analytics.Analytics
import javax.inject.Singleton

/**
 * Created by melniqw on 10.08.2018.
 */
@Module
class AppModule(val app: ApplicationLoader) {

    @Provides
    @Singleton
    fun provideContext() : Context = app

    @Provides
    @Singleton
    fun provideApplication() : Application = app

    @Provides
    @Singleton
    fun provideContentResolver() : ContentResolver = app.contentResolver

    @Provides
    @Singleton
    fun provideAnalytics() : Analytics = app.getAnalytics();
}