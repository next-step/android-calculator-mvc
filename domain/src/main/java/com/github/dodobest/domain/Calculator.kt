package com.github.dodobest.domain

class Calculator {
    companion object {
        // 사칙 연산 기호
        const val PLUS: Char = '+'
        const val MINUS: Char = '-'
        const val MULTIPLY: Char = '*'
        const val DIVIDE: Char = '/'

        var firstNumIndex: Int = -1 // 숫자를 나타내는 처음 Index 값
        var isMinusSign = false // 숫자가 음수인지 여부를 저장
    }

    fun evaluate(input: String): Double {
        val numAndSignArray: MutableList<String> = MutableList<String>(0) { "" } // 분리한 숫자와 문자를 저장할 변수

        // 띄어쓰기 없애기
        val inputString: String = eraseBlankAtString(input)

        // 빈 공백 문자를 입력한 경우 예외 처리
        if (inputString.equals("")) {
            throw IllegalArgumentException("빈 공백문자를 입력했습니다.")
        }

        // 문자열로 부터 숫자, 사칙 연산을 분리해서 배열에 추가하기
        addNumAndSingToArrayFromString(inputString, numAndSignArray)

        // 문자열 계산
        return calculate(numAndSignArray)
    }

    private fun eraseBlankAtString(inputString: String): String {
        return inputString.replace(" ", "")
    }

    private fun addNumAndSingToArrayFromString(inputString: String, numAndSignArray: MutableList<String>) {
        for (idx in inputString.indices) {
            // 문자열로 부터 숫자와 문자를 분리하기
            splitNumAndSignFromString(inputString, idx, numAndSignArray)
        }

        // 마지막 숫자 값 더해주고, 정적 변수 초기화 하기
        numAndSignArray.add(inputString.slice(IntRange(firstNumIndex, inputString.length-1)))

        firstNumIndex = -1
        isMinusSign = false

    }

    private fun splitNumAndSignFromString(inputString: String, charIndex: Int, numAndSignArray: MutableList<String>) {
        // 숫자인 경우
        if (checkCharIsNum(inputString[charIndex])) {
            // 숫자를 나타내는 처음 Index 값 업데이트 하기
            updateFirstNumIndex(inputString, charIndex)
            return
        }

        // 연산 기호인 경우
        checkArithmeticOperation(inputString, charIndex, numAndSignArray)
    }

    private fun calculate(inputArray: List<String>): Double {
        var sum: Double = inputArray[0].toDouble()
        var idx = 1

        while (idx < inputArray.size - 1) {
            val num: Double = inputArray[idx+1].toDouble()

            sum = calcWithOperation(sum, inputArray[idx], num)
            idx += 2
        }
        return sum
    }

    private fun calcWithOperation(sum: Double, operation: String, num: Double): Double {
        if (operation == PLUS.toString()) {
            return sum + num
        }

        if (operation == MINUS.toString()) {
            return sum - num
        }

        if (operation == MULTIPLY.toString()) {
            return sum * num
        }

        if (operation == DIVIDE.toString()) {
            return sum / num
        }

        throw IllegalArgumentException("사칙연산 외 기호가 입력되었습니다.")
    }

    private fun updateFirstNumIndex(inputString: String, charIndex: Int){
        // 값을 나타내는 처음 숫자가 이미 있다면 업데이트 하지 않음
        if (firstNumIndex != -1) {
            return
        }

        // 값 '0'이 아닌 0으로 시작하는 숫자를 입력한 경우 예외 처리
        if (checkNumStartWithZeroAndNotExactZero(inputString, charIndex)) {
            throw IllegalArgumentException("0으로 시작하는 숫자는 지원하지 않습니다.")
        }
        firstNumIndex = charIndex
    }

    private fun checkCharIsNum(charVal: Char): Boolean {
        if (charVal.code in '0'.code..'9'.code ) {
            return true
        }
        return false
    }

    private fun checkNumStartWithZeroAndNotExactZero(inputString: String, charIndex: Int): Boolean {
        if (inputString[charIndex] == '0' && charIndex < inputString.length - 1 && checkCharIsNum(inputString[charIndex + 1])) {
            return true
        }
        return false
    }

    private fun checkArithmeticOperation(inputString: String, charIndex: Int, numAndSignArray: MutableList<String>) {
        val inputChar: Char = inputString[charIndex]

        // 사칙 연산 기호가 아닌 경우 IllegalArgumentException throw
        if (!charIsOperation(inputChar)) {
            throw IllegalArgumentException("사칙 연산 외 기호가 입력되었습니다.")
        }

        // 사칙 연산 뒤에 값이 오지 않는 경우 IllegalArgumentException throw
        if (charIndex == inputString.length - 1) {
            throw IllegalArgumentException("사칙 연산 뒤에 값이 오지 않았습니다.")
        }

        // 사칙 연산 기호가 연속으로 2개 이상 온 경우 IllegalArgumentException throw
        throwErrorIfOperationIsConsecutive(inputString, charIndex)

        // 음수를 나타내는 '-' 부호 인지 확인한다
        if (isNegativeSignNotMinusSign(inputChar)) {
            firstNumIndex = charIndex
            isMinusSign = true
            return
        }

        // 0으로 나누는 경우 IllegalArgumentException throw
        if (isDivideWithZero(inputString, charIndex)) {
            throw IllegalArgumentException("0으로 나누는 값은 존재하지 않습니다.")
        }

        // 숫자와 연산 기호 배열에 저장하고 정적 변수 초기화 하기
        if (firstNumIndex != -1) {
            numAndSignArray.add(inputString.slice(IntRange(firstNumIndex, charIndex-1))) // 숫자
            numAndSignArray.add(inputString.slice(IntRange(charIndex, charIndex))) // 연산 기호

            firstNumIndex = -1
            isMinusSign = false
        }
    }

    private fun isNegativeSignNotMinusSign(inputChar: Char): Boolean {
        if (inputChar == '-' && firstNumIndex == -1) {
            return true
        }
        return false
    }

    private fun isDivideWithZero(inputString: String, charIndex: Int): Boolean {
        if (inputString[charIndex] == '/' && inputString[charIndex+1] == '0') {
            return true
        }
        return false
    }

    private fun throwErrorIfOperationIsConsecutive(inputString: String, charIndex: Int) {
        // 다음 문자가 사칙 연산 기호가 아닌 경우
        if (!charIsOperation(inputString[charIndex+1])) {
            return
        }

        // 지금 문자가 '-'가 아니고 다음 문자가 '-'여서 음수를 나타내는 경우
        if (inputString[charIndex] != '-' && inputString[charIndex+1] == '-') {
            return
        }

        throw IllegalArgumentException("연산 기호가 연속으로 입력되었습니다.")
    }

    private fun charIsOperation(inputChar: Char): Boolean {
        val arithmeticOperation: Array<Char> = arrayOf(PLUS, MINUS, MULTIPLY, DIVIDE) // 사칙연산을 저장한 배열 값
        if (arithmeticOperation.contains(inputChar)) {
            return true
        }
        return false
    }
}