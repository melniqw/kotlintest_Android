package me.melnikov.kotlintest

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by melniqw on 14.08.2018.
 */
class FailedUnitTest {
    @Test
    fun andNowThisWillSucceed() {
        assertTrue(1 == 1)
    }
}
