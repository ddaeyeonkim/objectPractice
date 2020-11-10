package chap01

class Ticket(var theater: Theater? = null) {

    private var isUsed: Boolean = false

    fun use() {
        isUsed = true
    }

    fun validate(theater: Theater): Boolean {
        return this != EMPTY && this.theater == theater && !isUsed
    }

    fun getFee() = theater?.getMovieFee() ?: Money.EMPTY

    companion object {
        val EMPTY = Ticket()
    }
}