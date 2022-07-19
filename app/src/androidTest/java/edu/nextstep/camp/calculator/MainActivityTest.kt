package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 버튼_5과_더하기와_1를_누르면_화면에_그대로_수식이_보여야한다() {
        //when
        onView(ViewMatchers.withId(R.id.button5)).perform(click())
        onView(ViewMatchers.withId(R.id.buttonPlus)).perform(click())
        onView(ViewMatchers.withId(R.id.button1)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("5 + 1")))
    }

    @Test
    fun 버튼_8과_9를_연속으로_누르면_화면에_89로_보여야한다() {
        //when
        onView(ViewMatchers.withId(R.id.button8)).perform(click())
        onView(ViewMatchers.withId(R.id.button9)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("89")))
    }

    @Test
    fun 피연산자없이_더하기를_누르면_화면에_아무런변화가_없어야한다() {
        //when
        onView(ViewMatchers.withId(R.id.buttonPlus)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("")))
    }

    @Test
    fun 피연산자없이_빼기를_누르면_화면에_아무런변화가_없어야한다() {
        //when
        onView(ViewMatchers.withId(R.id.buttonMinus)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("")))
    }

    @Test
    fun 피연산자없이_곱하기를_누르면_화면에_아무런변화가_없어야한다() {
        //when
        onView(ViewMatchers.withId(R.id.buttonMultiply)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("")))
    }

    @Test
    fun 피연산자없이_나누기를_누르면_화면에_아무런변화가_없어야한다() {
        //when
        onView(ViewMatchers.withId(R.id.buttonDivide)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("")))
    }

    @Test
    fun 피연산자_있을때_더하기를_누르면_화면에_해당_기호가_보여야한다() {
        //given
        onView(ViewMatchers.withId(R.id.button1)).perform(click())
        //when
        onView(ViewMatchers.withId(R.id.buttonPlus)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("1 + ")))
    }

    @Test
    fun 피연산자_있을때_빼기를_누르면_화면에_해당_기호가_보여야한다() {
        //given
        onView(ViewMatchers.withId(R.id.button1)).perform(click())
        //when
        onView(ViewMatchers.withId(R.id.buttonMinus)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("1 - ")))
    }

    @Test
    fun 입력된_수식이_없을때_지우기_버튼을_누르면_화면에_변화가_없어야한다() {
        //when
        onView(ViewMatchers.withId(R.id.buttonDivide)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("")))
    }

    @Test
    fun 입력된_수식이_있을때_지우기_버튼을_누르면_마지막으로_입력된_피연산자가_사라져야한다() {
        //given
        onView(ViewMatchers.withId(R.id.button3)).perform(click())
        onView(ViewMatchers.withId(R.id.button2)).perform(click())
        onView(ViewMatchers.withId(R.id.buttonPlus)).perform(click())
        onView(ViewMatchers.withId(R.id.button1)).perform(click())
        //when
        onView(ViewMatchers.withId(R.id.buttonDelete)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("32 + ")))
    }

    @Test
    fun 입력된_수식이_완전할_때_equal_버튼을_누르면_결과가_나와야한다() {
        //given
        onView(ViewMatchers.withId(R.id.button3)).perform(click())
        onView(ViewMatchers.withId(R.id.buttonPlus)).perform(click())
        onView(ViewMatchers.withId(R.id.button2)).perform(click())
        //when
        onView(ViewMatchers.withId(R.id.buttonEquals)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("5")))
    }

    @Test
    fun 입력된_수식이_완전하지_않을때_equal_버튼을_누르면_토스트가_떠야한다() {
        //given
        onView(ViewMatchers.withId(R.id.button3)).perform(click())
        onView(ViewMatchers.withId(R.id.buttonPlus)).perform(click())
        //when
        onView(ViewMatchers.withId(R.id.buttonEquals)).perform(click())
        //then
        onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(withText("3 + ")))
    }
}