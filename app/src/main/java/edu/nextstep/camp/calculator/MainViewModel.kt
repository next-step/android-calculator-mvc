package edu.nextstep.camp.calculator

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.domain.Calculator
import com.example.domain.ExpressionElement
import com.example.domain.Operand
import com.example.domain.Operation

class MainViewModel() : ViewModel() {
    val expression = ObservableField<String>("")
    private val calculator = Calculator()
    private val operatorCharList = listOf<Char>('+', '-', '×', '÷')

    fun appendExpressionElement(element: ExpressionElement, putSpace: Boolean = true) {
        val updatedExpression = expression.get() + (if(putSpace) " " else "") + when (element) {
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
        appendExpressionElement(operation)
    }

    fun onClickNumberBtn(num: Int) {
        when {
            operatorCharList.contains(expression.get()?.lastOrNull()) -> {
                appendExpressionElement(Operand(num))
            }
            expression.get()?.isEmpty() == true -> {
                appendExpressionElement(Operand(num), putSpace = false)
            }
            expression.get()?.lastOrNull()?.isDigit() == true -> {
                appendExpressionElement(Operand(num), putSpace = false)
            }
        }
    }

    fun onClickDeleteBtn() {
    }

    fun onClickEqualBtn() {
        calculator.evaluate(expression.get())
    }
}
