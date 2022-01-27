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
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    // 사용자가 피연산자 0 버튼을 누르면 화면에 0가 화면에 보여야 한다.
    @Test
    fun whenClick0Button_thenShow0TextView() {
        // when: 사용자가 피연산자 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then: 화면 에 0가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    // 사용자가 피연산자 1 버튼을 누르면 화면에 1가 화면에 보여야 한다.
    @Test
    fun whenClick1Button_thenShow1TextView() {
        // when: 사용자가 피연산자 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then: 화면 에 1가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    // 사용자가 피연산자 2 버튼을 누르면 화면에 2가 화면에 보여야 한다.
    @Test
    fun whenClick2Button_thenShow2TextView() {
        // when: 사용자가 피연산자 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then: 화면 에 2가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    // 사용자가 피연산자 3 버튼을 누르면 화면에 3가 화면에 보여야 한다.
    @Test
    fun whenClick3Button_thenShow3TextView() {
        // when: 사용자가 피연산자 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then: 화면 에 3가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    // 사용자가 피연산자 4 버튼을 누르면 화면에 4가 화면에 보여야 한다.
    @Test
    fun whenClick4Button_thenShow4TextView() {
        // when: 사용자가 피연산자 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 화면 에 4가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    // 사용자가 피연산자 5 버튼을 누르면 화면에 5가 화면에 보여야 한다.
    @Test
    fun whenClick5Button_thenShow5TextView() {
        // when: 사용자가 피연산자 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then: 화면 에 5가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    // 사용자가 피연산자 0 버튼을 누르면 화면에 0가 화면에 보여야 한다.
    @Test
    fun whenClick6Button_thenShow6TextView() {
        // when: 사용자가 피연산자 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then: 화면 에 6가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    // 사용자가 피연산자 7 버튼을 누르면 화면에 7가 화면에 보여야 한다.
    @Test
    fun whenClick7Button_thenShow7TextView() {
        // when: 사용자가 피연산자 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then: 화면 에 7가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    // 사용자가 피연산자 0 버튼을 누르면 화면에 0가 화면에 보여야 한다.
    @Test
    fun whenClick8Button_thenShow8TextView() {
        // when: 사용자가 피연산자 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then: 화면 에 8가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun whenClick9Button_thenShow9TextView() {
        // when: 사용자가 피연산자 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 화면 에 9가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    @Test
    fun `사용자가_수식을_입력하면_화면에_입력한_수식이_보인다`() {
        //when
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())

        //then
        onView(withId(R.id.textView)).check(matches(withText("1 + 2")))
    }

    @Test
    fun `숫자4를_입력되었을때_3를_누르면_텍스트에_12가_보인다`() {
        //given
        val basicText = "4"
        onView(withId(R.id.textView)).perform(setTextInTextView(basicText))

        //when
        onView(withId(R.id.button3)).perform(click())

        //then
        onView(withId(R.id.textView)).check(matches(withText("43")))
    }

    @Test
    fun `아무것도_입력이_없을때_연산자_기호를_누르면_입력이_되지않는다`() {
        // GIVEN
        val emptyString = ""
        onView(withId(R.id.textView)).perform(setTextInTextView(emptyString))

        // WHEN
        onView(withId(R.id.buttonPlus)).perform(click())

        // THEN
        onView(withId(R.id.textView)).check(matches(withText(emptyString)))
    }

    @Test
    fun `1로_입력_되어_있을때_연산자_기호를_누르면_해당_기호가_보인다`() {
        // GIVEN
        val operand = "1"
        onView(withId(R.id.textView)).perform(setTextInTextView(operand))

        // WHEN
        onView(withId(R.id.buttonPlus)).perform(click())

        // THEN
        onView(withId(R.id.textView)).check(matches(withText("1 + ")))
    }

    @Test
    fun `아무것도_입력이_없을때_지우기_버튼_누르면_변화없다`() {
        // GIVEN
        val emptyString = ""
        onView(withId(R.id.textView)).perform(setTextInTextView(emptyString))

        // WHEN
        onView(withId(R.id.buttonDelete)).perform(click())

        // THEN
        onView(withId(R.id.textView)).check(matches(withText(emptyString)))
    }

    @Test
    fun `수식이_입력될때_지우기_버튼_누르면_최근에누른_버튼글자가_지워진다`() {
        // GIVEN
        val statement = "32 + 1"
        onView(withId(R.id.textView)).perform(setTextInTextView(statement))

        // WHEN
        onView(withId(R.id.buttonDelete)).perform(click())

        // THEN
        onView(withId(R.id.textView)).check(matches(withText("32 + ")))
    }

    @Test
    fun `수식이_입력이_될_때_지우기_버튼_여러번_누르면_최근_누른_버튼_글자가_하나씩_제거된다`() {
        // GIVEN
        val statement = "32 + 1"
        onView(withId(R.id.textView)).perform(setTextInTextView(statement))

        // WHEN
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())

        // THEN
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun `수식을_입력하고_결과_버튼을_누르면_수식의_결과가_나온다`() {
        // GIVEN
        val statement = "2 + 2"
        onView(withId(R.id.textView)).perform(setTextInTextView(statement))

        // WHEN
        onView(withId(R.id.buttonEquals)).perform(click())

        // THEN
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    private fun setTextInTextView(value: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return CoreMatchers.allOf(
                    ViewMatchers.isDisplayed(),
                    ViewMatchers.isAssignableFrom(TextView::class.java)
                )
            }

            override fun perform(uiController: UiController, view: View) {
                (view as TextView).text = value
            }

            override fun getDescription(): String {
                return ""
            }
        }
    }
}
