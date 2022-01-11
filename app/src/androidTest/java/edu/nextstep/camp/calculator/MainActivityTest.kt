package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    // 사용자가 피연산자 0 버튼을 누르면 화면에 0이 보여야 한다.
    @Test
    fun test0() {
        // when: 사용자가 0 버튼을 누르면
        Espresso.onView(withText("0")).perform(click())

        // then: 화면에 0이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    // 사용자가 피연산자 1 버튼을 누르면 화면에 1이 보여야 한다.
    @Test
    fun test1() {
        // when: 사용자가 1 버튼을 누르면
        Espresso.onView(withText("1")).perform(click())

        // then: 화면에 1이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    // 사용자가 피연산자 2 버튼을 누르면 화면에 2이 보여야 한다.
    @Test
    fun test2() {
        // when: 사용자가 2 버튼을 누르면
        Espresso.onView(withText("2")).perform(click())

        // then: 화면에 2이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    // 사용자가 피연산자 3 버튼을 누르면 화면에 3이 보여야 한다.
    @Test
    fun test3() {
        // when: 사용자가 3 버튼을 누르면
        Espresso.onView(withText("3")).perform(click())

        // then: 화면에 3이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    // 사용자가 피연산자 4 버튼을 누르면 화면에 4이 보여야 한다.
    @Test
    fun test4() {
        // when: 사용자가 4 버튼을 누르면
        Espresso.onView(withText("4")).perform(click())

        // then: 화면에 4이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    // 사용자가 피연산자 5 버튼을 누르면 화면에 5이 보여야 한다.
    @Test
    fun test5() {
        // when: 사용자가 5 버튼을 누르면
        Espresso.onView(withText("5")).perform(click())

        // then: 화면에 5이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    // 사용자가 피연산자 6 버튼을 누르면 화면에 6이 보여야 한다.
    @Test
    fun test6() {
        // when: 사용자가 6 버튼을 누르면
        Espresso.onView(withText("6")).perform(click())

        // then: 화면에 6이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    // 사용자가 피연산자 7 버튼을 누르면 화면에 7이 보여야 한다.
    @Test
    fun test7() {
        // when: 사용자가 7 버튼을 누르면
        Espresso.onView(withText("7")).perform(click())

        // then: 화면에 7이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    // 사용자가 피연산자 8 버튼을 누르면 화면에 8이 보여야 한다.
    @Test
    fun test8() {
        // when: 사용자가 8 버튼을 누르면
        Espresso.onView(withText("8")).perform(click())

        // then: 화면에 8이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    // 사용자가 피연산자 9 버튼을 누르면 화면에 9이 보여야 한다.
    @Test
    fun test9() {
        // when: 사용자가 9 버튼을 누르면
        Espresso.onView(withText("9")).perform(click())

        // then: 화면에 9이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("9")))
    }
}
