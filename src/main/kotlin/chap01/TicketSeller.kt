package chap01

import kotlin.IllegalStateException

class TicketSeller(private var ticketOffice: TicketOffice) {

    fun getTicket(fee: Money): Ticket {
        return if (ticketOffice.getMovieFee() == fee) getTicketFromOffice(fee) else Ticket.EMPTY
    }

    fun getTicket(invitation: Invitation?): Ticket {
        return if (invitation != null) getTicketFromOffice(Money.EMPTY) else Ticket.EMPTY
    }

    private fun getTicketFromOffice(fee: Money): Ticket {
        val ticket = ticketOffice.getTicket(fee)
        if (ticket == Ticket.EMPTY) throw IllegalStateException("invalid ticketOffice")
        return ticket
    }

    fun setTicketOffice(ticketOffice: TicketOffice) {
        this.ticketOffice = ticketOffice
    }

    fun getMovieFee(): Money {
        return ticketOffice.getMovieFee()
    }
}