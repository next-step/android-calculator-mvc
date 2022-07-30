package edu.nextstep.camp.domain.operator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.domain.NumberOperandToken
import edu.nextstep.camp.domain.OperatorToken
import org.junit.Test

@Suppress("NonAsciiCharacters")
class MultiplicationTest {

	@Test
	fun `현재 값이 3인 경우 3을 곱하면 9를 반환해야한다`() {
		val result = OperatorToken.Multiplication.processOperation(3.toDouble(), NumberOperandToken("3"))
		assertThat(result).isEqualTo(9)
	}

}