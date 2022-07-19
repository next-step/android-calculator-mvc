package edu.nextstep.camp.calculator

import androidx.lifecycle.MutableLiveData
import edu.nextstep.camp.calculator.domain.Calculator

//logic
class MainActivityViewModel {
    val viewState: MutableLiveData<MainState> = MutableLiveData(MainState.DisplayText(""))

    fun onEvent(event: MainEvent) {
        when(event) {
            is MainEvent.DeleteLast -> eventDeleteLast(event)
            is MainEvent.AddOperator -> eventAddOperator(event)
            is MainEvent.AddNumber -> eventAddNumber(event)
            is MainEvent.Evalute -> eventEvalute(event)
        }
    }

    private fun eventDeleteLast(event: MainEvent.DeleteLast) {
        val text = deleteLastOperatorOrNumber(event.displayedText)
        viewState.value = MainState.DisplayText(text)
    }

    private fun eventAddOperator(event: MainEvent.AddOperator) {
        val lastChar = event.displayedText.getOrNull(event.displayedText.lastIndex) ?: return
        val displayedText = when(lastChar.isDigit()) {
            true -> event.displayedText
            false -> deleteLastOperatorOrNumber(event.displayedText)
        }

        val text = "$displayedText ${event.operator}"
        viewState.value = MainState.DisplayText(text)
    }

    private fun eventEvalute(event: MainEvent.Evalute) {
        runCatching {
            Calculator().evalute(event.displayedText)
        }.onSuccess {
            viewState.value = MainState.DisplayText(getEvalutedDisplayText(it))
        }.onFailure {
            viewState.value = MainState.ShowToast("${it.message}")
        }
    }

    private fun eventAddNumber(event: MainEvent.AddNumber) {
        viewState.value = MainState.DisplayText(getNumberAddedDisplayText(event))
    }

    private fun deleteLastOperatorOrNumber(displayedText: String) = displayedText
        .dropLastWhile { it == ' ' || it == '.' }
        .dropLast(1)
        .dropLastWhile { it == ' ' || it == '.' }

    private fun getEvalutedDisplayText(computed: Double): String = when(computed - computed.toInt()) {
        0.0 -> "${computed.toInt()}"
        else -> "$computed"
    }

    private fun getNumberAddedDisplayText(
        event: MainEvent.AddNumber,
    ) : String {
        val displayedText = event.displayedText
        val addedNumber = event.num
        val lastChar: Char? = displayedText.getOrNull(displayedText.lastIndex)
        return when {
            displayedText == "0" -> "$addedNumber"
            lastChar == null -> "$addedNumber"
            lastChar.isDigit() -> "$displayedText$addedNumber"
            lastChar == ' ' -> "$displayedText$addedNumber"
            else -> "$displayedText $addedNumber"
        }
    }
}