package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val activityScenarioRule =
        ActivityScenarioRule(MainActivity::class.java) // 반복적으로 해야하는 @Before, @After 부분을 알아서 해줌

    @Test
    fun test0() {
        // when : 사용자가 피연산자 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then : 계산기 텍스트뷰에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun test1() {
        // when : 사용자가 피연산자 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then : 계산기 텍스트뷰에 1이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun test2() {
        // when : 사용자가 피연산자 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        // then : 계산기 텍스트뷰에 2이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun test3() {
        // when : 사용자가 피연산자 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then : 계산기 텍스트뷰에 3이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun test4() {
        // when : 사용자가 피연산자 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        // then : 계산기 텍스트뷰에 4이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun test5() {
        // when : 사용자가 피연산자 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        // then : 계산기 텍스트뷰에 5이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun test6() {
        // when : 사용자가 피연산자 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then : 계산기 텍스트뷰에 6이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun test7() {
        // when : 사용자가 피연산자 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then : 계산기 텍스트뷰에 7이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun test8() {
        // when : 사용자가 피연산자 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then : 계산기 텍스트뷰에 8이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun test9() {
        // when : 사용자가 피연산자 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        // then : 계산기 텍스트뷰에 9이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    // 피연산자를 여러번 누르면 피연산자가 화면에 이어서 출력되어야 한다.
    @Test
    fun clickOperand_Continuously() {
        // when : 사용자가 피연산자 3,2 버튼을 이어서 누르면
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())

        // then : 계산기 텍스트뷰에 32가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("32")))
    }

    // 계산기 텍스트뷰에 아무런 수식이 없을때, 연산자를 누르면 아무런 변화가 없어야 한다.
    @Test
    fun clickOperator_When_Empty() {
        // when : 사용자가 +,-,x,÷ 연산자 버튼을 누르면
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())

        // then : 계산기 텍스트뷰에 아무런 변화가 없다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    // 피연산자와 연산자를 이어서 누르면, 피연산자와 연산자가 화면에 이어서 출력되어야 한다.
    @Test
    fun clickOperator() {
        // when : 사용자가 3과 마이너스 연산자 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())

        // then : 계산기 텍스트뷰에 3-가 출력되어야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3-")))
    }

    // 계산기 텍스트뷰에 아무런 수식이 없을때, 지우기 버튼을 누르면 아무런 변화가 없어야한다.
    @Test
    fun clickDelete_When_Empty() {
        // when : 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        // then : 아무런 변화가 없어야한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    // 계산기 텍스트뷰에 수식이 있을때, 지우기 버튼을 수식의 마지막 문자가 지워진다.
    @Test
    fun clickDelete() {
        // when : 사용자가 3,2,+,1 버튼을 누른후 지우기 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())

        // then : 계산기 텍스트뷰에 32+가 출력되어야 한다.
        onView(withId(R.id.textView)).check(matches(withText("32+")))
    }

    // 계산기 텍스트뷰에 수식이 있을때, = 버튼을 누르면 계산의 결과값이 텍스트뷰에 출력 되어야한다.
    @Test
    fun clickEqual() {
        // when : 사용자가 3,2,+,1,÷,3,x,9,-,6,= 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.button6)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click()) // 32+1÷3x9-6

        // then : 계산기 텍스트뷰에 93이 출력되어야 한다.
        onView(withId(R.id.textView)).check(matches(withText("93")))
    }

}