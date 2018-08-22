package me.melnikov.kotlintest.mock

import android.net.Uri
import me.melnikov.kotlintest.data.content.MediaAlbum
import me.melnikov.kotlintest.data.content.MediaFile

/**
 * Created by melniqw on 22.08.2018.
 */
object MockedObjects {
    val EMPTY_MEDIA_ALBUMS = setOf<MediaFile>()
    val MOCKED_MEDIA_ALBUMS = setOf(
            MediaAlbum(0, "first"),
            MediaAlbum(1, "second"),
            MediaAlbum(2, "third"))

    val EMPTY_MEDIA_FILES = listOf<MediaFile>()
    val MOCKED_MEDIA_FILES = listOf(
            MediaFile(Uri.EMPTY, "empty", false),
            MediaFile(Uri.EMPTY, "empty", false),
            MediaFile(Uri.EMPTY, "empty", false))
}