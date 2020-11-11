package chap01

interface Audience {
    fun enterTheater(ticketInspector: TicketInspector): Boolean
    fun getTicket(): Ticket
}

interface TicketBuyer {
    fun buyTicket(ticketSeller: TicketSeller)
}

class TheaterAudience(
    var amount: Money,
    var invitation: Invitation? = null
) : Audience, TicketBuyer {

    private var ticket: Ticket = Ticket.EMPTY

    override fun getTicket(): Ticket = ticket

    override fun enterTheater(ticketInspector: TicketInspector): Boolean {
        return ticketInspector.inspect(this)
    }

    override fun buyTicket(ticketSeller: TicketSeller) {
        if (invitation != null) {
            ticket = ticketSeller.getTicket(invitation)
            if (ticket != Ticket.EMPTY) {
                invitation = null
            }
        } else {
            val fee = ticketSeller.getMovieFee()
            ticket = ticketSeller.getTicket(fee)
            if (ticket != Ticket.EMPTY) {
                minusAmount(fee)
            }
        }
    }

    private fun minusAmount(fee: Money) {
        amount -= fee
    }
}