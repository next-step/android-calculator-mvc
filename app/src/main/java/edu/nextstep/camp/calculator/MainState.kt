package edu.nextstep.camp.calculator

sealed class MainState {
    data class DisplayText(val displayText: String): MainState()
}