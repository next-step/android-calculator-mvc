package com.github.dodobest.domain

enum class Operation (
    private val operation: String
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");
    companion object {
        fun charIsOperation(inputChar: Char): Boolean {
            return values().any{ it.getName() == inputChar.toString() }
        }

        fun convertToOperation(inputChar: String): Operation {
            return values().find{ it.getName() == inputChar }
                ?: throw IllegalArgumentException("[의도한 Exception]사칙 연산이 아닌 문자열을 전달했습니다.")
        }
    }

    fun getName() = operation
    fun calc(numOne:Double, numTwo: Double) = when (operation) {
        "+" -> numOne + numTwo
        "-" -> numOne - numTwo
        "*" -> numOne * numTwo
        "/" -> numOne / numTwo
        else -> throw IllegalArgumentException("[의도한 Exception]등록되지 않은 enum class 연산자 입니다")
    }
}

class Calculator {
    fun evaluate(input: String): Double {
        val inputString: String = eraseBlankAtString(input)

        require(inputString != "") { "[의도한 Exception]빈 공백문자를 입력했습니다." }

        return calculate(makeNumAndSingToArrayFromString(inputString))
    }

    private fun eraseBlankAtString(inputString: String): String {
        return inputString.replace(" ", "")
    }

    private fun makeNumAndSingToArrayFromString(inputString: String): MutableList<String> {
        val numAndSignArray: MutableList<String> = MutableList(0) { "" }
        val firstIndexOfNum: Array<Int> = arrayOf(-1)

        for (idx in inputString.indices) {
            numAndSignArray.addAll(splitNumAndSignFromString(inputString, idx, firstIndexOfNum))
        }
        numAndSignArray.add(inputString.slice(IntRange(firstIndexOfNum[0], inputString.length-1)))

        return numAndSignArray
    }

    private fun splitNumAndSignFromString(inputString: String, charIndex: Int, firstIndexOfNum: Array<Int>): MutableList<String> {
        if (checkCharIsNum(inputString[charIndex])) {
            updateFirstIndexOfNum(inputString, charIndex, firstIndexOfNum)
            return MutableList(0) { "" }
        }

        return checkArithmeticOperation(inputString, charIndex, firstIndexOfNum)
    }

    fun calculate(inputArray: List<String>): Double {
        var sum: Double = inputArray[0].toDouble()

        for (idx in 1 until inputArray.size step 2) {
            sum = Operation.convertToOperation(inputArray[idx]).calc(sum, inputArray[idx+1].toDouble())
        }

        return sum
    }

    private fun updateFirstIndexOfNum(inputString: String, charIndex: Int, firstIndexOfNum: Array<Int>){
        if (firstIndexOfNum[0] != -1) {
            return
        }

        require(!checkNumStartWithZeroAndNotExactZero(inputString, charIndex)) { "[의도한 Exception]0으로 시작하는 숫자는 지원하지 않습니다." }

        firstIndexOfNum[0] = charIndex
    }

    fun checkCharIsNum(charVal: Char): Boolean {
        if (charVal.code in '0'.code..'9'.code ) {
            return true
        }
        return false
    }

    private fun checkNumStartWithZeroAndNotExactZero(inputString: String, charIndex: Int): Boolean {
        return inputString[charIndex] == '0' && charIndex < inputString.length - 1 && checkCharIsNum(inputString[charIndex + 1])
    }

    private fun checkArithmeticOperation(inputString: String, charIndex: Int, firstIndexOfNum: Array<Int>): MutableList<String> {
        val numAndSignArray: MutableList<String> = MutableList(0) { "" }

        checkInputIsNotCorrect(inputString, charIndex)

        if (isNegativeSignNotMinusSign(inputString[charIndex], firstIndexOfNum)) {
            firstIndexOfNum[0] = charIndex
            return MutableList(0) { "" }
        }

        if (isPositiveSign(inputString[charIndex], firstIndexOfNum)) {
            return MutableList(0) { "" }
        }

        numAndSignArray.add(inputString.slice(IntRange(firstIndexOfNum[0], charIndex-1)))
        numAndSignArray.add(inputString[charIndex].toString())

        firstIndexOfNum[0] = -1

        return numAndSignArray
    }

    private fun isPositiveSign(inputChar: Char, firstIndexOfNum: Array<Int>): Boolean {
        return inputChar == '+' && firstIndexOfNum[0] == -1
    }

    private fun checkInputIsNotCorrect(inputString: String, charIndex: Int) {
        require(Operation.charIsOperation(inputString[charIndex])) { "[의도한 Exception]사칙 연산 외 기호가 입력되었습니다." }

        require(charIndex != inputString.length - 1) { "[의도한 Exception]사칙 연산 뒤에 값이 오지 않았습니다." }

        require(!isDivideWithZero(inputString, charIndex)) { "[의도한 Exception]0으로 나누는 값은 존재하지 않습니다." }

        throwErrorIfOperationIsConsecutive(inputString, charIndex)
    }

    private fun isNegativeSignNotMinusSign(inputChar: Char, firstIndexOfNum: Array<Int>): Boolean {
        return inputChar == '-' && firstIndexOfNum[0] == -1
    }

    private fun isDivideWithZero(inputString: String, charIndex: Int): Boolean {
        return inputString[charIndex] == '/' && inputString[charIndex+1] == '0'
    }

    private fun throwErrorIfOperationIsConsecutive(inputString: String, charIndex: Int) {
        if (!Operation.charIsOperation(inputString[charIndex+1])) {
            return
        }

        if (checkOperationIsWhatExpect(inputString, charIndex, Operation.MULTIPLY, Operation.PLUS)) {
            return
        }

        if (checkOperationIsWhatExpect(inputString, charIndex, Operation.MULTIPLY, Operation.MINUS)) {
            return
        }

        if (checkOperationIsWhatExpect(inputString, charIndex, Operation.DIVIDE, Operation.PLUS)) {
            return
        }

        if (checkOperationIsWhatExpect(inputString, charIndex, Operation.DIVIDE, Operation.MINUS)) {
            return
        }

        throw IllegalArgumentException("[의도한 Exception]연산 기호가 연속으로 입력되었습니다.")
    }

    private fun checkOperationIsWhatExpect(inputString: String, charIndex: Int, firstOperation: Operation, secondOperation: Operation): Boolean {
        return inputString[charIndex].toString() == firstOperation.getName()
                && inputString[charIndex+1].toString() == secondOperation.getName()
    }
}