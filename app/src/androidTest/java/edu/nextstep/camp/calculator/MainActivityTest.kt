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

    /**
     * GIVEN 입력된 수식이 없을 때
     * WHEN 사용자가 피연산자 N을 누르면 (N: 0~9)
     * THEN 해당 숫자가 화면에 보여야 한다.
     * */
    // N = 0
    @Test
    fun when_click_zero_show_zero() {
        onView(withId(R.id.button0)).perform(click())
        onView(withId(R.id.expressionText)).check(matches(withText("0")))
    }

    // N = 1
    @Test
    fun when_click_one_show_one() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.expressionText)).check(matches(withText("1")))
    }

    // N = 2
    @Test
    fun when_click_two_show_two() {
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.expressionText)).check(matches(withText("2")))
    }

    // N = 3
    @Test
    fun when_click_three_show_three() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.expressionText)).check(matches(withText("3")))
    }

    // N = 4
    @Test
    fun when_click_four_show_four() {
        onView(withId(R.id.button4)).perform(click())
        onView(withId(R.id.expressionText)).check(matches(withText("4")))
    }

    // N = 5
    @Test
    fun when_click_five_show_five() {
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.expressionText)).check(matches(withText("5")))
    }
    // N = 6
    @Test
    fun when_click_six_show_six() {
        onView(withId(R.id.button6)).perform(click())
        onView(withId(R.id.expressionText)).check(matches(withText("6")))
    }

    // N = 7
    @Test
    fun when_click_seven_show_seven() {
        onView(withId(R.id.button7)).perform(click())
        onView(withId(R.id.expressionText)).check(matches(withText("7")))
    }

    // N = 8
    @Test
    fun when_click_eight_show_eight() {
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.expressionText)).check(matches(withText("8")))
    }

    // N = 9
    @Test
    fun when_click_nine_show_nine() {
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.expressionText)).check(matches(withText("9")))
    }

    /**
     * GIVEN 연산자로 끝나는 수식이 주어졌을 때 (Operator: +, -, ×, ÷)[ex] '5 + '
     * WHEN 사용자가 피연산자 N을 누르면 (N: 0~9) [ex] '9'
     * THEN 해당 숫자가 화면에 보여야 한다. [ex] '5 + 9'
     * */
    // Operator +
    @Test
    fun given_formula_that_ends_with_an_operator_plus_when_click_number_then_concat_number_to_the_end() {
        // given: '5 +'
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        // when: '1'
        onView(withId(R.id.button1)).perform(click())
        // then: '5 + 1'
        onView(withId(R.id.expressionText)).check(matches(withText("5 + 1")))
    }

    // Operator -
    @Test
    fun given_formula_that_ends_with_an_operator_minus_when_click_number_then_concat_number_to_the_end() {
        // given: '5 -'
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        // when: '1'
        onView(withId(R.id.button1)).perform(click())
        // then: '5 - 1'
        onView(withId(R.id.expressionText)).check(matches(withText("5 - 1")))
    }

    // Operator ×
    @Test
    fun given_formula_that_ends_with_an_operator_multiply_when_click_number_then_concat_number_to_the_end() {
        // given: '5 ×'
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        // when: '1'
        onView(withId(R.id.button1)).perform(click())
        // then: '5 × 1'
        onView(withId(R.id.expressionText)).check(matches(withText("5 × 1")))
    }

    // Operator ÷
    @Test
    fun given_formula_that_ends_with_an_operator_divide_when_click_number_then_concat_number_to_the_end() {
        // given: '5 ÷'
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        // when: '1'
        onView(withId(R.id.button1)).perform(click())
        // then: '5 ÷ 1'
        onView(withId(R.id.expressionText)).check(matches(withText("5 ÷ 1")))
    }

    /**
     * GIVEN 피연산자로 끝나는 수식이 주어졌을 때 [ex] '51 + 2'
     * WHEN 사용자가 피연산자 N을 누르면 (N: 0~9) [ex] '8'
     * THEN 해당 숫자가 수식의 끝에 추가되어야 한다. [ex] '51 + 28'
     * */
    @Test
    fun given_formula_that_ends_with_an_operand_when_click_number_then_concat_number_to_the_end() {
        // given: '51 +'
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        // when: '8'
        onView(withId(R.id.button8)).perform(click())
        // then: '51 + 28'
        onView(withId(R.id.expressionText)).check(matches(withText("51 + 28")))
    }

    /**
     * GIVEN 피연산자가 주어졌을 때 [ex] '5'
     * WHEN 사용자가 피연산자 N을 누르면 (N: 0~9) [ex] '9'
     * THEN 해당 숫자가 수식의 끝에 추가되어야 한다. [ex] '59'
     * */
    @Test
    fun given_an_operand_when_click_number_then_concat_number_to_the_end() {
        // given: '5'
        onView(withId(R.id.button5)).perform(click())
        // when: '9'
        onView(withId(R.id.button9)).perform(click())
        // then: '59'
        onView(withId(R.id.expressionText)).check(matches(withText("59")))
    }

    /**
     * GIVEN 입력된 수식이 없을 때
     * WHEN 사용자가 연산자를 누르면 (Operator: +, -, ×, ÷)
     * THEN 화면에 아무 변화가 없어야 한다.
     * */
    // +
    @Test
    fun given_empty_expression_when_click_operator_then_no_change() {
        // when '+'
        onView(withId(R.id.buttonPlus)).perform(click())
        // then: ''
        onView(withId(R.id.expressionText)).check(matches(withText("")))
    }

    // -
    @Test
    fun given_empty_expression_when_click_operator_minus_then_no_change() {
        // when '-'
        onView(withId(R.id.buttonMinus)).perform(click())
        // then: ''
        onView(withId(R.id.expressionText)).check(matches(withText("")))
    }

    // ×
    @Test
    fun given_empty_expression_when_click_operator_multiply_then_no_change() {
        // when '×'
        onView(withId(R.id.buttonMultiply)).perform(click())
        // then: ''
        onView(withId(R.id.expressionText)).check(matches(withText("")))
    }

    // ÷
    @Test
    fun given_empty_expression_when_click_operator_divide_then_no_change() {
        // when '÷'
        onView(withId(R.id.buttonDivide)).perform(click())
        // then: ''
        onView(withId(R.id.expressionText)).check(matches(withText("")))
    }

    /**
     * GIVEN 피연산자가 주어진 경우 [ex] '1'
     * WHEN 사용자가 연산자를 누르면 (Operator: +, -, ×, ÷) [ex] '+'
     * THEN 해당 연산자가 수식의 끝에 추가되어야 한다. [ex] '1 +
     * */
    @Test
    fun given_operand_when_click_operator_then_concat_operator_to_the_end() {
        // given: '1'
        onView(withId(R.id.button1)).perform(click())
        // when '+'
        onView(withId(R.id.buttonPlus)).perform(click())
        // then: ''
        onView(withId(R.id.expressionText)).check(matches(withText("1 +")))
    }

    /**
     * GIVEN 피연산자로 끝나는 수식이 주어진 경우 [ex] '12 + 3'
     * WHEN 사용자가 연산자를 누르면 (Operator: +, -, ×, ÷) [ex] '×'
     * THEN 해당 연산자가 수식의 끝에 추가되어야 한다. [ex] '12 + 3 ×'
     * */
    @Test
    fun given_expression_that_ends_with_operand_when_click_operator_then_concat_operator_to_the_end() {
        // given: '12 + 3'
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        // when '×'
        onView(withId(R.id.buttonMultiply)).perform(click())
        // then: ''
        onView(withId(R.id.expressionText)).check(matches(withText("12 + 3 ×")))
    }

    /**
     * GIVEN 입력된 수식이 없을 때
     * WHEN 사용자가 지우기 버튼을 누르면
     * THEN 면화면에 아무 변화가 없어야 한다.
     * */
    @Test
    fun given_empty_expression_when_click_delete_then_no_change() {
        // when '<-'
        onView(withId(R.id.buttonDelete)).perform(click())
        // then: ''
        onView(withId(R.id.expressionText)).check(matches(withText("")))
    }

    /**
     * GIVEN 한자릿수 피연산자로 끝나는 수식이 주어졌을 때 [ex] '12 + 3'
     * WHEN 사용자가 지우기 버튼을 누르면
     * THEN 마지막 피연산자가 지워져야 한다. [ex] '12 +'
     * */
    @Test
    fun given_expression_that_ends_with_single_digit_operand_when_click_delete_then_truncate_last_operand() {
        // given: '12 + 3'
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        // when '<-'
        onView(withId(R.id.buttonDelete)).perform(click())
        // then: '12 +'
        onView(withId(R.id.expressionText)).check(matches(withText("12 +")))
    }

    /**
     * GIVEN 두자릿수 피연산자로 끝나는 수식이 주어졌을 때 [ex] '1 + 34'
     * WHEN 사용자가 지우기 버튼을 누르면
     * THEN 마지막 피연산자가 지워져야 한다. [ex] '1 + 3'
     * */
    @Test
    fun given_expression_that_ends_with_multi_digit_operand_when_click_delete_then_truncate_last_operand() {
        // given: '1+ 34'
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button4)).perform(click())
        // when '<-'
        onView(withId(R.id.buttonDelete)).perform(click())
        // then: '1 + 3'
        onView(withId(R.id.expressionText)).check(matches(withText("1 + 3")))
    }

    /**
     * GIVEN 연산자로 끝나는 수식이 주어졌을 때 [ex] '13 +'
     * WHEN 사용자가 지우기 버튼을 누르면
     * THEN 마지막 피연산자가 지워져야 한다. [ex] '13'
     * */
    @Test
    fun given_expression_that_ends_with_operator_when_click_delete_then_truncate_last_operator() {
        // given: '13 +'
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        // when '<-'
        onView(withId(R.id.buttonDelete)).perform(click())
        // then: '13'
        onView(withId(R.id.expressionText)).check(matches(withText("13")))
    }

    /**
     * GIVEN 입력된 수식이 완전할 때 [ex] '3 +2'
     * WHEN 사용자가 = 버튼을 누르면
     * THEN 마지막 피연산자가 지워져야 한다. [ex] '5'
     * */
    @Test
    fun given_valid_expression_when_click_equal_then_show_result() {
        // given: '3 +2'
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        // when '<-'
        onView(withId(R.id.buttonEquals)).perform(click())
        // then: ''
        onView(withId(R.id.expressionText)).check(matches(withText("5")))
    }
}
