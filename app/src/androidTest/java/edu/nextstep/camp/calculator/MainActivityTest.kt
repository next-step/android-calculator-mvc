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
    // 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.

    @get:Rule var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 입력된_내용이_없을_때_0을_누르면_화면에_0이_표시된다() {
        // when
        onView(withId(R.id.button0)).perform(click())

        // then
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }
}
