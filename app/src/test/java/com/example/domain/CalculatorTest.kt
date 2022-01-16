package com.example.domain


import com.google.common.truth.Truth.assertThat
import org.junit.Test

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
}