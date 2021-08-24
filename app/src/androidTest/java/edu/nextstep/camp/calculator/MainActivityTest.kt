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

    @Test
    fun `숫자가_입력된_상태에서_연산자를_누르면_해당기호가_나타나야한다`() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("1+")))
    }

    @Test
    fun `입력된_값이_없을_때_지우기_버튼을_누르면_화면에_아무런_변화가_없어야한다`() {
        onView(withId(R.id.buttonDelete)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("")))
    }

    @Test
    fun `입력된_수식에_끝자리가_숫자이면_숫자_하나만_지워야한다`(){
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("1")))
    }
}