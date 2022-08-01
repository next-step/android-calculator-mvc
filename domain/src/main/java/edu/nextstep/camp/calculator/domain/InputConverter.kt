package edu.nextstep.camp.calculator.domain

class InputConverter {

    private val _token = mutableListOf<Token>()
    val token get() = _token as List<Token>

    fun add(input: String) {
        when (val token: Token = TokenFactory(input)) {
            is Operand -> addOperand(token)
            is Operator -> addOperator(token)
        }
    }

    private fun addOperand(operand: Operand) {
        if (token.isEmpty() || token.last() is Operator) {
            _token.add(operand)
            return
        }
        val lastOperand = _token.removeLast() as Operand
        _token.add(lastOperand.merge(operand))
    }

    private fun addOperator(operator: Operator) {
        if (token.isEmpty()) {
            return
        }
        if (token.last() is Operator) {
            _token.removeLast()
        }
        _token.add(operator)
    }

    fun clearAndAddResult(result: Int) {
        _token.clear()
        _token.add(result.toOperand())
    }

    fun delete() {
        if (token.isEmpty()) {
            return
        }
        when (val lastToken = token.last()) {
            is Operator -> _token.removeLast()
            is Operand -> deleteOperand(lastToken)
        }
    }

    private fun deleteOperand(lastToken: Operand) {
        _token.removeLast()
        if (lastToken.operand > 10) {
            _token.add(lastToken.deleteLast())
        }
    }

    private fun Operand.merge(operand: Operand) =
        Operand("${this.operand}${operand.operand}".toInt())

    private fun Operand.deleteLast() = Operand(this.operand / 10)

    private fun Int.toOperand() = Operand(this)
}
