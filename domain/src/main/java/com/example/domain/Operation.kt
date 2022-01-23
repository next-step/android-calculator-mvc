package com.example.domain

enum class Operation {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    NOT_OPERATION_TYPE;

    fun checkOperationType(text: String): Boolean { //입력된 문자가 사칙 연산 기호인지 체크
        return text == "+" || text == "-" || text == "*" || text == "/"
    }

    fun changeTextToOperation(text: String):Operation {
        when(text){
            "+"->return PLUS
            "-"->return MINUS
            "*"->return MULTIPLY
            "/"->return DIVIDE
        }
        return NOT_OPERATION_TYPE
    }
}