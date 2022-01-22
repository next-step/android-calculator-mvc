package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.*
import org.junit.Test

class InputContentsClassifierTest {

    @Test
    fun makeInitialNumberWithOperations() {
        //given
        val contents = "1 + 2 - 3"

        //when
        val initialNumberWithOperations = InputContentsClassifier.makeInitialNumberWithOperationsFromContents(contents)
        val initialNumber = initialNumberWithOperations.first
        val operations = initialNumberWithOperations.second

        //then
        assertThat(initialNumber).isEqualTo(1)
        assertThat(operations[0][0]).isEqualTo("+")
        assertThat(operations[0][1]).isEqualTo("2")
        assertThat(operations[1][0]).isEqualTo("-")
        assertThat(operations[1][1]).isEqualTo("3")
    }
}
