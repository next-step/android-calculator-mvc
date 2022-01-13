package edu.nextstep.camp.calculator

data class Operation private constructor(
    private val arithmetic: IntArithmetics,
    private val number: Int
) {
    private constructor(arithmetic: String, number: String) : this(
        IntArithmetics.from(arithmetic),
        number.toInt()
    )

    fun calculate(accumulated: Int): Int = arithmetic.apply(accumulated, number)

    companion object {
        const val CHUNK_SIZE = 2

        fun from(chunk: List<String>): Operation {
            if(chunk.size != CHUNK_SIZE) {
                throw IllegalArgumentException("완전하지 않은 계산식입니다.")
            }
            val (arithmetic, number) = chunk
            return Operation(arithmetic, number)
        }
    }
}
