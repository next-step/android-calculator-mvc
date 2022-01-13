package edu.nextstep.camp.calculator

object Calculator {
    private const val DELIMITER = " "

    fun calculate(input: String): Int {
        val words = input.trim().split(DELIMITER)
        val identity = words[0].toInt()
        return words.drop(1)
            .chunked(Operation.CHUNK_SIZE)
            .map(Operation.Companion::from)
            .fold(identity) { accumulated: Int, operation: Operation ->
                operation.calculate(accumulated)
            }
    }
}
