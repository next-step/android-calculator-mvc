package edu.nextstep.camp.calculator

sealed class MainEvent {
    data class AddNumber(val displayedText: String, val num: Int) : MainEvent()
    data class AddOperator(val displayedText: String, val operator: Char) : MainEvent()
    data class Evaluate(val displayedText: String) : MainEvent()
    data class DeleteLast(val displayedText: String) : MainEvent()
}
