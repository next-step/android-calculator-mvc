package edu.nextstep.camp.calculator.model

class Calculator(var inputs : String) {
    companion object {
        private const val INDEX_INITIAL = 0
        private const val ASCII_ZERO = 48
        private const val ASCII_NINE = 57
    }

    fun splitText(): List<String> {
        var splits = inputs.split(" ")
        if(splits.size <= 1){
            throw IllegalArgumentException("문자열 계산을 할 수 없습니다.")
        }
        splits.forEachIndexed{index, text ->
            if(index % 2 == 0 && !isNumber(text)){
                throw IllegalArgumentException("숫자를 입력해주세요.")
            }
            if(index % 2 == 1 && Operator.of(text) == null){
                throw IllegalArgumentException("올바른 연산자 부호를 입력해주세요.")
            }
        }
        return splits
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
            operator?.let {
                calculateSum = operator.formula(calculateSum, splits[index+1].toDouble())
            }
        }
        return calculateSum
    }
}