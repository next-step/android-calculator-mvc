package edu.nextstep.camp.calculator

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MainActivityTest(
    @IdRes private val viewId: Int,
    private val result: String
) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 피연산자_버튼을_클릭시_버튼_값이_보여야한다() {
        // when 숫자 버튼 입력
        onView(withId(viewId)).perform(click())

        // then 숫자 출력
        onView(withId(R.id.textView)).check(matches(withText(result)))
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun parameterizedTestData() = listOf(
            arrayOf(R.id.button0, "0"),
            arrayOf(R.id.button1, "1"),
            arrayOf(R.id.button2, "2"),
            arrayOf(R.id.button3, "3"),
            arrayOf(R.id.button4, "4"),
            arrayOf(R.id.button5, "5"),
            arrayOf(R.id.button6, "6"),
            arrayOf(R.id.button7, "7"),
            arrayOf(R.id.button8, "8"),
            arrayOf(R.id.button9, "9"),
        )

    }

}
