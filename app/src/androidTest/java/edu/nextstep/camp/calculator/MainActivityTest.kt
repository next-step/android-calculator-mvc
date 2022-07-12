package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {

    }

    @Test
    fun `0_버튼을_누르면_화면에_0이_보여야_한다`() {
        //when: 0 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button0))
            .perform(ViewActions.click())

        //then: 화면에 0이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("0")))
    }

    @Test
    fun `1_버튼을_누르면_화면에_1이_보여야_한다`() {
        //when: 1 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button1))
            .perform(ViewActions.click())

        //then: 화면에 1이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
    }

    @Test
    fun `2_버튼을_누르면_화면에_2이_보여야_한다`() {
        //when: 2 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button2))
            .perform(ViewActions.click())

        //then: 화면에 2이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("2")))
    }

    @Test
    fun `3_버튼을_누르면_화면에_3이_보여야_한다`() {
        //when: 3 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button3))
            .perform(ViewActions.click())

        //then: 화면에 3이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("3")))
    }

    @Test
    fun `4_버튼을_누르면_화면에_4가_보여야_한다`() {
        //when: 4 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button4))
            .perform(ViewActions.click())

        //then: 화면에 4이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("4")))
    }

    @Test
    fun `5_버튼을_누르면_화면에_5가_보여야_한다`() {
        //when: 5 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button5))
            .perform(ViewActions.click())

        //then: 화면에 0이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("5")))
    }

    @Test
    fun `6_버튼을_누르면_화면에_6이_보여야_한다`() {
        //when: 6 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button6))
            .perform(ViewActions.click())

        //then: 화면에 0이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("6")))
    }

    @Test
    fun `7_버튼을_누르면_화면에_7이_보여야_한다`() {
        //when: 7 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button7))
            .perform(ViewActions.click())

        //then: 화면에 7이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("7")))
    }

    @Test
    fun `8_버튼을_누르면_화면에_8이_보여야_한다`() {
        //when: 8 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button8))
            .perform(ViewActions.click())

        //then: 화면에 8이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("8")))
    }

    @Test
    fun `9_버튼을_누르면_화면에_9가_보여야_한다`() {
        //when: 9 버튼을 누르면
        Espresso.onView(ViewMatchers.withId(R.id.button9))
            .perform(ViewActions.click())

        //then: 화면에 9이 보여야 한다
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("9")))
    }
}