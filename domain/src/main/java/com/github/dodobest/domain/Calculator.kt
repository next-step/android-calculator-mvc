package com.github.dodobest.domain

enum class Operation (
    private val operation: String
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    fun getName() = operation
}

class Calculator {
    fun evaluate(input: String): Double {
        val inputString: String = eraseBlankAtString(input)

        require(inputString != "") { "빈 공백문자를 입력했습니다." }

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
            sum = calcWithOperation(sum, inputArray[idx], inputArray[idx+1].toDouble())
        }

        return sum
    }

    private fun calcWithOperation(sum: Double, operation: String, num: Double): Double {
        return when (convertToOperation(operation)) {
            Operation.PLUS -> sum + num
            Operation.MINUS -> sum - num
            Operation.MULTIPLY -> sum * num
            Operation.DIVIDE -> sum / num
        }
    }

    private fun updateFirstIndexOfNum(inputString: String, charIndex: Int, firstIndexOfNum: Array<Int>){
        if (firstIndexOfNum[0] != -1) {
            return
        }

        require(!checkNumStartWithZeroAndNotExactZero(inputString, charIndex)) { "0으로 시작하는 숫자는 지원하지 않습니다." }

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
        require(charIsOperation(inputString[charIndex])) { "사칙 연산 외 기호가 입력되었습니다." }

        require(charIndex != inputString.length - 1) { "사칙 연산 뒤에 값이 오지 않았습니다." }

        require(!isDivideWithZero(inputString, charIndex)) { "0으로 나누는 값은 존재하지 않습니다." }

        throwErrorIfOperationIsConsecutive(inputString, charIndex)
    }

    private fun convertToOperation(inputChar: String): Operation {
        return Operation.values().find{ it.getName() == inputChar }
            ?: throw IllegalArgumentException("사칙 연산이 아닌 문자열을 전달했습니다.")
    }

    private fun isNegativeSignNotMinusSign(inputChar: Char, firstIndexOfNum: Array<Int>): Boolean {
        return inputChar == '-' && firstIndexOfNum[0] == -1
    }

    private fun isDivideWithZero(inputString: String, charIndex: Int): Boolean {
        return inputString[charIndex] == '/' && inputString[charIndex+1] == '0'
    }

    private fun throwErrorIfOperationIsConsecutive(inputString: String, charIndex: Int) {
        if (!charIsOperation(inputString[charIndex+1])) {
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

        throw IllegalArgumentException("연산 기호가 연속으로 입력되었습니다.")
    }

    private fun checkOperationIsWhatExpect(inputString: String, charIndex: Int, firstOperation: Operation, secondOperation: Operation): Boolean {
        return inputString[charIndex].toString() == firstOperation.getName()
                && inputString[charIndex+1].toString() == secondOperation.getName()
    }

    fun charIsOperation(inputChar: Char): Boolean {
        return Operation.values().any{ it.getName() == inputChar.toString() }
    }
}