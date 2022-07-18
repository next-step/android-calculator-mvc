package edu.nextstep.camp.calculator


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.google.android.material.button.MaterialButton
import de.mannodermaus.junit5.ActivityScenarioExtension
import edu.nextstep.camp.calculator.domain.model.Operand
import edu.nextstep.camp.calculator.domain.model.Operator
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MainActivityTest {
    @JvmField
    @RegisterExtension
    val scenarioExtension = ActivityScenarioExtension.launch<MainActivity>()

    @ParameterizedTest(name = "Given no output, When button{0} is pressed, Then output is {1}")
    @CsvSource(
        "0, 0",
        "1, 1",
        "2, 2",
        "3, 3",
        "4, 4",
        "5, 5",
        "6, 6",
        "7, 7",
        "8, 8",
        "9, 9",
    )
    fun givenNoDisplayedText_WhenNumberButtonPressed_ThenDisplayedTextIsNumber(buttonText: String, expected: String) {
        onView(withText(buttonText)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText(expected)))
    }

    @ParameterizedTest(name = "Given number displayed text, When button{0} is pressed, Then output is appended by {1}")
    @CsvSource(
        "1, 1, 11",
        "131, 9, 1319",
        "2, 2, 22",
        "301, 3, 3013"
    )
    fun givenNumberDisplayedText_WhenNumberButtonPressed_ThenDisplayedTextIsAppendedByNumberPressed(
        displayedText:String, buttonText: String, expected: String, scenario: ActivityScenario<MainActivity>
    ) {
        // given
        scenario.onActivity { activity ->
            activity.setDisplayedText(displayedText)
        }
        // when
        onView(allOf(withText(buttonText), withClassName(Matchers.hasToString(MaterialButton::class.java.canonicalName)))).perform(click())
        // then
        onView(withId(R.id.textView)).check(matches(withText(expected)))
    }

    @ParameterizedTest(name = "Given no output, When button {0} is pressed, Then output is none")
    @CsvSource(
        "+",
        "×",
        "÷"
    )
    fun givenNoDisplayedText_WhenOperatorButtonExceptForSubtractionPressed_ThenNothing(buttonText: String) {
        onView(withText(buttonText)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @ParameterizedTest(name = "Given number {0} displayed, When button {1} is pressed, Then output is {2}")
    @MethodSource("provide_GivenNumberDisplayed_WhenOperatorButtonPressed_ThenAppendsOperator")
    fun givenNumberDisplayed_WhenOperatorButtonPressed_ThenAppendsOperator(
        displayedText: String, buttonText: String, expected: String, scenario: ActivityScenario<MainActivity>
    ) {
        // given
        scenario.onActivity { activity ->
            activity.setDisplayedText(displayedText)
        }
        // when
        onView(withText(buttonText)).perform(click())
        // then
        onView(withId(R.id.textView)).check(matches(withText(expected)))
    }

    @Test
    fun givenNoDisplayText_WhenDelBtnPressed_ThenNothing() {
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @ParameterizedTest
    @MethodSource("provide_GivenDisplayedText_WhenDelBtnPressed_ThenDelLastElement")
    fun givenDisplayedText_WhenDelBtnPressed_ThenDelLastElement(
        displayedText: String, expected: String?, scenario: ActivityScenario<MainActivity>
    ) {
        scenario.onActivity {
            it.setDisplayedText(displayedText)
        }
        onView(withId(R.id.textView)).check(matches(withText(displayedText)))
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText(expected ?: "")))
    }

    @ParameterizedTest
    @CsvSource(
        "1 + 12, 13",
        "1 + 14 ÷ 2, 7",
        "12 - 14, -2",
        "1 × 4 ÷ 3, 1"
    )
    fun givenCompleteExpression_WhenEqualsBtnPressed_ThenResultIsDisplayed(
        displayedText: String, expected: String, scenario: ActivityScenario<MainActivity>
    ) {
        scenario.onActivity {
            it.setDisplayedText(displayedText)
        }
        onView(withId(R.id.textView)).check(matches(withText(displayedText)))
        onView(withId(R.id.buttonEquals)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText(expected)))
    }

    companion object {
        @JvmStatic
        private fun provide_GivenNumberDisplayed_WhenOperatorButtonPressed_ThenAppendsOperator(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1", "+", "1 + "),
                Arguments.of("1", "-", "1 - "),
                Arguments.of("33", "×", "33 × "),
                Arguments.of("1", "÷", "1 ÷ "),
            )
        }
        @JvmStatic
        private fun provide_GivenDisplayedText_WhenDelBtnPressed_ThenDelLastElement(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1", ""),
                Arguments.of("1 + ", "1"),
                Arguments.of("12", "1"),
                Arguments.of("1 × 4 ÷ ", "1 × 4"),
            )
        }
    }
}
