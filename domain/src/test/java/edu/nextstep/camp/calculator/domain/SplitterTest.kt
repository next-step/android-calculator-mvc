package edu.nextstep.camp.calculator.domain

import org.junit.Assert.*
import org.junit.Test

class SplitterTest {
    @Test
    fun 정상적으로_식이_공백으로_나뉘어지는지_확인한다() {
        val expression = "5 + 3 / 4"
        val expected = Operand(5)

        val splitNodeList = Splitter.split(expression)
        val actual = splitNodeList.first() as Operand

        assertEquals(actual, expected)
    }
}