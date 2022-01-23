package edu.nextstep.camp.calculator

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

class MainActivityTest {
    @get:Rule
    val activityScenarioRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_number_button_clicked_when_not_click_nothing_right_before() {
        // when : 사용자가 피연산자 1 버튼을 누르면
        onView(withText("1")).perform(click())

        // then : 1이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun test_number_button_clicked_when_not_click_number_button_right_before() {
        // given : 사용자가 이전에 연산자 기호를 눌렀을 때
        onView(withText("5")).perform(click())
        onView(withText("+")).perform(click())

        // when : 피연산자 1 버튼을 누르면
        onView(withText("1")).perform(click())

        // then : 연산자 기호 뒤에 숫자 1이 와야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5+1")))
    }

    @Test
    fun test_number_button_clicked_when_click_number_button_right_before() {
        // given : 사용자가 이전에 숫자 5 버튼을 눌렀을 때
        onView(withText("5")).perform(click())

        // when : 피연산자 1 버튼을 누르면
        onView(withText("1")).perform(click())

        // then : 화면에 '51'이 나와야 한다
        onView(withId(R.id.textView)).check(matches(withText("51")))
    }

    @Test
    fun test_arithmetic_button_clicked_when_not_click_number_button_right_before() {
        // given : 입력된 피연사자 없을 때
        // when : 사용자가 연산자 기호를 누르면
        onView(withText("+")).perform(click())

        // then : 화면에 아무런 변화가 없어야 한다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun test_arithmetic_button_clicked_when_click_number_button_right_before() {
        // given : 입력된 피연사자 있을 때
        onView(withText("1")).perform(click())

        // when : 사용자가 연산자 기호를 누르면
        onView(withText("+")).perform(click())

        // then : 입력된 피연산자 뒤에 입력한 연산자 기호가 와야 한다
        onView(withId(R.id.textView)).check(matches(withText("1+")))
    }

    @Test
    fun test_arithmetic_button_clicked_when_click_number_button_and_arithmetic_button_right_before() {
        // given : 입력된 피연사자 있을 때
        onView(withText("1")).perform(click())
        onView(withText("+")).perform(click())

        // when : 사용자가 연산자 기호를 누르면
        onView(withText("-")).perform(click())

        // then : 입력된 피연산자 뒤에 입력한 연산자 기호가 와야 한다
        onView(withId(R.id.textView)).check(matches(withText("1-")))
    }

    @Test
    fun test_erase_button_clicked_when_no_input() {
        // given : 입력된 수식이 없을 때
        // when : 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then : 화면에 아무 변화가 없어야 한다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun test_erase_button_clicked_when_there_are_input() {
        // given : 입력된 수식이 있을 때
        onView(withText("3")).perform(click())
        onView(withText("2")).perform(click())
        onView(withText("+")).perform(click())
        onView(withText("1")).perform(click())

        // when : 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then : 마지막으로 입력한 수식이 지워져야 한다
        onView(withId(R.id.textView)).check(matches(withText("32+")))

        // when : 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then : 마지막으로 입력한 수식이 지워져야 한다
        onView(withId(R.id.textView)).check(matches(withText("32")))

        // when : 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then : 마지막으로 입력한 수식이 지워져야 한다
        onView(withId(R.id.textView)).check(matches(withText("3")))

        // when : 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then : 마지막으로 입력한 수식이 지워져야 한다
        onView(withId(R.id.textView)).check(matches(withText("")))

        // when : 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then : 마지막으로 입력한 수식이 지워져야 한다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun test_result_button_clicked_input_is_right() {
        // given : 입력된 수식이 완전할 때
        onView(withText("3")).perform(click())
        onView(withText("2")).perform(click())
        onView(withText("+")).perform(click())
        onView(withText("1")).perform(click())

        // when : = 버튼을 누르면
        onView(withText("=")).perform(click())

        // then : 화면에 입력된 수식의 결과가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("33.0")))
    }

    @Test
    fun test_result_button_clicked_input_is_not_right() {
        // given : 입력된 수식이 완전하지 않을 때
        onView(withText("3")).perform(click())
        onView(withText("+")).perform(click())

        // when : = 버튼을 누르면
        onView(withText("=")).perform(click())

        // then : '완성되지 않은 수식입니다' 토스트 메세지가 화면에 보여야 한다
        // 토스트 메세지에 대한 테스트 대신 수식의 변화가 없도록 확인
        onView(withId(R.id.textView)).check(matches(withText("3+")))
    }

}