package edu.nextstep.camp.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

@Suppress("NonAsciiCharacters")
class CalculatorTest {
	private lateinit var target: Calculator

	@Before
	fun setup() {
		target = Calculator(ExpressionTokenConverterImpl())
	}

	@Test(expected = IllegalArgumentException::class)
	fun `null 을 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.evaluate(null)
	}

	@Test(expected = IllegalArgumentException::class)
	fun `빈 문자열을 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.evaluate("")
	}

	@Test(expected = IllegalArgumentException::class)
	fun `공백 문자를 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.evaluate(" ")
	}

	@Test(expected = IllegalArgumentException::class)
	fun `계산식에 사칙 기호가 아닌 문자가 포함되어 있는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.evaluate("3 & 4")
	}

	@Test(expected = NumberFormatException::class)
	fun `계산식에 숫자 형태가 아닌 문자열을 입력하는 경우 NumberFormatException 을 throw 해야한다`() {
		target.evaluate("abcd + 12")
	}

	@Test
	fun `processAddition 호출시 연산 결과에 피연산자를 더한다`() {
		val result = target.processAddition(3.toDouble(), Number("3"))
		assertThat(result).isEqualTo(6)
	}

	@Test
	fun `processSubtraction 호출시 연산 결과에 피연산자를 뺀다`() {
		val result = target.processSubtraction(3.toDouble(), Number("3"))
		assertThat(result).isEqualTo(0)
	}

	@Test
	fun `processMultiplication 호출시 연산 결과에 피연산자를 곱한다`() {
		val result = target.processMultiplication(3.toDouble(), Number("3"))
		assertThat(result).isEqualTo(9)
	}

	@Test
	fun `processMultiplication 호출시 연산 결과에 피연산자를 나눈다`() {
		val result = target.processDivision(3.toDouble(), Number("3"))
		assertThat(result).isEqualTo(1)
	}

	@Test(expected = IllegalArgumentException::class)
	fun `processMultiplication 호출시 0으로 나누는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.processDivision(3.toDouble(), Number("0"))
	}

	@Test(expected = IllegalArgumentException::class)
	fun `processOperator 호출시 Number, Number 인자가 넘어오면 IllegalArgumentException 를 throw 해야한다`() {
		target.processOperator(3.0, Number("3.0"), Number("3.0"))
	}

	@Test(expected = IllegalArgumentException::class)
	fun `processOperator 호출시 Operator, Operator 인자가 넘어오면 IllegalArgumentException 를 throw 해야한다`() {
		target.processOperator(3.0, Operator.Addition, Operator.Addition)
	}

	@Test(expected = IllegalArgumentException::class)
	fun `processOperator 호출시 Number, Operator 인자가 넘어오면 IllegalArgumentException 를 throw 해야한다`() {
		target.processOperator(3.0, Number("3.0"), Operator.Addition)
	}

	@Test
	fun evaluatesExpression() {
		val actual: Double = target.evaluate("1 + 2 + 3")
		assertThat(actual).isEqualTo(6)
	}

}