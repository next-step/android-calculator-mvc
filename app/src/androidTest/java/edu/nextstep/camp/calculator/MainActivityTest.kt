package edu.nextstep.camp.calculator

import android.os.IBinder
import android.view.WindowManager
import androidx.annotation.IdRes
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
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


class MainActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `연속적으로_숫자버튼을_클릭하면_숫자길이가_늘어난다`() {
        //when
        숫자_버튼을_누른다("3")
        결과화면에서_문자를_확인한다("3")

        숫자_버튼을_누른다("4")
        결과화면에서_문자를_확인한다("34")

        숫자_버튼을_누른다("5")
        결과화면에서_문자를_확인한다("345")

        숫자_버튼을_누른다("6")
        결과화면에서_문자를_확인한다("3456")
    }

    @Test
    fun `연속적으로_연산자버튼을_클릭하면_마지막_연산자만_표시된다`() {
        //given : 34
        숫자_버튼을_누른다("3")
        숫자_버튼을_누른다("4")
        //when
        연산자_버튼을_누른다("+")
        결과화면에서_문자를_확인한다("34+")

        연산자_버튼을_누른다("×")
        결과화면에서_문자를_확인한다("34×")

        연산자_버튼을_누른다("÷")
        결과화면에서_문자를_확인한다("34÷")

        연산자_버튼을_누른다("-")
        결과화면에서_문자를_확인한다("34-")
    }

    @Test
    fun `연속적으로_삭제버튼을_클릭하면_차례대로_마지막글자가_지워진다`() {
        //given : 32+1
        숫자_버튼을_누른다("3")
        숫자_버튼을_누른다("2")
        연산자_버튼을_누른다("+")
        숫자_버튼을_누른다("1")
        //when
        삭제_버튼을_누른다()
        결과화면에서_문자를_확인한다("32+")

        삭제_버튼을_누른다()
        결과화면에서_문자를_확인한다("32")

        삭제_버튼을_누른다()
        결과화면에서_문자를_확인한다("3")

        삭제_버튼을_누른다()
        결과화면에서_문자를_확인한다("")
    }

    @Test
    fun `완성된_표현식일_경우_결과버튼을_클릭하면_정상적인_연산결과가_표시된다`() {
        //given : 3+2×6÷2-1
        숫자_버튼을_누른다("3")
        연산자_버튼을_누른다("+")
        숫자_버튼을_누른다("2")
        연산자_버튼을_누른다("×")
        숫자_버튼을_누른다("6")
        연산자_버튼을_누른다("÷")
        숫자_버튼을_누른다("2")
        연산자_버튼을_누른다("-")
        숫자_버튼을_누른다("1")

        //when : =
        결과_버튼을_누른다()

        //then : 14
        결과화면에서_문자를_확인한다("14.0")
    }

    @Test
    fun `완성되지_않은_표현식일_경우_결과버튼을_클릭하면_메시지가_표시된다`() {
        //given : 3+2×
        숫자_버튼을_누른다("3")
        연산자_버튼을_누른다("+")
        숫자_버튼을_누른다("2")
        연산자_버튼을_누른다("×")

        //when : =
        결과_버튼을_누른다()

        //then : 14
        onView(withText("완성되지 않은 수식입니다.")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    private fun `숫자_버튼을_누른다`(text: String) {
        numberButtonIdMap[text]?.let { buttonId ->
            onView(withId(buttonId)).perform(click())
        }
    }

    private fun `삭제_버튼을_누른다`() {
        onView(withId(R.id.buttonDelete)).perform(click())
    }

    private fun `연산자_버튼을_누른다`(operatorCode: String) {
        operatorButtonIdMap[operatorCode]?.let { buttonId ->
            onView(withId(buttonId)).perform(click())
        }
    }

    private fun `결과_버튼을_누른다`() {
        onView(withId(R.id.buttonEquals)).perform(click())
    }

    private fun `결과화면에서_문자를_확인한다`(output: String) {
        onView(withId(R.id.outputTextView)).check(matches(withText(output)))
    }

    companion object {

        val numberButtonIdMap = mapOf(
            "0" to R.id.button0, "1" to R.id.button1, "2" to R.id.button2, "3" to R.id.button3,
            "4" to R.id.button4, "5" to R.id.button5, "6" to R.id.button6, "7" to R.id.button7,
            "8" to R.id.button8, "9" to R.id.button9,
        )
        val operatorButtonIdMap = mapOf(
            "+" to R.id.buttonPlus, "-" to R.id.buttonMinus,
            "×" to R.id.buttonMultiply, "÷" to R.id.buttonDivide,
        )
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

@RunWith(Parameterized::class)
class MainActivityParameterizedTest(
    private val buttonId: Int,
    private val output: String
) {

    @Test
    fun `숫자버튼을_클릭하면_해당숫자가_결과화면에_떠야한다`() {
        //when
        숫자_버튼을_누른다(buttonId)
        //then
        결과화면에서_문자를_확인한다(output)
    }

    private fun `숫자_버튼을_누른다`(@IdRes buttonId: Int) {
        onView(withId(buttonId)).perform(click())
    }

    private fun `결과화면에서_문자를_확인한다`(output: String) {
        onView(withId(R.id.outputTextView)).check(matches(withText(output)))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun getNum() = listOf(
            arrayOf(R.id.button0, "0"),
            arrayOf(R.id.button1, "1"),
            arrayOf(R.id.button2, "2"),
            arrayOf(R.id.button3, "3"),
            arrayOf(R.id.button4, "4"),
            arrayOf(R.id.button5, "5"),
            arrayOf(R.id.button6, "6"),
            arrayOf(R.id.button7, "7"),
            arrayOf(R.id.button8, "8"),
            arrayOf(R.id.button9, "9"),
        )
    }
}
