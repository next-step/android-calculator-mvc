package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.withId

object AndroidUITestHelper {

    fun onClickViewWithResId(resId: Int) {
        onView(withId(resId)).perform(click())
    }

    fun onClickViewsWithResIds(vararg resId: Int) {
        resId.forEach {
            onView(withId(it)).perform(click())
        }
    }

    fun onMatchTextWithResId(resId: Int, text: String) {
        onView(withId(resId)).check(matches(withText(text)))
    }
}