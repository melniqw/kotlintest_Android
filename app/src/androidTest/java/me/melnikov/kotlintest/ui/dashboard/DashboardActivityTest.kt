package me.melnikov.kotlintest.ui.dashboard

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
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
class DashboardActivityTest {

    @get:Rule
    val activityTestRule: ActivityTestRule<DashboardActivity> = ActivityTestRule(DashboardActivity::class.java)

    @Before
    fun setUp() {
        TestUtils.initMockedApplication()
    }

    @Test
    fun checkIfButton1Works() {
        val testText = "1234567890omgwtflol"
        Espresso.onView(ViewMatchers.withId(R.id.etText))
                .perform(ViewActions.typeText(testText), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.button1))
                .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.etText))
                .check(ViewAssertions.matches(ViewMatchers.withText("wtf")))
    }

    @Test
    fun checkIfButton2Works() {
        val testText = "1234567890omgwtflol"
        Espresso.onView(ViewMatchers.withId(R.id.etText))
                .perform(ViewActions.typeText(testText), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.button2))
                .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.etText))
                .check(ViewAssertions.matches(ViewMatchers.withText("omg")))
    }
}