package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityOperandClickTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `0_버튼을_누르면_해당_숫자가_화면에_보여야한다`(){
        onView(withId(R.id.button0)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("0")))
    }

    @Test
    fun `1_버튼을_누르면_해당_숫자가_화면에_보여야한다`(){
        onView(withId(R.id.button1)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("1")))
    }

    @Test
    fun `2_버튼을_누르면_해당_숫자가_화면에_보여야한다`(){
        onView(withId(R.id.button2)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("2")))
    }

    @Test
    fun `3_버튼을_누르면_해당_숫자가_화면에_보여야한다`(){
        onView(withId(R.id.button3)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("3")))
    }

    @Test
    fun `4_버튼을_누르면_해당_숫자가_화면에_보여야한다`(){
        onView(withId(R.id.button4)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("4")))
    }

    @Test
    fun `5_버튼을_누르면_해당_숫자가_화면에_보여야한다`(){
        onView(withId(R.id.button5)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("5")))
    }

    @Test
    fun `6_버튼을_누르면_해당_숫자가_화면에_보여야한다`(){
        onView(withId(R.id.button6)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("6")))
    }

    @Test
    fun `7_버튼을_누르면_해당_숫자가_화면에_보여야한다`(){
        onView(withId(R.id.button7)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("7")))
    }

    @Test
    fun `8_버튼을_누르면_해당_숫자가_화면에_보여야한다`(){
        onView(withId(R.id.button8)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("8")))
    }

    @Test
    fun `9_버튼을_누르면_해당_숫자가_화면에_보여야한다`(){
        onView(withId(R.id.button9)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("9")))
    }
}