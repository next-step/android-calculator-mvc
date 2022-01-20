package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.Before
import org.junit.Test

class CalculatorRepositoryTest {

    private val calculatorRepository = CalculatorRepository()

    @Before
    fun setUp() {
        calculatorRepository.deleteAllContent()
    }

    @Test
    fun appendNumberContent() {
        //given
        calculatorRepository.appendNumberContent("1")

        //when
        val displayContents = calculatorRepository.getDisplayContents()

        //then
        assertThat(displayContents).isEqualTo("1")
    }

    @Test
    fun appendOperatorContent() {
        //given
        calculatorRepository.appendNumberContent("1")
        calculatorRepository.appendOperatorContent("+")
        calculatorRepository.appendNumberContent("3")
        calculatorRepository.appendOperatorContent("-")
        calculatorRepository.appendNumberContent("5")

        //when
        val displayContents = calculatorRepository.getDisplayContents()

        //then
        assertThat(displayContents).isEqualTo("1 + 3 - 5")
    }

    @Test
    fun deleteAllContent() {
        //given
        calculatorRepository.appendNumberContent("1")
        calculatorRepository.appendOperatorContent("+")
        calculatorRepository.appendNumberContent("2")

        //when
        calculatorRepository.deleteAllContent()

        //then
        val displayContents = calculatorRepository.getDisplayContents()
        assertThat(displayContents).isEqualTo("")
    }

    @Test
    fun deleteLatestContent() {
        //given
        calculatorRepository.appendNumberContent("1")
        calculatorRepository.appendOperatorContent("+")
        calculatorRepository.appendNumberContent("2")
        calculatorRepository.appendNumberContent("3")

        //when
        calculatorRepository.deleteLatestContent()

        //then
        val displayContents = calculatorRepository.getDisplayContents()
        assertThat(displayContents).isEqualTo("1 + 2")
    }

    @Test
    fun calculateContentsWhenLastInputIsEmpty() {
        //given
        //when
        //then
        assertThatIllegalArgumentException().isThrownBy {
            calculatorRepository.calculateContents()
        }
    }

    @Test
    fun calculateContentsWhenLastInputIsNumber() {
        //given
        calculatorRepository.appendNumberContent("1")
        calculatorRepository.appendOperatorContent("+")
        calculatorRepository.appendNumberContent("3")
        calculatorRepository.appendOperatorContent("-")
        calculatorRepository.appendNumberContent("5")

        //when
        val result = calculatorRepository.calculateContents()

        //then
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun calculateContentsWhenLastInputIsOperator() {
        //given
        calculatorRepository.appendNumberContent("1")
        calculatorRepository.appendOperatorContent("+")
        calculatorRepository.appendNumberContent("3")
        calculatorRepository.appendOperatorContent("-")

        //when
        //then
        assertThatIllegalArgumentException().isThrownBy {
            calculatorRepository.calculateContents()
        }
    }

    @Test
    fun getDisplayContents() {
        //given
        calculatorRepository.appendNumberContent("1")
        calculatorRepository.appendOperatorContent("+")
        calculatorRepository.appendNumberContent("3")
        calculatorRepository.appendOperatorContent("-")

        //when
        val displayContents = calculatorRepository.getDisplayContents()
        //then
        assertThat(displayContents).isEqualTo("1 + 3 - ")
    }
}
