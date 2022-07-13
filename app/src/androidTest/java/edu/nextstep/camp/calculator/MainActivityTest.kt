package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
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
    private var buttonId: Int,
    private var expected: String
) {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    companion object {
        @JvmStatic
        @Parameters(name = "버튼id : {0}, text : {1}")
        fun getTestParameters() = listOf(
            arrayOf(R.id.button0, "0"),
            arrayOf(R.id.button1, "1"),
            arrayOf(R.id.button2, "2"),
            arrayOf(R.id.button3, "3"),
            arrayOf(R.id.button4, "4"),
            arrayOf(R.id.button5, "5"),
            arrayOf(R.id.button6, "6"),
            arrayOf(R.id.button7, "7"),
            arrayOf(R.id.button8, "8"),
            arrayOf(R.id.button9, "9")

        )
    }

    @Test
    fun `버튼을_누르면_화면에_숫자가_보여야_한다`() {
        //when: 0 버튼을 누르면
        onView(withId(buttonId)).perform(ViewActions.click())

        //then: 화면에 0이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText(expected)))
    }
}