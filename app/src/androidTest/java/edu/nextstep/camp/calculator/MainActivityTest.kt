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

    @Test
    fun 버튼_0을_누르면_화면에_0이_보여야_한다() {
        // when
        onView(withId(R.id.button0)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun 버튼_1을_누르면_화면에_1이_보여야_한다() {
        // when
        onView(withId(R.id.button1)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun 버튼_2를_누르면_화면에_2가_보여야_한다() {
        // when
        onView(withId(R.id.button2)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun 버튼_3을_누르면_화면에_3이_보여야_한다() {
        // when
        onView(withId(R.id.button3)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun 버튼_4를_누르면_화면에_4가_보여야_한다() {
        // when
        onView(withId(R.id.button4)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun 버튼_5를_누르면_화면에_5가_보여야_한다() {
        // when
        onView(withId(R.id.button5)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun 버튼_6을_누르면_화면에_6이_보여야_한다() {
        // when
        onView(withId(R.id.button6)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun 버튼_7을_누르면_화면에_7이_보여야_한다() {
        // when
        onView(withId(R.id.button7)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun 버튼_8을_누르면_화면에_8이_보여야_한다() {
        // when
        onView(withId(R.id.button8)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun 버튼_9를_누르면_화면에_9가_보여야_한다() {
        // when
        onView(withId(R.id.button9)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

}
