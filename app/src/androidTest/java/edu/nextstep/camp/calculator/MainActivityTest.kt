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

    // 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @Test
    fun 버튼_0을_누르면_화면에_0이_보여야_한다() {
        // when: 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())
        // then: 화면에 0이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun `피연산자_연산자_피연산자_버튼을_누르면_순서대로_보여야_한다`() {
        // when: 1 버튼, + 버튼, 2 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        // then: 화면에 1 + 2가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("1 + 2")))
    }

    @Test
    fun `입력된_피연산자가_있을_때_기존_숫자_뒤에_해당_숫자가_화면에_보여야_한다`() {
        // when: 1 버튼, 2 버튼, 3 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        // then: 화면에 123이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("123")))
    }

    @Test
    fun `입력된_피연산자가_없을_때_사용자가_연산자_버튼을_누르면_변화가_없어야_한다`() {
        // when: + 버튼을 누르면
        onView(withId(R.id.buttonPlus)).perform(click())
        // then: 화면이 비어있다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun 입력된_피연산자가_있을_때_사용자가_연산자_버튼을_누르면_해당_기호가_화면에_보여야_한다() {
        // given: '1 +'가 입력된 상태
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        // when: - 버튼을 누르면
        onView(withId(R.id.buttonMinus)).perform(click())
        // then: 화면에 '1 -'가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("1 -")))
    }

    @Test
    fun 입력된_수식이_없을_때_지우기_버튼을_누르면_변화가_없다() {
        // when: 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())
        // then: 화면이 비어있다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun 입력된_수식에_마지막이_연산자일_때_지우기_버튼을_누르면_연산자가_제거된다() {
        // given: '1 +'가 입력된 상태
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        // when: 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())
        // then: 화면에 '1 -'가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun 입력된_수식에_마지막이_10미만의_피연산자일_때_지우기_버튼을_누르면_피연산자가_제거된다() {
        // given: '1 + 9'가 입력된 상태
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button9)).perform(click())
        // when: 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())
        // then: 화면에 '1 -'가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("1 +")))
    }

    @Test
    fun 입력된_수식에_마지막이_10이상의_피연산자일_때_지우기_버튼을_누르면_피연산자의_일의_자리수가__제거된다() {
        // given: '1 + 19'가 입력된 상태
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button9)).perform(click())
        // when: 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())
        // then: 화면에 '1 + 1'이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("1 + 1")))
    }

    @Test
    fun 입력된_수식이_완전할_때_등호_버튼을_누르면_결과를_반환한다() {
        // given: '1 + 19 * 2'가 입력된 상태
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        // when: 지우기 버튼을 누르면
        onView(withId(R.id.buttonEquals)).perform(click())
        // then: 화면에 40이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("40")))
    }
}











