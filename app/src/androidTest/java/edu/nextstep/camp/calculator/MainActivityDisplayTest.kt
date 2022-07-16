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
        // when
        click(1)

        // then
        checkDisplayText("1")
    }

    @Test
    fun `display_number_when_the_present_operand_is_absent_2`() {
        // given "5 +"
        click(5)
        click("+")


        // when
        click(1)

        // then
        checkDisplayText("5 + 1")
    }

    @Test
    fun `append_number_when_the_operand_is_present`() {
        // given "8"
        click(8)

        // when
        click(9)

        // then
        checkDisplayText("89")
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
}
