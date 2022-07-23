package edu.nextstep.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionManagerTest {
    private lateinit var editor: ExpressionManager

    @BeforeEach
    fun init() {
        editor = ExpressionManager()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "0", "2", "5", "8", "9"])
    fun `입력된 피연산자가 없을 때, 사용자가 피연산자 0 ~ 9를 입력하면 화면에 해당 숫자가 식에 입력된다`(content: String) {
        editor.input(content)
        assertThat(editor.getExpression()).isEqualTo(content)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "0", "2", "5", "8", "9"])
    fun `입력된 피연산자가 있을 때, 기존 숫자 뒤에 해당 숫자가 식에 붙는다`(content: String) {
        editor.input("1")

        editor.input(content)
        assertThat(editor.getExpression()).isEqualTo("1$content")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "0", "2", "5", "8", "9"])
    fun `입력된 수식의 마지막이 0일 때 숫자가 입력되면 0에서 입력된 숫자로 마지막 값이 바뀐다`(content: String) {
        editor.input("0")
        editor.input(content)
        assertThat(editor.getExpression()).isEqualTo(content)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `입력된 피연산자가 없을 때, 사용자가 연산자 덧셈,뺄셈,곱셈,나눗셈을 입력하면 식에 아무런 변화가 없다`(content: String) {
        editor.input(content)
        assertThat(editor.getExpression()).isEqualTo("")
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `입력된 피연산자가 있을 때, 사용자가 연산자 덧셈,뺄셈,곱셈,나눗셈을 입력하면 해당 기호가 식에 입력된다`(content: String) {
        editor.input("1")
        editor.input(content)
        assertThat(editor.getExpression()).isEqualTo("1 $content")
    }

    @Test
    fun `입력된 수식이 없을 때, 사용자가 지우기를 입력하면 식에 아무런 변화가 없다`() {
        editor.erase()
        assertThat(editor.getExpression()).isEqualTo("")
    }

    @Test
    fun `숫자 연산자인 식에 지우기를 입력하면 식에 숫자만 남는다`() {
        editor.input("1")
        editor.input("1")
        editor.input("+")
        editor.erase()
        assertThat(editor.getExpression()).isEqualTo("11")
    }

    @Test
    fun `숫자 연산자 숫자인 식에 지우기를 입력하면 식에 숫자 연산자가 남는다`() {
        editor.input("1")
        editor.input("1")
        editor.input("+")
        editor.input("1")
        editor.erase()
        print(editor.getExpression())
        assertThat(editor.getExpression()).isEqualTo("11 +")
    }

    @Test
    fun `입력된 수식이 비어있으면 false를 반환한다`() {
        assertThat(editor.isEnableCalculateExpression()).isEqualTo(false)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "0", "2", "5", "8", "9"])
    fun `입력된 수식이 숫자만 있으면 true를 반환한다`(content: String) {
        editor.input(content)
        assertThat(editor.isEnableCalculateExpression()).isEqualTo(true)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `입력된 수식의 마지막이 연산자라면 false를 반환한다`(content: String) {
        editor.input("1")
        editor.input(content)
        assertThat(editor.isEnableCalculateExpression()).isEqualTo(false)
    }

    @Test
    fun `입력된 수식의 숫자 연산자 숫자의 형식이라면 true를 반환한다`() {
        editor.input("1")
        editor.input("*")
        editor.input("1")
        editor.input("1")
        editor.input("*")
        editor.input("0")
        assertThat(editor.isEnableCalculateExpression()).isEqualTo(true)
    }
}
