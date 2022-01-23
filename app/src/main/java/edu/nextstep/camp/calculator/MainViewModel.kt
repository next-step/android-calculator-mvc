package edu.nextstep.camp.calculator

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.domain.Calculator
import com.example.domain.ExpressionElement
import com.example.domain.Operand
import com.example.domain.Operation

class MainViewModel(): ViewModel() {
    val expression = ObservableField<String>("")
    private val calculator = Calculator()


    fun appendExpressionElement(element: ExpressionElement){
        val updatedExpression = expression.get() + when(element){
            is Operation.Add -> "+"
            is Operation.Subtract -> "-"
            is Operation.Multiply -> "×"
            is Operation.Divide -> "÷"
            is Operand -> element.value
        }
        expression.set(updatedExpression)
        expression.notifyChange()
    }

    fun onClickAddBtn(){
        appendExpressionElement(Operation.Add)
    }
    fun onClickOperationBtn(operation: Operation){
        appendExpressionElement(operation)
    }

    fun onClickNumberBtn(num: Int){
        expression.set(num.toString())
        expression.notifyChange()
    }

    fun onClickDeleteBtn(){

    }

    fun onClickEqualBtn(){
        calculator.evaluate(expression.get())
    }
}