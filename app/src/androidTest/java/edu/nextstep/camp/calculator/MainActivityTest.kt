package edu.nextstep.camp.calculator

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

class MainActivityTest {
    @get:Rule
    val activityScenarioRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test0() {
        // when : 사용자가 피연산자 0 버튼을 누르면
        onView(withText("0")).perform(click())
        // then : 화면에 0가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun test1() {
        // when : 사용자가 피연산자 1 버튼을 누르면
        onView(withText("1")).perform(click())
        // then : 화면에 1가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))

    }

    @Test
    fun test2() {
        // when : 사용자가 피연산자 2 버튼을 누르면
        onView(withText("2")).perform(click())
        // then : 화면에 2가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))

    }

    @Test
    fun test3() {
        // when : 사용자가 피연산자 3 버튼을 누르면
        onView(withText("3")).perform(click())
        // then : 화면에 3가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun test4() {
        // when : 사용자가 피연산자 4 버튼을 누르면
        onView(withText("4")).perform(click())
        // then : 화면에 4가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun test5() {
        // when : 사용자가 피연산자 5 버튼을 누르면
        onView(withText("5")).perform(click())
        // then : 화면에 5가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun test6() {
        // when : 사용자가 피연산자 6 버튼을 누르면
        onView(withText("6")).perform(click())
        // then : 화면에 6가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun test7() {
        // when : 사용자가 피연산자 7 버튼을 누르면
        onView(withText("7")).perform(click())
        // then : 화면에 7가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun test8() {
        // when : 사용자가 피연산자 8 버튼을 누르면
        onView(withText("8")).perform(click())
        // then : 화면에 8가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun test9() {
        // when : 사용자가 피연산자 9 버튼을 누르면
        onView(withText("9")).perform(click())
        // then : 화면에 0가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }


}