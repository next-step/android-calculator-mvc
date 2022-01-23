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
    fun click_1_2_3_shows_123() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("123")))
    }

    @Test
    fun click_1_3_plus_2_2_shows_1_3_plus_2_2() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("13 + 22")))
    }

    @Test
    fun click_9_multiply_divide_3_shows_9_divide_3() {
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("9 / 3")))
    }

    @Test
    fun click_1_2_3_multiply_delete_delete_divide_3_shows_1_2_divide_3() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("12 / 3")))
    }

    @Test
    fun click_2_multiply_3_3_then_shows_66() {
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("66")))
    }

    @Test
    fun click_66_divide_3_plus_3_multiply_2_shows_50() {
        onView(withId(R.id.button6)).perform(click())
        onView(withId(R.id.button6)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("50")))
    }
}