package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

@Suppress("NonAsciiCharacters")
class MainActivityTest {
	@get:Rule
	var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

	// 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
	@Test
	fun 버튼_0을_누르면_화면에_0이_보여야_한다() {
		// when: 0 버튼을 누르면
		onView(withId(R.id.button0)).perform(click())
		// then: 화면에 0이 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("0")))
	}

	@Test
	fun 버튼_1을_누르면_화면에_1이_보여야_한다() {
		// when: 1 버튼을 누르면
		onView(withId(R.id.button1)).perform(click())
		// then: 화면에 1이 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("1")))
	}

	@Test
	fun 버튼_2을_누르면_화면에_2이_보여야_한다() {
		// when: 2 버튼을 누르면
		onView(withId(R.id.button2)).perform(click())
		// then: 화면에 2이 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("2")))
	}

	@Test
	fun 버튼_3을_누르면_화면에_3이_보여야_한다() {
		// when: 3 버튼을 누르면
		onView(withId(R.id.button3)).perform(click())
		// then: 화면에 3이 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("3")))
	}

	@Test
	fun 버튼_4을_누르면_화면에_4이_보여야_한다() {
		// when: 4 버튼을 누르면
		onView(withId(R.id.button4)).perform(click())
		// then: 화면에 4이 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("4")))
	}

	@Test
	fun 버튼_5을_누르면_화면에_5이_보여야_한다() {
		// when: 5 버튼을 누르면
		onView(withId(R.id.button5)).perform(click())
		// then: 화면에 5이 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("5")))
	}

	@Test
	fun 버튼_6을_누르면_화면에_6이_보여야_한다() {
		// when: 6 버튼을 누르면
		onView(withId(R.id.button6)).perform(click())
		// then: 화면에 6이 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("6")))
	}

	@Test
	fun 버튼_7을_누르면_화면에_7이_보여야_한다() {
		// when: 7 버튼을 누르면
		onView(withId(R.id.button7)).perform(click())
		// then: 화면에 7이 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("7")))
	}

	@Test
	fun 버튼_8을_누르면_화면에_8이_보여야_한다() {
		// when: 8 버튼을 누르면
		onView(withId(R.id.button8)).perform(click())
		// then: 화면에 8이 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("8")))
	}

	@Test
	fun 버튼_9을_누르면_화면에_9이_보여야_한다() {
		// when: 9 버튼을 누르면
		onView(withId(R.id.button9)).perform(click())
		// then: 화면에 9이 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("9")))
	}

	@Test
	fun 버튼_8_9를_누르면_화면에_89가_보여야_한다() {
		// given: 8이 입력되어 있을 때
		onView(withId(R.id.button8)).perform(click())

		// when: 9를 입력하면
		onView(withId(R.id.button9)).perform(click())

		// then: 89가 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("89")))
	}

	@Test
	fun 빈_화면에서_버튼_더하기를_누르면_화면에_아무런_변화가_없어야_한다() {
		// when: 사용자가 연산자 + 버튼을 누르면
		onView(withId(R.id.buttonPlus)).perform(click())

		// then: 화면에 아무런 변화가 없어야 한다.
		onView(withId(R.id.textView)).check(matches(withText("")))
	}

	@Test
	fun 빈_화면에서_버튼_빼기를_누르면_화면에_아무런_변화가_없어야_한다() {
		// when: 사용자가 연산자 - 버튼을 누르면
		onView(withId(R.id.buttonMinus)).perform(click())

		// then: 화면에 아무런 변화가 없어야 한다.
		onView(withId(R.id.textView)).check(matches(withText("")))
	}

	@Test
	fun 빈_화면에서_버튼_곱하기를_누르면_화면에_아무런_변화가_없어야_한다() {
		// when: 사용자가 연산자 × 버튼을 누르면
		onView(withId(R.id.buttonMultiply)).perform(click())

		// then: 화면에 아무런 변화가 없어야 한다.
		onView(withId(R.id.textView)).check(matches(withText("")))
	}

	@Test
	fun 빈_화면에서_버튼_나누기를_누르면_화면에_아무런_변화가_없어야_한다() {
		// when: 사용자가 연산자 ÷ 버튼을 누르면
		onView(withId(R.id.buttonDivide)).perform(click())

		// then: 화면에 아무런 변화가 없어야 한다.
		onView(withId(R.id.textView)).check(matches(withText("")))
	}

	@Test
	fun 버튼_8_플러스_를_누른_경우_화면에_8_플러스가_보여야_한다() {
		// given: 8이 입력되어 있을 때
		onView(withId(R.id.button8)).perform(click())

		// 사용자가 연산자 + 버튼을 누르면
		onView(withId(R.id.buttonPlus)).perform(click())

		// '8 +' 가 화면에 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("8 +")))
	}

	@Test
	fun 화면에_8_플러스_수식이_있을때_마이너스를_누른_경우_화면에_8_마이너스가_보여야_한다() {
		// given: 8 + 가 입력되어 있을 때
		onView(withId(R.id.button8)).perform(click())
		onView(withId(R.id.buttonPlus)).perform(click())

		// 사용자가 연산자 - 버튼을 누르면
		onView(withId(R.id.buttonMinus)).perform(click())

		// '8 -' 가 화면에 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("8 -")))
	}

	@Test
	fun 화면에_8_플러스_수식이_있을때_곱하기_버튼을_누른_경우_화면에_8_곱하기가_보여야_한다() {
		// given: 8 + 가 입력되어 있을 때
		onView(withId(R.id.button8)).perform(click())
		onView(withId(R.id.buttonPlus)).perform(click())

		// 사용자가 연산자 × 버튼을 누르면
		onView(withId(R.id.buttonMultiply)).perform(click())

		// '8 ×' 가 화면에 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("8 ×")))
	}

	@Test
	fun 화면에_8_플러스_수식이_있을때_나누기를_누른_경우_화면에_8_나누기가_보여야_한다() {
		// given: 8 + 가 입력되어 있을 때
		onView(withId(R.id.button8)).perform(click())
		onView(withId(R.id.buttonPlus)).perform(click())

		// 사용자가 연산자 ÷ 버튼을 누르면
		onView(withId(R.id.buttonDivide)).perform(click())

		// '8 ÷' 가 화면에 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("8 ÷")))
	}

	@Test
	fun 화면에_8_플러스_수식이_있을때_플러스를_누른_경우_화면에_8_플러스가_보여야_한다() {
		// given: 8 + 가 입력되어 있을 때
		onView(withId(R.id.button8)).perform(click())
		onView(withId(R.id.buttonPlus)).perform(click())

		// 사용자가 연산자 + 버튼을 누르면
		onView(withId(R.id.buttonPlus)).perform(click())

		// '8 +' 가 화면에 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("8 +")))
	}

	@Test
	fun 빈화면에서_지우기_버튼을_누르면_화면에_아무런_변화가_없어야_한다() {
		// when: 사용자가 지우기 버튼을 누르면
		onView(withId(R.id.buttonDelete)).perform(click())

		// then: 화면에 아무런 변화가 없어야 한다.
		onView(withId(R.id.textView)).check(matches(withText("")))
	}

	@Test
	fun 화면에_32_플러스_1_수식이_있을때_지우기_버튼을_누르면_화면에_32_플러스가_보여야_한다() {
		// given: 32 + 1 수식이 있을 때
		onView(withId(R.id.button3)).perform(click())
		onView(withId(R.id.button2)).perform(click())
		onView(withId(R.id.buttonPlus)).perform(click())
		onView(withId(R.id.button1)).perform(click())

		// when: 사용자가 지우기 버튼을 누르면
		onView(withId(R.id.buttonDelete)).perform(click())

		// then: '32 +' 가 화면에 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("32 +")))
	}

	@Test
	fun 화면에_32_플러스_수식이_있을때_지우기_버튼을_누르면_화면에_32가_보여야_한다() {
		// given: 32 + 수식이 있을 때
		onView(withId(R.id.button3)).perform(click())
		onView(withId(R.id.button2)).perform(click())
		onView(withId(R.id.buttonPlus)).perform(click())

		// when: 사용자가 지우기 버튼을 누르면
		onView(withId(R.id.buttonDelete)).perform(click())

		// then: '32' 가 화면에 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("32")))
	}

	@Test
	fun 화면에_32_수식이_있을때_지우기_버튼을_누르면_화면에_3이_보여야_한다() {
		// given: 32 수식이 있을 때
		onView(withId(R.id.button3)).perform(click())
		onView(withId(R.id.button2)).perform(click())

		// when: 사용자가 지우기 버튼을 누르면
		onView(withId(R.id.buttonDelete)).perform(click())

		// then: '3' 이 화면에 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("3")))
	}

	@Test
	fun 화면에_3_수식이_있을때_지우기_버튼을_누르면_화면에_빈화면이_보여야_한다() {
		// given: 3 수식이 있을 때
		onView(withId(R.id.button3)).perform(click())

		// when: 사용자가 지우기 버튼을 누르면
		onView(withId(R.id.buttonDelete)).perform(click())

		// then: 빈 화면에 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("")))
	}

	@Test
	fun 화면에_3_플러스_2_수식이_있을때_등호_버튼을_누르면_5가_화면에_보여야한다() {
		// given: 3 + 2 수식이 있을 때,
		onView(withId(R.id.button3)).perform(click())
		onView(withId(R.id.buttonPlus)).perform(click())
		onView(withId(R.id.button2)).perform(click())

		// when: 사용자가 = 버튼을 누르면
		onView(withId(R.id.buttonEquals)).perform(click())

		// then: 5가 화면에 보여야 한다.
		onView(withId(R.id.textView)).check(matches(withText("5")))
	}
}
