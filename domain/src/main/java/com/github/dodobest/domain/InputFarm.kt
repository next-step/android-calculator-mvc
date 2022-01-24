package com.github.dodobest.domain

class InputFarm {
    private val calculator = Calculator()
    private val _numAndSignArray: MutableList<String> = MutableList(0) { "" }
    private val _arraySize: Int get() = _numAndSignArray.size

    fun handleInputArithmetic(inputOperation: String) {
        if (_arraySize == 0) return

        if (Operation.charIsOperation(_numAndSignArray.last().toCharArray().last())) {
            _numAndSignArray[_arraySize - 1] = inputOperation
            return
        }

        _numAndSignArray.add(inputOperation)
    }

    fun handleInputNum (inputNum: String) {
        if (_arraySize > 0 && calculator.checkCharIsNum(_numAndSignArray.last().toCharArray().last())) {
            _numAndSignArray[_arraySize-1] = (_numAndSignArray.last().toInt() * 10 + inputNum.toInt()).toString()
            return
        }
        _numAndSignArray.add(inputNum)
    }

    fun getString(): String {
        return _numAndSignArray.joinToString("")
    }

    fun handleInputDelete() {
        if (_arraySize == 0) return

        if (_numAndSignArray.last().length > 1) {
            _numAndSignArray[_arraySize-1] = (_numAndSignArray.last().toDouble().toInt() / 10 ).toString()
            return
        }

        _numAndSignArray.removeLast()
    }

    fun checkExpressionCanCalculated(): Boolean {
        if (Operation.charIsOperation(_numAndSignArray.last().toCharArray().last())) {
            return false
        }
        return true
    }

    fun handleEquals(){
        val res: String = calculator.calculate(_numAndSignArray).toString()

        _numAndSignArray.clear()
        _numAndSignArray.add(res)
    }
}