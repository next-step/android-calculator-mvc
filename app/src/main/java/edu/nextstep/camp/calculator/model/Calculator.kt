package edu.nextstep.camp.calculator.model

class Calculator(var inputs : String) {
    companion object {
        private const val INDEX_INITIAL = 0
        private const val ASCII_ZERO = 48
        private const val ASCII_NINE = 57
    }

    fun splitText(): List<String> {
        return inputs.split(" ")
    }

    fun isNumber(text : String): Boolean {
        return text.elementAt(INDEX_INITIAL).toInt() in ASCII_ZERO..ASCII_NINE
    }

    fun isSplitLengthOperator(): Boolean {
        return splitText().size % 2 == 1
    }

    fun calculate(): Double {
        val splits = splitText()
        var calculateSum = splits[0].toDouble()
        for(index in 1 until splits.size step 2){
            val operator = Operator.of(splits[index])
            calculateSum = operator.formula(calculateSum, splits[index+1].toDouble())
        }
        return calculateSum
    }
}