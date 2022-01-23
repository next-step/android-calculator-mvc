package net.woogear.domain

class CalculatorManager {
    companion object {
        fun input(currentText: String, newText: String): String {
            if (currentText.isEmpty()) {
                return if (OperationType.isOperator(newText)) currentText else newText
            }

            if (OperationType.isOperator(newText)) {
                return inputOperator(currentText, newText)
            }

            val lastText = currentText.last().toString()
            val isLastTextInt = lastText.toIntOrNull() != null

            return if (isLastTextInt) "$currentText$newText" else "$currentText $newText"
        }

        private fun inputOperator(currentText: String, newText: String): String {
            val lastText = currentText.last().toString()

            if (OperationType.isOperator(lastText)) {
                return currentText.substring(0, currentText.lastIndex) + newText
            }

            return "$currentText $newText"
        }

        fun delete(currentText: String): String {
            if (currentText.isEmpty()) {
                return currentText
            }

            val subText = currentText.substring(0, currentText.lastIndex)

            return when {
                subText.isEmpty() -> subText
                subText.last().toString().isBlank() -> delete(subText)
                else -> subText
            }
        }

        fun isFormulaCompleted(currentText: String): Boolean {
            return when {
                currentText.isEmpty() -> false
                OperationType.isOperator(currentText.last().toString()) -> false
                else -> true
            }
        }
    }
}