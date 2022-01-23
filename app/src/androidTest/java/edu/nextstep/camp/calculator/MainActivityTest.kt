package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun click_1_and_2_and_3_then_shows_123() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("123")))
    }

    @Test
    fun click_13_and_plus_and_22_then_shows_13_plus_22() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("13 + 22")))
    }

    @Test
    fun click_9_and_multiply_and_divide_3_then_shows_9_divide_3() {
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("9 / 3")))
    }
}