package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.extension.RegisterExtension
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class MainActivityTest {

    @JvmField
    @RegisterExtension
    val scenarioExtension = ActivityScenarioExtension.launch<MainActivity>()

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"])
    fun 사용자가_피연산자를_누르면_해당_숫자가_화면에_보여야_한다(text: String) {
        // when
        onView(withText(text)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText(text)))
    }

    @ParameterizedTest(name = "{0}에서 피연산자 {1}을 누르면 {2}가 보여야 한다.")
    @CsvSource(
        "'', 1, 1",
        "'5 + ', 1, 5 + 1",
    )
    fun 입력된_피연산자가_없을_때_사용자가_피연산자_버튼을_누르면_화면에_해당_숫자가_보여야_한다(
        original: String,
        pressed: String,
        expected: String,
    ) {
        // given
        val textView = withId(R.id.textView)
        onView(textView).perform(setTextInTextView(original))

        // when
        onView(withText(pressed)).perform(click())

        // then
        onView(textView).check(matches(withText(expected)))
    }

}
