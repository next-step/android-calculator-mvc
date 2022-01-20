package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
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
    fun click0button() {
        // when: 사용자가 피연산자 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then: 계산기 텍스트에 0가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun click1button() {
        // when: 사용자가 피연산자 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then: 계산기 텍스트에 1가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun click2button() {
        // when: 사용자가 피연산자 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then: 계산기 텍스트에 2가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun click3button() {
        // when: 사용자가 피연산자 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then: 계산기 텍스트에 3가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun click4button() {
        // when: 사용자가 피연산자 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 계산기 텍스트에 4가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun click5button() {
        // when: 사용자가 피연산자 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then: 계산기 텍스트에 5가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun click6button() {
        // when: 사용자가 피연산자 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then: 계산기 텍스트에 6가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun click7button() {
        // when: 사용자가 피연산자 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then: 계산기 텍스트에 7가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun click8button() {
        // when: 사용자가 피연산자 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then: 계산기 텍스트에 8가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun click9button() {
        // when: 사용자가 피연산자 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 계산기 텍스트에 9가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    @Test
    fun clickNumberButtonWhenLastInputIsNotNumber() {
        //given
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        //when
        onView(withId(R.id.button1)).perform(click())

        //then
        onView(withId(R.id.textView)).check(matches(withText("5 + 1")))
    }

    @Test
    fun clickNumberButtonWhenLastInputIsNumber() {
        //given
        onView(withId(R.id.button8)).perform(click())

        //when
        onView(withId(R.id.button9)).perform(click())

        //then
        onView(withId(R.id.textView)).check(matches(withText("89")))
    }

    @Test
    fun clickOperatorButtonWhenLastInputIsNotNumber() {
        //given
        //when
        onView(withId(R.id.buttonPlus)).perform(click())

        //then
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun clickOperatorButtonWhenLastInputIsNumber() {
        //given
        onView(withId(R.id.button1)).perform(click())

        //when
        onView(withId(R.id.buttonPlus)).perform(click())

        //then
        onView(withId(R.id.textView)).check(matches(withText("1 + ")))
    }

    @Test
    fun clickOperatorButtonWhenLastInputIsOperator() {
        //given
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        //when
        onView(withId(R.id.buttonMinus)).perform(click())

        //then
        onView(withId(R.id.textView)).check(matches(withText("1 - ")))
    }

    @Test
    fun clickDeleteButtonWhenEmpty() {
        //given
        //when
        onView(withId(R.id.buttonDelete)).perform(click())

        //then
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun clickDeleteButtonWhenExistOperation() {
        //given
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())

        //when
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())

        //then
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun clickEqualsButtonWhenExistProperOperation() {
        //given
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())

        //when
        onView(withId(R.id.buttonEquals)).perform(click())

        //then
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }
}
