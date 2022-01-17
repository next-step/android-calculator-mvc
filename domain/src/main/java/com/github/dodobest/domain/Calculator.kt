package com.github.dodobest.domain

class Calculator {

    fun evaluate(input: String): Double {
        // 띄어쓰기 없애기
        val inputString: String = eraseBlankAtString(input)

        // 숫자와 기호를 나누기
        val numAndSignArray: Array<String> = splitNumAndSign(inputString)

        // 문자열 계산하기
        val ans: Double = calculate(numAndSignArray)

        return ans
    }

    private fun eraseBlankAtString(inputString: String): String {
        return inputString.replace(" ", "")
    }

    private fun splitNumAndSign(inputString: String) : Array<String>{
        val arithmeticOperation: Array<Char> = arrayOf('+', '-', '*', '/') // 사칙연산을 저장한 배열 값

        var stringArray: Array<String> = emptyArray<String>() // 분리한 숫자와 문자를 저장할 변수
        var firstIdx: Int = -1 // 숫자를 나타내는 처음 Index 값
        var isMinusSign = false // 숫자가 음수인지 여부를 저장

        for(idx in 0 until inputString.length){
            // 숫자인 경우
            if (inputString[idx].code in '0'.code..'9'.code) {
                if (firstIdx == -1) {
                    // 0으로 시작하는 숫자를 입력한 경우 예외 처리
                    if (inputString[idx] == '0' && idx < inputString.length && inputString[idx+1].code in '0'.code..'9'.code) {
                        throw IllegalArgumentException("0으로 시작하는 숫자는 지원하지 않습니다.")
                    }
                    firstIdx = idx
                }
                // 연산 기호인 경우
            } else if (arithmeticOperation.contains(inputString[idx])) {
                // 음수 값이 입력으로 주어진 경우와 뺄셈을 구분해야 함
                if (inputString[idx] == '-') {
                    // '-' 기호가 연속으로 온 경우 예외 처리
                    if (isMinusSign) {
                        throw IllegalArgumentException("- 기호가 연속으로 입력되었습니다.")
                    } else if (firstIdx == -1) {
                        firstIdx = idx
                        isMinusSign = true
                    } else if (firstIdx != -1) {
                        stringArray += inputString.slice(IntRange(firstIdx, idx-1)) // 숫자
                        stringArray += inputString.slice(IntRange(idx, idx)) // 연산 기호
                        firstIdx = -1
                        isMinusSign = false
                    }
                } else if (firstIdx != -1) {
                    // '-' 와 다른 기호가 연속으로 온 경우 예외 처리
                    if (isMinusSign && (firstIdx == idx -1)) {
                        throw IllegalArgumentException("-기호와 다른 연산 기호가 연속으로 입력되었습니다.")
                        // '/' 뒤에 0을 입력한 경우 예외 처리
                    } else if (inputString[idx] == '/' && idx < inputString.length && inputString[idx+1] == '0') {
                        throw IllegalArgumentException("0으로 나누는 값은 존재하지 않습니다.")
                    }
                    stringArray += inputString.slice(IntRange(firstIdx, idx-1)) // 숫자
                    stringArray += inputString.slice(IntRange(idx, idx)) // 연산 기호
                    firstIdx = -1
                    isMinusSign = false
                    // 숫자 앞에 +를 붙인 경우 넘어가기 ex) 10 대신에 +10
                } else if (inputString[idx] == '+') {
                    continue
                    // 연산 기호가 연속으로 2개 오는 경우 예외 처리
                } else {
                    throw IllegalArgumentException("연산 기호가 연속으로 입력되었습니다.")
                }
            } else {
                throw IllegalArgumentException("사칙 연산 외 기호가 입력되었습니다.")
            }
        }

        // 마지막 숫자 값 더해주기
        if (firstIdx != -1) {
            stringArray += inputString.slice(IntRange(firstIdx, inputString.length-1))
            // 숫자 없이 연산 기호 만 입력 된 경우 예외 처리
        } else {
            throw IllegalArgumentException("연산에 적용될 숫자 값이 입력되지 않았습니다.")
        }

        // 빈 공백 문자를 입력한 경우 예외 처리
        if (inputString.equals("")) {
            throw IllegalArgumentException("빈 공백문자를 입력했습니다.")
        }

        return stringArray
    }

    private fun calculate(inputArray: Array<String>): Double {
        var sum: Double = inputArray[0].toDouble()
        var idx = 1

        while (idx < inputArray.size - 1) {
            val num: Double = inputArray[idx+1].toDouble()
            if (inputArray[idx] == "+") sum += num
            else if (inputArray[idx] == "-") sum -= num
            else if (inputArray[idx] == "*") sum *= num
            else if (inputArray[idx] == "/") sum /= num
            idx += 2
        }

        return sum
    }
}