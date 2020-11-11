package chap01

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class TheaterAudienceTest {

    private lateinit var ticketSeller: TicketSeller

    @Before
    fun setUp() {
        val theater = Theater()
        theater.setMovieFee(Money(10_000))

        val ticketOffice = TicketOffice(theater, Money(1_000_000))
        ticketOffice.addTickets(100)

        ticketSeller = TicketSeller(ticketOffice)
    }

    @Test
    fun `초대권이 있는 관객이 티켓을 구매하면 금액 차감이 되지 않는다`() {
        // given
        val amount = Money(100_000)
        val audience = TheaterAudience(amount, Invitation())

        // when
        audience.buyTicket(ticketSeller)

        // then
        assertEquals(amount, audience.amount)
    }

    @Test
    fun `초대권이 있는 관객이 티켓을 구매하면 초대장이 제거 된다`() {
        // given
        val amount = Money(100_000)
        val audience = TheaterAudience(amount, Invitation())

        // when
        audience.buyTicket(ticketSeller)

        // then
        assertEquals(null, audience.invitation)
    }

    @Test
    fun `초대권이 없는 관객은 티켓을 구매하면 잔액이 차감된다`() {
        // given
        val amount = Money(100_000)
        val audience = TheaterAudience(amount)

        // when
        audience.buyTicket(ticketSeller)

        // then
        assertEquals(Money(90_000), audience.amount)
    }
}