package edu.nextstep.camp.calculator

object Calculator {
    fun calculate(input: String): Int {
        val list = input.split(" ")
        return list.subList(1, list.size)
            .chunked(2)
            .map { Pair(IntArithmetics.from(it[0]), it[1].toInt()) }
            .fold(list[0].toInt()) { acc, curr -> curr.first.apply(acc, curr.second) }
    }
}
