package me.melnikov.kotlintest.ui.main

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import me.melnikov.kotlintest.R
import me.melnikov.kotlintest.TestUtils
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

/**
 * Created by melniqw on 22.08.2018.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityToDashboardTest {

    @get:Rule
    val activityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        TestUtils.initMockedApplication()
    }

    @Test
    fun onCreate() {
        Espresso.onView(ViewMatchers.withId(R.id.navigation_dashboard))
                .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.button1))
                .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.etText))
                .check(ViewAssertions.matches(ViewMatchers.withText("wtf")))
                .perform(ViewActions.clearText(),
                        ViewActions.typeText("lolo"),
                        ViewActions.closeSoftKeyboard())
                .check(ViewAssertions.matches(ViewMatchers.withText("lolo")))

        Espresso.pressBack()
    }
}