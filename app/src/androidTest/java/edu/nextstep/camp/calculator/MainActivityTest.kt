package edu.nextstep.camp.calculator

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

class MainActivityTest() {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @RunWith(Parameterized::class)
    class NumberButtonTest(@IdRes val numberButtonID: Int, private val expectedResult: String) {
        //사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
        @get:Rule
        var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

        @Test
        fun 입력된_피연산자가_없을_때_사용자가_피연산자_0_에서_9_버튼을_누르면_화면에_해당_숫자가_화면에_보여야_한다() {
            //when 숫자 버튼이 눌리면
            onView(withId(numberButtonID)).perform(click())
            //then 해당 숫자의 버튼이 보여야한다.
            onView(withId(R.id.textView)).check(matches(withText(expectedResult)))
        }

        companion object {
            @JvmStatic
            @Parameterized.Parameters(name = "{index} - button{1} 이 눌리면 {1}이 출력된다.")
            fun testData(): Collection<Array<Any>> {
                return listOf(
                    arrayOf(R.id.button0, "0"),
                    arrayOf(R.id.button1, "1"),
                    arrayOf(R.id.button2, "2"),
                    arrayOf(R.id.button3, "3"),
                    arrayOf(R.id.button4, "4"),
                    arrayOf(R.id.button5, "5"),
                    arrayOf(R.id.button6, "6"),
                    arrayOf(R.id.button7, "7"),
                    arrayOf(R.id.button8, "8"),
                    arrayOf(R.id.button9, "9")
                )
            }
        }
    }

    @Test
    fun 입력된_연산자가_있을_때_사용자가_피연산자_버튼을_누르면_화면에_해당_숫자가_화면의_마지막에_추가된다() {
        //given 숫자 9 + 이 눌려져있을때
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        //when 숫자 버튼 5가 눌리면
        onView(withId(R.id.button5)).perform(click())
        //then 9 + 5가 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("9 + 5")))
    }

    @Test
    fun 입력된_피연산자가_있을_때_사용자가_피연산자_버튼을_누르면_화면에_해당_숫자가_화면에_추가된다() {
        //given 숫자 9 8 이 눌려져있을때
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.button8)).perform(click())
        //when 숫자 버튼 5가 눌리면
        onView(withId(R.id.button5)).perform(click())
        //then 985가 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("985")))
    }

    @Test
    fun 입력된_피연산자가_없을_때_사용자가_연산자_버튼을_누르면_화면에_아무런_변화가_없어야_한다() {
        //given 피연산자가 없을 때 == 0으로 표시됨
        onView(withId(R.id.textView)).check(matches(withText("0")))
        //when 연산자 버튼이 눌리면
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        //then 변화가 없다 = 0으로 표시됨
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun 입력된_피연산자가_있을_때_사용자가_연산자_버튼을_누르면_화면에_해당_연산자가_보여야_한다() {
        //given 피연산자가 있을때 5
        onView(withId(R.id.button5)).perform(click())
        //when 연산자 버튼이 눌리면 +
        onView(withId(R.id.buttonPlus)).perform(click())
        //then 연산자가 보인다. 5 +
        onView(withId(R.id.textView)).check(matches(withText("5 +")))
    }

    @Test
    fun 입력된_연산자가_있을_때_사용자가_연산자_버튼을_누르면_화면에_마지막_연산자가_새로_눌려진_연산자로_보여야_한다() {
        //given 연산자가 있을때 5 +
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        //when 연산자 버튼이 눌리면 -
        onView(withId(R.id.buttonMinus)).perform(click())
        //then 연산자가 보인다. 5 -
        onView(withId(R.id.textView)).check(matches(withText("5 -")))
    }

    @Test
    fun 입력된_수식이_없을_때_지우기_버튼을_누르면_화면에_아무런_변화가_없어야_한다() {
        //given 피연산자가 없을 때 == 0으로 표시됨
        onView(withId(R.id.textView)).check(matches(withText("0")))
        //when 지우기 버튼이 눌리면
        onView(withId(R.id.buttonDelete)).perform(click())
        //then 변화가 없다
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun 입력된_수식이_있을_때_사용자가_지우기_버튼을_누르면_마지막으로_입력된_연산자_또는_피연산자가_지워진다() {
        //given 수식이 있을 때 5 + 32 - 2
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        //when 지우기 버튼이 눌리면
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("5 + 32 -")))
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("5 + 32")))
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("5 + 3")))
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("5 +")))
        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("5")))
        onView(withId(R.id.buttonDelete)).perform(click())
        //then  마지막부터 지워진다.
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun 입력된_수식이_완전할_때_사용자가_equals_를_누르면_수식의_결과가_화면에_보인다() {
        //given 숫자 9 + 5의 수식이 있을때
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button5)).perform(click())
        //when equals가 눌리면
        onView(withId(R.id.buttonEquals)).perform(click())
        //then 14.0이 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("14.0")))
    }


}