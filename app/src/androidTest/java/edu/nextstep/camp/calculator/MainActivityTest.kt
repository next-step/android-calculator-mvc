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
    fun button0() {
        // when : '0' 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then : '0'이 보여야 한다.
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("0")))
    }

    @Test
    fun button1() {
        // when : '1' 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then : '1'이 보여야 한다.
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("1")))
    }

    @Test
    fun button2() {
        // when : '2' 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then : '2'이 보여야 한다.
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("2")))
    }

    @Test
    fun button3() {
        // when : '3' 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then : '3'이 보여야 한다.
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("3")))
    }

    @Test
    fun button4() {
        // when : '4' 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then : '4'가 보여야 한다.
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("4")))
    }

    @Test
    fun button5() {
        // when : '5' 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then : '5'가 보여야 한다.
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("5")))
    }

    @Test
    fun button6() {
        // when : '6' 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then : '6'이 보여야 한다.
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("6")))
    }

    @Test
    fun button7() {
        // when : '7' 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then : '7'이 보여야 한다.
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("7")))
    }

    @Test
    fun button8() {
        // when : '8' 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then : '8'이 보여야 한다.
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("8")))
    }

    @Test
    fun button9() {
        // when : '9' 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then : '9'가 보여야 한다.
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("9")))
    }

    // 입력된 피연산자가 없을 때, 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @Test
    fun buttonPressed1() {
        // when : -> 1 클릭 -> 1
        onView(withId(R.id.button1)).perform(click())

        // then : '1'이 보여야 한다
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("1")))
    }

    // 입력된 피연산자가 없을 때, 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @Test
    fun buttonPress5_Plus_1() {
        // when : 5 + -> 1 클릭 -> 5 + 1
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())

        // then : '5 + 1'이 보여야 한다
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("5 + 1")))
    }

    // 입력된 피연산자가 있을 때, 기존 숫자 뒤에 해당 숫자가 화면에 보여야 한다. 예를 들면, 8이 입력되어 있을 때 9를 입력하면 89가 보여야 한다.
    @Test
    fun buttonPress8_9() {
        // when : 8 -> 9 클릭 -> 89
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.button9)).perform(click())

        // then : '5 + 1'이 보여야 한다
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("89")))
    }

    // 입력된 피연산자가 없을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
    @Test
    fun buttonPressOperator_noOperand() {
        // when : -> +, -, ×, ÷ 클릭 ->
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())

        // then : '5 + 1'이 보여야 한다
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("")))
    }

    // 입력된 피연산자가 있을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 해당 기호가 화면에 보여야 한다.
    @Test
    fun buttonPressOperator_hasOperand_1() {
        // when : 1 -> + 클릭 -> 1 +
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        // then : '5 + 1'이 보여야 한다
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("1 +")))
    }

    // 입력된 피연산자가 있을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 해당 기호가 화면에 보여야 한다.
    @Test
    fun buttonPressOperator_hasOperand_2() {
        // when : 1 + -> - 클릭 -> 1 -
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())

        // then : '5 + 1'이 보여야 한다
        onView(withId(R.id.tvResultDisplay)).check(matches(withText("1 -")))
    }
}