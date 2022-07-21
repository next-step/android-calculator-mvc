package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import edu.nextstep.camp.calculator.AndroidUITestHelper.onClickViewWithResId
import edu.nextstep.camp.calculator.AndroidUITestHelper.onClickViewsWithResIds
import edu.nextstep.camp.calculator.AndroidUITestHelper.onMatchTextWithResId
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 버튼_5과_더하기와_1를_누르면_화면에_그대로_수식이_보여야한다() {
        //when
        onClickViewsWithResIds(R.id.button5, R.id.buttonPlus, R.id.button1)
        //then
        onMatchTextWithResId(R.id.tv_result, "5 + 1")
    }

    @Test
    fun 버튼_8과_9를_연속으로_누르면_화면에_89로_보여야한다() {
        //when
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.button9)).perform(click())
        //then
        onMatchTextWithResId(R.id.tv_result, "89")
    }

    @Test
    fun 피연산자없이_더하기를_누르면_화면에_아무런변화가_없어야한다() {
        //when
        onClickViewWithResId(R.id.buttonPlus)
        //then
        onMatchTextWithResId(R.id.tv_result, "")
    }

    @Test
    fun 피연산자없이_빼기를_누르면_화면에_아무런변화가_없어야한다() {
        //when
        onClickViewWithResId(R.id.buttonMinus)
        //then
        onMatchTextWithResId(R.id.tv_result, "")
    }

    @Test
    fun 피연산자없이_곱하기를_누르면_화면에_아무런변화가_없어야한다() {
        //when
        onClickViewWithResId(R.id.buttonMultiply)
        //then
        onMatchTextWithResId(R.id.tv_result, "")
    }

    @Test
    fun 피연산자없이_나누기를_누르면_화면에_아무런변화가_없어야한다() {
        //when
        onClickViewWithResId(R.id.buttonDivide)
        //then
        onMatchTextWithResId(R.id.tv_result, "")
    }

    @Test
    fun 피연산자_있을때_더하기를_누르면_화면에_해당_기호가_보여야한다() {
        //given
        onClickViewWithResId(R.id.button1)
        //when
        onClickViewWithResId(R.id.buttonPlus)
        //then
        onMatchTextWithResId(R.id.tv_result, "1 + ")
    }

    @Test
    fun 피연산자_있을때_빼기를_누르면_화면에_해당_기호가_보여야한다() {
        //given
        onClickViewWithResId(R.id.button1)
        //when
        onClickViewWithResId(R.id.buttonMinus)
        //then
        onMatchTextWithResId(R.id.tv_result, "1 - ")
    }

    @Test
    fun 입력된_수식이_없을때_지우기_버튼을_누르면_화면에_변화가_없어야한다() {
        //when
        onClickViewWithResId(R.id.buttonDivide)
        //then
        onMatchTextWithResId(R.id.tv_result, "")
    }

    @Test
    fun 입력된_수식이_있을때_지우기_버튼을_누르면_마지막으로_입력된_피연산자가_사라져야한다() {
        //given
        onClickViewsWithResIds(R.id.button3, R.id.button2, R.id.buttonPlus, R.id.button1)
        //when~then:1
        onClickViewWithResId(R.id.buttonDelete)
        onMatchTextWithResId(R.id.tv_result, "32 + ")
        //when~then:2
        onClickViewWithResId(R.id.buttonDelete)
        onMatchTextWithResId(R.id.tv_result, "32")
        //when~then:3
        onClickViewWithResId(R.id.buttonDelete)
        onMatchTextWithResId(R.id.tv_result, "3")
        //when~then:4
        onClickViewWithResId(R.id.buttonDelete)
        onMatchTextWithResId(R.id.tv_result, "")
    }

    @Test
    fun 입력된_수식이_완전할_때_equal_버튼을_누르면_결과가_나와야한다() {
        //given
        onClickViewsWithResIds(R.id.button3, R.id.buttonPlus, R.id.button2)
        //when
        onClickViewWithResId(R.id.buttonEquals)
        //then
        onMatchTextWithResId(R.id.tv_result, "5")
    }

    @Test
    fun 입력된_수식이_완전하지_않을때_equal_버튼을_누르면_토스트가_떠야한다() {
        //given
        onClickViewsWithResIds(R.id.button3, R.id.buttonPlus)
        //when
        onClickViewWithResId(R.id.buttonEquals)
        //then
        onMatchTextWithResId(R.id.tv_result, "3 + ")
    }
}