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
    fun whenButton0IsPressed0IsShown() {
        onView(withId(R.id.button0)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun whenButton1IsPressed1IsShown() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun whenButton2IsPressed2IsShown() {
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun whenButton3IsPressed3IsShown() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }
    @Test
    fun whenButton4IsPressed4IsShown() {
        onView(withId(R.id.button4)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }
    @Test
    fun whenButton5IsPressed5IsShown() {
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }
    @Test
    fun whenButton6IsPressed6IsShown() {
        onView(withId(R.id.button6)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }
    @Test
    fun whenButton7IsPressed7IsShown() {
        onView(withId(R.id.button7)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun whenButton8IsPressed8IsShown() {
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }
    @Test
    fun whenButton9IsPressed9IsShown() {
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

}
