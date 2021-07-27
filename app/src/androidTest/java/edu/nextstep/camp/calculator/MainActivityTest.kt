package edu.nextstep.camp.calculator

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import edu.nextstep.camp.calculator.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MainActivityTest(
        private val buttonId: Int,
        private val number: String
) {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `버튼을_누르면_해당_버튼의_숫자가_TextView에_표시된다`() {
        //when
        onView(withId(buttonId)).perform(click())

        //then
        onView(withId(R.id.textviewOutput)).check(matches(withText(number)))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun provideButtonResourceAndNumbers() =
                listOf(
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