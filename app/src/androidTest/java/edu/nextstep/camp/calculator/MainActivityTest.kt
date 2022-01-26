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
}