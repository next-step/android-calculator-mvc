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
    // 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun display0_when_press_button0() {
        // when
        onView(withId(R.id.button0)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun display1_when_press_button1() {
        // when
        onView(withId(R.id.button1)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun display2_when_press_button2() {
        // when
        onView(withId(R.id.button2)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun display3_when_press_button3() {
        // when
        onView(withId(R.id.button3)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun display4_when_press_button4() {
        // when
        onView(withId(R.id.button4)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun display5_when_press_button5() {
        // when
        onView(withId(R.id.button5)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun display6_when_press_button6() {
        // when
        onView(withId(R.id.button6)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun display7_when_press_button7() {
        // when
        onView(withId(R.id.button7)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun display8_when_press_button8() {
        // when
        onView(withId(R.id.button8)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun display9_when_press_button9() {
        // when
        onView(withId(R.id.button9)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }
}
