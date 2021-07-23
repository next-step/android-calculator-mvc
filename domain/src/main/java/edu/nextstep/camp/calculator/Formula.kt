package edu.nextstep.camp.calculator

class Formula(val value: String) {

    init {
        val (numberGroup, operatorGroup) =
            Groupings.numberGroup(this) to Groupings.operatorGroup(this)
        require(numberGroup.size == operatorGroup.size + 1)
    }
}
