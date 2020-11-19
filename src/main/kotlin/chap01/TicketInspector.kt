package chap01

class TicketInspector(private val theater: Theater) {

    fun inspect(ticket: Ticket): Boolean {
        if (ticket.validate(theater)) {
            ticket.use()
            return true
        }
        return false
    }
}
