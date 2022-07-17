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
    // 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.

    @get:Rule var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 입력된_내용이_없을_때_5를_누르면_화면에_5가_표시된다() {
        // when
        clickButtonWithId(R.id.button5)

        // then
        checkResultMatches("5")
    }

    @Test
    fun `5가_입력되어_있을_때_더하기를_누르면_5_더하기가_표시된다`() {
        // given
        clickButtonWithId(R.id.button5)

        // when
        clickButtonWithId(R.id.buttonPlus)

        // then
        checkResultMatches("5 +")
    }

    @Test
    fun `5_더하기가_입력되어_있을_때_빼기를_누르면_5_빼기가_표시된다`() {
        // given
        clickButtonWithId(R.id.button5)
        clickButtonWithId(R.id.buttonPlus)

        // when
        clickButtonWithId(R.id.buttonMinus)

        // then
        checkResultMatches("5 -")
    }

    @Test
    fun `5_더하기가_입력되어_있을_때_1을_누르면_5_더하기_1이_표시된다`() {
        // given
        clickButtonWithId(R.id.button5)
        clickButtonWithId(R.id.buttonPlus)

        // when
        clickButtonWithId(R.id.button1)

        // then
        checkResultMatches("5 + 1")
    }

    @Test
    fun `5가_입력되어_있을_때_5를_누르면_55가_표시된다`() {
        // given
        clickButtonWithId(R.id.button5)

        // when
        clickButtonWithId(R.id.button5)

        // then
        checkResultMatches("55")
    }

    @Test
    fun 아무것도_입력되지_않았을_때_더하기를_누르면_아무것도_표시되지_않는다() {
        // when
        clickButtonWithId(R.id.buttonPlus)

        // then
        checkResultMatches("")
    }

    @Test
    fun 입력된_수식이_없을_때_지우기를_누르면_아무것도_표시되지_않는다() {
        // when
        clickButtonWithId(R.id.buttonDelete)

        // then
        checkResultMatches("")
    }

    @Test
    fun `5_더하기_1이_입력되어_있을_때_지우기를_누르면_5_더하기를_표시한다`() {
        // given
        clickButtonWithId(R.id.button5)
        clickButtonWithId(R.id.buttonPlus)
        clickButtonWithId(R.id.button1)

        // when
        clickButtonWithId(R.id.buttonDelete)

        // then
        checkResultMatches("5 +")
    }

    @Test
    fun `5_더하기_1이_입력되어_있을_때_등호를_누르면_6이_표시된다`() {
        // given
        clickButtonWithId(R.id.button5)
        clickButtonWithId(R.id.buttonPlus)
        clickButtonWithId(R.id.button1)

        // when
        clickButtonWithId(R.id.buttonEquals)

        // then
        checkResultMatches("6")
    }

    @Test
    fun `5_더하기가_입력되어_있을_때_등호를_누르면_화면에_5_더하기가_표시된다`() {
        // given
        clickButtonWithId(R.id.button5)
        clickButtonWithId(R.id.buttonPlus)

        // when
        clickButtonWithId(R.id.buttonEquals)

        // then
        checkResultMatches("5 +")
    }

    @Test
    fun `5_더하기_1이_계산되고_더하기_1을_누르면_6_더하기_1이_표시된다`() {
        // given
        clickButtonWithId(R.id.button5)
        clickButtonWithId(R.id.buttonPlus)
        clickButtonWithId(R.id.button1)
        clickButtonWithId(R.id.buttonEquals)

        // when
        clickButtonWithId(R.id.buttonPlus)
        clickButtonWithId(R.id.button1)

        // then
        checkResultMatches("6 + 1")
    }

    private fun checkResultMatches(text: String) {
        onView(withId(R.id.textView)).check(matches(withText(text)))
    }

    private fun clickButtonWithId(id: Int) {
        onView(withId(id)).perform(click())
    }
}
