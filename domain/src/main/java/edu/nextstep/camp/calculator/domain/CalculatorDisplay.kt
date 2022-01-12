package edu.nextstep.camp.calculator.domain

class CalculatorDisplay {

    private var _displayString = ""
    val displayString: String get() = _displayString

    fun setDisplayStringFromNumber(number: Int) {
        _displayString = number.toString()
    }
}
