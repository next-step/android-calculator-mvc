package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import edu.nextstep.camp.calculator.domain.model.Input
import edu.nextstep.camp.calculator.domain.model.NumberInput
import edu.nextstep.camp.calculator.domain.model.OperatorInput
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class InputControllerTest {

    @ParameterizedTest(name = "#{index}) when {1} is received, displayedText is {0}")
    @MethodSource("provideInputList")
    fun whenInputListReceived_outputIsExpected(inputList: List<Input>, expected: String) {
        val inputController = InputController()
        var actual = ""
        inputList.forEach {
            actual = inputController.onReceiveInput(it)
        }
        Truth.assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "#{index}) displayedText is {0}")
    @CsvSource(
        "1000110",
        "1+1-1-"
    )
    fun setCurrentDisplayedText(text: String) {
        val inputController = InputController()
        Truth.assertThat(inputController.setCurrentDisplayedText(text)).isEqualTo(text)
    }


    companion object {
        @JvmStatic
        private fun provideInputList(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(NumberInput.FIVE, NumberInput.EIGHT, OperatorInput.DIV), "58÷"),
                Arguments.of(listOf(OperatorInput.DIV, NumberInput.FIVE, OperatorInput.MINUS, OperatorInput.PLUS), "5+"),
            )
        }
    }
}
