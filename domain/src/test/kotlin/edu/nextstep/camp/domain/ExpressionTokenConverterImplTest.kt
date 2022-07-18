package edu.nextstep.camp.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

@Suppress("NonAsciiCharacters")
class ExpressionTokenConverterImplTest {

	private lateinit var target: ExpressionTokenConverterImpl

	@Before
	fun setup() {
		target = ExpressionTokenConverterImpl()
	}

	@Test(expected = IllegalArgumentException::class)
	fun `null 을 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.convert(null)
	}

	@Test(expected = IllegalArgumentException::class)
	fun `빈 문자열을 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.convert("")
	}

	@Test(expected = IllegalArgumentException::class)
	fun `공백 문자를 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.convert(" ")
	}

	@Test(expected = IllegalArgumentException::class)
	fun `사칙 기호가 아닌 문자를 전달하는 경우 IllegalArgumentException 를 throw 해야한다`() {
		target.convert("&")
	}

	@Test(expected = NumberFormatException::class)
	fun `숫자 형태가 아닌 문자열을 입력하는 경우 NumberFormatException 을 throw 해야한다`() {
		target.convert("abcd")
	}

	@Test
	fun `숫자 형태의 문자열을 전달하는 경우 Number 객체를 반환해야 한다`() {
		val result = target.convert("123")

		assertThat(result).isInstanceOf(NumberOperand::class.java)
	}

	@Test
	fun `+ 문자를 전달하는 경우 Operator_Addition 객체를 반환해야 한다`() {
		val result = target.convert("+")

		assertThat(result).isInstanceOf(Operator.Addition::class.java)
	}

	@Test
	fun `- 문자를 전달하는 경우 Operator_Subtraction 객체를 반환해야 한다`() {
		val result = target.convert("-")

		assertThat(result).isInstanceOf(Operator.Subtraction::class.java)
	}

	@Test
	fun `× 문자를 전달하는 경우 Operator_Multiplication 객체를 반환해야 한다`() {
		val result = target.convert("×")

		assertThat(result).isInstanceOf(Operator.Multiplication::class.java)
	}

	@Test
	fun `÷ 문자를 전달하는 경우 Operator_Addition 객체를 반환해야 한다`() {
		val result = target.convert("÷")

		assertThat(result).isInstanceOf(Operator.Division::class.java)
	}
}