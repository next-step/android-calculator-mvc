package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.*
import edu.nextstep.camp.calculator.domain.model.ExpressionToken
import edu.nextstep.camp.calculator.domain.model.Operand
import edu.nextstep.camp.calculator.domain.model.Operator
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class UserInputActionProcessorTest {

    @ParameterizedTest(name = "#{index}) when {1} is received, displayedText is {0}")
    @MethodSource("provideInputList")
    fun whenInputListReceived_outputIsExpected(userInputActionList: List<ExpressionToken>, expected: String) {
        val inputController = ExpressionTokenProcessor()
        var actual = ""
        userInputActionList.forEach {
            actual = inputController.processUserInputAction(it)
        }
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "#{index}) displayedText is {0}")
    @CsvSource(
        "1000110",
        "1+1-1-"
    )
    fun setCurrentDisplayedText(text: String) {
        val inputController = ExpressionTokenProcessor()
        assertThat(inputController.setCurrentDisplayedText(text)).isEqualTo(text)
    }


    companion object {
        @JvmStatic
        private fun provideInputList(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(Operand(5), Operand(8), Operator.DIVISION), "58÷"),
                Arguments.of(listOf(Operator.DIVISION, Operand(5), Operator.SUBTRACTION, Operator.ADDITION), "5+"),
            )
        }
    }
}
