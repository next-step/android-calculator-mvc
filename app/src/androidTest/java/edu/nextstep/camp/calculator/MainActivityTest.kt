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
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MainActivityTest(
    private val buttonId: Int,
    private val output: String
) {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `숫자버튼을_클릭하면_해당숫자가_결과화면에_떠야한다`() {
        //when
        숫자_버튼을_누른다(buttonId)
        //then
        결과화면에서_숫자를_확인한다(output)
    }

    private fun `숫자_버튼을_누른다`(@IdRes buttonId: Int) {
        onView(withId(buttonId)).perform(click())
    }

    private fun `결과화면에서_숫자를_확인한다`(output: String) {
        onView(withId(R.id.outputTextView)).check(matches(withText(output)))
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun getNum() = listOf(
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
}
