package edu.nextstep.camp.calculator

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.domain.Calculator
import com.example.domain.ExpressionUtils
import com.example.domain.Operation
import com.jakewharton.rxrelay3.PublishRelay
import com.jakewharton.rxrelay3.Relay

class MainViewModel() : ViewModel() {
    private val expressionUtils = ExpressionUtils()
    val expressionObservable = ObservableField<String>("")
    private val calculator = Calculator()

    val showToast: Relay<Boolean> = PublishRelay.create()

    fun onClickOperationBtn(operation: Operation) {
        expressionUtils.appendOperator(getSymbol(operation))
        expressionObservable.set(expressionUtils.getExpression())
    }

    fun onClickNumberBtn(num: Int) {
        expressionUtils.appendNumber(num.toString())
        expressionObservable.set(expressionUtils.getExpression())
    }

    fun onClickDeleteBtn() {
        expressionUtils.removeLast()
        expressionObservable.set(expressionUtils.getExpression())
    }

    fun onClickEqualBtn() {
        if (expressionUtils.endsWithOperator()) showToast.accept(true)
        else {
            val result = calculator.evaluate(expressionUtils.getExpression())
            expressionUtils.replaceToResult(result.toString())
            expressionObservable.set(result.toString())
        }
    }
}

enum class Operator(val symbol: String) {
    Add("+"), Subtract("-"), Multiply("×"), Divide("÷")
}

fun getSymbol(operator: Operation): String {
    return when (operator) {
        Operation.Add -> Operator.Add.symbol
        Operation.Divide -> Operator.Divide.symbol
        Operation.Multiply -> Operator.Multiply.symbol
        Operation.Subtract -> Operator.Subtract.symbol
    }
}
