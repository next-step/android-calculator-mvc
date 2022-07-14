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

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    // 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @Test
    fun pressButton0() {
        // when
        onView(withId(R.id.button0)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun pressButton1() {
        // when
        onView(withId(R.id.button1)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun pressButton2() {
        // when
        onView(withId(R.id.button2)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun pressButton3() {
        // when
        onView(withId(R.id.button3)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun pressButton4() {
        // when
        onView(withId(R.id.button4)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun pressButton5() {
        // when
        onView(withId(R.id.button5)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun pressButton6() {
        // when
        onView(withId(R.id.button6)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun pressButton7() {
        // when
        onView(withId(R.id.button7)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun pressButton8() {
        // when
        onView(withId(R.id.button8)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun pressButton9() {
        // when
        onView(withId(R.id.button9)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

}