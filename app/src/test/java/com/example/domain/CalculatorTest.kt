package com.example.domain


import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test
import java.lang.IllegalArgumentException

class CalculatorTest{

    @Test
    fun evaluatesExpression_add(){
        val calculator = Calculator()
        val actual:Int = calculator.evaluate("1+2+3")
        assertThat(actual).isEqualTo(6)
    }


    @Test
    fun evaluatesExpression_subtract(){
        val calculator = Calculator()
        val actual:Int = calculator.evaluate("3-2-1")
        assertThat(actual).isEqualTo(0)
    }

    @Test
    fun evaluatesExpression_multiply(){
        val calculator = Calculator()
        val actual:Int = calculator.evaluate("1*2*3")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun evaluatesExpression_divide(){
        val calculator = Calculator()
        val actual:Int = calculator.evaluate("6/3/2")
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun evaluatesExpression_withSpace_add_subtract(){
        val calculator = Calculator()
        val actual:Int = calculator.evaluate("1+2+3 +4 - 5")
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun evaluatesExpression_withSpace_multiply_divide(){
        val calculator = Calculator()
        val actual:Int = calculator.evaluate("1*2*3 /4 * 5")
        assertThat(actual).isEqualTo(5)
    }

    @Test(expected = IllegalArgumentException::class)
    fun evaluatesExpression_input_is_null(){
        val calculator = Calculator()
        val actual = calculator.evaluate(null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun evaluatesExpression_input_is_empty(){
        val calculator = Calculator()
        val actual = calculator.evaluate("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun evaluatesExpression_input_is_blank(){
        val calculator = Calculator()
        val actual = calculator.evaluate("   ")
    }
}