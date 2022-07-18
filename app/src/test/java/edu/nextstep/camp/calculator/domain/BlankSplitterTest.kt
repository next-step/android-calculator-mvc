package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import org.junit.Test

class BlankSplitterTest {

    private val blankSplitter = BlankSplitter()

    @Test
    fun 공백_제거_테스트() {
        val actual = blankSplitter.removeBlankCalculatorContent("1 2 3 4")
        Truth.assertThat(actual).isEqualTo(listOf("1", "2", "3", "4"))
    }

}