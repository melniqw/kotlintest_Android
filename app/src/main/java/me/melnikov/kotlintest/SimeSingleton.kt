package me.melnikov.kotlintest

/**
 * Created by melniqw on 03.08.2018.
 */
class SomeSingleton private constructor() {

    init {
        println("Singleton $this is initialized")
    }

    private object Holder {
        val INSTANCE = SomeSingleton()
    }

    companion object {
        val instance : SomeSingleton by lazy { Holder.INSTANCE }
    }

    var b : String = ""
}