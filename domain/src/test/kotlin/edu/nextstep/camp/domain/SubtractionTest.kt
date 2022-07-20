package edu.nextstep.camp.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

@Suppress("NonAsciiCharacters")
class SubtractionTest {

	@Test
	fun `현재 값이 3 인 경우 3을 빼면 0을 반환해야한다`() {
		val result = OperatorToken.Subtraction.processOperation(3.toDouble(), NumberOperandToken("3"))
		assertThat(result).isEqualTo(0)
	}

}
