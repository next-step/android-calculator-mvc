package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test


class MainActivityDisplayTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `display_number_when_the_present_operand_is_absent`() {
        clicks(1) shouldHaveText "1"
    }

    @Test
    fun `display_number_when_the_present_operand_is_absent_2`() {
        clicks(5, "+", 1) shouldHaveText "5 + 1"
    }

    @Test
    fun `append_number_when_the_operand_is_present`() {
        clicks(8, 9) shouldHaveText "89"
    }

    @Test
    fun `do_nothing_when_press_op_button_when_the_operand_is_absent`() {
        clicks("+") shouldHaveText ""
    }

    @Test
    fun `the_most_recent_operator_is_displayed_when_the_operand_is_present`() {
        clicks(1, "+") shouldHaveText "1 +"
    }

    @Test
    fun `the_most_recent_operator_is_displayed_when_the_operand_is_present2`() {
        clicks(1, "-", "+") shouldHaveText "1 +"
    }

    @Test
    fun `display_nothing_when_press_delete_on_empty_display`() {
        clicks("<") shouldHaveText ""
    }

    @Test
    fun `display_nothing_when_press_equals_on_empty_display`() {
        clicks("=") shouldHaveText ""
    }

    @Test
    fun `delete_from_the_most_recent_value_when_press_delete`() {
        clicks(3, 2, "+", 1) shouldHaveText "32 + 1"
        clicks("<") shouldHaveText "32 +"
        clicks("<") shouldHaveText "32"
        clicks("<") shouldHaveText "3"
        clicks("<") shouldHaveText ""
    }

    @Test
    fun `calculate_when_provides_a_complete_expression`() {
        clicks(3, "+", 2, "=") shouldHaveText "5"
    }

    private fun checkDisplayText(text: String) {
        onView(withId(R.id.textView)).check(matches(withText(text)))
    }

    private fun click(number: Int) {
        val buttonId = when (number) {
            0 -> R.id.button0
            1 -> R.id.button1
            2 -> R.id.button2
            3 -> R.id.button3
            4 -> R.id.button4
            5 -> R.id.button5
            6 -> R.id.button6
            7 -> R.id.button7
            8 -> R.id.button8
            9 -> R.id.button9
            else -> throw IllegalArgumentException("number must be between 0 and 9")
        }
        onView(withId(buttonId)).perform(click())
    }

    private fun click(op: String) {
        val buttonId = when (op) {
            "+" -> R.id.buttonPlus
            "-" -> R.id.buttonMinus
            "*" -> R.id.buttonMultiply
            "/" -> R.id.buttonDivide
            "=" -> R.id.buttonEquals
            "<" -> R.id.buttonDelete
            else -> throw IllegalArgumentException("not supported op: $op")
        }
        onView(withId(buttonId)).perform(click())
    }

    private fun clicks(vararg args: Any): ClickContext {
        for (arg in args) {
            when (arg) {
                is Int -> click(arg)
                is String -> click(arg)
                else -> throw UnsupportedOperationException()
            }
        }
        return ClickContext
    }

    private infix fun ClickContext.shouldHaveText(expected: String) {
        checkDisplayText(expected)
    }

    private object ClickContext
}
