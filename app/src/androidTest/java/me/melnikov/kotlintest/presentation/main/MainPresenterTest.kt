package me.melnikov.kotlintest.presentation.main

import me.melnikov.kotlintest.TestUtils
import me.melnikov.kotlintest.ui.main.MainView
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by melniqw on 22.08.2018.
 */
@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var mainView: MainView

    lateinit var mainPresenter: MainPresenter

    @Before
    fun setUp() {
        TestUtils.initMockedApplication()

        mainPresenter = MainPresenter()
        mainPresenter.attachView(mainView)
    }

    @Test
    fun showDashboard() {
        mainPresenter.showDashboard()
        verify(mainView).showDashboard()
    }

    @Test
    fun showGallery() {
        mainPresenter.showGallery()
        verify(mainView).showGallery()
    }
}