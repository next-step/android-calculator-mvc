package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

/**
 * Expression클래스 테스트
 * Created by jeongjinhong on 2022. 07. 19..
 */
class ExpressionTest() {
    lateinit var expressionTool: Expression

    @Before
    fun setUp() {
        expressionTool = Expression()
    }

    @Test
    fun 피연산자가_없을_때_피연산자를_추가하면_표현식에_피연산자가_추가된다() {
        //when:
        val result = expressionTool.addOperand(1)
        //then:
        Truth.assertThat(result).isEqualTo("1")
    }

    @Test
    fun 추가된_연산자가_있을_때_피연산자를_추가하면_표현식에_피연산자가_추가된다() {
        //given:
        expressionTool.addOperand(1)
        expressionTool.addOperator("+")
        //when:
        val result = expressionTool.addOperand(1)
        //then:
        Truth.assertThat(result).isEqualTo("1 + 1")
    }

    @Test
    fun 추가된_피연산자가_있을_때_피연산자를_추가하면_표현식에_피연산자가_추가된다() {
        //given:
        expressionTool.addOperand(1)
        //when:
        val result = expressionTool.addOperand(1)
        //then:
        Truth.assertThat(result).isEqualTo("11")
    }

    @Test
    fun 추가된_피연산자가_없을_때_연산자를_추가하면_표현식에_아무런_변화가_없어야_한다() {
        //given:
        //when:
        val result = expressionTool.addOperator("+")
        //then:
        Truth.assertThat(result).isEqualTo("")
    }

    @Test
    fun 추가된_피연산자가_있을_때_연산자를_추가하면_표현식에_해당_연산자가_추가된다() {
        //given:
        expressionTool.addOperand(1)
        //when:
        val result = expressionTool.addOperator("+")
        //then:
        Truth.assertThat(result).isEqualTo("1 +")
    }

    @Test
    fun 추가된_수식이_없을_떼_삭제를_하면_표현식에_아무런_변화가_없어야_한다() {
        //given:
        //when:
        val result = expressionTool.delete()
        //then:
        Truth.assertThat(result).isEqualTo("")
    }

    @Test
    fun 추가된_연산자가_있을_때_삭제를_하면_해당_연산자가_삭제되어야_한다() {
        //given:
        expressionTool.addOperand(1)
        expressionTool.addOperator("+")
        //when:
        val result = expressionTool.delete()
        //then:
        Truth.assertThat(result).isEqualTo("1")
    }

    @Test
    fun 추가된_피연산자가_있을_때_삭제를_하면_해당_피연산자가_삭제되어야_한다() {
        //given:
        expressionTool.addOperand(1)
        expressionTool.addOperand(1)
        //when:
        val result = expressionTool.delete()
        //then:
        Truth.assertThat(result).isEqualTo("1")
    }

    @Test
    fun 값을_초기화하면_해당값으로_표현식이_세팅되어야한다() {
        //given:
        //when:
        expressionTool.initializeValue(3.3)
        //then:
        Truth.assertThat(expressionTool.expression).isEqualTo("3.3")
    }

}