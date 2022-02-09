package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MainActivityOperandButtonTest(
    private val operandButtonText: String
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 입력된_수식이_없고_피연산자_버튼이_눌렸을_때_결과_창에_피연산자가_입력된다() {
        // given : 입력된 수식이 없고
        // when : 피연산자 버튼을 눌렀을 때
        onView(withText(operandButtonText)).perform(click())
        // then : 결과 창에 피연산자가 입력된다.
        onView(withId(R.id.textView)).check(matches(withText(operandButtonText)))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "피연산자가 {0}일 때")
        fun operandButtonText() = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
    }
}

@RunWith(Parameterized::class)
class MainActivityOperatorButtonTest(
    private val operatorButtonText: String
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 입력된_수식이_없고_연산자_버튼을_눌렀을_때_결과창에_아무런_변화가_없다() {
        // given : 입력된 수식이 없고
        // when : 연산자 버튼을 눌렀을 때
        onView(withText(operatorButtonText)).perform(click())
        // then : 결과 창에 아무런 변화가 없다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun 피연산자가_있는_수식이_있고_연산자_버튼을_눌렀을_때_결과창에_연산자가_추가된다() {
        // given : 피연산자가 있는 수식이 있고
        onView(withId(R.id.button1)).perform(click())
        // when : 연산자 버튼을 눌렀을 때
        onView(withText(operatorButtonText)).perform(click())
        // then : 결과 창에 연산자가 추가된다.
        onView(withId(R.id.textView)).check(matches(withText("1 $operatorButtonText")))
    }

    @Test
    fun 피연산자와_연산자가있는_수식이_있고_연산자_버튼을_눌렀을_때_결과_창에_연산자가_누른_연산자로_변경된다() {
        // given : 피연산자와 연산자가 있는 수식이 있고
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        // when : 연산자 버튼을 눌렀을 때
        onView(withText(operatorButtonText)).perform(click())
        // then : 결과 창에 연산자가 누른 연산자로 변경된다.
        onView(withId(R.id.textView)).check(matches(withText("1 $operatorButtonText")))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "연산자가 {0} 일 때")
        fun operandButtonText() = listOf("+","-","×","÷")
    }
}

class MainActivityTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 피연산자와_연산자가_있는_수식이_있고_피연산자_버튼을_눌렀을_때_결과_창에_피연산자가_추가된다(){
        // given : 피연산자와 연산자가 있는 수식이 있고
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        // when : 피연산자 버튼을 눌렀을 때
        onView(withId(R.id.button1)).perform(click())
        // then : 결과 창에 피연산자가 추가된다
        onView(withId(R.id.textView)).check(matches(withText("5 + 1")))
    }

    @Test
    fun 수식_8에서_9_를_누르면_결과창에_89가_보인다() {
        // given : 8이라는 피연산자가 있는 수식이 있고
        onView(withText("8")).perform(click())
        // when : 9라는 피연산자를 누르면
        onView(withText("9")).perform(click())
        // then : 결과창에 89가 보인다
        onView(withId(R.id.textView)).check(matches(withText("89")))
    }

    @Test
    fun 빈_수식에서_지우기_버튼을_누르면_결과창에는_변화가_없다() {
        // given : 빈 수식이 있고
        // when : 지우기 버튼을 눌렀을 때
        onView(withId(R.id.buttonDelete)).perform(click())
        // then : 결과 창에는 변화가 없다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun 수식_32_더하기_1에서_지우기_버튼을_누르면_맨_뒤_글자만_지워진다() {
        // given : 32 + 1이라는 수식이 주어지고
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        // when : 지우기 버튼이 눌렀을 때
        onView(withId(R.id.buttonDelete)).perform(click())
        // then : 결과 창에 맨 뒤 글자만 지워진다
        onView(withId(R.id.textView)).check(matches(withText("32 +")))
    }

    @Test
    fun 수식_32_더하기_에서_지우기_버튼을_누르면_맨_뒤_글자만_지워진다() {
        // given : 32 + 라는 수식이 있고
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        // when : 지우기 버튼을 눌렀을 때
        onView(withId(R.id.buttonDelete)).perform(click())
        // then : 결과 창에 맨 뒤 글자만 지워진다
        onView(withId(R.id.textView)).check(matches(withText("32")))
    }

    @Test
    fun 완성된_수식에서_결과를_내면_결과창에_수식의_결과가_보여진다() {
        // given : 3 + 2 라는 완성된 수식이 있을 때
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        // when : Equals 버튼을 누르면
        onView(withId(R.id.buttonEquals)).perform(click())
        // then : 결과창에 입력된 수식의 결과가 보여진다
        onView(withId(R.id.textView)).check(matches(withText("5.0")))
    }
}