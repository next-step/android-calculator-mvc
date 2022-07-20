package edu.nextstep.camp.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

@Suppress("NonAsciiCharacters")
class CalculatorTest {
	private lateinit var target: Calculator

	@Before
	fun setup() {
		target = Calculator()
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

	@Test(expected = IllegalArgumentException::class)
	fun `계산식에 숫자 형태가 아닌 문자열을 입력하는 경우 IllegalArgumentException 을 throw 해야한다`() {
		target.evaluate("abcd + 12")
	}

	@Test
	fun `1 + 2 + 3 연산 수행시 6을 반환해야한다`() {
		val actual: Double = target.evaluate("1 + 2 + 3")
		assertThat(actual).isEqualTo(6)
	}

}