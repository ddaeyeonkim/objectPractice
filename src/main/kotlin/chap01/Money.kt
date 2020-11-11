package chap01

data class Money(private val amount: Long) : Comparable<Money> {

    operator fun plus(amount: Money) = Money(this.amount + amount.amount)

    operator fun minus(amount: Money): Money {
        if (amount > this) throw IllegalStateException("not enough money")
        return Money(this.amount - amount.amount)
    }

    override fun compareTo(other: Money): Int {
        return this.amount.compareTo(other.amount)
    }

    companion object {
        val EMPTY = Money(0)
    }
}