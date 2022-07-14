package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 07. 14..
 */
class MainActivityTest{
    //사용자가 피연사자 0-9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 버튼_0을_누르면_화면에_0이_보여야_한다() {
        //when: 0 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(click())
        //then: 화면에 0이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("0")))

    }

    @Test
    fun 버튼_1을_누르면_화면에_1이_보여야_한다() {
        //when: 1 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(click())
        //then: 화면에 1이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("1")))

    }

    @Test
    fun 버튼_2을_누르면_화면에_2이_보여야_한다() {
        //when: 2 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(click())
        //then: 화면에 2이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("2")))

    }
    @Test
    fun 버튼_3을_누르면_화면에_3이_보여야_한다() {
        //when: 3 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button3)).perform(click())
        //then: 화면에 3이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("3")))

    } @Test
    fun 버튼_4을_누르면_화면에_4이_보여야_한다() {
        //when: 4 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(click())
        //then: 화면에 4이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("4")))

    }
    @Test
    fun 버튼_5을_누르면_화면에_5이_보여야_한다() {
        //when: 5 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(click())
        //then: 화면에 5이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("5")))

    }
    @Test
    fun 버튼_6을_누르면_화면에_6이_보여야_한다() {
        //when: 6 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button6)).perform(click())
        //then: 화면에 6이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("6")))

    }
    @Test
    fun 버튼_7을_누르면_화면에_7이_보여야_한다() {
        //when: 7 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button7)).perform(click())
        //then: 화면에 7이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("7")))

    }
    @Test
    fun 버튼_8을_누르면_화면에_8이_보여야_한다() {
        //when: 8 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button8)).perform(click())
        //then: 화면에 8이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("8")))

    }
    @Test
    fun 버튼_9을_누르면_화면에_9이_보여야_한다() {
        //when: 9 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button9)).perform(click())
        //then: 화면에 9이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("9")))

    }

}