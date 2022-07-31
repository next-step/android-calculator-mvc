package edu.nextstep.camp.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

@Suppress("NonAsciiCharacters")
class ExpressionTest {
	private lateinit var expression: Expression
	
	@Before
	fun setup() {
		expression = Expression()
	}
	
	@Test
	fun `빈 연산식일때 피연산자 토큰을 추가하면 해당 피연산자만 있는 연산식이 되어야 한다`() {
		expression += NumberOperandToken("0")

		assertThat(expression.toString()).isEqualTo("0")
	}

	@Test
	fun `5 + 연산식이 있을때 피연산자 0 토큰을 추가하면 5 + 0 연산식이 되어야 한다`() {
		expression += NumberOperandToken("5")
		expression += OperatorToken.Addition

		expression += NumberOperandToken("0")

		assertThat(expression.toString()).isEqualTo("5 + 0")
	}

	@Test
	fun `8 연산식이 있을때 9 피연산자를 입력하면 89 연산식이 되어야 한다`() {
		expression += NumberOperandToken("8")

		expression += NumberOperandToken("9")

		assertThat(expression.toString()).isEqualTo("89")
	}

	@Test
	fun `빈 연산식일때 + 연산자 토큰을 추가하면 계속 빈 연산식이 되어야 한다`() {
		expression += OperatorToken.Addition

		assertThat(expression.toString()).isEqualTo("")
	}

	@Test
	fun `빈 연산식일때 - 연산자 토큰을 추가하면 계속 빈 연산식이 되어야 한다`() {
		expression += OperatorToken.Subtraction

		assertThat(expression.toString()).isEqualTo("")
	}

	@Test
	fun `빈 연산식일때 × 연산자 토큰을 추가하면 계속 빈 연산식이 되어야 한다`() {
		expression += OperatorToken.Multiplication

		assertThat(expression.toString()).isEqualTo("")
	}

	@Test
	fun `빈 연산식일때 ÷ 연산자 토큰을 추가하면 계속 빈 연산식이 되어야 한다`() {
		expression += OperatorToken.Division

		assertThat(expression.toString()).isEqualTo("")
	}

	@Test
	fun `8 연산식이 있을때 + 연산자를 입력하면 8 + 연산식이 되어야 한다`() {
		expression += NumberOperandToken("8")

		expression += OperatorToken.Addition

		assertThat(expression.toString()).isEqualTo("8 +")
	}

	@Test
	fun `8 + 연산식이 있을때 - 연산자를 입력하면 8 - 연산식이 되어야 한다`() {
		expression += NumberOperandToken("8")
		expression += OperatorToken.Addition

		expression += OperatorToken.Subtraction

		assertThat(expression.toString()).isEqualTo("8 -")
	}

	@Test
	fun `빈 연산식일때 마지막 기호를 지우는 경우 계속 빈 연산식이 되어야 한다`() {
		expression = expression.removeLastCharacter()

		assertThat(expression.toString()).isEqualTo("")
	}

	@Test
	fun `32 + 1 연산식이 있을때 마지막 기호를 지우는 경우 32 + 연산식이 되어야 한다`() {
		expression += NumberOperandToken("32")
		expression += OperatorToken.Addition
		expression += NumberOperandToken("1")

		expression = expression.removeLastCharacter()

		assertThat(expression.toString()).isEqualTo("32 +")
	}

	@Test
	fun `32 + 연산식이 있을때 마지막 기호를 지우는 경우 32 연산식이 되어야 한다`() {
		expression += NumberOperandToken("32")
		expression += OperatorToken.Addition

		expression = expression.removeLastCharacter()

		assertThat(expression.toString()).isEqualTo("32")
	}

	@Test
	fun `32 연산식이 있을때 마지막 기호를 지우는 경우 3 연산식이 되어야 한다`() {
		expression += NumberOperandToken("32")

		expression = expression.removeLastCharacter()

		assertThat(expression.toString()).isEqualTo("3")
	}

	@Test
	fun `3 연산식이 있을때 마지막 기호를 지우는 경우 빈 연산식이 되어야 한다`() {
		expression += NumberOperandToken("3")

		expression = expression.removeLastCharacter()

		assertThat(expression.toString()).isEqualTo("")
	}
}