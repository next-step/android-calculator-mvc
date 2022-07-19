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
    fun 버튼_0을_누르면_화면에_0이_보여야_한다() {
        onView(withId(R.id.button0)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun 버튼_1을_누르면_화면에_1이_보여야_한다() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun 버튼_2을_누르면_화면에_2이_보여야_한다() {
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun 버튼_3을_누르면_화면에_3이_보여야_한다() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun 버튼_4을_누르면_화면에_4이_보여야_한다() {
        onView(withId(R.id.button4)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun 버튼_5을_누르면_화면에_5이_보여야_한다() {
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun 버튼_6을_누르면_화면에_6이_보여야_한다() {
        onView(withId(R.id.button6)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun 버튼_7을_누르면_화면에_7이_보여야_한다() {
        onView(withId(R.id.button7)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun 버튼_8을_누르면_화면에8이_보여야_한다() {
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun 버튼_9을_누르면_화면에_9이_보여야_한다() {
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    @Test
    fun 입력한_값이_올바르게_들어오는지_확인한다() {
        val expected = "3 + 2"

        performClick(R.id.button3)
        performClick(R.id.buttonPlus)
        performClick(R.id.button2)

        assertText(expected)
    }

    @Test
    fun 버튼8과_버튼9를_누르면_89가_입력되야_한다() {
        performClick(R.id.button8)
        performClick(R.id.button9)

        assertText("89")
    }

    @Test
    fun 입력된_피연산자가_없을_때_연산자_버튼을_누르면_변화가_없어야_한다() {
        val expected = ""
        performClick(R.id.buttonDivide)

        assertText(expected)
    }

    @Test
    fun 마지막에_연산자가_입력된_상태로_다른_연산자가_들어오면_마지막_연산자를_교체한다() {
        val expected = "6 -"
        performClick(R.id.button6)
        performClick(R.id.buttonPlus)
        performClick(R.id.buttonMinus)

        assertText(expected)
    }

    @Test
    fun 지우기_버튼이_잘_작동하는지_확인한다() {
        val expected = "5"

        performClick(R.id.button5)
        performClick(R.id.buttonMinus)
        performClick(R.id.button4)

        performClick(R.id.buttonDelete)
        performClick(R.id.buttonDelete)

        assertText(expected)
    }

    @Test
    fun 식_입력_후_계산_버튼을_눌렀을_때_올바르게_계산_되는지_확인한다() {
        val expected = "36" // '8 - 2 * 12 / 2'

        performClick(R.id.button8)
        performClick(R.id.buttonMinus)
        performClick(R.id.button2)
        performClick(R.id.buttonMultiply)
        performClick(R.id.button1)
        performClick(R.id.button2)
        performClick(R.id.buttonDivide)
        performClick(R.id.button2)
        performClick(R.id.buttonEquals)

        assertText(expected)
    }

    private fun performClick(id: Int) {
        onView(withId(id)).perform(click())
    }

    private fun assertText(expected: String) {
        onView(withId(R.id.textView)).check(matches(withText(expected)))
    }
}