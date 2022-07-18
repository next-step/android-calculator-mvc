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
    fun 입력된_피연산자가_없을_때_사용자가_피연산자_숫자_버튼을_누르면_화면에_해당_숫자가_화면에_보여야_한다() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun 입력된_피연산자가_있을_때_기존_숫자_뒤에_해당_숫자가_화면에_보여야_한다() {
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("89")))
    }

    @Test
    fun 입력된_피연산자가_없을_때_사용자가_연산자_버튼을_누르면_화면에_아무런_변화가_없어야_한다() {
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun 입력된_피연산자가_있을_때_사용자가_연산자_버튼을_누르면_해당_기호가_화면에_보여야_한다() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("1 -")))
    }

    @Test
    fun 입력된_수식이_없을_때_사용자가_지우기_버튼을_누르면_화면에_아무런_변화가_없어야_한다() {
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun 입력된_수식이_있을_때_사용자가_지우기_버튼을_누르면_수식에_마지막으로_입력된_연산자_또는_피연산자가_지워져야_한다() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("32 +")))
    }

    @Test
    fun 입력된_수신이_완전할_때_사용자가_등호_버튼을_누르면_입력된_수식의_결과가_화면에_보여야_한다() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun 입력된_수식이_완전하지_않을_때_사용자가_등호_버튼을_눌렀을_때_완성되지_않은_수식입니다_토스트_메세지가_화면에_보여야_한다() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())
    }
}