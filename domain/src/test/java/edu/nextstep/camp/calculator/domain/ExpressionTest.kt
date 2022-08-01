package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionTest {
    @Test
    fun Expression을_사용하여_여러_수식을_병합하여_계산한_결과를_반환한다() {
        //given
        // (8 + (3 * 2)) - 2
        val expression = Expression.Calculation(
            Expression.Calculation(
                Expression.Value(8),
                Expression.Calculation(
                    Expression.Value(3),
                    Expression.Value(2),
                    Operator.MULTIPLY
                ),
                Operator.PLUS
            ),
            Expression.Value(2),
            Operator.MINUS
        )
        //when
        val actual = expression.execute()
        //then
        assertThat(actual).isEqualTo(12)
    }
}
