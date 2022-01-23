package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.*
import org.junit.Test

class InputFormulaClassifierTest {

    @Test
    fun makeInitialNumberWithOperations() {
        //given
        val formula = "1 + 2 - 3"

        //when
        val initialOperandWithOperations = InputFormulaClassifier.makeInitialOperandWithOperationsFromFormula(formula)
        val initialOperand = initialOperandWithOperations.initialOperand
        val operations = initialOperandWithOperations.operations

        //then
        assertThat(initialOperand).isEqualTo(1)
        assertThat(operations[0][0]).isEqualTo("+")
        assertThat(operations[0][1]).isEqualTo("2")
        assertThat(operations[1][0]).isEqualTo("-")
        assertThat(operations[1][1]).isEqualTo("3")
    }
}
