package edu.nextstep.camp.calculator

import androidx.annotation.IdRes
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
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun `test1`() {

        val inputAndExpected = listOf(
            R.id.button0 to "0",
            R.id.button1 to "1",
            R.id.button2 to "2",
            R.id.button3 to "3",
            R.id.button4 to "4",
            R.id.button5 to "5",
            R.id.button6 to "6",
            R.id.button7 to "7",
            R.id.button8 to "8",
            R.id.button9 to "9",
        )

        inputAndExpected.forEach { (buttonId, output) ->
            버튼을_눌러_결과를_확인한다(buttonId, output)
        }
    }

    private fun `버튼을_눌러_결과를_확인한다`(buttonId: Int, output: String) {
        //when
        버튼을_누른다(buttonId)
        //then
        결과화면에서_숫자를_확인한다(output)
    }

    private fun `버튼을_누른다`(@IdRes buttonId: Int) {
        onView(withId(buttonId)).perform(click())
    }

    private fun `결과화면에서_숫자를_확인한다`(output: String) {
        onView(withId(R.id.outputTextView)).check(matches(withText(output)))
    }
}