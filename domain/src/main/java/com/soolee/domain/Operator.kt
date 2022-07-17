package com.soolee.domain

enum class Operator(
    val operatorMark: String,
    val operator: (accumulated: Int, nextInt: Int) -> Int
) {
    NONE(
        operatorMark = "",
        operator =
        { accumulated, nextInt ->
            (accumulated.toString() + nextInt.toString()).toInt()
        }
    ),
    PLUS(
        operatorMark = "+",
        operator =
        { accumulated, nextInt ->
            accumulated + nextInt
        }
    ),
    MINUS(
        operatorMark = "-",
        operator =
        { accumulated, nextInt ->
            accumulated - nextInt
        }
    ),
    MUTIPLY(
        operatorMark = "×",
        operator =
        { accumulated, nextInt ->
            accumulated * nextInt
        }
    ),
    DIVIDE(
        operatorMark = "÷",
        operator =
        { accumulated, nextInt ->
            accumulated / nextInt
        }
    );

    companion object {
        fun getOperator(operatorMark: String): Operator = values()
            .first {
                it.operatorMark == operatorMark
            }

        fun getOperated(accumulated: Int, nextInt: Int, operatorMark: String): Int {
            return getOperator(operatorMark).operator(accumulated, nextInt)
        }
    }
}

