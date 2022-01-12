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
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun whenClick0Button_thenShow0InTextView() {
        // when: 사용자가 피연산자 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())
        // then: 화면에 0이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun whenClick1Button_thenShow1InTextView() {
        // when: 사용자가 피연산자 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())
        // then: 화면에 1이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun whenClick2Button_thenShow2InTextView() {
        // when: 사용자가 피연산자 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())
        // then: 화면에 2이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun whenClick3Button_thenShow3InTextView() {
        // when: 사용자가 피연산자 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())
        // then: 화면에 3이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun whenClick4Button_thenShow4InTextView() {
        // when: 사용자가 피연산자 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())
        // then: 화면에 4이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun whenClick5Button_thenShow5InTextView() {
        // when: 사용자가 피연산자 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())
        // then: 화면에 5이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun whenClick6Button_thenShow6InTextView() {
        // when: 사용자가 피연산자 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())
        // then: 화면에 6이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun whenClick7Button_thenShow7InTextView() {
        // when: 사용자가 피연산자 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())
        // then: 화면에 7이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun whenClick8Button_thenShow8InTextView() {
        // when: 사용자가 피연산자 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())
        // then: 화면에 8이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun whenClick9Button_thenShow9InTextView() {
        // when: 사용자가 피연산자 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())
        // then: 화면에 9이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }
}
