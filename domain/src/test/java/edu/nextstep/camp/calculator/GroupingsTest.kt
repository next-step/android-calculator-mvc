package edu.nextstep.camp.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class GroupingsTest {

    @ParameterizedTest
    @ValueSource(strings = ["2+3*4/2", "2 + 3 * 4 / 2"])
    fun `수식 중에서 숫자들만 그룹화합니다`(formula: String) {
        val numberGroup = listOf(2.0, 3.0, 4.0, 2.0)
        val actual = Groupings.numberGroup(formula)

        actual
            .zip(numberGroup)
            .forEach {
                assertThat(it.first).isEqualTo(it.second)
            }
    }

    @Test
    fun `수식 중에서 연산자들만 그룹화합니다`() {
        val formula = "2+3*4/2"
        val operatorGroup = listOf(
            Operator.PLUS,
            Operator.MULTIPLE,
            Operator.DIVIDE
        )
        val actual = Groupings.operatorGroup(formula)

        actual
            .zip(operatorGroup)
            .forEach {
                assertThat(it.first).isEqualTo(it.second)
            }
    }
}
