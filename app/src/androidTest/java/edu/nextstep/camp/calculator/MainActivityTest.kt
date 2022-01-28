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
    fun whenClick0_thenDisplay0() {
        // when: 사용자가 피연산자 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun whenClick1_thenDisplay1() {
        // when: 사용자가 피연산자 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then: 계산기 텍스트에 1이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun whenClick2_thenDisplay2() {
        // when: 사용자가 피연산자 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then: 계산기 텍스트에 2이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun whenClick3_thenDisplay3() {
        // when: 사용자가 피연산자 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then: 계산기 텍스트에 3이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun whenClick4_thenDisplay4() {
        // when: 사용자가 피연산자 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 계산기 텍스트에 4이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun whenClick5_thenDisplay5() {
        // when: 사용자가 피연산자 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then: 계산기 텍스트에 5이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun whenClick6_thenDisplay6() {
        // when: 사용자가 피연산자 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then: 계산기 텍스트에 6이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun whenClick7_thenDisplay7() {
        // when: 사용자가 피연산자 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then: 계산기 텍스트에 7이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun whenClick8_thenDisplay8() {
        // when: 사용자가 피연산자 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then: 계산기 텍스트에 8이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun whenClick9_thenDisplay9() {
        // when: 사용자가 피연산자 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 계산기 텍스트에 9이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    @Test
    fun givenDisplay8_whenClick9_thenDisplay89() {
        // given: 입력된 피연산자가 8일 때
        onView(withId(R.id.button8)).perform(click())

        // when: 사용자가 피연산자 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 계산기 텍스트에 89가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("89")))
    }

    @Test
    fun givenDisplay5_whenClick4_thenDisplay54() {
        // given: 입력된 피연산자가 5일 때
        onView(withId(R.id.button5)).perform(click())

        // when: 사용자가 피연산자 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 계산기 텍스트에 54가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("54")))
    }

    @Test
    fun whenClickDivide_thenDisplayEmpty() {
        // when: 사용자가 연산자 나누기 버튼을 누르면
        onView(withId(R.id.buttonDivide)).perform(click())

        // then: 계산기 텍스트가 공백으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun whenClickMultiply_thenDisplayEmpty() {
        // when: 사용자가 연산자 곱하기 버튼을 누르면
        onView(withId(R.id.buttonMultiply)).perform(click())

        // then: 계산기 텍스트가 공백으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun whenClickPlus_thenDisplayEmpty() {
        // when: 사용자가 연산자 더하기 버튼을 누르면
        onView(withId(R.id.buttonPlus)).perform(click())

        // then: 계산기 텍스트가 공백으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun whenClickMinus_thenDisplayEmpty() {
        // when: 사용자가 연산자 빼기 버튼을 누르면
        onView(withId(R.id.buttonMinus)).perform(click())

        // then: 계산기 텍스트가 공백으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun givenDisplay4_whenClickMultiply_thenDisplayExpression() {
        // given: 입력된 피연산자가 4일 때
        onView(withId(R.id.button4)).perform(click())

        // when: 사용자가 연산자 곱하기 버튼을 누르면
        onView(withId(R.id.buttonMultiply)).perform(click())

        // then: 계산기 텍스트에 4 × 가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4 ×")))
    }

    @Test
    fun givenDisplay8_whenClickMinus_thenDisplayExpression() {
        // given: 입력된 피연산자가 8일 때
        onView(withId(R.id.button8)).perform(click())

        // when: 사용자가 연산자 빼기 버튼을 누르면
        onView(withId(R.id.buttonMinus)).perform(click())

        // then: 계산기 텍스트에 8 - 가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8 -")))
    }

    @Test
    fun givenDisplayExpression_whenClickDivide_thenDisplayExpression() {
        // given: 입력된 피연산자가 3 + 일 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        // when: 사용자가 연산자 나누기 버튼을 누르면
        onView(withId(R.id.buttonDivide)).perform(click())

        // then: 계산기 텍스트에 3 ÷ 가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3 ÷")))
    }

    @Test
    fun whenClickDelete_thenDisplayEmpty() {
        // when: 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then: 계산기 텍스트가 공백으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun givenDisplayExpression_whenClickDelete_thenDisplayExpression() {
        // given: 입력된 수식이 32 + 1 일 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())

        // when: 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then: 계산기 텍스트에 32 + 으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("32 +")))
    }

    @Test
    fun givenDisplayExpression_whenClickDelete_thenDisplay32() {
        // given: 입력된 수식이 32 + 일 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        // when: 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then: 계산기 텍스트에 32 으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("32")))
    }

    @Test
    fun givenDisplay32_whenClickDelete_thenDisplay3() {
        // given: 입력된 피연산자가 32 일 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())

        // when: 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then: 계산기 텍스트에 3 으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun givenDisplayExpression_whenClickEquals_thenDisplayResult() {
        // given: 입력된 수식이 3 + 2 + 1 * 5일 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.button5)).perform(click())

        // when: 사용자가 = 버튼을 누르면
        onView(withId(R.id.buttonEquals)).perform(click())

        // then: 계산기 텍스트에 30.0 으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("30.0")))
    }

    @Test
    fun givenDisplayExpression_whenClickEquals_thenDisplayResult2() {
        // given: 입력된 수식이 4 + 2 + 1 * 5일 때
        onView(withId(R.id.button4)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.button5)).perform(click())

        // when: 사용자가 = 버튼을 누르면
        onView(withId(R.id.buttonEquals)).perform(click())

        // then: 계산기 텍스트에 30.0 으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("35.0")))
    }
}