package edu.nextstep.camp.calculator;

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

    // 입력된 피연산자가 없을 때, 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @Test
    fun clickButton0_shouldShow0() {
        // when: 사용자가 피연산자 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then: 화면 에 0가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun clickButton1_shouldShow1() {
        // when: 사용자가 피연산자 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then: 화면 에 1가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun clickButton2_shouldShow2() {
        // when: 사용자가 피연산자 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then: 화면 에 2가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun clickButton3_shouldShow3() {
        // when: 사용자가 피연산자 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then: 화면 에 3가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun clickButton4_shouldShow4() {
        // when: 사용자가 피연산자 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 화면 에 4가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun clickButton5_shouldShow5() {
        // when: 사용자가 피연산자 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then: 화면 에 5가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun clickButton6_shouldShow6() {
        // when: 사용자가 피연산자 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then: 화면 에 6가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun clickButton7_shouldShow7() {
        // when: 사용자가 피연산자 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then: 화면 에 7가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun clickButton8_shouldShow8() {
        // when: 사용자가 피연산자 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then: 화면 에 8가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun clickButton9_shouldShow9() {
        // when: 사용자가 피연산자 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 화면 에 9가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    @Test
    fun `입력된 피연산자가 있을 때 기존 숫자 뒤에 해당 숫자가 화면에 보여야 한다`() {
        // when: 사용자가 8 버튼 누른 후, 9 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.button9)).perform(click())

        // then: 화면에 '89'를 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("89")))
    }

    // 입력된 피연산자가 없을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
    @Test
    fun `입력된 피연산자가 없을 때 사용자가 사칙 연산자 버튼을 누르면 화면에 아무런 변화가 없어야 한다`() {
        // when: 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())

        // then: 화면에 ''를 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    // 입력된 피연산자가 있을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 해당 기호가 화면에 보여야 한다.
    @Test
    fun `입력된 피연산자가 있을 때 사용자가 사칙 연산자 버튼을 누르면 해당 기호가 화면에 보여야 한다1`() {
        // when: 사용자가 버튼 5를 입력 후 연산자 + 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        // then: 화면에 '5 +'가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("5 +")))
    }

    @Test
    fun `입력된 피연산자가 있을 때 사용자가 사칙 연산자 버튼을 누르면 해당 기호가 화면에 보여야 한다2`() {
        // when: 사용자가 버튼 5를 입력 후 연산자 + 버튼을 누른 후 연산자 -를 누르면
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())

        // then: 화면에 '5 -'가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("5 -")))
    }

    @Test
    fun `입력된 수식이 없을 때 사용자가 지우기 버튼을 누르면 화면에 아무런 변화가 없어야 한다`() {
        // when: 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then: 화면에 ''이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun `입력된 수식이 있을 때 사용자가 지우기 버튼을 누르면 수식에 마지막으로 입력된 연산자 또는 피연산자가 지워져야 한다`() {
        // given: 수식 '35 + 1'가 주어졌을 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())

        // when: 입력 후 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then: 화면에 '35 +'이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("35 +")))
    }

    // 입력된 수신이 완전할 때, 사용자가 = 버튼을 누르면 입력된 수식의 결과가 화면에 보여야 한다.
    @Test
    fun `입력된 수신이 완전할 때 사용자가 등호 버튼을 누르면 입력된 수식의 결과가 화면에 보여야 한다`() {
        // given: 수식 '3 + 5'가 주어졌을 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button5)).perform(click())

        // when: 사용자가 = 버튼을 누르면
        onView(withId(R.id.buttonEquals)).perform(click())

        // then: 화면에 수식을 계산한 결과값 '8'이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }
}
