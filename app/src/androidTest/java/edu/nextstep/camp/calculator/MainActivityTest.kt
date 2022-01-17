package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso
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

    // 사용자가 피연산자 0 버튼을 누르면 화면에 0이 보여야 한다.
    @Test
    fun pressNumberButton0() {
        // when: 사용자가 0 버튼을 누르면
        Espresso.onView(withId(R.id.button0)).perform(click())

        // then: 화면에 0이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    // 사용자가 피연산자 1 버튼을 누르면 화면에 1이 보여야 한다.
    @Test
    fun pressNumberButton1() {
        // when: 사용자가 1 버튼을 누르면
        Espresso.onView(withId(R.id.button1)).perform(click())

        // then: 화면에 1이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    // 사용자가 피연산자 2 버튼을 누르면 화면에 2이 보여야 한다.
    @Test
    fun pressNumberButton2() {
        // when: 사용자가 2 버튼을 누르면
        Espresso.onView(withId(R.id.button2)).perform(click())

        // then: 화면에 2이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    // 사용자가 피연산자 3 버튼을 누르면 화면에 2이 보여야 한다.
    @Test
    fun pressNumberButton3() {
        // when: 사용자가 3 버튼을 누르면
        Espresso.onView(withId(R.id.button3)).perform(click())

        // then: 화면에 3이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    // 사용자가 피연산자 4 버튼을 누르면 화면에 4이 보여야 한다.
    @Test
    fun pressNumberButton4() {
        // when: 사용자가 4 버튼을 누르면
        Espresso.onView(withId(R.id.button4)).perform(click())

        // then: 화면에 4이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    // 사용자가 피연산자 5 버튼을 누르면 화면에 5이 보여야 한다.
    @Test
    fun pressNumberButton5() {
        // when: 사용자가 5 버튼을 누르면
        Espresso.onView(withId(R.id.button5)).perform(click())

        // then: 화면에 5이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    // 사용자가 피연산자 6 버튼을 누르면 화면에 6이 보여야 한다.
    @Test
    fun pressNumberButton6() {
        // when: 사용자가 6 버튼을 누르면
        Espresso.onView(withId(R.id.button6)).perform(click())

        // then: 화면에 6이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    // 사용자가 피연산자 7 버튼을 누르면 화면에 7이 보여야 한다.
    @Test
    fun pressNumberButton7() {
        // when: 사용자가 7 버튼을 누르면
        Espresso.onView(withId(R.id.button7)).perform(click())

        // then: 화면에 7이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    // 사용자가 피연산자 8 버튼을 누르면 화면에 8이 보여야 한다.
    @Test
    fun pressNumberButton8() {
        // when: 사용자가 8 버튼을 누르면
        Espresso.onView(withId(R.id.button8)).perform(click())

        // then: 화면에 8이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    // 사용자가 피연산자 9 버튼을 누르면 화면에 9이 보여야 한다.
    @Test
    fun pressNumberButton9() {
        // when: 사용자가 9 버튼을 누르면
        Espresso.onView(withId(R.id.button9)).perform(click())

        // then: 화면에 9이 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    // 사용자가 피연산자 9 버튼을 누르면 화면에 9이 보여야 한다.
    @Test
    fun inputNumber89() {
        // when: 사용자가 8과 9 버튼을 누르면
        Espresso.onView(withId(R.id.button8)).perform(click())
        Espresso.onView(withId(R.id.button9)).perform(click())

        // then: 화면에 89가 보여야 한다.
        Espresso.onView(withId(R.id.textView)).check(matches(withText("89")))
    }
}
