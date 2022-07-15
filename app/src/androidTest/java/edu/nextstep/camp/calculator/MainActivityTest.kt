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
    fun givenNoOutput_WhenNumberButtonPressed_ThenOutputIsNumber(buttonText: String, expected: String) {
        onView(withText(buttonText)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText(expected)))
    }
}
