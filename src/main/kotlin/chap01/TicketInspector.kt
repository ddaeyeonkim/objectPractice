package chap01

class TicketInspector(private val theater: Theater) {

    fun inspect(audience: Audience): Boolean {
        val ticket = audience.getTicket()

        if (ticket.validate(theater)) {
            ticket.use()
            return true
        }
        return false
    }
}