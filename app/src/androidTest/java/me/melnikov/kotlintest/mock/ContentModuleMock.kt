package me.melnikov.kotlintest.mock

import android.content.ContentResolver
import dagger.Module
import dagger.Provides
import me.melnikov.kotlintest.dagger.module.ContentModule
import me.melnikov.kotlintest.data.content.ContentManager
import javax.inject.Singleton

/**
 * Created by melniqw on 21.08.2018.
 */
@Module
class ContentModuleMock : ContentModule() {

    @Provides
    @Singleton
    @Override
    override fun provideContentManager(contentResolver: ContentResolver): ContentManager {
        return ContentManagerMock()
    }
}