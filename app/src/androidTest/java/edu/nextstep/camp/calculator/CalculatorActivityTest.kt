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

class CalculatorActivityTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(CalculatorActivity::class.java)

    @Test
    fun 최근_입력이_숫자가_아닐_때_숫자를_누르면_화면에_해당_숫자가_추가_된다() {
        // given
        // current "3 +"
        onView(withId(R.id.buttonThree)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        val expectedText = "3 + 1"

        // when
        onView(withId(R.id.buttonOne)).perform(click())


        // then
        onView(withId(R.id.textResult)).check(matches(withText(expectedText)))
    }

    @Test
    fun 최근_입력이_숫자일_때_숫자를_누르면_기존_숫자_뒤에_입력_숫자가_붙어_나타난다() {
        // given
        // current 1
        onView(withId(R.id.buttonOne)).perform(click())

        val expectedText = "12"

        // when
        onView(withId(R.id.buttonTwo)).perform(click())

        // then
        onView(withId(R.id.textResult)).check(matches(withText(expectedText)))
    }

    @Test
    fun 아무_것도_입력된_게_없을_때_지우기_버튼을_누르면_텍스트에_변화가_없어야_한다() {
        // when
        onView(withId(R.id.buttonDelete)).perform(click())

        // then
        onView(withId(R.id.textResult)).check(matches(withText("")))
    }
}

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
    fun 아무_것도_입력된_게_없을_때_숫자_버튼을_누르면_해당_값이_텍스트뷰에_보여야한다() {
        // when
        onView(withId(buttonResId)).perform(click())

        // then
        onView(withId(R.id.textResult)).check(matches(withText(expectedText)))
    }
}

@RunWith(Parameterized::class)
class CalculatorActivityOperatorParameterizedTest(
    @IdRes private val operatorButtonResId: Int,
    private val symbol: String,
) {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(CalculatorActivity::class.java)

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "버튼 {1} 일때")
        fun buttonResourcesAndNumbers(): Collection<Array<Any>> {
            return listOf(
                arrayOf(R.id.buttonPlus, "+"),
                arrayOf(R.id.buttonMinus, "-"),
                arrayOf(R.id.buttonMultiply, "*"),
                arrayOf(R.id.buttonDivide, "/"),
            )
        }
    }

    @Test
    fun 아무_것도_입력된_게_없을_때_연산자_버튼을_누르면_텍스트뷰에_아무_변화가_없어야_한다() {
        // when
        onView(withId(operatorButtonResId)).perform(click())

        // then
        onView(withId(R.id.textResult)).check(matches(withText("")))
    }

    @Test
    fun 입력된_숫자가_있을_때_연산자_버튼을_누르면_텍스트뷰에_해당_기호가_보여야_한다() {
        // given
        onView(withId(R.id.buttonSeven)).perform(click())

        // when
        onView(withId(operatorButtonResId)).perform(click())

        // then
        onView(withId(R.id.textResult)).check(matches(withText("7 $symbol")))
    }

    @Test
    fun 최근_입력이_연산자일_때_연산자_버튼을_누르면_텍스트뷰의_연산자가_누른_연산자로_바뀐다() {
        // given
        onView(withId(R.id.buttonSeven)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())

        // when
        onView(withId(operatorButtonResId)).perform(click())

        // then
        onView(withId(R.id.textResult)).check(matches(withText("7 $symbol")))
    }
}
