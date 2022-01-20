package edu.nextstep.camp.calculator

import android.widget.TextView
import androidx.core.text.isDigitsOnly
import com.nextstep.domain.Calculator

class Expression {
    private val calculator by lazy { Calculator() }

    fun calculatedValue(view: TextView): String {
        return calculator.calculate(replaceOperator(view.text.toString())).toString()
    }

    private fun replaceOperator(str: String) = str.replaceMultiply().replaceDivide()
    private fun String.replaceMultiply() = this.replace("×", "*")
    private fun String.replaceDivide() = this.replace("÷", "/")

    fun appendStatement(view: TextView, input: String): String {
        val trimmedString = view.text.toString().trim()
        return if (trimmedString.isEmptyOrDigit(input)) {
            "$trimmedString$input"
        } else {
            "$trimmedString $input"
        }
    }

    private fun String.isEmptyOrDigit(input: String) =
        this.isEmpty() || (this.last().isDigit() && input.isDigitsOnly())

    fun deleteLastElement(view: TextView) = view.text.toString().dropLast(1).trim()
}