package edu.nextstep.camp.domain

import org.junit.Before
import org.junit.Test

@Suppress("NonAsciiCharacters")
class ExpressionValidityCheckerImplTest {

    private lateinit var expressionValidityCheckerImpl: ExpressionValidityCheckerImpl

    @Before
    fun setup() {
        expressionValidityCheckerImpl = ExpressionValidityCheckerImpl()
    }

    @Test(expected = IllegalArgumentException::class)
    fun `null 을 전달하는 경우 IllegalArgumentException 를 throw 해야 한다`() {
        //given
        val targetExpression = null

        // when
        expressionValidityCheckerImpl.checkOrThrowException(targetExpression)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `공백 문자를 전달하는 경우 IllegalArgumentException 를 throw 해야 한다`() {
        //given
        val targetExpression = " "

        // when
        expressionValidityCheckerImpl.checkOrThrowException(targetExpression)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `연산식이 빈 문자열인 경우 IllegalArgumentException 를 throw 해야 한다`() {
        //given
        val targetExpression = ""

        // when
        expressionValidityCheckerImpl.checkOrThrowException(targetExpression)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `+ 와 같이 피연산자가 없는 연산식인 경우 IllegalArgumentException 를 throw 해야 한다`() {
        // given
        val targetExpression = "+"

        // when
        expressionValidityCheckerImpl.checkOrThrowException(targetExpression)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `1 + 와 같이 마지막 피연산자가 없는 연산식인 경우 IllegalArgumentException 를 throw 해야 한다`() {
        // given
        val targetExpression = "1 + "

        // when
        expressionValidityCheckerImpl.checkOrThrowException(targetExpression)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `3 & 4 과 같이 유효하지 않은 사칙 기호 문자가 포함되어 있는 경우 IllegalArgumentException 를 throw 해야한다`() {
        // given
        val targetExpression = "3 & 4"

        // when
        expressionValidityCheckerImpl.checkOrThrowException(targetExpression)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `a + 1 과 같이 연산식에 숫자, 사칙기호가 아닌 문자가 들어간 경우 IllegalArgumentException 를 throw 해야 한다`() {
        // given
        val targetExpression = "a + 1"

        // when
        expressionValidityCheckerImpl.checkOrThrowException(targetExpression)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `+-1 + 1 과 같이 피연산자의 부호 표시가 중복으로 들어간 경우 IllegalArgumentException 를 throw 해야 한다`() {
        // given
        val targetExpression = "+-1 + 1"

        // when
        expressionValidityCheckerImpl.checkOrThrowException(targetExpression)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `1 + 1(소수점) 과 같이 피연산자의 소수점 아래 숫자들이 나타나지 않은 경우 IllegalArgumentException 를 throw 해야 한다`() {
        // given
        val targetExpression = "1 + 1."

        // when
        expressionValidityCheckerImpl.checkOrThrowException(targetExpression)
    }

    @Test
    fun `1 + 2 + 3 과 같이 유효한 연산식인 경우 예외를 throw 하지 않고 정삭적으로 함수 실행을 종료해야한다`() {
        // given
        val targetExpression = "1 + 2 + 3"

        // when
        expressionValidityCheckerImpl.checkOrThrowException(targetExpression)
    }
}