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

    /**
     * 1. 입력된 피연산자가 없을 때 숫자를 누른 경우
     */
    @Test
    fun test0() {
        // when: 사용자가 피연산자 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun test1() {
        // when: 사용자가 피연산자 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then: 계산기 텍스트에 1이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun test2() {
        // when: 사용자가 피연산자 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then: 계산기 텍스트에 2이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun test3() {
        // when: 사용자가 피연산자 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then: 계산기 텍스트에 3이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun test4() {
        // when: 사용자가 피연산자 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 계산기 텍스트에 4이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun test5() {
        // when: 사용자가 피연산자 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then: 계산기 텍스트에 5이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun test6() {
        // when: 사용자가 피연산자 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then: 계산기 텍스트에 6이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun test7() {
        // when: 사용자가 피연산자 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then: 계산기 텍스트에 7이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun test8() {
        // when: 사용자가 피연산자 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then: 계산기 텍스트에 8이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun test9() {
        // when: 사용자가 피연산자 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 계산기 텍스트에 9이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    /**
     * 2. 입력된 피연산자가 있을 때 숫자를 누른 경우
     */

    @Test
    fun test10() {
        // given: 입력된 피연산자가 8일 때
        onView(withId(R.id.button8)).perform(click())

        // when: 사용자가 피연산자 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 계산기 텍스트에 89가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("89")))
    }

    @Test
    fun test11() {
        // given: 입력된 피연산자가 5일 때
        onView(withId(R.id.button5)).perform(click())

        // when: 사용자가 피연산자 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 계산기 텍스트에 89가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("54")))
    }

    /**
     * 3. 입력된 피연산자가 없을 때 연산자 버튼을 누른 경우
     */

    @Test
    fun test12() {
        // when: 사용자가 연산자 나누기 버튼을 누르면
        onView(withId(R.id.buttonDivide)).perform(click())

        // then: 계산기 텍스트가 공백으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun test13() {
        // when: 사용자가 연산자 곱하기 버튼을 누르면
        onView(withId(R.id.buttonMultiply)).perform(click())

        // then: 계산기 텍스트가 공백으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun test14() {
        // when: 사용자가 연산자 더하기 버튼을 누르면
        onView(withId(R.id.buttonPlus)).perform(click())

        // then: 계산기 텍스트가 공백으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun test15() {
        // when: 사용자가 연산자 빼기 버튼을 누르면
        onView(withId(R.id.buttonMinus)).perform(click())

        // then: 계산기 텍스트가 공백으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    /**
     * 4. 입력된 피연산자가 있을 때 연산자 버튼을 누른 경우
     */

    @Test
    fun test16() {
        // given: 입력된 피연산자가 4일 때
        onView(withId(R.id.button4)).perform(click())

        // when: 사용자가 연산자 곱하기 버튼을 누르면
        onView(withId(R.id.buttonMultiply)).perform(click())

        // then: 계산기 텍스트에 4 × 가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4 ×")))
    }

    @Test
    fun test17() {
        // given: 입력된 피연산자가 8일 때
        onView(withId(R.id.button8)).perform(click())

        // when: 사용자가 연산자 빼기 버튼을 누르면
        onView(withId(R.id.buttonMinus)).perform(click())

        // then: 계산기 텍스트에 8 - 가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8 -")))
    }

    @Test
    fun test18() {
        // given: 입력된 피연산자가 3 + 일 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        // when: 사용자가 연산자 나누기 버튼을 누르면
        onView(withId(R.id.buttonDivide)).perform(click())

        // then: 계산기 텍스트에 3 ÷ 가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3 ÷")))
    }

    /**
     * 5. 입력된 수식이 없을 때 지우기 버튼을 누른 경우
     */

    @Test
    fun test19() {
        // when: 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then: 계산기 텍스트가 공백으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    /**
     * 6. 입력된 수식이 있을 때 지우기 버튼을 누른 경우
     */

    @Test
    fun test20() {
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
    fun test21() {
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
    fun test22() {
        // given: 입력된 피연산자가 32 일 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())

        // when: 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then: 계산기 텍스트에 3 으로 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    /**
     * 7. 입력된 수식이 완전할 때 = 버튼을 누른 경우
     */

    @Test
    fun test23() {
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
    fun test24() {
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

    /**
     * 8. 입력된 수식이 완전하지 않을 때 = 버튼을 누른 경우
     *
     * 생략
     */
}