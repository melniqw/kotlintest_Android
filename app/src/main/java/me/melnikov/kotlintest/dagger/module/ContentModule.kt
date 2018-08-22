package me.melnikov.kotlintest.dagger.module

import android.content.ContentResolver
import dagger.Module
import dagger.Provides
import me.melnikov.kotlintest.data.content.ContentManager
import javax.inject.Singleton

/**
 * Created by melniqw on 21.08.2018.
 */
@Module(includes = [
    AppModule::class
])
open class ContentModule {

    @Provides
    @Singleton
    open fun provideContentManager(contentResolver: ContentResolver) = ContentManager(contentResolver)
}