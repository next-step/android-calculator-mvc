package edu.nextstep.camp.calculator

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import edu.nextstep.camp.calculator.utils.ToastMatcher.Companion.isToast
import edu.nextstep.camp.domain.stringcalculator.Operator
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

    // 이런 식으로 then의 결과가 다음 테스트응이 given이 되는 형식의 테스트에서 아래 방식 말고,
    // (when then이 여러개일때) 더 좋은 테스트 방법이 있는 지 궁금합니다.
    @Test
    fun 입력된_수식이_있을때_지우기_버튼을_누르면_마지막으로_입력된_값이_지워져야_한다() {
        // given 46 + 5
        onView(withId(R.id.buttonFour)).perform(click())
        onView(withId(R.id.buttonSix)).perform(click())

        onView(withId(R.id.buttonPlus)).perform(click())

        onView(withId(R.id.buttonFive)).perform(click())

        // when
        onView(withId(R.id.buttonDelete)).perform(click())
        // then
        onView(withId(R.id.textResult)).check(matches(withText("46 +")))

        // when
        onView(withId(R.id.buttonDelete)).perform(click())
        // then
        onView(withId(R.id.textResult)).check(matches(withText("46")))

        // when
        onView(withId(R.id.buttonDelete)).perform(click())
        // then
        onView(withId(R.id.textResult)).check(matches(withText("4")))
    }

    @Test
    fun 입력된_수식이_완전할_때_결과_버튼을_누르면_수식의_결과가_텍스트에_나타난다() {
        // given 8 + 9
        onView(withId(R.id.buttonEight)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonNine)).perform(click())

        // when
        onView(withId(R.id.buttonEquals)).perform(click())

        // then
        onView(withId(R.id.textResult)).check(matches(withText("17")))
    }

    @Test
    fun 입력된_수식이_완전하지_않을_때_결과_버튼을_누르면_토스트_메시지가_나타난다() {
        // given 9 +
        onView(withId(R.id.buttonNine)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        // when
        onView(withId(R.id.buttonEquals)).perform(click())

        // then
        onView(withText("완성되지 않은 수식입니다")).inRoot(isToast())
            .check(matches(isDisplayed()))
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
        @Parameterized.Parameters(name = "연산자 버튼 {1} 일때")
        fun buttonResourcesAndNumbers(): Collection<Array<Any>> {
            return listOf(
                arrayOf(R.id.buttonPlus, Operator.PLUS.token),
                arrayOf(R.id.buttonMinus, Operator.MINUS.token),
                arrayOf(R.id.buttonMultiply, Operator.MULTIPLY.token),
                arrayOf(R.id.buttonDivide, Operator.DIVIDE.token),
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
