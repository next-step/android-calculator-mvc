package net.woogear.domain

class FormulaManager(private var currentText: String = "") {

    fun input(newText: String): String {
        when {
            currentText.isEmpty() -> setTextForEmpty(newText)
            OperationType.isOperator(newText) -> setOperator(newText)
            else -> setTextToRight(newText)
        }

        return currentText
    }

    private fun setTextForEmpty(newText: String) {
        if (OperationType.isOperator(newText)) {
            return
        }

        currentText = newText
    }

    private fun setOperator(newText: String) {
        val lastText = currentText.last().toString()

        if (OperationType.isOperator(lastText)) {
            currentText = currentText.substring(0, currentText.lastIndex) + newText
            return
        }

        currentText = "$currentText $newText"
    }

    private fun setTextToRight(newText: String) {
        val lastText = currentText.last().toString()
        val isLastTextInt = lastText.toIntOrNull() != null

        if (isLastTextInt) {
            currentText = "$currentText$newText"
            return
        }

        currentText = "$currentText $newText"
    }

    fun delete(): String {
        if (currentText.isEmpty()) {
            return currentText
        }

        removeTextFromRight()

        return currentText
    }

    private fun removeTextFromRight() {
        currentText = currentText.substring(0, currentText.lastIndex)

        if (currentText.isEmpty()) {
            return
        }

        if (currentText.last().toString().isBlank()) {
            delete()
            return
        }
    }

    fun isFormulaCompleted(): Boolean {
        return when {
            currentText.isEmpty() -> false
            OperationType.isOperator(currentText.last().toString()) -> false
            else -> true
        }
    }
}