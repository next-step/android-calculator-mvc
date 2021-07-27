package edu.nextstep.camp.calculator

class Formula(val value: String) {

    init {
        require(
            Groupings.numberGroup(this).size == Groupings.operatorGroup(this).size + 1
        )
    }
}
