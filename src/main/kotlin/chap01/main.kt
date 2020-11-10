package chap01

fun main() {

    val theater = Theater()
    val ticketInspector = TicketInspector(theater)

    val audience = TheaterAudience(amount = Money(50000), invitation = Invitation())

    val ticketOffice = TicketOffice(theater, Money(100000))
    ticketOffice.addTickets(100)

    val ticketSeller = TicketSeller(ticketOffice)

    audience.buyTicket(ticketSeller)

    val isEntered = audience.enterTheater(ticketInspector)
    println(isEntered)
}