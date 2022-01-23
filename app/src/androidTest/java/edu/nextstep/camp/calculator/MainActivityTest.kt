package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * GIVEN 입력된 수식이 없을 때
     * WHEN 사용자가 피연산자 N을 누르면 (N: 0~9)
     * THEN 해당 숫자가 화면에 보여야 한다.
     * */
    // N = 0
    @Test
    fun when_click_zero_show_zero() {
        onView(withId(R.id.button0)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    // N = 1
    @Test
    fun when_click_one_show_one() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    // N = 2
    @Test
    fun when_click_two_show_two() {
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    // N = 3
    @Test
    fun when_click_three_show_three() {
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    // N = 4
    @Test
    fun when_click_four_show_four() {
        onView(withId(R.id.button4)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    // N = 5
    @Test
    fun when_click_five_show_five() {
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }
    // N = 6
    @Test
    fun when_click_six_show_six() {
        onView(withId(R.id.button6)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    // N = 7
    @Test
    fun when_click_seven_show_seven() {
        onView(withId(R.id.button7)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    // N = 8
    @Test
    fun when_click_eight_show_eight() {
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    // N = 9
    @Test
    fun when_click_nine_show_nine() {
        onView(withId(R.id.button9)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }
}
