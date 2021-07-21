package edu.nextstep.camp.calculator

import org.junit.Test

class NumberTest {

    @Test(expected = RuntimeException::class)
    fun `숫자로 변환할 수 없는경우 Exception 발생`() {
        val cantConvertString = "t"
        Number(cantConvertString)
    }
}