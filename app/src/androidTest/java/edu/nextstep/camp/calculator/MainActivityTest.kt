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

    // 사용자가 피연산자 0 버튼을 누르면 화면에 0가 화면에 보여야 한다.
    @Test
    fun test0() {
        // when: 사용자가 피연산자 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then: 화면 에 0가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    // 사용자가 피연산자 1 버튼을 누르면 화면에 1가 화면에 보여야 한다.
    @Test
    fun test1() {
        // when: 사용자가 피연산자 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then: 화면 에 1가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    // 사용자가 피연산자 2 버튼을 누르면 화면에 2가 화면에 보여야 한다.
    @Test
    fun test2() {
        // when: 사용자가 피연산자 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then: 화면 에 2가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    // 사용자가 피연산자 3 버튼을 누르면 화면에 3가 화면에 보여야 한다.
    @Test
    fun test3() {
        // when: 사용자가 피연산자 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then: 화면 에 3가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    // 사용자가 피연산자 4 버튼을 누르면 화면에 4가 화면에 보여야 한다.
    @Test
    fun test4() {
        // when: 사용자가 피연산자 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 화면 에 4가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    // 사용자가 피연산자 5 버튼을 누르면 화면에 5가 화면에 보여야 한다.
    @Test
    fun test5() {
        // when: 사용자가 피연산자 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then: 화면 에 5가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    // 사용자가 피연산자 0 버튼을 누르면 화면에 0가 화면에 보여야 한다.
    @Test
    fun test6() {
        // when: 사용자가 피연산자 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then: 화면 에 6가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    // 사용자가 피연산자 7 버튼을 누르면 화면에 7가 화면에 보여야 한다.
    @Test
    fun test7() {
        // when: 사용자가 피연산자 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then: 화면 에 7가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    // 사용자가 피연산자 0 버튼을 누르면 화면에 0가 화면에 보여야 한다.
    @Test
    fun test8() {
        // when: 사용자가 피연산자 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then: 화면 에 8가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun test9() {
        // when: 사용자가 피연산자 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 화면 에 9가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }
}