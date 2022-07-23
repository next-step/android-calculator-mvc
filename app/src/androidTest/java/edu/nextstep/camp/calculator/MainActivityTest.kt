package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    //안드로이드 테스트에서는 method 명으로 공백을 사용하지 못한다

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun `버튼_0을_누르면_화면에_0이_보여야_한다`() {

        onView(ViewMatchers.withId(R.id.button0)).perform(click())

        onView(ViewMatchers.withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun `버튼_1을_누르면_화면에_1이_보여야_한다`() {

        onView(ViewMatchers.withId(R.id.button1)).perform(click())

        onView(ViewMatchers.withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun `버튼_2을_누르면_화면에_2이_보여야_한다`() {

        onView(ViewMatchers.withId(R.id.button2)).perform(click())

        onView(ViewMatchers.withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun `버튼_3을_누르면_화면에_3이_보여야_한다`() {

        onView(ViewMatchers.withId(R.id.button3)).perform(click())

        onView(ViewMatchers.withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun `버튼_4을_누르면_화면에_4이_보여야_한다`() {

        onView(ViewMatchers.withId(R.id.button4)).perform(click())

        onView(ViewMatchers.withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun `버튼_5을_누르면_화면에_5이_보여야_한다`() {

        onView(ViewMatchers.withId(R.id.button5)).perform(click())

        onView(ViewMatchers.withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun `버튼_6을_누르면_화면에_6이_보여야_한다`() {

        onView(ViewMatchers.withId(R.id.button6)).perform(click())

        onView(ViewMatchers.withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun `버튼_7을_누르면_화면에_7이_보여야_한다`() {

        onView(ViewMatchers.withId(R.id.button7)).perform(click())

        onView(ViewMatchers.withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun `버튼_8을_누르면_화면에_8이_보여야_한다`() {

        onView(ViewMatchers.withId(R.id.button8)).perform(click())

        onView(ViewMatchers.withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun `버튼_9을_누르면_화면에_9이_보여야_한다`() {

        onView(ViewMatchers.withId(R.id.button9)).perform(click())

        onView(ViewMatchers.withId(R.id.textView)).check(matches(withText("9")))
    }

}