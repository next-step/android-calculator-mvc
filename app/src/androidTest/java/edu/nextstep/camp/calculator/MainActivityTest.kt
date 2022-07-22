package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
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
        //when
        click(R.id.button0)

        //then
        assertText("0")
    }

    @Test
    fun 버튼_1을_누르면_화면에_1이_보여야_한다() {
        //when
        click(R.id.button1)

        //then
        assertText("1")
    }

    @Test
    fun 버튼_2을_누르면_화면에_2이_보여야_한다() {
        //when
        click(R.id.button2)

        //then
        assertText("2")
    }

    @Test
    fun 버튼_3을_누르면_화면에_3이_보여야_한다() {
        //when
        click(R.id.button3)

        //then
        assertText("3")
    }

    @Test
    fun 버튼_4을_누르면_화면에_4이_보여야_한다() {
        //when
        click(R.id.button4)

        //then
        assertText("4")
    }

    @Test
    fun 버튼_5을_누르면_화면에_5이_보여야_한다() {
        //when
        click(R.id.button5)

        //then
        assertText("5")
    }

    @Test
    fun 버튼_6을_누르면_화면에_6이_보여야_한다() {
        //when
        click(R.id.button6)

        //then
        assertText("6")
    }

    @Test
    fun 버튼_7을_누르면_화면에_7이_보여야_한다() {
        //when
        click(R.id.button7)

        //then
        assertText("7")
    }

    @Test
    fun 버튼_8을_누르면_화면에8이_보여야_한다() {
        //when
        click(R.id.button8)

        //then
        assertText("8")
    }

    @Test
    fun 버튼_9을_누르면_화면에_9이_보여야_한다() {
        //when
        click(R.id.button9)

        //then
        assertText("9")
    }

    @Test
    fun 입력한_값이_올바르게_들어오는지_확인한다() {
        //given
        val expected = "3 + 2"

        //when
        click(R.id.button3, R.id.buttonPlus, R.id.button2)

        //then
        assertText(expected)
    }

    @Test
    fun 버튼8과_버튼9를_누르면_89가_입력되야_한다() {
        //when
        click(R.id.button8)
        click(R.id.button9)

        //then
        assertText("89")
    }

    @Test
    fun 입력된_피연산자가_없을_때_연산자_버튼을_누르면_변화가_없어야_한다() {
        //given
        val expected = ""

        //when
        click(R.id.buttonDivide)

        //then
        assertText(expected)
    }

    @Test
    fun 마지막에_연산자가_입력된_상태로_다른_연산자가_들어오면_마지막_연산자를_교체한다() {
        //given
        val expected = "6 -"

        //when
        click(R.id.button6, R.id.buttonPlus, R.id.buttonMinus)

        //then
        assertText(expected)
    }

    @Test
    fun 지우기_버튼이_잘_작동하는지_확인한다() {
        //given
        val expected = "5"

        //when
        click(R.id.button5, R.id.buttonMinus, R.id.button4, R.id.buttonDelete, R.id.buttonDelete)

        //then
        assertText(expected)
    }

    @Test
    fun 식_입력_후_계산_버튼을_눌렀을_때_올바르게_계산_되는지_확인한다() {
        //given
        val expected = "36" // '8 - 2 * 12 / 2'

        //when
        click(
            R.id.button8,
            R.id.buttonMinus,
            R.id.button2,
            R.id.buttonMultiply,
            R.id.button1,
            R.id.button2,
            R.id.buttonDivide,
            R.id.button2,
            R.id.buttonEquals
        )

        //then
        assertText(expected)
    }

    private fun click(vararg idArray: Int) {
        for (id in idArray) {
            onView(withId(id)).perform(ViewActions.click())
        }
    }

    private fun assertText(expected: String) {
        onView(withId(R.id.textView)).check(matches(withText(expected)))
    }
}