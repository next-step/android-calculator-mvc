package edu.nextstep.camp.calculator.domain

enum class CalculateOrder {
    NUMBER_FIRST,
    NUMBER_SECOND,
    OPERATION;

    fun getNextCalculateOrder(): CalculateOrder {
        return when (this) {
            NUMBER_FIRST -> OPERATION
            OPERATION -> NUMBER_SECOND
            NUMBER_SECOND -> OPERATION
        }
    }
}
