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
    fun `입력된_숫자뒤에_숫자를_더_입력하면_연달아서_숫자가_보여야한다`() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button9)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("19")))
    }

    @Test
    fun `입력된_값이_없는_상태에서_연산자를_누르면_화면에_아무런_변화가_없어야_한다`() {
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("")))
    }
}