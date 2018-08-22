package me.melnikov.kotlintest.data.content

import android.net.Uri
import android.support.media.ExifInterface

import java.io.FileInputStream

/**
 * Created by melniqw on 17.08.2018.
 */
data class MediaFile(private val _uri: Uri,
                     private val _pathName: String,
                     private val _isVideo: Boolean) {

    val uri get() = _uri

    val pathName get() = _pathName

    val isVideo get() = _isVideo

    val latLong get() : DoubleArray? {
        try {
            val inputStream = FileInputStream(_pathName)
            return ExifInterface(inputStream).latLong
        } catch (e : Exception) {
            println(e)
        }
        return null
    }

}