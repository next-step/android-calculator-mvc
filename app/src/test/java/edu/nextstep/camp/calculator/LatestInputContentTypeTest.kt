package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LatestInputContentTypeTest {

    @Test
    fun getLatestInputContentType_WhenFormulaEmpty() {
        //given
        val formula = ""

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(formula)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.NONE)
    }

    @Test
    fun getLatestInputContentType_WhenLatestContentIsOperand() {
        //given
        val formula = "1 + 2"

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(formula)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.OPERAND)
    }

    @Test
    fun getLatestInputContentType_WhenLatestContentIsOperator() {
        //given
        val formula = "1 + 2 - "

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(formula)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.OPERATOR)
    }


    @Test
    fun getLatestInputContentLength_whenFormulaIsEmpty() {
        //given
        val formula = ""

        //when
        val result = LatestInputContentType.getLatestInputContentLength(formula)

        //then
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun getLatestInputContentLength_whenLastContentIsOperand() {
        //given
        val formula = "1 + 3"

        //when
        val result = LatestInputContentType.getLatestInputContentLength(formula)

        //then
        assertThat(result).isEqualTo(LatestInputContentType.LENGTH_OPERAND_CONTENT)
    }

    @Test
    fun getLatestInputContentLength_whenLastContentIsOperator() {
        //given
        val formula = "1 + 3 - "

        //when
        val result = LatestInputContentType.getLatestInputContentLength(formula)

        //then
        assertThat(result).isEqualTo(LatestInputContentType.LENGTH_OPERATOR_CONTENT)
    }
}
