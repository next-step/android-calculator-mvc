package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LatestInputContentTypeTest {

    @Test
    fun getLatestInputContentTypeWhenContentsEmpty() {
        //given
        val contentList = listOf<String>()

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contentList)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.NONE)
    }

    @Test
    fun getLatestInputContentTypeWhenLatestContentIsNumber() {
        //given
        val contentList = listOf("1", " + ", "2")

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contentList)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.NUMBER)
    }

    @Test
    fun getLatestInputContentTypeWhenLatestContentIsOperator() {
        //given
        val contentList = listOf("1", " + ", "2", " - ")

        //when
        val latestInputContentType = LatestInputContentType.getLatestInputContentType(contentList)

        //then
        assertThat(latestInputContentType).isEqualTo(LatestInputContentType.OPERATOR)
    }
}
