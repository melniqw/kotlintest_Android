package me.melnikov.kotlintest.presentation.gallery

import io.reactivex.Single
import me.melnikov.kotlintest.TestUtils
import me.melnikov.kotlintest.data.content.ContentManager
import me.melnikov.kotlintest.mock.MockedObjects
import me.melnikov.kotlintest.ui.gallery.GalleryView
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.`when` as _when


/**
 * Created by melniqw on 18.08.2018.
 */
@RunWith(MockitoJUnitRunner::class)
class GalleryPresenterTest {

    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var galleryView: GalleryView

    @Mock
    lateinit var contentManager: ContentManager

    lateinit var galleryPresenter: GalleryPresenter

    @Before
    fun setUp() {
        TestUtils.initMockedApplication()

        galleryPresenter = GalleryPresenter()
        galleryPresenter.contentManager = contentManager
        galleryPresenter.attachView(galleryView)
    }

    @Test
    fun loadFilledMediaFiles() {
        _when(galleryPresenter.contentManager.getMediaFiles(0))
                .thenReturn(Single.just(MockedObjects.MOCKED_MEDIA_FILES))

        galleryPresenter.loadMediaFiles(0)

        verify(galleryView).clearImages()
        verify(galleryView).showProgress()
        verify(galleryView).showImages(MockedObjects.MOCKED_MEDIA_FILES)
        verify(galleryView, never()).showEmpty()
        verifyNoMoreInteractions(galleryView)
    }

    @Test
    fun loadEmptyMediaFiles() {
        _when(galleryPresenter.contentManager.getMediaFiles(0))
                .thenReturn(Single.just(MockedObjects.EMPTY_MEDIA_FILES))

        galleryPresenter.loadMediaFiles(0)

        verify(galleryView).clearImages()
        verify(galleryView).showProgress()
        verify(galleryView, never()).showImages(MockedObjects.EMPTY_MEDIA_FILES)
        verify(galleryView).showEmpty()
        verifyNoMoreInteractions(galleryView)
    }
}