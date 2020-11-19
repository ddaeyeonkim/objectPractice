package chap01

class TicketSeller(private var ticketOffice: TicketOffice) {

    fun setTicketOffice(ticketOffice: TicketOffice) {
        this.ticketOffice = ticketOffice
    }

    fun getTicket(fee: Money): Ticket {
        return ticketOffice.getTicket(fee)
    }

    fun getMovieFee(): Money {
        return ticketOffice.getMovieFee()
    }
}
