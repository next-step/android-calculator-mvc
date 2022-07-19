package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 버튼_0을_누르면_화면에_0이_보여야_한다(){
        // when : 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())
        // then : 화면에 0이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("0")));
    }

    @Test
    fun 버튼_1을_누르면_화면에_1이_보여야_한다(){
        // when : 0 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())
        // then : 화면에 0이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("1")));
    }

    @Test
    fun 버튼_2을_누르면_화면에_2이_보여야_한다(){
        // when : 0 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())
        // then : 화면에 0이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("2")));
    }

    @Test
    fun 버튼_3을_누르면_화면에_3이_보여야_한다(){
        // when : 0 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())
        // then : 화면에 0이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("3")));
    }

    @Test
    fun 버튼_4을_누르면_화면에_4이_보여야_한다(){
        // when : 0 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())
        // then : 화면에 0이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("4")));
    }

    @Test
    fun 버튼_5을_누르면_화면에_5이_보여야_한다(){
        // when : 0 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())
        // then : 화면에 0이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("5")));
    }

    @Test
    fun 버튼_6을_누르면_화면에_6이_보여야_한다(){
        // when : 0 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())
        // then : 화면에 0이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("6")));
    }

    @Test
    fun 버튼_7을_누르면_화면에_7이_보여야_한다(){
        // when : 0 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())
        // then : 화면에 0이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("7")));
    }

    @Test
    fun 버튼_8을_누르면_화면에_8이_보여야_한다(){
        // when : 0 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())
        // then : 화면에 0이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("8")));
    }

    @Test
    fun 버튼_9을_누르면_화면에_9이_보여야_한다(){
        // when : 0 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())
        // then : 화면에 0이 보여야 한다.
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("9")));
    }
}