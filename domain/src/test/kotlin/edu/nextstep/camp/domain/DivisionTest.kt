package edu.nextstep.camp.domain

import com.google.common.truth.Truth
import org.junit.Test

@Suppress("NonAsciiCharacters")

class DivisionTest {
	@Test
	fun `현재 값이 3인 경우 3을 나누면 1을 반환해야한다`() {
		val result = Division.processOperation(3.toDouble(), NumberOperandToken("3"))
		Truth.assertThat(result).isEqualTo(1)
	}

	@Test(expected = IllegalArgumentException::class)
	fun `0으로 나누면 IllegalArgumentException 를 throw 해야한다`() {
		val result = Division.processOperation(3.toDouble(), NumberOperandToken("0"))
		Truth.assertThat(result).isEqualTo(1)
	}
}