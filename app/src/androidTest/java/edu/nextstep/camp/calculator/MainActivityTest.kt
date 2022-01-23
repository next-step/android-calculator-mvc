package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
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
    fun click_0button_show0() {
        // when: 사용자가 피연산자 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then: 계산기 텍스트에 0이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun click_1button_show1() {
        // when: 사용자가 피연산자 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then: 계산기 텍스트에 1이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun click_2button_show2() {
        // when: 사용자가 피연산자 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then: 계산기 텍스트에 2이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun click_3button_show3() {
        // when: 사용자가 피연산자 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then: 계산기 텍스트에 3이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun click_4button_show4() {
        // when: 사용자가 피연산자 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 계산기 텍스트에 4이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun click_5button_show5() {
        // when: 사용자가 피연산자 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then: 계산기 텍스트에 5이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun click_6button_show6() {
        // when: 사용자가 피연산자 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then: 계산기 텍스트에 6이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun click_7button_show7() {
        // when: 사용자가 피연산자 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then: 계산기 텍스트에 7이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun click_8button_show8() {
        // when: 사용자가 피연산자 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then: 계산기 텍스트에 8이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun click_9button_show9() {
        // when: 사용자가 피연산자 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 계산기 텍스트에 9이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    @Test
    fun noExistOperand_inputOperand_showOperand() {
        // when: 입력된 피연산자가 없을 때 사용자가 5, +, 1을 누르면
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())

        // then: 계산기 텍스트에 5 + 1이 보여야한다
        onView(withId(R.id.textView)).check(matches(withText("5 + 1")))
    }

    @Test
    fun existOperand_inputOperand_showOperand() {
        // given: 8이라는 숫자가 입력되어있을때
        onView(withId(R.id.button8)).perform(click())

        // when: 사용자가 9를 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 계산기 텍스트에 89가 보여야한다
        onView(withId(R.id.textView)).check(matches(withText("89")))
    }

    @Test
    fun noExistOperand_inputOperator_notChanged() {
        // given: 초기상태에서

        // when: 사용자가 +를 누르면
        onView(withId(R.id.buttonPlus)).perform(click())

        // then: 계산기 화면에 아무것도 보이지 않아야한다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun existOperand_inputOperator_showOperator() {
        // given: 1이라는 숫자가 입력되있을 때
        onView(withId(R.id.button1)).perform(click())

        // when: 사용자가 +를 누르면
        onView(withId(R.id.buttonPlus)).perform(click())

        // then: 계산기 화면에 1 +가 보여야한다
        onView(withId(R.id.textView)).check(matches(withText("1 +")))
    }

    @Test
    fun noExistAnything_clickDelete_notChanged() {
        // given: 아무것도 입력되지 않았을 때

        // when: 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then: 아무런 변화가 없어야한다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun existOperand_clickDelete_deleteLastOperand() {
        // given: 32 + 1이 입력되있을 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())

        // when: 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then: 1이 지워져야한다
        onView(withId(R.id.textView)).check(matches(withText("32 +")))
    }

    @Test
    fun perfectMathematicalExpression_clickEqual_showResult() {
        // given: 3 + 2가 입력되있을 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        // when: = 버튼을 누르면
        onView(withId(R.id.buttonEquals)).perform(click())

        // then: 계산기 화면에 5가 보여야한다
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }
}