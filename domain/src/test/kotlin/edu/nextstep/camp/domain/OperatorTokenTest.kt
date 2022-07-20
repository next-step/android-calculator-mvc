package edu.nextstep.camp.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

@Suppress("NonAsciiCharacters")
class OperatorTokenTest {

	@Test(expected = IllegalArgumentException::class)
	fun `convertOperatorToken 빈 문자열을 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		OperatorToken.convertOperatorToken("")
	}

	@Test(expected = IllegalArgumentException::class)
	fun `convertOperatorToken 공백 문자를 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		OperatorToken.convertOperatorToken(" ")
	}

	@Test(expected = IllegalArgumentException::class)
	fun `convertOperatorToken 사칙 기호가 아닌 문자를 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		OperatorToken.convertOperatorToken("&")
	}

	@Test
	fun `convertOperatorToken + 문자를 전달하는 경우 Operator_Addition 객체를 반환해야한다`() {
		val result = OperatorToken.convertOperatorToken("+")

		assertThat(result).isEqualTo(Addition)
	}

	@Test
	fun `convertOperatorToken - 문자를 전달하는 경우 Operator_Subtraction 객체를 반환해야한다`() {
		val result = OperatorToken.convertOperatorToken("-")

		assertThat(result).isEqualTo(Subtraction)
	}

	@Test
	fun `convertOperatorToken × 문자를 전달하는 경우 Operator_Multiplication 객체를 반환해야한다`() {
		val result = OperatorToken.convertOperatorToken("×")

		assertThat(result).isEqualTo(Multiplication)
	}

	@Test
	fun `convertOperatorToken ÷ 문자를 전달하는 경우 Operator_Addition 객체를 반환해야한다`() {
		val result = OperatorToken.convertOperatorToken("÷")

		assertThat(result).isEqualTo(Division)
	}

}