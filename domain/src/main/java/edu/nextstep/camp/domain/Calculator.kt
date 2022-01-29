package edu.nextstep.camp.domain

object Calculator {

    private const val IS_NOT_OR_BLANK: String = "입력값이 null 이거나 빈 공백 문자입니다."
    private const val DELIMITER: String = " "

    fun calculate(input: String?): String {

        validateNullOrEmpty(input)

        val splitStrings = splitInputStr(input!!)
        var result: Int = splitStrings[0].toInt()

        splitStrings.forEachIndexed { i, _ ->
            if (i % 2 == 1) {
                val param = splitStrings[i + 1].toInt()
                val operator = Operator.operationEnum(splitStrings[i])
                result = operator.execute(result, param)
            }
        }
        return result.toString()
    }

    private fun validateNullOrEmpty(input: String?) {
        require(!input?.trim().isNullOrEmpty()) { IS_NOT_OR_BLANK }
    }

    private fun splitInputStr(input: String): List<String> = input.split(DELIMITER)

    fun getStringIsNotOrBlank(): String {
        return IS_NOT_OR_BLANK
    }
}