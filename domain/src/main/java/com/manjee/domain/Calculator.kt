package com.manjee.domain

class Calculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("입력 값은 null 이거나 비어있을 수 없습니다")
        }

        return 246
    }
}