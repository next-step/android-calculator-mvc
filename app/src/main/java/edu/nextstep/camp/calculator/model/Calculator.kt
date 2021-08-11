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

    fun calculate(): Double {
        val inputs = splitText()
        var result = inputs[0].toDouble()
        for(index in 1 until inputs.size step 2){
            if(Operator.PLUS.sign == inputs[index]){
                result = Operator.PLUS.formula(result, inputs[index+1].toDouble())
            }else if(Operator.MINUS.sign == inputs[index]){
                result = Operator.MINUS.formula(result, inputs[index+1].toDouble())
            }else if(Operator.MULTIPLY.sign == inputs[index]){
                result = Operator.MULTIPLY.formula(result, inputs[index+1].toDouble())
            }else if(Operator.DIVIDE.sign == inputs[index]){
                result = Operator.DIVIDE.formula(result, inputs[index+1].toDouble())
            }else {
                result =  0.0
            }
        }
        return result
    }
}