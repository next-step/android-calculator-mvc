package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.model.Input

interface InputHandler {
    fun handleInput(input: Input)
}
