package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.exception.ExpressionNotCompleteException
import edu.nextstep.camp.calculator.domain.model.Input
import edu.nextstep.camp.calculator.domain.model.NumberInput
import edu.nextstep.camp.calculator.domain.model.OperatorInput
import edu.nextstep.camp.calculator.domain.model.OtherInput
import org.jetbrains.annotations.TestOnly

class InputController {
    private val inputList = mutableListOf<Input>()

    fun onReceiveInput(input: Input) : String {
        return when (input) {
            is OtherInput -> handleOtherInput(input)
            is OperatorInput -> handleOperatorInput(input)
            is NumberInput -> handleNumberInput(input)
            else -> throw IllegalArgumentException("Unknown Input Type")
        }
    }

    private fun handleNumberInput(input: NumberInput) : String {
        return inputList.run {
            add(input)
            toExpression()
        }
    }

    private fun handleOperatorInput(input: OperatorInput) : String {
        return inputList.run {
            if (inputList.lastOrNull() is NumberInput) add(input)
            else if (inputList.lastOrNull() is OperatorInput) inputList[inputList.lastIndex] = input
            toExpression()
        }
    }

    private fun handleOtherInput(input: OtherInput) : String {
        return when (input) {
            OtherInput.DEL -> inputList.run {
                removeLastOrNull()
                toExpression()
            }
            OtherInput.EQUALS -> evaluate()
            else -> throw IllegalArgumentException("Unknown Input")
        }
    }

    private fun evaluate(): String {
        val parsedStr = inputList.toExpression()
        if (!RegexUtils.checkExpressionIsValid(parsedStr)) {
            throw ExpressionNotCompleteException()
        }
        val result = Calculator.evaluate(parsedStr)
        inputList.clear()
        result.toString().forEach {
            inputList.add(Input.getFromValue(it.toString()))
        }

        return inputList.toExpression()
    }
    
    private fun List<Input>.toExpression() : String {
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
            operand.toString().forEach {
                inputList.add(Input.getFromValue(it.toString()))
            }
            operators.getOrNull(index)?.let {
                inputList.add(Input.getFromValue(it))
            }
        }
        return inputList.toExpression()
    }
}
