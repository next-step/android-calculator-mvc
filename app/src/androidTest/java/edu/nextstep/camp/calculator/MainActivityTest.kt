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
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    //사용자가 피연산자 0버튼을 누르면 화면에 0가 화면에 보여야 한다.
    @Test
    fun clickButtonNumber0_inputTextviewNumber0() {
        //when: 사용자가 피연산자 0 버튼을 누르면
        onView(withText("0")).perform(click())

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    //사용자가 피연산자 1버튼을 누르면 화면에 1가 화면에 보여야 한다.
    @Test
    fun clickButtonNumber1_inputTextviewNumber1() {
        //when: 사용자가 피연산자 1 버튼을 누르면
        onView(withText("1")).perform(click())

        //then: 계산기 텍스트에 1이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    //사용자가 피연산자 2버튼을 누르면 화면에 2가 화면에 보여야 한다.
    @Test
    fun clickButtonNumber2_inputTextviewNumber2() {
        //when: 사용자가 피연산자 2 버튼을 누르면
        onView(withText("2")).perform(click())

        //then: 계산기 텍스트에 1이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    //사용자가 피연산자 3버튼을 누르면 화면에 3가 화면에 보여야 한다.
    @Test
    fun clickButtonNumber3_inputTextviewNumber3() {
        //when: 사용자가 피연산자 3 버튼을 누르면
        onView(withText("3")).perform(click())

        //then: 계산기 텍스트에 3이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    //사용자가 피연산자 4버튼을 누르면 화면에 4가 화면에 보여야 한다.
    @Test
    fun clickButtonNumber4_inputTextviewNumber4() {
        //when: 사용자가 피연산자 4 버튼을 누르면
        onView(withText("4")).perform(click())

        //then: 계산기 텍스트에 4이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    //사용자가 피연산자 5버튼을 누르면 화면에 5가 화면에 보여야 한다.
    @Test
    fun clickButtonNumber5_inputTextviewNumber5() {
        //when: 사용자가 피연산자 5 버튼을 누르면
        onView(withText("5")).perform(click())

        //then: 계산기 텍스트에 5이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    //사용자가 피연산자 6버튼을 누르면 화면에 6가 화면에 보여야 한다.
    @Test
    fun clickButtonNumber6_inputTextviewNumber6() {
        //when: 사용자가 피연산자 6 버튼을 누르면
        onView(withText("6")).perform(click())

        //then: 계산기 텍스트에 6이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    //사용자가 피연산자 7버튼을 누르면 화면에 7가 화면에 보여야 한다.
    @Test
    fun clickButtonNumber7_inputTextviewNumber7() {
        //when: 사용자가 피연산자 7 버튼을 누르면
        onView(withText("7")).perform(click())

        //then: 계산기 텍스트에 7이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    //사용자가 피연산자 8버튼을 누르면 화면에 8가 화면에 보여야 한다.
    @Test
    fun clickButtonNumber8_inputTextviewNumber8() {
        //when: 사용자가 피연산자 8 버튼을 누르면
        onView(withText("8")).perform(click())

        //then: 계산기 텍스트에 8이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    //사용자가 피연산자 9버튼을 누르면 화면에 9가 화면에 보여야 한다.
    @Test
    fun clickButtonNumber9_inputTextviewNumber9() {
        //when: 사용자가 피연산자 9 버튼을 누르면
        onView(withText("9")).perform(click())

        //then: 계산기 텍스트에 9이 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    @Test
    fun `입력된_피연산자가_있을_때_기존_숫자_뒤에_해당_숫자가_화면에_보여야_한다`() {
        //given: 8이 화면에 입력되어 있을 때
        onView(withId(R.id.button8)).perform(click())

        //when:  9버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        //then:  89가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("89")))

    }

    @Test
    fun `입력된_피연산자가_없을_때_사용자가_연산자_버튼을_누르면_화면에_아무런_변화가_없어야_한다`() {
        //given: 화면에 입력된 피연산자가 없을 때

        //when: +버튼을 누르면
        onView(withId(R.id.buttonPlus)).perform(click())

        //then: 화면에 아무런 변화가 없어야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun `입력된_피연산자가_있을_때_사용자가_연산자_버튼을_누르면_해당_기호가_화면에_보여야_한다`() {
        //given: 1이 화면에 입력되어 있을 때
        onView(withId(R.id.button1)).perform(click())

        //when: + 버튼을 누르면
        onView(withId(R.id.buttonPlus)).perform(click())

        //then: 화면에 1 + 가 보여아 한다.
        onView(withId(R.id.textView)).check(matches(withText("1 + ")))
    }

    @Test
    fun `입력된_수식이_없을_때_사용자가_지우기_버튼을_누르면_화면에_아무련_변화가_없어야_한다`() {
        //given: 화면에 입력된 수식이 없을 때

        //when: 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        //then: 화면에 아무런 변화가 없어야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun `입력된_수식이_있을_때_사용자가_지우기_버튼을_누르면_마지막으로_입력된_연산자_또는_피연산자가_지워져야_한다`() {
        //given: 화면에 32 + 1이 입력되어 있을 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())

        //when: 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())

        //then: 32 + 가 화면에 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("32 +")))
    }

    @Test
    fun `입력된_수식이_완전할_때_사용자가_equlas기호_버튼을_누르면_입력된_수식의_결과가_화면에_보여야_한다`() {
        //given: 화면에 1 + 2를 입력되어 있을 때
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())

        //when: = 버튼을 누르면
        onView(withId(R.id.buttonEquals)).perform(click())

        //then: 5가 화면에 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }
}


/*기능 요구 사항
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
입력된 수신이 완전하지 않을 때, 사용자가 = 버튼을 눌렀을 때 완성되지 않은 수식입니다 토스트 메세지가 화면에 보여야 한다.
3 + -> = 클릭 -> 완성되지 않은 수식입니다

 */

