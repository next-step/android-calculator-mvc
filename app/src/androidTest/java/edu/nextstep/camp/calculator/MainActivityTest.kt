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
    fun test0() {
        // given
        onView(withId(R.id.button0)).perform(click())

        // then: textView에 0이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun test1() {
        // given
        onView(withId(R.id.button1)).perform(click())

        // then: textView에 1이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun test2() {
        // given
        onView(withId(R.id.button2)).perform(click())

        // then: textView에 2가 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun test3() {
        // given
        onView(withId(R.id.button3)).perform(click())

        // then: textView에 3이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun test4() {
        // given
        onView(withId(R.id.button4)).perform(click())

        // then: textView에 4가 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun test5() {
        // given
        onView(withId(R.id.button5)).perform(click())

        // then: textView에 5가 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun test6() {
        // given
        onView(withId(R.id.button6)).perform(click())

        // then: textView에 6이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun test7() {
        // given
        onView(withId(R.id.button7)).perform(click())

        // then: textView에 7이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun test8() {
        // given
        onView(withId(R.id.button8)).perform(click())

        // then: textView에 8이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun test9() {
        // given
        onView(withId(R.id.button9)).perform(click())

        // then: textView에 9가 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }
}