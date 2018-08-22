package me.melnikov.kotlintest.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by melniqw on 31.07.2018.
 */
data class User(
        @SerializedName("name") val name: String,
        @SerializedName("surname") val surname: String,
        @SerializedName("age") val age: Int,
        @SerializedName("speed") val speed : Speed,
        @SerializedName("last_logged_in") val lastLoggedIn : Long
) : Human(null) {

}