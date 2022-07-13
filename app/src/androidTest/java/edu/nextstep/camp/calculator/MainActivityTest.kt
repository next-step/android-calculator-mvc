package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.extension.RegisterExtension
import org.junit.jupiter.params.ParameterizedTest
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

}
