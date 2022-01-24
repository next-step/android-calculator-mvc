package edu.nextstep.camp.calculator

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.domain.Calculator
import com.example.domain.ExpressionElement
import com.example.domain.Operand
import com.example.domain.Operation
import com.jakewharton.rxrelay3.PublishRelay
import com.jakewharton.rxrelay3.Relay

class MainViewModel() : ViewModel() {
    val expression = ObservableField<String>("")
    private val calculator = Calculator()
    private val operatorCharList = listOf<Char>('+', '-', '×', '÷')

    val showToast: Relay<Boolean> = PublishRelay.create()

    fun appendExpressionElement(element: ExpressionElement, putSpace: Boolean = true) {
        val updatedExpression = expression.get() + (if (putSpace) " " else "") + when (element) {
            is Operation.Add -> "+"
            is Operation.Subtract -> "-"
            is Operation.Multiply -> "×"
            is Operation.Divide -> "÷"
            is Operand -> element.value
        }
        expression.set(updatedExpression)
        expression.notifyChange()
    }

    fun onClickOperationBtn(operation: Operation) {
        if (expression.get()?.isEmpty() == false) appendExpressionElement(operation)
    }

    fun onClickNumberBtn(num: Int) {
        when {
            operatorCharList.contains(expression.get()?.lastOrNull()) -> appendExpressionElement(Operand(num))
            expression.get()?.isEmpty() == true -> appendExpressionElement(Operand(num), putSpace = false)
            expression.get()?.lastOrNull()?.isDigit() == true -> appendExpressionElement(Operand(num), putSpace = false)
        }
    }

    fun onClickDeleteBtn() {
        if (expression.get().isNullOrEmpty().not()) truncateExpression()
    }

    fun truncateExpression() {
        val truncatedExpression = expression.get()?.dropLast(1)
        if (truncatedExpression?.last()?.isWhitespace() == true) expression.set(truncatedExpression.dropLast(1))
        else expression.set(truncatedExpression)
        expression.notifyChange()
    }

    fun onClickEqualBtn() {
        if (expression.get()?.last()?.isDigit()?.not() == true) {
            showToast.accept(true)
        } else {
            val result = calculator.evaluate(expression.get())
            expression.set(result.toString())
        }
    }
}
