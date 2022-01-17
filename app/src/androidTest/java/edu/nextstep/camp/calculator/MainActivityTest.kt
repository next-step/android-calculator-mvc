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

    // 사용자가 피연산자 0 버튼을 누르면 화면에 0이 보여야 한다.
    @Test
    fun pressNumberButton0() {
        // when: 사용자가 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then: 화면에 0이 보여야 한다.
        assertTextEquals("0")
    }

    // 사용자가 피연산자 1 버튼을 누르면 화면에 1이 보여야 한다.
    @Test
    fun pressNumberButton1() {
        // when: 사용자가 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then: 화면에 1이 보여야 한다.
        assertTextEquals("1")
    }

    // 사용자가 피연산자 2 버튼을 누르면 화면에 2이 보여야 한다.
    @Test
    fun pressNumberButton2() {
        // when: 사용자가 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then: 화면에 2이 보여야 한다.
        assertTextEquals("2")
    }

    // 사용자가 피연산자 3 버튼을 누르면 화면에 2이 보여야 한다.
    @Test
    fun pressNumberButton3() {
        // when: 사용자가 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then: 화면에 3이 보여야 한다.
        assertTextEquals("3")
    }

    // 사용자가 피연산자 4 버튼을 누르면 화면에 4이 보여야 한다.
    @Test
    fun pressNumberButton4() {
        // when: 사용자가 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 화면에 4이 보여야 한다.
        assertTextEquals("4")
    }

    // 사용자가 피연산자 5 버튼을 누르면 화면에 5이 보여야 한다.
    @Test
    fun pressNumberButton5() {
        // when: 사용자가 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then: 화면에 5이 보여야 한다.
        assertTextEquals("5")
    }

    // 사용자가 피연산자 6 버튼을 누르면 화면에 6이 보여야 한다.
    @Test
    fun pressNumberButton6() {
        // when: 사용자가 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then: 화면에 6이 보여야 한다.
        assertTextEquals("6")
    }

    // 사용자가 피연산자 7 버튼을 누르면 화면에 7이 보여야 한다.
    @Test
    fun pressNumberButton7() {
        // when: 사용자가 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then: 화면에 7이 보여야 한다.
        assertTextEquals("7")
    }

    // 사용자가 피연산자 8 버튼을 누르면 화면에 8이 보여야 한다.
    @Test
    fun pressNumberButton8() {
        // when: 사용자가 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then: 화면에 8이 보여야 한다.
        assertTextEquals("8")
    }

    // 사용자가 피연산자 9 버튼을 누르면 화면에 9이 보여야 한다.
    @Test
    fun pressNumberButton9() {
        // when: 사용자가 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 화면에 9이 보여야 한다.
        assertTextEquals("9")
    }

    // 사용자가 피연산자 89 버튼을 누르면 화면에 89가 보여야 한다.
    @Test
    fun inputNumber89() {
        // when: 사용자가 8과 9 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.button9)).perform(click())

        // then: 화면에 89가 보여야 한다.
        assertTextEquals("89")
    }

    // 사용자가 5 + 1 을 누르면 화면에 보여야 한다.
    @Test
    fun inputFivePlusOne() {
        // when: 사용자가 8과 9 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())

        // then: 화면에 89가 보여야 한다.
        assertTextEquals("5 + 1")
    }

    // 입력된 피연산자가 없을 때, 연산자 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
    @Test
    fun noInput_pressOperator() {
        // given: 입력이 없다.
        val expected = ""
        assertTextEquals(expected)

        // when: 연산자 버튼을 누른다.
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())

        // then: 아무런 변화가 없어야 한다.
        assertTextEquals(expected)
    }

    // 입력된 피연산자가 없을 때, 연산자 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
    @Test
    fun noOperand_pressOperator() {
        // given: 입력된 피연산자가 없다.
        val expected = "1 + "
        onView(withId(R.id.textView)).perform(replaceText(expected))

        // when: 연산자 버튼을 누른다.
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())

        // then: 아무런 변화가 없어야 한다.
        assertTextEquals(expected)
    }

    // 입력된 피연산자가 있을 때, + 버튼을 누르면 기호가 화면에 보여야 한다.
    @Test
    fun pressPlusButton() {
        // given: 1이 피연산자로 입력되었다.
        onView(withId(R.id.textView)).perform(replaceText("1"))

        // when: + 연산자 버튼을 누른다.
        onView(withId(R.id.buttonPlus)).perform(click())

        // then: + 기호가 화면에 보인다.
        assertTextEquals("1 + ")
    }

    // 입력된 피연산자가 있을 때, - 버튼을 누르면 기호가 화면에 보여야 한다.
    @Test
    fun pressMinusButton() {
        // given: 1이 피연산자로 입력되었다.
        onView(withId(R.id.textView)).perform(replaceText("1"))

        // when: - 연산자 버튼을 누른다.
        onView(withId(R.id.buttonMinus)).perform(click())

        // then: - 기호가 화면에 보인다.
        assertTextEquals("1 - ")
    }

    // 입력된 피연산자가 있을 때, * 버튼을 누르면 기호가 화면에 보여야 한다.
    @Test
    fun pressMultiplyButton() {
        // given: 1이 피연산자로 입력되었다.
        onView(withId(R.id.textView)).perform(replaceText("1"))

        // when: * 연산자 버튼을 누른다.
        onView(withId(R.id.buttonMultiply)).perform(click())

        // then: * 기호가 화면에 보인다.
        assertTextEquals("1 * ")
    }

    // 입력된 피연산자가 있을 때, / 버튼을 누르면 기호가 화면에 보여야 한다.
    @Test
    fun pressDivideButton() {
        // given: 1이 피연산자로 입력되었다.
        onView(withId(R.id.textView)).perform(replaceText("1"))

        // when: / 연산자 버튼을 누른다.
        onView(withId(R.id.buttonDivide)).perform(click())

        // then: / 기호가 화면에 보인다.
        assertTextEquals("1 / ")
    }

    // 입력된 수식이 없을 때, 지우기 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
    @Test
    fun noInput_pressDelete() {
        // given: 입력된 수식이 없다.
        val expected = ""
        assertTextEquals(expected)

        // when: 지우기 버튼을 누른다.
        onView(withId(R.id.buttonDelete)).perform(click())

        // then: 아무런 변화가 없어야 한다.
        assertTextEquals(expected)
    }

    // 입력된 수식이 있을 때, 지우기 버튼을 누르면 수식에 마지막으로 입력된 내용이 지워져야 한다.
    @Test
    fun pressDeleteButton() {
        // given: 32 + 1 이 입력되었다.
        onView(withId(R.id.textView)).perform(replaceText("32 + 1"))

        // when: 지우기 버튼을 누르면
        // then: 마지막 입력이 지워진다.
        onView(withId(R.id.buttonDelete)).perform(click())
        assertTextEquals("32 + ")

        onView(withId(R.id.buttonDelete)).perform(click())
        assertTextEquals("32")

        onView(withId(R.id.buttonDelete)).perform(click())
        assertTextEquals("3")

        onView(withId(R.id.buttonDelete)).perform(click())
        assertTextEquals("")
    }

    private fun assertTextEquals(expected: String) {
        onView(withId(R.id.textView)).check(matches(withText(expected)))
    }


    // NOTE: 참고한 링크 (https://stackoverflow.com/questions/32846738/android-testing-how-to-change-text-of-a-textview-using-espresso)
    private fun replaceText(value: String): ViewAction = object : ViewAction {
        override fun getConstraints(): Matcher<View> = CoreMatchers.allOf(
            ViewMatchers.isDisplayed(),
            ViewMatchers.isAssignableFrom(TextView::class.java)
        )

        override fun getDescription(): String {
            return "replace text"
        }

        override fun perform(uiController: UiController, view: View) {
            (view as TextView).text = value
        }
    }
}
