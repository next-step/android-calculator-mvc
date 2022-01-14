package com.github.dodobest.domain

import kotlin.random.Random

class Calculator {

    fun evaluate(inputString: String): Double {
        /*
            고려 사항
            1. 숫자의 자릿수를 모르기 때문에 사칙연산을 만나기 전까지를 숫자로 지칭(사칙연산이 아닌 기호가 들어갈 수 있음)
            2. 사용자가 사칙연산을 입력할때 뛰어쓰기를 할 수도 있고 안 할수도 있음
        */

        var inputString = inputString.replace(" ", "")
        var res = 0

        return 0.0
    }
}