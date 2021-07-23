package edu.nextstep.camp.calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class FormulaTest {

    @Test
    fun `수식 중에서 연산자가 아닌 것이 포함되어있으면 에러가 발생합니다`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Formula("2!3@4#2")
        }
    }
}
