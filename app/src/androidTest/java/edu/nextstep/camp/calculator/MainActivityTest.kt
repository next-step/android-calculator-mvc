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
    fun pressedNumberButton_shouldShowNumber() {
        // when: 1을 입력하면
        onView(withId(R.id.button1)).perform(click())
        // then: 1이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun showedNumber_pressedNumberButton_shouldShowNumberAfterExistingNumber() {
        // given: 8이 입력되어 있을 때
        onView(withId(R.id.button8)).perform(click())
        // when: 9를 입력하면
        onView(withId(R.id.button9)).perform(click())
        // then: 89가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("89")))
    }

    @Test
    fun pressedOperatorButton_shouldShowNothing() {
        // when: 사용자가 연산자 + 버튼을 누르면
        onView(withId(R.id.buttonPlus)).perform(click())
        // then: 화면에 아무런 변화가 없어야 한다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun showedNumber_pressedOperatorButton_shouldShowOperator() {
        // given: 1이 입력되어 있을 때
        onView(withId(R.id.button1)).perform(click())
        // when: 사용자가 연산자 + 버튼을 누르면
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        // then: '1 -'가 화면에 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("1 -")))
    }

    @Test
    fun pressedDeleteButton_shouldShowNothing() {
        // when: 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())
        // then: 화면에 아무런 변화가 없어야 한다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun showedNumber_pressedDeleteButton_shouldDeleteLastOperatorOrOperand() {
        // given: '32 + 1' 수식이 있을 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        // when: 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())
        // then: '32 +'가 화면에 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("32 +")))
    }

    @Test
    fun completeExpression_pressedEqualsButton_shouldShowResult() {
        // given: '3 + 2' 수식이 있을 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        // when: 사용자가 = 버튼을 누르면
        onView(withId(R.id.buttonEquals)).perform(click())
        // then: 5가 화면에 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun incompleteExpression_pressedEqualsButton_shouldShowToastMessage() {
        // given: '3 +' 수식이 있을 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        // when: 사용자가 = 버튼을 누르면
        onView(withId(R.id.buttonEquals)).perform(click())
        // then: 토스트 메세지가 화면에 보여야 한다
    }
}