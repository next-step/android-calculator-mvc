package edu.nextstep.camp.calculator

private typealias Chunk = List<String>
private typealias ParsedChunk = Pair<IntArithmetics, Int>

object Calculator {
    private const val DELIMITER = " "
    private const val CHUNK_SIZE = 2

    fun calculate(input: String): Int {
        val (identity, words) = input.split(DELIMITER)
        return words.chunked(CHUNK_SIZE)
            .map { parse(it) }
            .fold(identity.toInt()) { acc, cur -> accumulate(acc, cur) }
    }

    private operator fun Chunk.component2(): List<String> = this.drop(1)

    private fun parse(chunk: Chunk): ParsedChunk {
        val arithmetic = IntArithmetics.from(chunk[0])
        val number = chunk[1].toInt()
        return Pair(arithmetic, number)
    }

    private fun accumulate(acc: Int, cur: ParsedChunk): Int {
        val arithmetic = cur.first
        val number = cur.second
        return arithmetic.apply(acc, number)
    }
}
