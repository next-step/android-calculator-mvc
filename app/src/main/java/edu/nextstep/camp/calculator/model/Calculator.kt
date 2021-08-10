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

    fun isSplitLengthOddNumber(): Boolean {
        return splitText().size % 2 == 1
    }

    fun calcurate(): Double {
        val inputs = splitText()
        if(Operator.PLUS.sign == inputs[1]){
            return Operator.PLUS.formula(inputs[0].toDouble(), inputs[2].toDouble())
        }else if(Operator.MINUS.sign == inputs[1]){
            return Operator.MINUS.formula(inputs[0].toDouble(), inputs[2].toDouble())
        }else if(Operator.MULTIPLY.sign == inputs[1]){
            return Operator.MULTIPLY.formula(inputs[0].toDouble(), inputs[2].toDouble())
        }else if(Operator.DIVIDE.sign == inputs[1]){
            return Operator.DIVIDE.formula(inputs[0].toDouble(), inputs[2].toDouble())
        }else {
            return 0.0
        }
    }
}