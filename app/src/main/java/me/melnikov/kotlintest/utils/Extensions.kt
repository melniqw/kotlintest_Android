package me.melnikov.kotlintest.utils

fun Any?.toString(): String {
    if (this == null) return "null"
    return toString()
}

fun<T> ArrayList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun<T> List<T>.lastIndex() : Int {
    return this.size - 1
}