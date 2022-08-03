package edu.nextstep.camp.caculator.domain

class Expression (private val expressionString: String) {
    private val expressionList = mutableListOf<String>()

    init {
        setExpression(this.expressionString)
    }

    fun getExpressionList(): List<String> = expressionList

    private fun setExpression(expressionString: String) {
        require(expressionString.isNotEmpty()) {"Expression is empty"}

        expressionString.split(' ').map {
            if (it.isNotEmpty() && (AVAILABLE_INPUT_VALUES.contains(it) || AVAILABLE_INPUT_OPERATORS.contains(it))) {
                expressionList.add(it)
            } else {
                throw IllegalArgumentException("There is a wrong expression")
            }
        }
    }

    companion object {
        const val AVAILABLE_INPUT_VALUES = "0123456789"
        const val AVAILABLE_INPUT_OPERATORS = "+-/*"
    }
}