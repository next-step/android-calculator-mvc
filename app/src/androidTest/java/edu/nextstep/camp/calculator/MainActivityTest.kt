package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    //사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 버튼_0을_누르면_화면에_0이_보여야_한다() {
        //when 0이 눌리면
        onView(withId(R.id.button0)).perform(click())

        //then 0이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun 버튼_1을_누르면_화면에_1이_보여야_한다() {
        //when 1이 눌리면
        onView(withId(R.id.button1)).perform(click())

        //then 1이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun 버튼_2을_누르면_화면에_2이_보여야_한다() {
        //when 2이 눌리면
        onView(withId(R.id.button2)).perform(click())

        //then 2이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun 버튼_3을_누르면_화면에_3이_보여야_한다() {
        //when 3이 눌리면
        onView(withId(R.id.button3)).perform(click())

        //then 3이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun 버튼_4을_누르면_화면에_4이_보여야_한다() {
        //when 4이 눌리면
        onView(withId(R.id.button4)).perform(click())

        //then 4이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun 버튼_5을_누르면_화면에_5이_보여야_한다() {
        //when 5이 눌리면
        onView(withId(R.id.button5)).perform(click())

        //then 5이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun 버튼_6을_누르면_화면에_6이_보여야_한다() {
        //when 6이 눌리면
        onView(withId(R.id.button6)).perform(click())

        //then 6이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun 버튼_7을_누르면_화면에_7이_보여야_한다() {
        //when 7이 눌리면
        onView(withId(R.id.button7)).perform(click())

        //then 7이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun 버튼_8을_누르면_화면에_8이_보여야_한다() {
        //when 8이 눌리면
        onView(withId(R.id.button8)).perform(click())

        //then 8이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun 버튼_9을_누르면_화면에_9이_보여야_한다() {
        //when 9이 눌리면
        onView(withId(R.id.button9)).perform(click())

        //then 9이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }
}