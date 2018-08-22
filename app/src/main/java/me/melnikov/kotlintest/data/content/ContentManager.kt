package me.melnikov.kotlintest.data.content

import android.content.ContentResolver
import android.content.ContentUris
import android.provider.MediaStore
import io.reactivex.Single
import java.util.*
import java.util.concurrent.Callable

/**
 * Created by melniqw on 17.08.2018.
 */
open class ContentManager(private val contentResolver: ContentResolver?) {

    open fun getMediaAlbums() = Single.fromCallable(Callable<Set<MediaAlbum>> {
        val albums = LinkedHashSet<MediaAlbum>()

        val queryUri = MediaStore.Files.getContentUri("external")

        val projection = arrayOf(
                MediaStore.Images.Media.BUCKET_ID,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME)

        val selection = "(${MediaStore.Files.FileColumns.MEDIA_TYPE} = ${MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE}" +
                " OR " +
                "${MediaStore.Files.FileColumns.MEDIA_TYPE} = ${MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO})"

        val orderBy = "${MediaStore.Images.Media.DATE_MODIFIED} DESC"

        try {
            val cursor = contentResolver!!.query(queryUri, projection, selection, null, orderBy)
            if (cursor == null) {
                throw IllegalStateException("cursor is ${null}")
            }

            val idColumnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_ID)
            val nameColumnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
            while (cursor.moveToNext()) {
                val albumId = cursor.getInt(idColumnIndex)
                val albumName = cursor.getString(nameColumnIndex)
                albums.add(MediaAlbum(albumId, albumName))
            }
            cursor.close()
        } catch (e: Exception) {
            println(e)
        }
        return@Callable albums
    })

    open fun getMediaFiles(albumId: Int) = Single.fromCallable(Callable<List<MediaFile>> {
        val mediaFiles = LinkedList<MediaFile>()

        val queryUri = MediaStore.Files.getContentUri("external")

        val projection = arrayOf(
                MediaStore.Files.FileColumns._ID,
                MediaStore.Files.FileColumns.MEDIA_TYPE,
                MediaStore.Files.FileColumns.DATA)

        var selection = "(${MediaStore.Files.FileColumns.MEDIA_TYPE} = ${MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE}" +
                " OR " +
                "${MediaStore.Files.FileColumns.MEDIA_TYPE} = ${MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO})"

        var args: Array<String>? = null
        // if albumId is set then get images with bucket_id == albumId
        if (albumId != 0) {
            selection = selection + " AND ${MediaStore.Images.Media.BUCKET_ID} = ?"
            args = arrayOf(albumId.toString())
        }

        val orderBy = "${MediaStore.Images.ImageColumns.DATE_ADDED} DESC"

        try {
            val cursor = contentResolver!!.query(queryUri, projection, selection, args, orderBy)
            if (cursor == null) {
                throw IllegalStateException("cursor is ${null}")
            }

            val idIndex = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns._ID)
            val mediaTypeIndex = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.MEDIA_TYPE)
            val dataIndex = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA)
            while (cursor.moveToNext()) {
                val uri = ContentUris.withAppendedId(queryUri, cursor.getInt(idIndex).toLong())
                val pathName = cursor.getString(dataIndex)
                val isVideo = cursor.getInt(mediaTypeIndex) == MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO
                mediaFiles.add(MediaFile(uri, pathName, isVideo))
            }
            cursor.close()
        } catch (e: Exception) {
            println(e)
        }

        return@Callable mediaFiles
    })
}