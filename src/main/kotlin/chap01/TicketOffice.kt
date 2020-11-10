package chap01

class TicketOffice(private val theater: Theater, private var amount: Money) {
    private val tickets = hashSetOf<Ticket>()

    fun addTickets(n: Int) {
        val tickets = (0 until n).map { Ticket(theater) }
        this.tickets.addAll(tickets)
    }

    fun getTicket(fee: Money): Ticket {
        addAmount(fee)
        return pollTicket()
    }

    private fun pollTicket(): Ticket {
        if (tickets.isEmpty()) return Ticket.EMPTY
        val ticket = tickets.first()
        tickets.remove(ticket)
        return ticket
    }

    fun getMovieFee(): Money {
        return theater.getMovieFee()
    }

    private fun addAmount(fee: Money) {
        this.amount += fee
    }
}