package edu.nextstep.camp.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

object Calculator {

    private const val ASCII_ZERO = 48
    private const val ASCII_NINE = 59
    private val ASCII_NUMBER_RANGE = ASCII_ZERO..ASCII_NINE

    fun calculate(formula: String): Double {
        val (numberGroup: List<Double>, operatorGroup: List<Operator>) =
            mutableListOf<Double>() to mutableListOf<Operator>()

        val numberBuilder = StringBuilder()
        formula.forEachIndexed { index, item ->
            when {
                index == formula.lastIndex -> {
                    numberBuilder.append(item)
                    numberGroup.add(
                        numberBuilder
                            .toString()
                            .toDouble()
                    )
                }
                item.code in ASCII_NUMBER_RANGE -> {
                    numberBuilder.append(item)
                }
                else -> {
                    numberGroup.add(
                        numberBuilder
                            .toString()
                            .toDouble()
                    )
                    numberBuilder.clear()
                    operatorGroup.add(Operator.findBySymbol(item))
                }
            }
        }
        var result = numberGroup.removeAt(0)
        operatorGroup
            .zip(numberGroup)
            .map {
                result = it.first.formula(result, it.second)
            }
        return result
    }
}

internal class CalculatorTest {

    @Test
    fun `2 더하기 3 곱하기 4 나누기 2 를 연산하면 10이 출력됩니다`() {
        val formula = "2+3*4/2"
        assertThat(Calculator.calculate(formula)).isEqualTo(10.0)
    }
}
