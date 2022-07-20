package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import org.junit.Test

class ExpressionTest {
    @Test
    fun 빈_계산식은_0_으로_표시된다() {
        val expression = Expression()
        //then 0표시
        Truth.assertThat(expression.toString()).isEqualTo("0")
    }

    @Test
    fun 빈_계산식에_숫자를_추가할시_해당_숫자가_마지막에_추가된다() {
        val expression = Expression()
        //given 피연산자가 없을때
        //when 1추가
        expression.add('1')
        //then 1표시
        Truth.assertThat(expression.toString()).isEqualTo("1")
    }

    @Test
    fun 계산식에_숫자가_있을때_새로운_숫자를_추가할시_새로운_숫자가_마지막에_추가된다() {
        val expression = Expression()
        //given 1이 있을때
        expression.add('1')
        //when 2를 추가하면
        expression.add('2')
        //then 12로 표시된다.
        Truth.assertThat(expression.toString()).isEqualTo("12")
    }

    @Test
    fun 피연산자가_없는경우_연산자를_추가할_수_없다() {
        val expression = Expression()
        //given 아무 숫자도 없을때

        //when 연산자를 추가하면
        expression.add('+')
        //then 연산자가 추가 되지 않는다.
        Truth.assertThat(expression.toString()).isEqualTo("0")
    }

    @Test
    fun 마지막으로_추가된_것이_연산자일때_연산자를_추가하면_기존_연산자가_새로_추가된것으로_변경된다() {
        val expression = Expression()
        //given 1 + 일때
        expression.add('1')
        expression.add('+')
        Truth.assertThat(expression.toString()).isEqualTo("1 +")
        //when - 추가시
        expression.add('-')
        //then 1 - 으로 표현된다.
        Truth.assertThat(expression.toString()).isEqualTo("1 -")
    }

    @Test
    fun 입력된_수식은_뒤에서_부터_지워진다() {
        val expression = Expression()
        //given 1 + 13
        expression.add('1')
        expression.add('+')
        expression.add('1')
        expression.add('3')
        //when1 제거 요청시
        expression.removeLast()
        //then1 1 + 1 으로 표시된다.
        Truth.assertThat(expression.toString()).isEqualTo("1 + 1")
        //when2 마지막까지 제거 요청시
        expression.removeLast()
        expression.removeLast()
        expression.removeLast()
        //then2 빈계산식인 0 으로 표현된다.
        Truth.assertThat(expression.toString()).isEqualTo("0")
    }
    @Test
    fun 현재_수식이_완성되지_않았는지_알_수_있다() {
        val expression = Expression()
        //when 1 + 수식일때
        expression.add('1')
        expression.add('+')
        //then false를 리턴한다.
        Truth.assertThat(expression.isCompleted()).isEqualTo(false)
    }    @Test
    fun 현재_수식이_완성되었는지_알_수_있다() {
        val expression = Expression()
        //when 1 + 1 수식일때
        expression.add('1')
        expression.add('+')
        expression.add('1')
        //then true를 리턴한다.
        Truth.assertThat(expression.isCompleted()).isEqualTo(true)
    }

}
//('÷', '×', '-', '+')