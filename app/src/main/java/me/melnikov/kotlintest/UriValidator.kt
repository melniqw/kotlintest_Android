package me.melnikov.kotlintest

import android.content.Context
import io.reactivex.Single

import java.net.URI

/**
 * Created by melniqw on 17.08.2018.
 */
class UriValidator(private val context: Context) {

    fun validate(uri: String): String {
        var resId = R.string.nothing
        if (isUrl(uri)) {
            resId = R.string.url
        } else if (isFile(uri)) {
            resId = R.string.file
        }
        return context.getString(resId)
    }

    private fun isUrl(uri: String): Boolean {
        return "http" == URI.create(uri).scheme
    }

    private fun isFile(uri: String): Boolean {
        return "file" == URI.create(uri).scheme
    }
}