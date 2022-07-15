package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class MainActivityTest(
    buttonDescription: String,
    private val buttonId: Int,
    private val expectedText: String
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    companion object {
        @JvmStatic
        @Parameters(name = "버튼 : {0}, 동작 예상 텍스트 : {2}")
        fun getTestParameters() = listOf(
            arrayOf("버튼0", R.id.button0, "0"),
            arrayOf("버튼1", R.id.button1, "1"),
            arrayOf("버튼2", R.id.button2, "2"),
            arrayOf("버튼3", R.id.button3, "3"),
            arrayOf("버튼4", R.id.button4, "4"),
            arrayOf("버튼5", R.id.button5, "5"),
            arrayOf("버튼6", R.id.button6, "6"),
            arrayOf("버튼7", R.id.button7, "7"),
            arrayOf("버튼8", R.id.button8, "8"),
            arrayOf("버튼9", R.id.button9, "9")
        )
    }

    @Test
    fun `버튼_동작`() {
        //when: 버튼을 누르면
        onView(withId(buttonId)).perform(ViewActions.click())
        //then: 화면에 버튼의 텍스트가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText(expectedText)))
    }
}