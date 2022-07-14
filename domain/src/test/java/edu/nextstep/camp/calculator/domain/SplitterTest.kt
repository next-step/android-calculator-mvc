package edu.nextstep.camp.calculator.domain

import org.junit.Assert
import org.junit.Test

/**
 * Created by link.js on 2022. 07. 14..
 */
class SplitterTest {

    // TODO 파라미터 테스트로 다양하게 해보는게 좋을듯.
    @Test
    fun `Splitter가 문자열을 공백문자로 잘 구분한다`() {
        Assert.assertEquals(Splitter.splitByDelimiter("3 + 5 - 6 / 7").size, 7)
    }
}