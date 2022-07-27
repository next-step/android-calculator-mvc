package camp.nextstep.camp.calculator.domain

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class RawExpressionCheckTest {

    private lateinit var rawExpressionCheck: RawExpressionCheck

    @Before
    fun settings() {
        rawExpressionCheck = RawExpressionCheck()
    }

    @Test
    fun `입력값이 null일 경우 IllegalArgumentException throw 테스트`() {
        //given
        val expression = null

        //then
        assertThrows(IllegalArgumentException::class.java) {
            rawExpressionCheck.checkNullOrBlank(
                expression
            )
        }
    }

    @Test
    fun `입력값이 공백 문자일 경우 IllegalArgumentException throw 테스트`() {
        //given
        val expression = " "

        //then
        assertThrows(IllegalArgumentException::class.java) {
            rawExpressionCheck.checkNullOrBlank(expression)
        }
    }

}