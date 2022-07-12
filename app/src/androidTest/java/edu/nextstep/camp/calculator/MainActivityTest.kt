package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun on0ButtonPressed() {
        onView(withId(R.id.button0)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun on1ButtonPressed() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun on2ButtonPressed() {
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun on3ButtonPressed() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }
    @Test
    fun on4ButtonPressed() {
        onView(withId(R.id.button4)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }
    @Test
    fun on5ButtonPressed() {
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }
    @Test
    fun on6ButtonPressed() {
        onView(withId(R.id.button6)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }
    @Test
    fun on7ButtonPressed() {
        onView(withId(R.id.button7)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun on8ButtonPressed() {
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }
    @Test
    fun on9ButtonPressed() {
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

}
