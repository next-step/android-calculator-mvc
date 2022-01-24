package com.example.calculator

enum class Operator(val char: Char?) : CalculateInterface {
    NONE(null) {
        override fun calculate(first: Int, second: Int): Int {
            return first
        }
    },
    PLUS('+') {
        override fun calculate(first: Int, second: Int): Int {
            return first + second
        }
    },
    MINUS('-') {
        override fun calculate(first: Int, second: Int): Int {
            return first - second
        }
    },
    MULTIPLY('×') {
        override fun calculate(first: Int, second: Int): Int {
            return first * second
        }
    },
    DIVIDE('÷') {
        override fun calculate(first: Int, second: Int): Int {
            return first / second
        }
    };

    companion object {
        fun get(value: Char): Operator {
            return values().firstOrNull { it.char == value } ?: NONE
        }
    }
}