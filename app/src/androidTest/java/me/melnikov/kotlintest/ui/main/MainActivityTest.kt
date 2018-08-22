package me.melnikov.kotlintest.ui.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.runner.AndroidJUnitRunner
import me.melnikov.kotlintest.R
import me.melnikov.kotlintest.TestUtils
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by melniqw on 22.08.2018.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest : AndroidJUnitRunner() {

    @get:Rule
    val activityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        TestUtils.initMockedApplication()
    }

    @Test
    fun onCreate() {
        onView(withId(R.id.navigation_gallery))
                .perform(click())
    }

    @Test
    fun showMessage() {
    }

    @Test
    fun showDashboard() {
    }

    @Test
    fun showGallery() {
    }
}