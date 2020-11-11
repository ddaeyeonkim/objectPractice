package chap01

class Theater {
    private var fee: Money = Money.EMPTY

    fun setMovieFee(fee: Money) {
        this.fee = fee
    }

    fun getMovieFee(): Money {
        return fee
    }
}