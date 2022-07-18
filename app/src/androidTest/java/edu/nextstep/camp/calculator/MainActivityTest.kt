package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 07. 14..
 */
class MainActivityTest{
    //사용자가 피연사자 0-9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 버튼_0을_누르면_화면에_0이_보여야_한다() {
        //when: 0 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(click())
        //then: 화면에 0이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("0")))

    }

    @Test
    fun 버튼_1을_누르면_화면에_1이_보여야_한다() {
        //when: 1 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(click())
        //then: 화면에 1이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("1")))

    }

    @Test
    fun 버튼_2을_누르면_화면에_2이_보여야_한다() {
        //when: 2 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(click())
        //then: 화면에 2이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("2")))

    }
    @Test
    fun 버튼_3을_누르면_화면에_3이_보여야_한다() {
        //when: 3 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button3)).perform(click())
        //then: 화면에 3이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("3")))

    } @Test
    fun 버튼_4을_누르면_화면에_4이_보여야_한다() {
        //when: 4 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(click())
        //then: 화면에 4이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("4")))

    }
    @Test
    fun 버튼_5을_누르면_화면에_5이_보여야_한다() {
        //when: 5 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(click())
        //then: 화면에 5이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("5")))

    }
    @Test
    fun 버튼_6을_누르면_화면에_6이_보여야_한다() {
        //when: 6 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button6)).perform(click())
        //then: 화면에 6이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("6")))

    }
    @Test
    fun 버튼_7을_누르면_화면에_7이_보여야_한다() {
        //when: 7 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button7)).perform(click())
        //then: 화면에 7이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("7")))

    }
    @Test
    fun 버튼_8을_누르면_화면에_8이_보여야_한다() {
        //when: 8 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button8)).perform(click())
        //then: 화면에 8이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("8")))

    }
    @Test
    fun 버튼_9을_누르면_화면에_9이_보여야_한다() {
        //when: 9 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button9)).perform(click())
        //then: 화면에 9이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("9")))

    }

    @Test
    fun 입력된_피연산자가_없을_때_숫자버튼을_클릭하면_해당_숫자가_화면에_보여야_한다() {
        //given 피연산자가 없을때
        //when: 숫자를 클릭하면
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(click())
        //then: 화면에 숫자가 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("1")))
    }
    @Test
    fun 연산자입력후에_숫자버튼을_클릭하면_해당_숫자가_화면에_보여야_한다() {
        //given 연산자가 있을때
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.buttonPlus)).perform(click())
        //when: 숫자를 클릭하면
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(click())
        //then: 화면에 숫자가 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("1 + 1")))
    }

    @Test
    fun 입력된_피연산자가_있을_때_숫자버튼을_클릭하면_해당_숫자가_화면에_보여야_한다() {
        //given 피연산자가 있을때
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(click())
        //when: 숫자를 클릭하면
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(click())
        //then: 기존 숫자 뒤에 숫자가 보여야한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("12")))
    }

    @Test
    fun 입력된_피연산자가_없을_때_연산자버튼을_클릭하면_아무런_변화가_없어야_한다() {
        //given 피연산자가 없을때
        //when: 연산자버튼을 클릭하면
        Espresso.onView(ViewMatchers.withId(R.id.buttonMinus)).perform(click())
        //then: 아무런 변화가 없어야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    @Test
    fun 입력된_피연산자가_있을_때_연산자버튼을_클릭하면_해당_기호가_화면에_보여야_한다() {
        //given 피연산자가 있을때
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(click())
        //when: 연산자버튼을 클릭하면
        Espresso.onView(ViewMatchers.withId(R.id.buttonPlus)).perform(click())
        //then: 해당 기호가 화면에 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("1 +")))
    }

    @Test
    fun 입력된_수식이_없을_때_지우기_버튼을_누르면_아무런_변화가_없어야_한다() {
        //given 수식이 없을때
        //when: 지우기버튼을 클릭하면
        Espresso.onView(ViewMatchers.withId(R.id.buttonDelete)).perform(click())
        //then: 아무런 변화가 없어야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    @Test
    fun 마지막이_연산자일때_지우기_버튼을_누르면_마지막_연산자가_지워져야_한다() {
        //given 마지막이 연산자일때
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.buttonPlus)).perform(click())
        //when: 지우기버튼을 클릭하면
        Espresso.onView(ViewMatchers.withId(R.id.buttonDelete)).perform(click())
        //then: 연산자가 지워져야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("2")))
    }

    @Test
    fun 마지막이_피연산자일때_지우기_버튼을_누르면_마지막_피연산자가_지워져야_한다() {
        //given 마지막이 피연산자일때
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.button3)).perform(click())
        //when: 지우기버튼을 클릭하면
        Espresso.onView(ViewMatchers.withId(R.id.buttonDelete)).perform(click())
        //then: 피연산자가 지워져야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("2")))
    }

    @Test
    fun 입력된_수식이_완전할_때_등호버튼을_누르면_결과값이_나온다() {
        //given 입력된 수식이 완전할때
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.buttonPlus)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(click())
        //when: 등호버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.buttonEquals)).perform(click())
        //then: 결과값이 나온다
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("${4f}")))
    }

}