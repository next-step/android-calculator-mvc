package edu.nextstep.camp.calculator.domain

/**
 * Created by link.js on 2022. 07. 14..
 */
object Splitter {
    private const val DELIMITER = " "

    fun splitByDelimiter(input: String): List<String> {
        return input.split(DELIMITER)
    }
}