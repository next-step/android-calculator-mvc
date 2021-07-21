package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun pressedZeroButton_shouldShowZero() {
        onView(withId(R.id.button0)).perform(click())

        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun pressedOneButton_shouldShowOne() {
        onView(withId(R.id.button1)).perform(click())

        onView(withId(R.id.textView)).check(matches(withText("1")))
    }
}