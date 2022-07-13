package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class OperationTest(
    operator: Char,
    private val operation: Operation,
    private val left: Int,
    private val right: Int,
    private val expected: Int
) {

    companion object {
        @JvmStatic
        @Parameters(name = " {2} {0} {3} = {4} ")
        fun getTestParameters() = listOf(
            arrayOf(Operation.Plus.char, Operation.Plus, 2, 3, 5),
            arrayOf(Operation.Minus.char, Operation.Minus, 2, 3, -1),
            arrayOf(Operation.Div.char,  Operation.Div, 6, 3, 2),
            arrayOf(Operation.Mult.char, Operation.Mult, 2, 3, 6),
        )
    }

    @Test
    fun `연산`() {
        //when
        val actual = operation(left, right)

        //then
        assertThat(actual).isEqualTo(expected)
    }
}