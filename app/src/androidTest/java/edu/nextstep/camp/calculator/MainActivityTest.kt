package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

/*
입력된 피연산자가 없을 때, 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
-> 1 클릭 -> 1
5 + -> 1 클릭 -> 5 + 1
입력된 피연산자가 있을 때, 기존 숫자 뒤에 해당 숫자가 화면에 보여야 한다. 예를 들면, 8이 입력되어 있을 때 9를 입력하면 89가 보여야 한다.
8 -> 9 클릭 -> 89
입력된 피연산자가 없을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
-> + 클릭 ->
입력된 피연산자가 있을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 해당 기호가 화면에 보여야 한다.
1 -> + 클릭 -> 1 +
1 + -> - 클릭 -> 1 -
입력된 수식이 없을 때, 사용자가 지우기 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
-> 지우기 클릭 ->
입력된 수식이 있을 때, 사용자가 지우기 버튼을 누르면 수식에 마지막으로 입력된 연산자 또는 피연산자가 지워져야 한다.
32 + 1 -> 지우기 클릭 -> 32 + -> 지우기 클릭 -> 32 -> 지우기 클릭 -> 3 -> 지우기 클릭 ->  -> 지우기 클릭 ->
입력된 수신이 완전할 때, 사용자가 = 버튼을 누르면 입력된 수식의 결과가 화면에 보여야 한다.
3 + 2 -> = 클릭 -> 5
입력된 수식이 완전하지 않을 때, 사용자가 = 버튼을 눌렀을 때 완성되지 않은 수식입니다 토스트 메세지가 화면에 보여야 한다.
3 + -> = 클릭 -> 완성되지 않은 수식입니다
*/
class MainActivityTest {
    // 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @get:Rule
    var activityScenarioRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 버튼_0을_누르면_화면에_0이_보여야_한다() {
        // when: 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then: 화면에 0이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun 버튼_1을_누르면_화면에_1이_보여야_한다() {
        // when: 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then: 화면에 1이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun 버튼_2을_누르면_화면에_2이_보여야_한다() {
        // when: 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then: 화면에 2이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun 버튼_3을_누르면_화면에_3이_보여야_한다() {
        // when: 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then: 화면에 3이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun 버튼_4을_누르면_화면에_4이_보여야_한다() {
        // when: 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 화면에 4이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun 버튼_5을_누르면_화면에_5이_보여야_한다() {
        // when: 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then: 화면에 5이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun 버튼_6을_누르면_화면에_6이_보여야_한다() {
        // when: 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then: 화면에 6이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun 버튼_7을_누르면_화면에_7이_보여야_한다() {
        // when: 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then: 화면에 7이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun 버튼_8을_누르면_화면에_8이_보여야_한다() {
        // when: 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then: 화면에 8이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun 버튼_9을_누르면_화면에_9이_보여야_한다() {
        // when: 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 화면에 9이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    @Test
    fun 입력된_피연산자가_있을_때_기존_숫자_뒤에_해당_숫자가_화면에_보여야_한다() {
        // Given
        onView(withId(R.id.button8)).perform(click())

        // When
        onView(withId(R.id.button0)).perform(click())

        // Then
        onView(withId(R.id.textView)).check(matches(withText("80")))
    }

    @Test
    fun 입력된_피연산자가_없을_때_사용자가_연산자_버튼을_누르면_화면에_아무런_변화가_없어야한다() {
        // When
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())

        // Then
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun `입력된_피연산자가_있을_때_사용자가_연산자_버튼을_누르면_해당_기호가_화면에_보여야_한다`() {
        // Given
        onView(withId(R.id.button1)).perform(click())

        // When
        onView(withId(R.id.buttonMinus)).perform(click())

        // Then
        onView(withId(R.id.textView)).check(matches(withText("1 -")))
    }

    @Test
    fun `입력된_수식이_없을_때_사용자가_지우기_버튼을_누르면_화면에_아무런_변화가_없어야_한다`() {
        // When
        onView(withId(R.id.buttonDelete)).perform(click())

        // Then
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun `입력된_피연산자_한자리_있을_때_사용자가_지우기_버튼을_누르면_수식에_마지막으로_입력된_연산자_또는_피연산자가_지워져야_한다`() {
        // Given
        onView(withId(R.id.button1)).perform(click())

        // When
        onView(withId(R.id.buttonDelete)).perform(click())

        // Then
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun `입력된_연산자_있을_때_사용자가_지우기_버튼을_누르면_수식에_마지막으로_입력된_연산자_또는_피연산자가_지워져야_한다`() {
        // Given
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())

        // When
        onView(withId(R.id.buttonDelete)).perform(click())

        // Then
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun `입력된_피연산자_있을_때_사용자가_지우기_버튼을_누르면_수식에_마지막으로_입력된_연산자_또는_피연산자가_지워져야_한다`() {
        // Given
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.button1)).perform(click())

        // When
        onView(withId(R.id.buttonDelete)).perform(click())

        // Then
        onView(withId(R.id.textView)).check(matches(withText("1 -")))
    }

    @Test
    fun `입력된_수신이_완전할_때_사용자가_equal_버튼을_누르면_입력된_수식의_결과가_화면에_보여야_한다`() {
        // Given
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.button6)).perform(click())

        // When
        onView(withId(R.id.buttonEquals)).perform(click())

        // Then
        onView(withId(R.id.textView)).check(matches(withText("30")))
    }
}