package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun click_1_2_3_shows_123() {
        // given
        // when: click 1 2 3
        performClick(R.id.button1)
        performClick(R.id.button2)
        performClick(R.id.button3)

        // then: 화면에 123 이 보인다
        assertTextViewEquals("123")
    }

    @Test
    fun click_1_3_plus_2_2_shows_13_plus_22() {
        // given
        // when: click 1 3 + 2 2
        performClick(R.id.button1)
        performClick(R.id.button3)
        performClick(R.id.buttonPlus)
        performClick(R.id.button2)
        performClick(R.id.button2)

        // then
        assertTextViewEquals("13 + 22")
    }

    @Test
    fun click_9_multiply_divide_3_shows_9_divide_3() {
        // given
        // when: click 9 * / 3
        performClick(R.id.button9)
        performClick(R.id.buttonMultiply)
        performClick(R.id.buttonDivide)
        performClick(R.id.button3)

        // then
        assertTextViewEquals("9 / 3")
    }

    @Test
    fun click_1_2_3_multiply_delete_delete_divide_3_shows_12_divide_3() {
        // given
        // when: click 1 2 3 * delete delete / 3
        performClick(R.id.button1)
        performClick(R.id.button2)
        performClick(R.id.button3)
        performClick(R.id.buttonMultiply)
        performClick(R.id.buttonDelete)
        performClick(R.id.buttonDelete)
        performClick(R.id.buttonDivide)
        performClick(R.id.button3)

        // then
        assertTextViewEquals("12 / 3")
    }

    @Test
    fun click_2_multiply_3_3_equals_66() {
        // given: click 2 * 3 3
        performClick(R.id.button2)
        performClick(R.id.buttonMultiply)
        performClick(R.id.button3)
        performClick(R.id.button3)

        // when: click =
        performClick(R.id.buttonEquals)

        // then
        assertTextViewEquals("66")
    }

    @Test
    fun click_6_6_divide_3_plus_3_multiply_2_equals_50() {
        // given: click 66 / 3 + 3 * 2
        // when: click =
        performClick(R.id.button6)
        performClick(R.id.button6)
        performClick(R.id.buttonDivide)
        performClick(R.id.button3)
        performClick(R.id.buttonPlus)
        performClick(R.id.button3)
        performClick(R.id.buttonMultiply)
        performClick(R.id.button2)
        performClick(R.id.buttonEquals)

        // then
        assertTextViewEquals("50")
    }

    private fun performClick(id: Int) {
        onView(withId(id)).perform(click())
    }

    private fun assertTextViewEquals(expected: String) {
        onView(withId(R.id.textView)).check(matches(withText(expected)))
    }
}