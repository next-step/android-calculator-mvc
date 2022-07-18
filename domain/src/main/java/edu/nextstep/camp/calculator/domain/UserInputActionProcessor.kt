package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.exception.ExpressionNotCompleteException
import edu.nextstep.camp.calculator.domain.model.Operand
import edu.nextstep.camp.calculator.domain.model.Operator
import edu.nextstep.camp.calculator.domain.model.UserInputAction
import edu.nextstep.camp.calculator.domain.model.OtherInputAction
import org.jetbrains.annotations.TestOnly

class UserInputActionProcessor {
    private val userInputActionList = mutableListOf<UserInputAction>()

    fun processUserInputAction(userInputAction: UserInputAction) : String {
        return when (userInputAction) {
            is OtherInputAction -> processOtherInput(userInputAction)
            is Operator -> processOperatorInput(userInputAction)
            is Operand -> processNumberInput(userInputAction)
            else -> throw IllegalArgumentException("Unknown Input Type")
        }
    }

    private fun processNumberInput(input: Operand) : String {
        return userInputActionList.run {
            add(input)
            toExpression()
        }
    }

    private fun processOperatorInput(input: Operator) : String {
        return userInputActionList.run {
            if (lastOrNull() is Operand) add(input)
            else if (lastOrNull() is Operator) this[lastIndex] = input
            toExpression()
        }
    }

    private fun processOtherInput(input: OtherInputAction) : String {
        return when (input) {
            OtherInputAction.DEL -> userInputActionList.run {
                removeLastOrNull()
                toExpression()
            }
            OtherInputAction.EQUALS -> evaluate()
            else -> throw IllegalArgumentException("Unknown Input")
        }
    }

    private fun evaluate(): String {
        val parsedStr = userInputActionList.toExpression()
        if (!RegexUtils.checkExpressionIsValid(parsedStr)) {
            throw ExpressionNotCompleteException()
        }
        val result = Calculator.evaluate(parsedStr)
        userInputActionList.clear()
        result.toString().forEach {
            userInputActionList.add(UserInputAction.getFromValue(it.toString()))
        }

        return userInputActionList.toExpression()
    }
    
    private fun List<UserInputAction>.toExpression() : String {
        val sb = StringBuilder()
        forEach {
            sb.append(it.value)
        }
        return sb.toString()
    }

    @TestOnly
    fun setCurrentDisplayedText(displayedText: String) : String{
        userInputActionList.clear()
        val operands = RegexUtils.getOperandsList(displayedText)
        val operators = RegexUtils.getOperatorsList(displayedText)
        operands.forEachIndexed { index, operand ->
            operand.toString().forEach {
                userInputActionList.add(UserInputAction.getFromValue(it.toString()))
            }
            operators.getOrNull(index)?.let {
                userInputActionList.add(UserInputAction.getFromValue(it))
            }
        }
        return userInputActionList.toExpression()
    }
}
