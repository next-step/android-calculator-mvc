package edu.nextstep.camp.calculator

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import edu.nextstep.camp.calculator.ui.MainActivity
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `입력된_피연산자가_없을때_피연산자를_클릭하면_해당숫자가_화면에보인다`() {
        //given
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        //when
        onView(withId(R.id.button1)).perform(click())

        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText("5+1")))
    }

    @Test
    fun `입력된_피연산자가_있을때_피연산자를_클릭하면_해당숫자가_화면에보인다`() {
        //given
        onView(withId(R.id.button5)).perform(click())

        //when
        onView(withId(R.id.button1)).perform(click())

        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText("51")))
    }

    @Test
    fun `입력된_피연산자가_없을때_연산자를_클릭하면_아무런_변화가_없다`() {
        //when
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())

        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText("")))
    }

    @Test
    fun `입력된_피연산자가_있을때_연산자를_클릭하면_화면에_연산자가_표시된다`() {
        //given
        onView(withId(R.id.button1)).perform(click())

        //when
        onView(withId(R.id.buttonMinus)).perform(click())

        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText("1-")))
    }

    @Test
    fun `입력된_수식이_없을떄_지우기버튼을_누르면_아무런_변화가_없다`() {
        //when
        onView(withId(R.id.buttonDelete)).perform(click())

        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText("")))
    }

    @Test
    fun `입력된_수식이_있을때_지우기버튼을_누르면_삭제된다`() {
        //given
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        지우기버튼을_누르면_마지막_피연산자_혹은_연산자가_삭제된다(expected = "32")
        지우기버튼을_누르면_마지막_피연산자_혹은_연산자가_삭제된다(expected = "3")
        지우기버튼을_누르면_마지막_피연산자_혹은_연산자가_삭제된다(expected = "")
        입력된_수식이_없을떄_지우기버튼을_누르면_아무런_변화가_없다()
    }

    fun `지우기버튼을_누르면_마지막_피연산자_혹은_연산자가_삭제된다`(expected: String) {
        //when
        onView(withId(R.id.buttonDelete)).perform(click())

        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText(expected)))
    }

    @Test
    fun `수식의_마지막이_연산자일때_지우기버튼을_누르면_연산자가_삭제된다`() {
        //given
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        //when
        onView(withId(R.id.buttonDelete)).perform(click())

        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText("32")))
    }

    @Test
    fun `수식의_마지막이_숫자일때_지우기버튼을_누르면_숫자가_삭제된다`() {
        //given
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())

        //when
        onView(withId(R.id.buttonDelete)).perform(click())

        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText("3")))
    }

    @Test
    fun `수식을_다_지웠을때는_공백을_출력한다`() {
        //given
        onView(withId(R.id.button3)).perform(click())

        //when
        onView(withId(R.id.buttonDelete)).perform(click())

        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText("")))
    }

    @Test
    fun `입력된_수식이_완전할때_계산하기버튼을_누르면_수식의_결과가_표시된다`() {
        //given
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())

        //when
        onView(withId(R.id.buttonEquals)).perform(click())


        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText("5")))
    }

    @Test
    fun `입력된_수식이_완전하지_않을때_계산하기버튼을_누르면_마지막_피연산자만을_제거한뒤_계산한다`() {
        //given
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button7)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())

        //when
        onView(withId(R.id.buttonEquals)).perform(click())

        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText("10")))
    }
}