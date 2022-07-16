package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class MainActivityTest(
    private val buttonID: Int,
    private val expected: String
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    companion object {
        @JvmStatic
        @Parameters(name = "버튼{index}를 클릭하면 결과값 {1}이 나오도록 한다.")
        fun buttonNumberList() = listOf(
            arrayOf(R.id.button0, "0"),
            arrayOf(R.id.button1, "1"),
            arrayOf(R.id.button2, "2"),
            arrayOf(R.id.button3, "3"),
            arrayOf(R.id.button4, "4"),
            arrayOf(R.id.button5, "5"),
            arrayOf(R.id.button6, "6"),
            arrayOf(R.id.button7, "7"),
            arrayOf(R.id.button8, "8"),
            arrayOf(R.id.button9, "9"),
        )
    }

    @Test
    fun testGetButtonNumber() {
        //when
        onView(withId(buttonID)).perform(click())
        //then
        onView(withId(R.id.textView)).check(matches(withText(expected)))
    }
}