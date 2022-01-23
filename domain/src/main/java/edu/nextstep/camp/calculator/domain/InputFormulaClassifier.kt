package edu.nextstep.camp.calculator.domain

object InputFormulaClassifier {

    fun makeInitialOperandWithOperationsFromFormula(formula: String): DetachedOperation {
        val operationFormula = formula.split(" ")

        val initialOperand = operationFormula.first().toDouble()

        val operations = operationFormula.mapIndexed { index, s ->
            when {
                index == 0 -> return@mapIndexed null
                isOddIndexNumber(index) -> return@mapIndexed listOf(operationFormula[index], operationFormula[index + 1])
            }

            return@mapIndexed null
        }.filterNotNull()

        return DetachedOperation(initialOperand, operations)
    }

    private fun isOddIndexNumber(index: Int): Boolean {
        return index % 2 == 1
    }
}
