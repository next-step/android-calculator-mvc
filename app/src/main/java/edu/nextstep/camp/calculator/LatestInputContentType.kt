package edu.nextstep.camp.calculator

enum class LatestInputContentType {
    NONE,
    NUMBER,
    OPERATOR;

    companion object {
        fun getLatestInputContentType(contentList: List<String>): LatestInputContentType {
            if (contentList.isEmpty()) {
                return NONE
            }

            val latestInput = contentList.last()

            if (latestInput.length == LENGTH_NUMBER_CONTENT) {
                return NUMBER
            }

            if (latestInput.length == LENGTH_OPERATOR_CONTENT) {
                return OPERATOR
            }

            throw IllegalArgumentException()
        }

        private const val LENGTH_NUMBER_CONTENT = 1
        private const val LENGTH_OPERATOR_CONTENT = 3
    }
}
