package chap01

class Invitation : TicketValuable {

    override fun changeTicket(ticketSeller: TicketSeller): Ticket {
        return ticketSeller.getTicket(Money.EMPTY)
    }
}
