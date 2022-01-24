package edu.nextstep.camp.calculator

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

object AndroidTestHelper {

    fun onViewsClick(@IdRes vararg ids: Int) {
        ids.forEach {
            onView(withId(it)).perform(click())
        }
    }

    fun onViewMatchText(@IdRes id: Int, text: String) {
        onView(withId(id)).check(matches(withText(text)))
    }
}