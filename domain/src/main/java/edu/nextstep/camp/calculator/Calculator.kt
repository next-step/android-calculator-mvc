package edu.nextstep.camp.calculator

object Calculator {

    fun calculate(formula: Formula): Double {
        val (numberGroup, operatorGroup) =
            Groupings.numberGroup(formula = formula) to Groupings.operatorGroup(formula = formula)
        var result = numberGroup.last()
        operatorGroup
            .zip(numberGroup.takeLast(numberGroup.lastIndex))
            .forEach {
                result = it.first.formula(result, it.second)
            }
        return result
    }
}
