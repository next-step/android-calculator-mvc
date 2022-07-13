package edu.nextstep.camp.calculator

import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivity : AppCompatActivity() {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    // 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @Test
    fun 버튼_0_을_누르면_화면에_0이_보여야_한다() {
        // when 0 을 누르면
        onView(withId(R.id.button0)).perform(click())

        // then: 화면에 0 이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun 버튼_1_을_누르면_화면에_1이_보여야_한다() {
        // when 1 을 누르면
        onView(withId(R.id.button1)).perform(click())

        // then: 화면에 1 이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun 버튼_2_를_누르면_화면에_2이_보여야_한다() {
        // when 2 를 누르면
        onView(withId(R.id.button2)).perform(click())

        // then: 화면에 2 가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun 버튼_3_을_누르면_화면에_3이_보여야_한다() {
        // when 3 을 누르면
        onView(withId(R.id.button3)).perform(click())

        // then: 화면에 3 이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun 버튼_4_를_누르면_화면에_4이_보여야_한다() {
        // when 4 를 누르면
        onView(withId(R.id.button4)).perform(click())

        // then: 화면에 4 가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun 버튼_5_를_누르면_화면에_5이_보여야_한다() {
        // when 5 를 누르면
        onView(withId(R.id.button5)).perform(click())

        // then: 화면에 5 가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun 버튼_6_을_누르면_화면에_6이_보여야_한다() {
        // when 6 을 누르면
        onView(withId(R.id.button6)).perform(click())

        // then: 화면에 6 이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun 버튼_7_을_누르면_화면에_7이_보여야_한다() {
        // when 7 을 누르면
        onView(withId(R.id.button7)).perform(click())

        // then: 화면에 7 이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun 버튼_8_을_누르면_화면에_8이_보여야_한다() {
        // when 8 을 누르면
        onView(withId(R.id.button8)).perform(click())

        // then: 화면에 8 이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun 버튼_9_를_누르면_화면에_9이_보여야_한다() {
        // when 9 를 누르면
        onView(withId(R.id.button9)).perform(click())

        // then: 화면에 9 가 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

}
