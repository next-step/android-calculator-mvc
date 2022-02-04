package com.example.domain


data class Expression(val value: String) {

    operator fun plus(express: Char): Expression {
        return when (express.isDigit()) {
            true -> copy(value = "$value$express")
            false -> copy(value = compareLastIndex(value, express))
        }
    }

    private fun compareLastIndex(value: String, char: Char): String {
        if (value.isBlank()) {
            return ""
        }
        return when (value.last() == ' ') {
            true -> "${value.dropLast(3)} $char "
            false -> "$value $char "
        }
    }


    fun removeLast(text: String): Expression {
        if (text.isBlank()) return EMPTY
        val numberSize = 1
        val operatorSize = 3
        return Expression(text.dropLast(
            text.last().toString()
                .toIntOrNull()?.let { numberSize } ?: operatorSize))
    }


    companion object {
        val EMPTY = Expression("")
    }
}