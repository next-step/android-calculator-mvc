package edu.nextstep.camp.calculator

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun pressedZeroButton_shouldShowZero() {
        onView(withId(R.id.button0)).perform(click())

        shouldShowText(displayedText = "0")
    }

    @Test
    fun pressedOneButton_shouldShowOne() {
        onView(withId(R.id.button1)).perform(click())

        shouldShowText(displayedText = "1")
    }

    @Test
    fun pressedTwoButton_shouldShowTwo() {
        onView(withId(R.id.button2)).perform(click())

        shouldShowText(displayedText = "2")
    }

    @Test
    fun pressedThreeButton_shouldShowThree() {
        onView(withId(R.id.button3)).perform(click())

        shouldShowText(displayedText = "3")
    }

    @Test
    fun pressedFourButton_shouldShowFour() {
        onView(withId(R.id.button4)).perform(click())

        shouldShowText(displayedText = "4")
    }

    @Test
    fun pressedFiveButton_shouldShowFive() {
        onView(withId(R.id.button5)).perform(click())

        shouldShowText(displayedText = "5")
    }

    @Test
    fun pressedSixButton_shouldShowSix() {
        onView(withId(R.id.button6)).perform(click())

        shouldShowText(displayedText = "6")
    }

    @Test
    fun pressedSevenButton_shouldShowSeven() {
        onView(withId(R.id.button7)).perform(click())

        shouldShowText(displayedText = "7")
    }

    @Test
    fun pressedEightButton_shouldShowEight() {
        onView(withId(R.id.button8)).perform(click())

        shouldShowText(displayedText = "8")
    }

    @Test
    fun pressedNineButton_shouldShowNine() {
        onView(withId(R.id.button9)).perform(click())

        shouldShowText(displayedText = "9")
    }

    @Test
    fun existInputOperand_InputOtherOperand_shouldShowNumberAfterInputNumber() {
        onView(withId(R.id.button8)).perform(click())

        onView(withId(R.id.button9)).perform(click())

        shouldShowText(displayedText = "89")
    }

    @Test
    fun notExistInputOperand_inputOperator_shouldNotShowOperator() {
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())

        shouldShowText(displayedText = "")
    }

    @Test
    fun existInputOperand_pressedOperator_shouldShowOperator() {
        onView(withId(R.id.button1)).perform(click())

        onView(withId(R.id.buttonPlus)).perform(click())

        shouldShowText(displayedText = "1+")
    }

    @Test
    fun inputOneAndPlusButton_pressedOperator_shouldShowOperator() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        onView(withId(R.id.buttonMinus)).perform(click())

        shouldShowText(displayedText = "1-")
    }

    @Test
    fun emptyFormula_pressedDeleteButton_noChange() {
        onView(withId(R.id.buttonDelete)).perform(click())

        shouldShowText(displayedText = "")
    }

    @Test
    fun existFormula_pressedDeleteButton_shouldErasedByOneCharacter() {
        onView(withId(R.id.textView)).perform(setTextInTextView("32+1"))

        onView(withId(R.id.buttonDelete)).perform(click())

        shouldShowText(displayedText = "32+")
    }

    @Test
    fun completeInputFormula_pressedEqualsButton_calculate() {
        onView(withId(R.id.textView)).perform(setTextInTextView("3+2"))

        onView(withId(R.id.buttonEquals)).perform(click())

        shouldShowText(displayedText = "5.0")
    }

    private fun shouldShowText(displayedText: String) {
        onView(withId(R.id.textView)).check(matches(withText(displayedText)))
    }

    private fun setTextInTextView(value: String): ViewAction = object : ViewAction {
        override fun getConstraints(): Matcher<View> =
            CoreMatchers.allOf(
                ViewMatchers.isDisplayed(),
                ViewMatchers.isAssignableFrom(TextView::class.java)
            )

        override fun getDescription(): String = "Replace Text"

        override fun perform(uiController: UiController?, view: View?) {
            (view as? TextView)?.text = value
        }
    }

}
