package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class CalculatorActivityTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `입력된_피연산자가_없을_때_사용자가_피연산자_0_에서_9_버튼을_누르면_화면에_해당_숫자가_화면에_보여야_한다`() {

        val expectedText = "5 + 1"

        // given: "5 + "
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        // when
        onView(withId(R.id.button1)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText(expectedText)))
    }

    @Test
    fun `입력된_피연산자가_있을_때_기존_숫자_뒤에_해당_숫자가_화면에_보여야_한다_예를_들면_8이_입력되어_있을_때_9를_입력하면_89가_보여야_한다`() {

        val expectedText = "89"

        // given: "8"
        onView(withId(R.id.button8)).perform(click())

        //when
        onView(withId(R.id.button9)).perform(click())

        //then
        onView(withId(R.id.textView)).check(matches(withText(expectedText)))
    }

}