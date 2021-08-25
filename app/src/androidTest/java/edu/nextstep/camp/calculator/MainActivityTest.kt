package edu.nextstep.camp.calculator

import android.os.IBinder
import android.view.WindowManager
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Root
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test


class MainActivityTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `입력된_숫자뒤에_숫자를_더_입력하면_연달아서_숫자가_보여야한다`() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button9)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("19")))
    }

    @Test
    fun `입력된_값이_없는_상태에서_연산자를_누르면_화면에_아무런_변화가_없어야_한다`() {
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("")))
    }

    @Test
    fun `숫자가_입력된_상태에서_연산자를_누르면_해당기호가_나타나야한다`() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("1 + ")))
    }

    @Test
    fun `입력된_값이_없을_때_지우기_버튼을_누르면_화면에_아무런_변화가_없어야한다`() {
        onView(withId(R.id.buttonDelete)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("")))
    }

    @Test
    fun `입력된_수식에_끝자리가_숫자이면_숫자_하나만_지워야한다`() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("1")))
    }

    @Test
    fun `입력된_수식에_끝자리가_연산자가_있으면_연산자와_마지막_숫자의_값이_지워져야한다`() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonDelete)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("1")))
    }

    @Test
    fun `연산자가_입력된_상황에서_연산결과를_얻으려고_하면_토스트_메세지가_보여야한다`() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())

        onView(withText("수식이 올바르지 않습니다.")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    @Test
    fun `수식이_입력된_상황에서_결과값을_얻으면_값이_출력된다`() {
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())

        onView(withId(R.id.textFormula)).check(matches(withText("2")))
    }
}

class ToastMatcher : TypeSafeMatcher<Root>() {
    override fun describeTo(description: Description) {
        description.appendText("is toast")
    }

    override fun matchesSafely(item: Root): Boolean {
        val type: Int = item.windowLayoutParams.get().type
        if (type == WindowManager.LayoutParams.TYPE_TOAST) {
            val windowToken: IBinder = item.decorView.windowToken
            val appToken: IBinder = item.decorView.applicationWindowToken
            if (windowToken === appToken) {
                //means this window isn't contained by any other windows.
                return true
            }
        }
        return false
    }
}