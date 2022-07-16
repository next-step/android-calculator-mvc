package edu.nextstep.camp.calculator.domain

/**
 * Created by link.js on 2022. 07. 14..
 */
object Splitter {
    private const val DEFAULT_DELIMITER = ' '

    fun splitByDelimiter(input: String, delimiter: Char = DEFAULT_DELIMITER): List<String> {
        return input.split(delimiter)
    }
}