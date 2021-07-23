package edu.nextstep.camp.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupingsTest {

    @Test
    fun `수식 중에서 숫자들만 그룹화합니다`() {
        val formula = "2+3*4/2"
        val numberGroup = listOf(2.0, 3.0, 4.0, 2.0)
        val actual = Groupings.numberGroup(formula)

        actual
            .zip(numberGroup)
            .forEach {
                assertThat(it.first).isEqualTo(it.second)
            }
    }
}
