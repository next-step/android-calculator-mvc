package edu.nextstep.camp.calculator

object OperatorDisplay {

    fun print(beforeText: CharSequence, operator: Operator) = when {
        beforeText.isEmpty() -> ""
        Operator.findBySymbol(beforeText.last()) != Operator.NONE ->
            String.format("%s%s", beforeText.dropLast(1), operator.symbol)
        else -> String.format("%s%s", beforeText, operator.symbol)
    }
}
