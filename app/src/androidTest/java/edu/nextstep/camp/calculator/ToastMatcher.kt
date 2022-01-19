package edu.nextstep.camp.calculator

import android.view.WindowManager
import androidx.test.espresso.Root
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

// NOTE: 링크를 참고했습니다. (https://stackoverflow.com/a/33387980/6686126)
class ToastMatcher : TypeSafeMatcher<Root>() {
    override fun describeTo(description: Description?) {
        description?.appendText("is toast")
    }

    override fun matchesSafely(root: Root?): Boolean {
        val type = root?.windowLayoutParams?.get()?.type
        if (type == WindowManager.LayoutParams.TYPE_TOAST) {
            val windowToken = root?.decorView?.windowToken
            val appToken = root?.decorView?.applicationWindowToken
            return windowToken == appToken
        }
        return false
    }
}
