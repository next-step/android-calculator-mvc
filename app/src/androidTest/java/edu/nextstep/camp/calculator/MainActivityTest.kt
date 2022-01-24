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
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun when_click_0_then_show_0() {
        // when : 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then : 화면에 0가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    //사용자가 피연산자 1버튼을 누르면 화면에 1가 화면에 보여야 한다.
    @Test
    fun when_click_1_then_show_1() {
        // when : 사용자가 피연산자 1버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then : 화면에 1가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    //사용자가 피연산자 2버튼을 누르면 화면에 2가 화면에 보여야 한다.
    @Test
    fun when_click_2_then_show_2() {
        // when : 사용자가 피연산자 2버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then : 화면에 2가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    //사용자가 피연산자 3버튼을 누르면 화면에 3가 화면에 보여야 한다.
    @Test
    fun when_click_3_then_show_3() {
        // when : 사용자가 피연산자 3버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then : 화면에 3가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    //사용자가 피연산자 4버튼을 누르면 화면에 4가 화면에 보여야 한다.
    @Test
    fun when_click_4_then_show_4() {
        // when : 사용자가 피연산자 4버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then : 화면에 4가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    //사용자가 피연산자 5버튼을 누르면 화면에 5가 화면에 보여야 한다.
    @Test
    fun when_click_5_then_show_5() {
        // when : 사용자가 피연산자 5버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then : 화면에 5가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    //사용자가 피연산자 6버튼을 누르면 화면에 6가 화면에 보여야 한다.
    @Test
    fun when_click_6_then_show_6() {
        // when : 사용자가 피연산자 6버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then : 화면에 6가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    //사용자가 피연산자 7버튼을 누르면 화면에 7가 화면에 보여야 한다.
    @Test
    fun when_click_7_then_show_7() {
        // when : 사용자가 피연산자 7버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then : 화면에 7가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    //사용자가 피연산자 8버튼을 누르면 화면에 8가 화면에 보여야 한다.
    @Test
    fun when_click_8_then_show_8() {
        // when : 사용자가 피연산자 8버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then : 화면에 8가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    //사용자가 피연산자 9버튼을 누르면 화면에 9가 화면에 보여야 한다.
    @Test
    fun when_click_9_then_show_9() {
        // when : 사용자가 피연산자 9버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then : 화면에 9가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    //입력된 피연산자가 있을 때, 기존 숫자 뒤에 해당 숫자가 화면에 보여야 한다. 예를 들면, 8이 입력되어 있을 때 9를 입력하면 89가 보여야 한다.
    @Test
    fun when_click_8_and_9_then_show_89() {
        // when
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.button9)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("89")))
    }

    //입력된 피연산자가 없을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
    @Test
    fun when_click_operator_then_show_empty() {
        // when
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    //입력된 피연산자가 있을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 해당 기호가 화면에 보여야 한다.
    @Test
    fun when_click_number_and_operator_then_show_text() {
        // when
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button7)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("2+7")))
    }

    //입력된 수식이 없을 때, 사용자가 지우기 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
    @Test
    fun when_click_delete_then_show_empty() {
        // when
        onView(withId(R.id.buttonDelete)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    //입력된 수식이 있을 때, 사용자가 지우기 버튼을 누르면 수식에 마지막으로 입력된 연산자 또는 피연산자가 지워져야 한다.
    @Test
    fun given_formula_when_click_delete_then_show_result() {
        // when
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button7)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("2+")))
    }

    //입력된 수신이 완전할 때, 사용자가 = 버튼을 누르면 입력된 수식의 결과가 화면에 보여야 한다.
    @Test
    fun given_formula_when_click_equals_then_show_result() {
        // when
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button7)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }
}