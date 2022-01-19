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
    val activityScenarioRue = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun click0_show0() {
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun click1_show1() {
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun click2_show2() {
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun click3_show3() {
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun click4_show4() {
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun click5_show5() {
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun click6_show6() {
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun click7_show7() {
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun click8_show8() {
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun click9_show9() {
        //when: 사용자가 피연산자 0버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    @Test
    fun noOperand_input_showStatement() {
        //when: 사용자가 피연산자 1, +, 2를 누르면
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())

        //then: 계산기 텍스트에 '1 + 2'가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1 + 2")))
    }

    @Test
    fun withOperand_inputOperand_addOperandNextToNumber() {
        //given: 숫자가 입력되었을 때
        val basicText = "1"
        onView(withId(R.id.textView)).perform(setTextInTextView(basicText))

        //when: 사용자가 피연산자 2를 누르면
        onView(withId(R.id.button2)).perform(click())

        //then: 계산기 텍스트에 '12'가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("12")))
    }

    private fun setTextInTextView(str: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return CoreMatchers.allOf(
                    ViewMatchers.isDisplayed(), ViewMatchers.isAssignableFrom(
                        TextView::class.java
                    )
                )
            }

            override fun perform(uiController: UiController, view: View) {
                (view as TextView).text = str
            }

            override fun getDescription(): String {
                return "replace text"
            }
        }
    }

    @Test
    fun withoutOperand_inputOperator_showNothing() {
        // GIVEN - 아무것도 입력이 되어있지 않을 때
        val emptyString = ""
        onView(withId(R.id.textView)).perform(setTextInTextView(emptyString))

        // WHEN - 사용자가 +, -, *, / 를 누르면
        onView(withId(R.id.buttonPlus)).perform(click())

        // THEN - 입력이 되지 않는다.
        onView(withId(R.id.textView)).check(matches(withText(emptyString)))
    }
}