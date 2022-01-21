package com.lcw.study.nextstep.domain

enum class OperationType {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    NOTOPERATIONTYPE;

     fun checkOperationType(text: String): Boolean { //입력된 문자가 사칙 연산 기호인지 체크
        return text == "+" || text == "-" || text == "*" || text == "/"
    }

     fun changeTextToOperation(text: String):OperationType{
        when(text){
            "+"->return PLUS
            "-"->return MINUS
            "*"->return MULTIPLY
            "/"->return DIVIDE
        }
         return NOTOPERATIONTYPE
    }
}