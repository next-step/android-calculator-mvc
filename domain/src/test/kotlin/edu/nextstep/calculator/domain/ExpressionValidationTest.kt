package edu.nextstep.calculator.domain

import org.junit.Test

class ExpressionValidationTest {
    @Test
    fun `수식이 숫자 한개만 있다면 IllegalArgumentException이 발생하지 않는다`() {
        ExpressionValidation.isValidExpression("1")
        ExpressionValidation.isValidExpression("0")
        ExpressionValidation.isValidExpression("-1")
        ExpressionValidation.isValidExpression("100002")
    }

    @Test
    fun `수식이 숫자 연산자 숫자의 형태라면 IllegalArgumentException이 발생하지 않는다`() {
        ExpressionValidation.isValidExpression("1 + 2")
        ExpressionValidation.isValidExpression("1 * 22")
        ExpressionValidation.isValidExpression("-1 - -22")
        ExpressionValidation.isValidExpression("-1 / 22")
    }

    @Test
    fun `수식이 숫자 (연산자 숫자) 형식이라면 IllegalArgumentException이 발생하지 않는다`() {
        ExpressionValidation.isValidExpression("1 + 2")
        ExpressionValidation.isValidExpression("1 + 2 + 333")
        ExpressionValidation.isValidExpression("1 + 2 - 0 + 12 + 5")
        ExpressionValidation.isValidExpression("1 + 2 - 0 * 12 + 5 - -1")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `수식이 숫자 (연산자 숫자)의 형식이 아니라면 IllegalArgumentException이 발생한다`() {
        ExpressionValidation.isValidExpression("1 + 2 +")
        ExpressionValidation.isValidExpression("1 + ")
        ExpressionValidation.isValidExpression("+ 1 + 2")
    }
}
