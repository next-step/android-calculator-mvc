package edu.nextstep.camp.calculator

sealed class MainState {
    data class DisplayText(val displayText: String): MainState()
    data class ShowToast(val message: String): MainState()
}