package chap01

interface TicketValuable {
    fun changeTicket(ticketSeller: TicketSeller): Ticket
}
