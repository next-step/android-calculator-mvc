package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
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

    private fun shouldShowText(displayedText: String) {
        onView(withId(R.id.textView)).check(matches(withText(displayedText)))
    }

}