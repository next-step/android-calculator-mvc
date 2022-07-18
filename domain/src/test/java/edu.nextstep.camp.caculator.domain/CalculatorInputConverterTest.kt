package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import org.junit.Test

class CalculatorInputConverterTest {
    @Test
    fun `계산기에_1+2를_입력하면_("1","+","2")의_배열이_나온다`() {
        val actual: List<String> = CalculatorInputConverter.getCalculatorInputToTextArr("1+2")
        Truth.assertThat(actual).isEqualTo(listOf("1", "+", "2"))
    }

    @Test
    fun `계산기에_공백이_포함된_1+ 2를_입력하면_("1","+","2")의_배열이_나온다`() {
        val actual: List<String> = CalculatorInputConverter.getCalculatorInputToTextArr("1+ 2")
        Truth.assertThat(actual).isEqualTo(listOf("1", "+", "2"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `계산기에_계산할_수_없는_문자_1+a-2를_입력하면_에러가_나온다`() {
        CalculatorInputConverter.getCalculatorInputToTextArr("1+a-2")
    }
}