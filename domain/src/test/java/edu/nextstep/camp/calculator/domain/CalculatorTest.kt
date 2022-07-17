package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Calculator 클래스 테스트
 * Created by jeongjinhong on 2022. 07. 17..
 */
class CalculatorTest{
    lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test(expected = java.lang.IllegalArgumentException::class)
    fun Input이_Null_이거나_공백이면_IllegalArgumentException_throw(){
        calculator.evaluatesExpression("  ")
    }

    @Test(expected = java.lang.IllegalArgumentException::class)
    fun 사칙연산_기호가_아닌_경우_IllegalArgumentException_throw(){
        calculator.evaluatesExpression("3 ~ 4")
    }

    @Test
    fun 덧셈이_정상적으로_수행되는가(){
        val result = calculator.evaluatesExpression("3 + 4")
        assertThat(result).isEqualTo(3 + 4)
    }

    @Test
    fun 뺄셈이_정상적으로_수행되는가(){
        val result = calculator.evaluatesExpression("3 - 4")
        assertThat(result).isEqualTo(3 - 4)
    }

    @Test
    fun 나눗셈이_정상적으로_수행되는가(){
        val result = calculator.evaluatesExpression("3 / 4")
        assertThat(result).isEqualTo(3.0 / 4)
    }

    @Test
    fun 곱셈이_정상적으로_수행되는가(){
        val result = calculator.evaluatesExpression("3 * 4")
        assertThat(result).isEqualTo(3 * 4)
    }

    @Test
    fun 모든_사칙연산을_포함한_식이_잘_수행되는가(){
        val result = calculator.evaluatesExpression("2 + 3 * 4 / 2")
        assertThat(result).isEqualTo((2 + 3) * 4 / 2)
    }

}