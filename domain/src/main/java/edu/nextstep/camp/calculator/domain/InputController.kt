package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.model.ExpressionElement
import edu.nextstep.camp.calculator.domain.model.Operand
import edu.nextstep.camp.calculator.domain.model.Operator
import edu.nextstep.camp.calculator.domain.model.Symbol
import org.jetbrains.annotations.TestOnly

class InputController {
    private val inputList = mutableListOf<ExpressionElement>()

    fun onReceiveInput(symbol: Symbol) : String {
        return when (symbol) {
            Symbol.DEL -> {
                inputList.removeLastOrNull()
                inputList.toExpression()
            }
            Symbol.EQUALS -> {
                evaluate()
            }
        }
    }

    fun onReceiveInput(element: ExpressionElement) : String {
        return inputList.run {
            add(element)
            toExpression()
        }
    }

    private fun evaluate(): String {
        val parsedStr = inputList.toExpression()
        inputList.clear()
        inputList.add(Operand(Calculator.evaluate(parsedStr)))

        return inputList.toExpression()
    }
    
    private fun List<ExpressionElement>.toExpression() : String {
        val sb = StringBuilder()
        forEach {
            sb.append(it.value)
        }
        return sb.toString()
    }

    @TestOnly
    fun setCurrentDisplayedText(displayedText: String) : String{
        inputList.clear()
        val operands = RegexUtils.getOperandsList(displayedText)
        val operators = RegexUtils.getOperatorsList(displayedText)
        operands.forEachIndexed { index, operand ->
            inputList.add(Operand(operand))
            operators.getOrNull(index)?.let {
                inputList.add(Operator.getFromRaw(it))
            }
        }
        return inputList.toExpression()
    }
}
