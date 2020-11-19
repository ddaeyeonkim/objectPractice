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
        return ticketInspector.inspect(ticket)
    }

    override fun buyTicket(ticketSeller: TicketSeller) {
        if (invitation != null) {
            buyTicketWithInvitation(ticketSeller, invitation)
        } else {
            buyTicketWithAmount(ticketSeller, amount)
        }
    }

    private fun buyTicketWithInvitation(ticketSeller: TicketSeller, invitation: Invitation?) {
        ticket = invitation?.changeTicket(ticketSeller) ?: Ticket.EMPTY
        if (ticket.isNotEmpty()) {
            this.invitation = null
        }
    }

    private fun buyTicketWithAmount(ticketSeller: TicketSeller, amount: Money) {
        ticket = amount.changeTicket(ticketSeller)
        if (ticket.isNotEmpty()) {
            minusAmount(ticketSeller.getMovieFee())
        }
    }

    private fun minusAmount(fee: Money) {
        amount -= fee
    }
}
