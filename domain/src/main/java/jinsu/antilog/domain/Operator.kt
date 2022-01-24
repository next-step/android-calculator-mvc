package jinsu.antilog.domain

sealed class Operator {
    object Plus : Operator() {
        override val symbol: String
            get() = "+"
        override fun operate(left: Double, right: Double): Double = left + right
    }

    object Minus : Operator() {
        override val symbol: String
            get() = "-"
        override fun operate(left: Double, right: Double): Double = left - right
    }

    object Multiply : Operator() {
        override val symbol: String
            get() = "*"
        override fun operate(left: Double, right: Double): Double = left * right
    }

    object Divide : Operator() {
        override val symbol: String
            get() = "/"
        override fun operate(left: Double, right: Double): Double {
            if (right == 0.0) throw IllegalArgumentException("0으로는 나눌 수 없습니다.")
            return left / right
        }
    }

    abstract fun operate(left:Double, right: Double) : Double
    abstract val symbol : String

    companion object {
        fun findOperatorBySymbol(symbol: String) = when (symbol) {
            Plus.symbol -> Plus
            Minus.symbol -> Minus
            Multiply.symbol -> Multiply
            Divide.symbol -> Divide
            else -> throw IllegalArgumentException("$symbol 을 연산자로 사용할 수 없습니다.")
        }
    }
}