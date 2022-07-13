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
class MainActivityTest(input: Pair<Int, String>) {
    private var buttonId: Int
    private var experted: String

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    init {
        this.buttonId = input.first
        this.experted = input.second
    }

    companion object {
        @Parameters
        @JvmStatic
        fun getTestParameters() = arrayOf(
            R.id.button0 to "0",
            R.id.button1 to "1",
            R.id.button2 to "2",
            R.id.button3 to "3",
            R.id.button4 to "4",
            R.id.button5 to "5",
            R.id.button6 to "6",
            R.id.button7 to "7",
            R.id.button8 to "8",
            R.id.button9 to "9"
        )
    }

    @Test
    fun `숫자_버튼을_누르면_화면에_숫자가_보여야_한다`() {
        //when: 0 버튼을 누르면
        onView(withId(buttonId)).perform(ViewActions.click())

        //then: 화면에 0이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText(experted)))
    }
}