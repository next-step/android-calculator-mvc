package edu.nextstep.camp.caculator.domain

import com.google.common.truth.Truth
import edu.nextstep.camp.calculator.domain.Operator
import org.junit.Assert.assertThrows
import org.junit.Test

class OperatorTest {
    @Test
    fun `잘못된_수식을_입력하면_에러를_낸다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Operator.getOperated(accumulated = 32, nextInt = 2, operatorMark = "r")
        }
    }
    @Test
    fun `유효한_수식을_입력하면_연산_결과값을_낸다(32-2=30)`() {
        var actual = Operator.getOperated(accumulated = 32, nextInt = 2, operatorMark = "-")
        Truth.assertThat(actual).isEqualTo(30)
    }
}