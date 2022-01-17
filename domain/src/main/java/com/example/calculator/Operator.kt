package com.example.calculator

enum class Operator(val char: Char?) {
    NONE(null), PLUS('+'), MINUS('-'), MULTIPLY('*'), DIVIDE('/');

    companion object {
        fun get(value: Char): Operator {
            return values().firstOrNull { it.char == value } ?: NONE
        }
    }
}