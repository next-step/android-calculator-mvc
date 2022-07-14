package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.model.Operator
import edu.nextstep.camp.calculator.domain.model.Symbol

interface InputHandler {
    fun handleNumberInput(number: Int)

    fun handleOperatorInput(operator: Operator)

    fun handleSymbolInput(symbol: Symbol)
}
