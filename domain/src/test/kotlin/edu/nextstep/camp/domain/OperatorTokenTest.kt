package edu.nextstep.camp.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

@Suppress("NonAsciiCharacters")
class OperatorTokenTest {

	@Test(expected = IllegalArgumentException::class)
	fun `빈 문자열을 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		OperatorToken.convertOperatorToken("")
	}

	@Test(expected = IllegalArgumentException::class)
	fun `공백 문자를 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		OperatorToken.convertOperatorToken(" ")
	}

	@Test(expected = IllegalArgumentException::class)
	fun `사칙 기호가 아닌 문자를 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		OperatorToken.convertOperatorToken("&")
	}

	@Test
	fun `+ 문자를 전달하는 경우 Operator_Addition 객체를 반환해야한다`() {
		val result = OperatorToken.convertOperatorToken("+")

		assertThat(result).isEqualTo(OperatorToken.Addition)
	}

	@Test
	fun `- 문자를 전달하는 경우 Operator_Subtraction 객체를 반환해야한다`() {
		val result = OperatorToken.convertOperatorToken("-")

		assertThat(result).isEqualTo(OperatorToken.Subtraction)
	}

	@Test
	fun `× 문자를 전달하는 경우 Operator_Multiplication 객체를 반환해야한다`() {
		val result = OperatorToken.convertOperatorToken("×")

		assertThat(result).isEqualTo(OperatorToken.Multiplication)
	}

	@Test
	fun `÷ 문자를 전달하는 경우 Operator_Addition 객체를 반환해야한다`() {
		val result = OperatorToken.convertOperatorToken("÷")

		assertThat(result).isEqualTo(OperatorToken.Division)
	}

}