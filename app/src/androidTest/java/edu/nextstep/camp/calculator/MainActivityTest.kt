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
    val activityScenarioRue = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun text0(){
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun text1(){
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun text2(){
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun text3(){
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun text4(){
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun text5(){
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun text6(){
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun text7(){
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun text8(){
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun text9(){
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }
}