package edu.nextstep.camp.calculator

import android.os.IBinder
import android.view.WindowManager
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Root
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun whenButton0Click_thenDisplay0() {
        // when: 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())

        //then: 화면에 해당 0 숫자가 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("0")))
    }


    @Test
    fun whenButton1Click_thenDisplay1() {
        // when: 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        //then: 화면에 해당 1 숫자가 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("1")))
    }


    @Test
    fun whenButton2Click_thenDisplay2() {
        // when: 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())

        //then: 화면에 해당 2 숫자가 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("2")))
    }


    @Test
    fun whenButton3Click_thenDisplay3() {
        // when: 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())

        //then: 화면에 해당 3 숫자가 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("3")))
    }


    @Test
    fun whenButton4Click_thenDisplay4() {
        // when: 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())

        //then: 화면에 해당 4 숫자가 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("4")))
    }


    @Test
    fun whenButton5Click_thenDisplay5() {
        // when: 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())

        //then: 화면에 해당 5 숫자가 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("5")))
    }


    @Test
    fun whenButton6Click_thenDisplay6() {
        // when: 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())

        //then: 화면에 해당 6 숫자가 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("6")))
    }


    @Test
    fun whenButton7Click_thenDisplay7() {
        // when: 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())

        //then: 화면에 해당 7 숫자가 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("7")))
    }


    @Test
    fun whenButton8Click_thenDisplay8() {
        // when: 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())

        //then: 화면에 해당 8 숫자가 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("8")))
    }


    @Test
    fun whenButton9Click_thenDisplay9() {
        // when: 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())

        //then: 화면에 해당 9 숫자가 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("9")))
    }


    @Test
    fun 입력된_상태가_5_더하기_일때_1버튼를_누르면_5_더하기_1_표시된다() {
        // given: 5+ 가 입려된 상태에서
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        // when: 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        //then: 화면에 해당 5 + 1이 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("5 + 1")))
    }

    @Test
    fun 입력된_상태가_5_곱하기_일때_1버튼를_누르면_5_곱하기_1_표시된다() {
        // given: 5* 가 입려된 상태에서
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())

        // when: 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        //then: 화면에 해당 5 * 1이 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("5 * 1")))
    }

    @Test
    fun 입력된_상태가_5_빼기_일때_1버튼를_누르면_5_빼기_1_표시된다() {
        // given: 5- 가 입려된 상태에서
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())

        // when: 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        //then: 화면에 해당 5 - 1이 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("5 - 1")))
    }

    @Test
    fun 입력된_상태가_5_나누기_일때_1버튼를_누르면_5_나누기_1_표시된다() {
        // given: 5/ 가 입려된 상태에서
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())

        // when: 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        //then: 화면에 해당 5 / 1이 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("5 / 1")))
    }

    @Test
    fun 입력된_상태가_8_일때_1버튼를_누르면_81_표시된다() {
        // given: 8이 입려된 상태에서
        onView(withId(R.id.button8)).perform(click())

        // when: 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())

        //then: 화면에 해당 81이 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("81")))
    }

    @Test
    fun 초기상태에서_8_1_5_7_버튼를_누르면_8157_이_표시된다() {
        // when: 8,1,5,7 버튼을 순서대로 누르면
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.button7)).perform(click())

        //then: 화면에 해당 8157이 화면에 보여야 한다.
        onView(withId(R.id.textViewDisplay)).check(matches(withText("8157")))
    }

    @Test
    fun 초기상태에서_더하기_버튼을_누르면_변화가_없다() {
        // when:
        onView(withId(R.id.buttonPlus)).perform(click())
        //then:
        onView(withId(R.id.textViewDisplay)).check(matches(withText("")))
    }

    @Test
    fun 초기상태에서_마이너스_버튼을_누르면_변화가_없다() {
        // when:
        onView(withId(R.id.buttonMinus)).perform(click())
        //then:
        onView(withId(R.id.textViewDisplay)).check(matches(withText("")))
    }

    @Test
    fun 초기상태에서_곱하기_버튼을_누르면_변화가_없다() {
        // when:
        onView(withId(R.id.buttonMultiply)).perform(click())
        //then:
        onView(withId(R.id.textViewDisplay)).check(matches(withText("")))
    }

    @Test
    fun 초기상태에서_나누기_버튼을_누르면_변화가_없다() {
        // when:
        onView(withId(R.id.buttonDivide)).perform(click())
        //then:
        onView(withId(R.id.textViewDisplay)).check(matches(withText("")))
    }

    @Test
    fun 입력된_상태가_0일때_0를_누르면_변화가_없다() {
        onView(withId(R.id.button0)).perform(click())

        // when:
        onView(withId(R.id.button0)).perform(click())
        onView(withId(R.id.button0)).perform(click())

        //then:
        onView(withId(R.id.textViewDisplay)).check(matches(withText("0")))
    }

    @Test
    fun 입력된_상태가_100일때_0를_누르면_1000이_입력된다() {
        // given
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button0)).perform(click())
        onView(withId(R.id.button0)).perform(click())

        // when:
        onView(withId(R.id.button0)).perform(click())

        //then:
        onView(withId(R.id.textViewDisplay)).check(matches(withText("1000")))
    }

    @Test
    fun 입력된_상태가_1_일때_더하기를_누르면_1_더하기가_입력된다() {
        // given
        onView(withId(R.id.button1)).perform(click())

        // when:
        onView(withId(R.id.buttonPlus)).perform(click())

        // Then
        onView(withId(R.id.textViewDisplay)).check(matches(withText("1 +")))
    }

    @Test
    fun 입력된_상태가_1_더하기_일_때_마이너스_버튼을_누르면_1_마이너스가_입력된다() {
        // given
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        // when:
        onView(withId(R.id.buttonMinus)).perform(click())

        // Then
        onView(withId(R.id.textViewDisplay)).check(matches(withText("1 -")))
    }


    @Test
    fun 입력된_상태가_초기값일때_지우기_버튼을_눌러도_화면에_아무런_변화가_없다() {
        // when:
        onView(withId(R.id.buttonDelete)).perform(click())

        // Then
        onView(withId(R.id.textViewDisplay)).check(matches(withText("")))
    }

    @Test
    fun 입력된_수식이_있을_때_사용자가_지우기_버튼을_누르면_마지막_으로_입력된_연산자_또는_피연산자가_지워진다_32_더하기_1() {
        // given:
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())

        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textViewDisplay)).check(matches(withText("32 +")))

        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textViewDisplay)).check(matches(withText("32")))

        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textViewDisplay)).check(matches(withText("3")))

        onView(withId(R.id.buttonDelete)).perform(click())
        onView(withId(R.id.textViewDisplay)).check(matches(withText("")))
    }

    @Test
    fun 입력된_계산가능한_수식이_있을때_사용자가_Equal_버튼을_누르면_계산된_결과가_나온다_32_더하기_1_곱하기_2_기대값_66() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.button2)).perform(click())

        onView(withId(R.id.buttonEquals)).perform(click())

        onView(withId(R.id.textViewDisplay)).check(matches(withText("66")))
    }

    @Test
    fun 입력된_계산가능한_수식이_있을때_사용자가_Equal_버튼을_누르면_계산된_결과가_나온다_32_더하기_1_곱하기_2_equal클릭_나누기_4_기대값_16() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.button4)).perform(click())

        onView(withId(R.id.buttonEquals)).perform(click())

        onView(withId(R.id.textViewDisplay)).check(matches(withText("16")))
    }

    @Test
    fun 입력된_계산가능한_수식이_있을때_사용자가_Equal_버튼을_누른_후_다시_수식을_입력하면_Equal_누를때_결과에_수식이_입력된다_32_더하기_1_곱하기_2_equal클릭_나누기_4_기대값_66_나누기_4() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.button4)).perform(click())

        onView(withId(R.id.textViewDisplay)).check(matches(withText("66 / 4")))
    }

    @Test
    fun 입력된_수식이_완전하지_않을때_사용자가_Equal_버튼을_누르면_토스트가_노출된다() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        onView(withId(R.id.buttonEquals)).perform(click())
        onView(withText(R.string.err_invalid_formula))
            .inRoot(ToastMatcher("완성되지 않은 수식입니다"))
            .check(matches(isDisplayed()))
    }

    inner class ToastMatcher(private val message: String): TypeSafeMatcher<Root>() {

        override fun describeTo(description: Description) {
            description.appendText(message)
        }

        override fun matchesSafely(root: Root): Boolean {
            val type: Int = root.windowLayoutParams.get().type
            if (type == WindowManager.LayoutParams.TYPE_TOAST) {
                val windowToken: IBinder = root.decorView.windowToken
                val appToken: IBinder = root.decorView.applicationWindowToken
                if (windowToken === appToken) {
                    // means this window isn't contained by any other windows.
                    return true
                }
            }
            return false
        }

    }
}