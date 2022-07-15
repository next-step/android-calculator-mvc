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

@RunWith(Parameterized::class)
class MainActivityTest(@IdRes val numberButtonID: Int, private val expectedResult: String) {

    //사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 숫자버튼을_누르면_화면에_버튼의_숫자가_보여야_한다() {
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