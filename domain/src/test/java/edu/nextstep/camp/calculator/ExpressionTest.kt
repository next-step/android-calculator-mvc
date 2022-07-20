package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class ExpressionTest {
    private lateinit var expression: Expression
    private lateinit var stack: Stack<String>

    @Before
    fun setUp() {
        expression = Expression()
        stack = Stack()
    }

    @Test
    fun 사용자가_입력한대로_더하기_수식을_넣을_경우() {
        //given
        stack.push("3")
        stack.push("+")
        stack.push("2")
        stack.push("+")
        stack.push("10")

        //when
        val input = "10 + 2 + 3"
        val actual = expression.getStackForCalculating(input)

        //then
        assertThat(actual).isEqualTo(stack)
    }

    @Test
    fun 사용자가_입력한대로_빼기_수식을_넣을_경우() {
        //given
        stack.push("3")
        stack.push("-")
        stack.push("2")
        stack.push("-")
        stack.push("10")

        //when
        val input = "10 - 2 - 3"
        val actual = expression.getStackForCalculating(input)

        //then
        assertThat(actual).isEqualTo(stack)
    }

    @Test
    fun 사용자가_입력한대로_곱하기_수식을_넣을_경우() {
        //given
        stack.push("3")
        stack.push("*")
        stack.push("2")
        stack.push("*")
        stack.push("10")

        //when
        val input = "10 * 2 * 3"
        val actual = expression.getStackForCalculating(input)

        //then
        assertThat(actual).isEqualTo(stack)
    }

    @Test
    fun 사용자가_입력한대로_나누기_수식을_넣을_경우() {
        //given
        stack.push("3")
        stack.push("/")
        stack.push("2")
        stack.push("/")
        stack.push("10")

        //when
        val input = "10 / 2 / 3"
        val actual = expression.getStackForCalculating(input)

        //then
        assertThat(actual).isEqualTo(stack)
    }
}