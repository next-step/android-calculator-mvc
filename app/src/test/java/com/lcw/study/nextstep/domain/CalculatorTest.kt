package com.lcw.study.nextstep.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()
    private var operation: OperationType = OperationType.PLUS

    @Test
    fun 더하기() {
        val result: Int = calculator.evaluate("1 + 2 + 3")
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun 빼기() {
        val result: Int = calculator.evaluate("3 - 2 - 1")
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun 곱하기() {
        val result: Int = calculator.evaluate("1 * 2 * 3")
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun 나누기() {
        val result: Int = calculator.evaluate("4 / 2 / 1")
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun 사칙연산() {
        val result: Int = calculator.evaluate("3 + 2 - 1 * 5 / 5")
        assertThat(result).isEqualTo(4)
    }

    @Test(expected =IllegalArgumentException::class)
    fun `입력값이 null 이거나 공백일경우`() {
        val result: Int = calculator.evaluate("")
        assertThat(result).isEqualTo(throw IllegalArgumentException())
    }

    @Test(expected =IllegalArgumentException::class)
    fun `사칙연산 기호가 아닌경우`(){
        val result: Int = calculator.evaluate("#")
        assertThat(result).isEqualTo(throw IllegalArgumentException("사칙연산 기호가 아닙니다."))
    }

    @Test
    fun `입력된 문자가 사칙연산 기호가 맞는경우`(){
        val result: Boolean = operation.checkTextIsOperationType("+")
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `입력된 문자가 사칙연산 기호가 아닌경우`(){
        val result: Boolean = operation.checkTextIsOperationType("@")
        assertThat(result).isEqualTo(false)
    }
    @Test
    fun `입력된 문자가 + 기호면 PLUS로 변경한다`(){
        val result: OperationType = operation.changeTextToOperation("+")
        assertThat(result).isEqualTo(OperationType.PLUS)
    }

    @Test
    fun `입력된 문자가 - 기호면 MINUS로 변경한다`(){
        val result: OperationType = operation.changeTextToOperation("-")
        assertThat(result).isEqualTo(OperationType.MINUS)
    }

    @Test
    fun `입력된 문자가 * 기호면 MULTIPLY로 변경한다`(){
        val result: OperationType = operation.changeTextToOperation("*")
        assertThat(result).isEqualTo(OperationType.MULTIPLY)
    }

    @Test
    fun `입력된 문자가 나누기 기호면 DIVIDE로 변경한다`(){
        val result: OperationType = operation.changeTextToOperation("/")
        assertThat(result).isEqualTo(OperationType.DIVIDE)
    }

    @Test
    fun `입력된 문자가 사칙연산 기호가 아니면 NOT_OPERATION_TYPE로 변경한다`(){
        val result: OperationType = operation.changeTextToOperation("(")
        assertThat(result).isEqualTo(OperationType.NOT_OPERATION_TYPE)
    }

    @Test
    fun `입력된 타입이 PLUS이면 첫번째 입력값과 두번째 입력값을 더한다`(){
        val result: Int = operation.calculateOperation(OperationType.PLUS,1,2)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `입력된 타입이 MINUS이면 첫번째 입력값과 두번째 입력값을 뺀다`(){
        val result: Int = operation.calculateOperation(OperationType.MINUS,5,2)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `입력된 타입이 MULTIPLY이면 첫번째 입력값과 두번째 입력값을 곱한다`(){
        val result: Int = operation.calculateOperation(OperationType.MULTIPLY,5,2)
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `입력된 타입이 DIVIDE이면 첫번째 입력값과 두번째 입력값을 나눈다`(){
        val result: Int = operation.calculateOperation(OperationType.DIVIDE,6,2)
        assertThat(result).isEqualTo(3)
    }
}