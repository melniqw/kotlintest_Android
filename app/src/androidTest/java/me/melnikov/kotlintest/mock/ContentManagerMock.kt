package me.melnikov.kotlintest.mock

import io.reactivex.Single
import me.melnikov.kotlintest.data.content.ContentManager

/**
 * Created by melniqw on 21.08.2018.
 */
class ContentManagerMock : ContentManager(null) {

    override fun getMediaAlbums() = Single.just(MockedObjects.MOCKED_MEDIA_ALBUMS)

    override fun getMediaFiles(albumId: Int) = Single.just(MockedObjects.MOCKED_MEDIA_FILES)

}