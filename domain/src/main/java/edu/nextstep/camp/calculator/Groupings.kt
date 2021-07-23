package edu.nextstep.camp.calculator

object Groupings {

    private const val ASCII_ZERO = 48
    private const val ASCII_NINE = 57
    private const val ASCII_SPACE = 32
    private const val ASCII_PLUS = 43
    private const val ASCII_MINUS = 45
    private const val ASCII_MULTIPLE = 42
    private const val ASCII_DIVIDE = 47
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
                ASCII_PLUS,
                ASCII_MINUS,
                ASCII_MULTIPLE,
                ASCII_DIVIDE -> operatorGroup.add(Operator.findBySymbol(item))
                else -> return@forEach
            }
        }
        return operatorGroup
    }
}
