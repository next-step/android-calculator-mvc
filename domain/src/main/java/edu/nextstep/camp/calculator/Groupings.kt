package edu.nextstep.camp.calculator

object Groupings {

    private const val ASCII_ZERO = 48
    private const val ASCII_NINE = 57
    private const val ASCII_SPACE = 32
    private val ASCII_NUMBER_RANGE = ASCII_ZERO..ASCII_NINE

    fun numberGroup(formula: Formula): List<Double> {
        val (numberBuilder, numberGroup) =
            StringBuilder() to mutableListOf<Double>()
        formula.value.forEachIndexed { index, item ->
            when {
                index == formula.value.lastIndex -> {
                    numberBuilder.append(item)
                    numberGroup.add(numberBuilder.toString().toDouble())
                }
                item.code in ASCII_NUMBER_RANGE -> {
                    numberBuilder.append(item)
                }
                item.code == ASCII_SPACE -> return@forEachIndexed
                else -> {
                    numberGroup.add(numberBuilder.toString().toDouble())
                    numberBuilder.clear()
                }
            }
        }
        return numberGroup
    }

    fun operatorGroup(formula: Formula): List<Operator> {
        val operatorGroup = mutableListOf<Operator>()
        formula.value.forEach { item ->
            when (item.code) {
                in ASCII_NUMBER_RANGE,
                ASCII_SPACE -> return@forEach
                else -> operatorGroup.add(Operator.findBySymbol(item))
            }
        }
        return operatorGroup
    }
}
