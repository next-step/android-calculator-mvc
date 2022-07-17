package com.soolee.domain.util

class CalculatorInputUtil {
    companion object {
        fun isNumberRegex(text: String): Boolean {
            var regex = Regex("[0-9]")
            return (text.matches(regex))
        }
        fun isOperationMarkRegex(text:String):Boolean{
            var regex = Regex("[×÷+\\-]")
            return (text.matches(regex))
        }
    }
}