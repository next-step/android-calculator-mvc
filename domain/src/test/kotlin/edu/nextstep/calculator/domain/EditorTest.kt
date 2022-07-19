package edu.nextstep.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class EditorTest {
    private lateinit var editor: Editor

    @BeforeEach
    fun init() {
        editor = Editor()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "0", "2", "5", "8", "9"])
    fun `입력된 피연산자가 없을 때, 사용자가 피연산자 0 ~ 9를 입력하면 화면에 해당 숫자가 식에 입력된다`(content: String) {
        editor.input(content)
        assertThat(editor.expression).isEqualTo(content)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "0", "2", "5", "8", "9"])
    fun `입력된 피연산자가 있을 때, 기존 숫자 뒤에 해당 숫자가 식에 붙는다`(content: String) {
        editor.input("1")

        editor.input(content)
        assertThat(editor.expression).isEqualTo("1$content")
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `입력된 피연산자가 없을 때, 사용자가 연산자 덧셈,뺄셈,곱셈,나눗셈을 입력하면 식에 아무런 변화가 없다`(content: String) {
        editor.input(content)
        assertThat(editor.expression).isEqualTo("")
    }
}
