package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test0() {
        // when
        onView(withText("0")).perform(click())

        // then
        onView(withId(R.id.tv_result)).check(matches(withText("0")))
    }

    @Test
    fun test1() {
        // when
        onView(withText("1")).perform(click())

        // then
        onView(withId(R.id.tv_result)).check(matches(withText("1")))
    }

    @Test
    fun test2() {
        // when
        onView(withText("2")).perform(click())

        // then
        onView(withId(R.id.tv_result)).check(matches(withText("2")))
    }

    @Test
    fun test3() {
        // when
        onView(withText("3")).perform(click())

        // then
        onView(withId(R.id.tv_result)).check(matches(withText("3")))
    }

    @Test
    fun test4() {
        // when
        onView(withText("4")).perform(click())

        // then
        onView(withId(R.id.tv_result)).check(matches(withText("4")))
    }

    @Test
    fun test5() {
        // when
        onView(withText("5")).perform(click())

        // then
        onView(withId(R.id.tv_result)).check(matches(withText("5")))
    }

    @Test
    fun test6() {
        // when
        onView(withText("6")).perform(click())

        // then
        onView(withId(R.id.tv_result)).check(matches(withText("6")))
    }

    @Test
    fun test7() {
        // when
        onView(withText("7")).perform(click())

        // then
        onView(withId(R.id.tv_result)).check(matches(withText("7")))
    }

    @Test
    fun test8() {
        // when
        onView(withText("8")).perform(click())

        // then
        onView(withId(R.id.tv_result)).check(matches(withText("8")))
    }

    @Test
    fun test9() {
        // when
        onView(withText("9")).perform(click())

        // then
        onView(withId(R.id.tv_result)).check(matches(withText("9")))
    }
}
