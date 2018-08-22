package me.melnikov.kotlintest.data.content

/**
 * Created by melniqw on 17.08.2018.
 */
data class MediaAlbum(private val _id: Int,
                      private val _name: String) {

    val id get() = _id

    val name get() = _name
}