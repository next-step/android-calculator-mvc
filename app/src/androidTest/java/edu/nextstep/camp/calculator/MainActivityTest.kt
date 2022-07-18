package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("메인화면 테스트")
class MainActivityTest {
    @JvmField
    @RegisterExtension
    val scenarioExtension = ActivityScenarioExtension.launch<MainActivity>()

    @Nested
    @DisplayName("버튼 동작")
    inner class `버튼_기본_동작` {


        @CsvSource("'버튼0', ${R.id.button0}, '0'",
            "'버튼1', ${R.id.button1}, '1'",
            "'버튼2', ${R.id.button2}, '2'",
            "'버튼3', ${R.id.button3}, '3'",
            "'버튼4', ${R.id.button4}, '4'",
            "'버튼5', ${R.id.button5}, '5'",
            "'버튼6', ${R.id.button6}, '6'",
            "'버튼7', ${R.id.button7}, '7'",
            "'버튼8', ${R.id.button8}, '8'",
            "'버튼9', ${R.id.button9}, '9'")
        @DisplayName("동작")
        @ParameterizedTest(name = "{0} 선택, 예상결과 = {2}")
        fun `버튼_동작`(buttonDescription: String, buttonId: Int, expectedText: String) {
            //when: 버튼을 누르면
            onView(withId(buttonId)).perform(ViewActions.click())
            //then: 화면에 버튼의 텍스트가 보여야 한다
            onView(withId(R.id.textView)).check(matches(withText(expectedText)))
        }
    }

    @Nested
    @DisplayName("연산 동작")
    inner class `연산_동작` {
        //기능 요구 사항
        /* 입력된 피연산자가 없을 때, 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
        -> 1 클릭 -> 1 */
        @Test
        @DisplayName("' '-> '1' 클릭 = '1'")
        fun `입력된_피연산자가_없을때_숫자_클릭은_해당_숫자가_표시된다`() {
            onView(withId(R.id.button1)).perform(ViewActions.click())
            onView(withId(R.id.textView)).check(matches(withText("1")))
        }

        /* 5 + -> 1 클릭 -> 5 + 1 */
        @Test
        @DisplayName("'5 +' -> '1' 클릭 = '5 + 1'")
        fun `입력된_피연산자가_없을때_숫자_클릭은_해당_숫자가_표시된다_Case2`() {
            onView(withId(R.id.button5)).perform(ViewActions.click())
            onView(withId(R.id.buttonPlus)).perform(ViewActions.click())

            onView(withId(R.id.button1)).perform(ViewActions.click())

            onView(withId(R.id.textView)).check(matches(withText("5 + 1")))
        }

        @Test
        @DisplayName("'8' -> '9' 클릭 = '89'")
        fun `입력된_피연산자가_있을때_숫자_클릭은_기존_숫자_뒤에_해당_숫자가_표시된다`() {
            onView(withId(R.id.button8)).perform(ViewActions.click())

            onView(withId(R.id.button9)).perform(ViewActions.click())

            onView(withId(R.id.textView)).check(matches(withText("89")))
        }

        @Test
        @DisplayName("' ' -> '+ or - or / or *' 클릭 = ' '")
        fun `입력된_피연산자가_없을때_연산자_클릭은_변화가_없다`() {
            onView(withId(R.id.buttonPlus)).perform(ViewActions.click())
            onView(withId(R.id.buttonDivide)).perform(ViewActions.click())
            onView(withId(R.id.buttonMultiply)).perform(ViewActions.click())
            onView(withId(R.id.buttonMinus)).perform(ViewActions.click())

            onView(withId(R.id.textView)).check(matches(withText("")))
        }

        @Test
        @DisplayName("1 -> '+' 클릭 = '1 +'")
        fun `입력된_피연산자가_있을때_연산자_클릭은_해당_기호가_보인다`() {
            onView(withId(R.id.button1)).perform(ViewActions.click())

            onView(withId(R.id.buttonPlus)).perform(ViewActions.click())

            onView(withId(R.id.textView)).check(matches(withText("1 +")))
        }

        @Test
        @DisplayName("'1 +' -> '-' 클릭 = '1 -'")
        fun `입력된_피연산자가_있을때_연산자_클릭은_해당_기호가_보인다_Case2`() {
            onView(withId(R.id.button1)).perform(ViewActions.click())
            onView(withId(R.id.buttonPlus)).perform(ViewActions.click())

            onView(withId(R.id.buttonMinus)).perform(ViewActions.click())

            onView(withId(R.id.textView)).check(matches(withText("1 -")))
        }

        @Test
        @DisplayName("' ' -> '<-' 클릭 = ' '")
        fun `입력된_수식이_없을때_지우기_클릭은_변화가_없다`() {
            onView(withId(R.id.buttonDelete)).perform(ViewActions.click())

            onView(withId(R.id.textView)).check(matches(withText("")))
        }

        @Test
        @DisplayName("'32 + 1' -> '<-' 5 회 클릭 = ' '")
        fun `입력된_수식이_있을때_지우기_클릭은_마지막_연산자_또는_피연산자가_삭제된다`() {
            //given
            onView(withId(R.id.button3)).perform(ViewActions.click())
            onView(withId(R.id.button2)).perform(ViewActions.click())
            onView(withId(R.id.buttonPlus)).perform(ViewActions.click())
            onView(withId(R.id.button1)).perform(ViewActions.click())

            //when
            onView(withId(R.id.buttonDelete)).perform(ViewActions.click())

            //then
            onView(withId(R.id.textView)).check(matches(withText("32 +")))

            //when
            onView(withId(R.id.buttonDelete)).perform(ViewActions.click())

            //then
            onView(withId(R.id.textView)).check(matches(withText("32")))

            //when
            onView(withId(R.id.buttonDelete)).perform(ViewActions.click())

            //then
            onView(withId(R.id.textView)).check(matches(withText("3")))

            //when
            onView(withId(R.id.buttonDelete)).perform(ViewActions.click())

            //then
            onView(withId(R.id.textView)).check(matches(withText("")))

            //when
            onView(withId(R.id.buttonDelete)).perform(ViewActions.click())

            //then
            onView(withId(R.id.textView)).check(matches(withText("")))
        }

        @Test
        @DisplayName("'3 + 2' -> '=' 클릭 = '5'")
        fun `입력된_수식이_완전할때_등호_클릭은_수식의_결과가_표시된다`() {
            //given
            onView(withId(R.id.button3)).perform(ViewActions.click())
            onView(withId(R.id.buttonPlus)).perform(ViewActions.click())
            onView(withId(R.id.button2)).perform(ViewActions.click())

            //when
            onView(withId(R.id.buttonEquals)).perform(ViewActions.click())

            //then
            onView(withId(R.id.textView)).check(matches(withText("5")))
        }

        @Test
        @DisplayName("'3 +' -> '=' 클릭 = '3 +'")
        fun `입력된_수식이_완전하지_않을때_등호_클릭은_변화가_없다`() {
            //given
            onView(withId(R.id.button3)).perform(ViewActions.click())
            onView(withId(R.id.buttonPlus)).perform(ViewActions.click())

            //when
            onView(withId(R.id.buttonEquals)).perform(ViewActions.click())

            //then
            onView(withId(R.id.textView)).check(matches(withText("3 +")))
        }
    }
}