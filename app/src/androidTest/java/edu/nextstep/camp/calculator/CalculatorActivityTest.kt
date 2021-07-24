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

/**
 * Created By Malibin
 * on 7월 24, 2021
 */

@RunWith(Parameterized::class)
class CalculatorActivityNumberParameterizedTest(
    @IdRes private val buttonResId: Int,
    private val expectedText: String,
) {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(CalculatorActivity::class.java)

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "버튼 {1}을 누르면 {1}이 보인다")
        fun buttonResourcesAndNumbers(): Collection<Array<Any>> {
            return listOf(
                arrayOf(R.id.buttonZero, "0"),
                arrayOf(R.id.buttonOne, "1"),
                arrayOf(R.id.buttonTwo, "2"),
                arrayOf(R.id.buttonThree, "3"),
                arrayOf(R.id.buttonFour, "4"),
                arrayOf(R.id.buttonFive, "5"),
                arrayOf(R.id.buttonSix, "6"),
                arrayOf(R.id.buttonSeven, "7"),
                arrayOf(R.id.buttonEight, "8"),
                arrayOf(R.id.buttonNine, "9"),
            )
        }
    }

    @Test
    fun 버튼을_누르면_해당_값이_텍스트뷰에_보여야한다() {
        // when
        onView(withId(buttonResId)).perform(click())

        // then
        onView(withId(R.id.textResult)).check(matches(withText(expectedText)))
    }
}
