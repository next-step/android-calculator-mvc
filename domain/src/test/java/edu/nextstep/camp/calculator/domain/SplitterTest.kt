package edu.nextstep.camp.calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


/**
 * Created by link.js on 2022. 07. 14..
 */
class SplitterTest {

    @ParameterizedTest(name = "{0}의 문자 갯수는 {1}")
    @CsvSource("2 + 3, 3",
        "5 - 2, 3",
        "5 * 3, 3",
        "5 + 3 / 4, 5",
        "2 + 3 * 4 / 2, 7",
        "200 - 10 / 10, 5")
    fun `Splitter가 문자열을 공백문자로 잘 구분한다`(expression: String, size: Int) {
        assertEquals(Splitter.splitByDelimiter(expression, " ").size, size)
    }
}