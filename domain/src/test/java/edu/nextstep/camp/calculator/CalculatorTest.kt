package edu.nextstep.camp.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

object Calculator {

    private const val ASCII_ZERO = 48
    private const val ASCII_NINE = 59
    private val ASCII_NUMBER_RANGE = ASCII_ZERO..ASCII_NINE

    fun calculate(formula: String): Double {
        val (numberGroup, operatorGroup) =
            numberGroup(formula = formula) to operatorGroup(formula = formula)
        var result = numberGroup.last()
        operatorGroup
            .zip(numberGroup.takeLast(numberGroup.lastIndex))
            .map {
                result = it.first.formula(result, it.second)
            }
        return result
    }

    private fun numberGroup(formula: String): List<Double> {
        val (numberBuilder, numberGroup) =
            StringBuilder() to mutableListOf<Double>()
        formula.forEachIndexed { index, item ->
            when {
                index == formula.lastIndex -> {
                    numberBuilder.append(item)
                    numberGroup.add(numberBuilder.toString().toDouble())
                }
                item.code in ASCII_NUMBER_RANGE -> {
                    numberBuilder.append(item)
                }
                else -> {
                    numberGroup.add(numberBuilder.toString().toDouble())
                    numberBuilder.clear()
                }
            }
        }
        return numberGroup
    }

    private fun operatorGroup(formula: String): List<Operator> {
        val operatorGroup = mutableListOf<Operator>()
        formula.forEach { item ->
            if (item.code in ASCII_NUMBER_RANGE) return@forEach
            operatorGroup.add(Operator.findBySymbol(item))
        }
        return operatorGroup
    }
}

internal class CalculatorTest {

    @Test
    fun `2 더하기 3 곱하기 4 나누기 2 를 연산하면 10이 출력됩니다`() {
        val formula = "2+3*4/2"
        assertThat(Calculator.calculate(formula)).isEqualTo(10.0)
    }
}
