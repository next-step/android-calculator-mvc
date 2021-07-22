package edu.nextstep.camp.domain.stringcalculator

/**
 * Created By Malibin
 * on 7월 22, 2021
 */

object StringTokens {
    fun from(string: String): List<String> = string.trim().split(DELIMITER)

    private const val DELIMITER = " "
}
