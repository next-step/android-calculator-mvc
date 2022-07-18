package edu.nextstep.camp.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

@Suppress("NonAsciiCharacters")
class OperatorImplTest {

	private lateinit var target: OperatorImpl

	@Before
	fun setup() {
		target = OperatorImpl()
	}

	@Test
	fun `processOperation 현재 값이 3 인 경우 3을 더하면 6을 반환해야한다`() {
		val result = target.processOperation(3.toDouble(), OperatorToken.Addition, NumberOperandToken("3"))
		assertThat(result).isEqualTo(6)
	}

	@Test
	fun `processOperation 현재 값이 3 인 경우 3을 빼면 0을 반환해야한다`() {
		val result = target.processOperation(3.toDouble(), OperatorToken.Subtraction, NumberOperandToken("3"))
		assertThat(result).isEqualTo(0)
	}

	@Test
	fun `processOperation 현재 값이 3인 경우 3을 곱하면 9를 반환해야한다`() {
		val result = target.processOperation(3.toDouble(), OperatorToken.Multiplication, NumberOperandToken("3"))
		assertThat(result).isEqualTo(9)
	}

	@Test
	fun `processOperation 현재 값이 3인 경우 3을 나누면 1을 반환해야한다`() {
		val result = target.processOperation(3.toDouble(), OperatorToken.Division, NumberOperandToken("3"))
		assertThat(result).isEqualTo(1)
	}

	@Test(expected = IllegalArgumentException::class)
	fun `processOperation 0으로 나누면 IllegalArgumentException 를 throw 해야한다`() {
		val result = target.processOperation(3.toDouble(), OperatorToken.Division, NumberOperandToken("0"))
		assertThat(result).isEqualTo(1)
	}

	@Test(expected = IllegalArgumentException::class)
	fun `convertOperatorToken 빈 문자열을 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.convertOperatorToken("")
	}

	@Test(expected = IllegalArgumentException::class)
	fun `convertOperatorToken 공백 문자를 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.convertOperatorToken(" ")
	}

	@Test(expected = IllegalArgumentException::class)
	fun `convertOperatorToken 사칙 기호가 아닌 문자를 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.convertOperatorToken("&")
	}

	@Test
	fun `convertOperatorToken + 문자를 전달하는 경우 Operator_Addition 객체를 반환해야한다`() {
		val result = target.convertOperatorToken("+")

		assertThat(result).isInstanceOf(OperatorToken.Addition::class.java)
	}

	@Test
	fun `convertOperatorToken - 문자를 전달하는 경우 Operator_Subtraction 객체를 반환해야한다`() {
		val result = target.convertOperatorToken("-")

		assertThat(result).isInstanceOf(OperatorToken.Subtraction::class.java)
	}

	@Test
	fun `convertOperatorToken × 문자를 전달하는 경우 Operator_Multiplication 객체를 반환해야한다`() {
		val result = target.convertOperatorToken("×")

		assertThat(result).isInstanceOf(OperatorToken.Multiplication::class.java)
	}

	@Test
	fun `convertOperatorToken ÷ 문자를 전달하는 경우 Operator_Addition 객체를 반환해야한다`() {
		val result = target.convertOperatorToken("÷")

		assertThat(result).isInstanceOf(OperatorToken.Division::class.java)
	}
}