package net.woogear.domain

class InputManager {
    companion object {
        fun input(currentText: String, newText: String): String {
            if (currentText.isEmpty()) {
                if (OperationType.isOperator(newText)) {
                    return currentText
                }

                return newText
            }

            if (OperationType.isOperator(newText)) {
                return "$currentText $newText"
            }

            val lastText = currentText.last().toString()
            val isLastTextInt = lastText.toIntOrNull() != null
            return if (isLastTextInt) "$currentText$newText" else "$currentText $newText"
        }
    }
}