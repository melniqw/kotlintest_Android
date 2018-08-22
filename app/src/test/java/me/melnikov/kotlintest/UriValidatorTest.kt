package me.melnikov.kotlintest

import android.content.Context
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.`when` as _when

/**
 * Created by melniqw on 17.08.2018.
 */
class UriValidatorTest {

    companion object {
        val NOTHING: String = "Nothing"
        val URL: String = "URL"
        val FILE: String = "File"
    }

    private lateinit var mockContext: Context
    private lateinit var uriValidator: UriValidator

    @Before
    fun setUp() {
        mockContext = Mockito.mock(Context::class.java)
        _when(mockContext.getString(R.string.nothing)).thenReturn(NOTHING)
        _when(mockContext.getString(R.string.url)).thenReturn(URL)
        _when(mockContext.getString(R.string.file)).thenReturn(FILE)
        uriValidator = UriValidator(mockContext)
    }

    @Test
    fun validate() {
        assertEquals(uriValidator.validate("http://google.com"), URL)
        assertEquals(uriValidator.validate("file://sdcard/DCIM/img001.jpg"), FILE)
        assertEquals(uriValidator.validate("bla-bla-bla"), NOTHING)
    }
}