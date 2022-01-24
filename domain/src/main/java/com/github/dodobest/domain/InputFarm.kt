package com.github.dodobest.domain

class InputFarm {
    private val calculator = Calculator()
    private val numAndSignArray: MutableList<String> = MutableList(0) { "" }
    private val arraySize: Int get() = numAndSignArray.size

    fun handleInputArithmetic(inputOperation: String) {
        if (arraySize == 0) return

        if (Operation.charIsOperation(numAndSignArray.last().toCharArray().last())) {
            numAndSignArray[arraySize - 1] = inputOperation
            return
        }

        numAndSignArray.add(inputOperation)
    }

    fun handleInputNum (inputNum: String) {
        if (arraySize > 0 && calculator.checkCharIsNum(numAndSignArray.last().toCharArray().last())) {
            numAndSignArray[arraySize-1] = (numAndSignArray.last().toInt() * 10 + inputNum.toInt()).toString()
            return
        }
        numAndSignArray.add(inputNum)
    }

    fun getString(): String {
        return numAndSignArray.joinToString("")
    }

    fun handleInputDelete() {
        if (arraySize == 0) return

        if (numAndSignArray.last().length > 1) {
            numAndSignArray[arraySize-1] = (numAndSignArray.last().toDouble().toInt() / 10 ).toString()
            return
        }

        numAndSignArray.removeLast()
    }

    fun checkExpressionCanCalculated(): Boolean {
        if (Operation.charIsOperation(numAndSignArray.last().toCharArray().last())) {
            return false
        }
        return true
    }

    fun handleEquals(){
        val res: String = calculator.calculate(numAndSignArray).toString()

        numAndSignArray.clear()
        numAndSignArray.add(res)
    }
}