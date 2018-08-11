package me.melnikov.kotlintest.model

import com.google.gson.annotations.SerializedName

/**
 * Created by melniqw on 31.07.2018.
 */
abstract class Human(
        @SerializedName("id") private val id : Long?
) : Identifiable {

    override fun getId(): Long? {
        return id
    }
}