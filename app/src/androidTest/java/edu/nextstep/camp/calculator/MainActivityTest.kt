package edu.nextstep.camp.calculator

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.hamcrest.Matcher
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class MainActivityTest {

    @JvmField
    @RegisterExtension
    val scenarioExtension = ActivityScenarioExtension.launch<MainActivity>()

    @ParameterizedTest
    @CsvSource(
        "'', 1, 1",
        "5 +, 1, 5 + 1",
        "8, 9, 89",
        "123, 4, 1234",
    )
    fun 사용자가_피연산자_버튼을_누르면_화면에_해당_숫자가_화면에_보여야_한다(
        original: String,
        pressed: String,
        expected: String,
    ) {
        assertTextViewWithAction(
            givenText = original,
            clickedButton = withText(pressed),
            expectedText = expected,
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "×", "÷"])
    fun 입력된_피연산자가_없을_때_사용자가_연산자_버튼을_누르면_화면에_아무런_변화가_없어야_한다(
        operator: String
    ) {
        assertTextViewWithAction(
            givenText = "",
            clickedButton = withText(operator),
            expectedText = "",
        )
    }

    @ParameterizedTest
    @CsvSource(
        "123, +, 123 +",
        "2000 + 3, ×, 2000 + 3 *",
    )
    fun 입력된_피연산자가_있을_때_사용자가_연산자_버튼을_누르면_해당_기호가_화면에_보여야_한다(
        operand: String,
        operator: String,
        expected: String
    ) {
        assertTextViewWithAction(
            givenText = operand,
            clickedButton = withText(operator),
            expectedText = expected,
        )
    }

    @Test
    fun 입력된_수식이_없을_때_사용자가_지우기_버튼을_누르면_화면에_아무런_변화가_없어야_한다() {
        assertTextViewWithAction(
            givenText = "",
            clickedButton = withId(R.id.buttonDelete),
            expectedText = "",
        )
    }

    @ParameterizedTest
    @CsvSource(
        "5 +, 5",
        "8, ''",
        "1 / 2 + 8, 1 / 2 +",
    )
    fun 입력된_수식이_있을_때_사용자가_지우기_버튼을_누르면_수식에_마지막으로_입력된_연산자_또는_피연산자가_지워져야_한다(
        original: String,
        expected: String,
    ) {
        assertTextViewWithAction(
            givenText = original,
            clickedButton = withId(R.id.buttonDelete),
            expectedText = expected,
        )
    }

    @ParameterizedTest
    @CsvSource(
        "5 + 5, 10.0",
        "48 / 4 * 2, 24.0",
        "1 / 2 + 8, 8.5",
    )
    fun 입력된_수신이_완전할_때_사용자가_결과_버튼을_누르면_입력된_수식의_결과가_화면에_보여야_한다(
        expression: String,
        expected: String
    ) {
        assertTextViewWithAction(
            givenText = expression,
            clickedButton = withId(R.id.buttonEquals),
            expectedText = expected,
        )
    }

    private fun assertTextViewWithAction(
        givenText: String,
        clickedButton: Matcher<View>,
        expectedText: String,
    ) {
        // given
        val textView = withId(R.id.textView)
        onView(textView).perform(setTextInTextView(givenText))

        // when
        onView(clickedButton).perform(click())

        // then
        onView(textView).check(matches(withText(expectedText)))
    }

}
