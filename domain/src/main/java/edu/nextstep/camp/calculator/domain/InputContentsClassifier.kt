package edu.nextstep.camp.calculator.domain

object InputContentsClassifier {

    fun makeInitialNumberWithOperationsFromContents(contents: String): Pair<Double, List<List<String>>> {
        val operationContents = contents.split(" ")

        val initialNumber = operationContents.first().toDouble()

        val operations = operationContents.mapIndexed { index, s ->
            when {
                index == 0 -> return@mapIndexed null
                isOddIndexNumber(index) -> return@mapIndexed listOf(operationContents[index], operationContents[index + 1])
            }

            return@mapIndexed null
        }.filterNotNull()

        return Pair(initialNumber, operations)
    }

    private fun isOddIndexNumber(index: Int): Boolean {
        return index % 2 == 1
    }
}
