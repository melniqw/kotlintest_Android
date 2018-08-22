package me.melnikov.kotlintest.mock

import dagger.Component
import me.melnikov.kotlintest.presentation.gallery.GalleryPresenterTest
import javax.inject.Singleton

/**
 * Created by melniqw on 21.08.2018.
 */
@Singleton
@Component(modules = [
    AppModuleMock::class,
    ContentModuleMock::class
])
interface AppComponentMock {

    fun inject(galleryPresenterTest: GalleryPresenterTest)
}