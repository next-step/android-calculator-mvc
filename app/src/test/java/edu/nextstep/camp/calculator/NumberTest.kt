package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.Number
import org.junit.Test

class NumberTest {

    @Test(expected = RuntimeException::class)
    fun `숫자가 아닌 값을 변환하려고 하면 Exception 발생`() {
        //given
        val cantConvertString = "abc"

        //when
        Number(cantConvertString)
    }
}