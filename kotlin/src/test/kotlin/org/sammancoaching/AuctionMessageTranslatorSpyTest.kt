package org.sammancoaching

import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test

class AuctionMessageTranslatorSpyTest {

    @Test
    fun notifiesAuctionClosedWhenCloseMessageReceived() {
        val message = "SOLVersion: 1.1; Event: CLOSE;"

        val listener: AuctionEventListener = mockk(relaxed = true)
        val translator = AuctionMessageTranslator(listener)

        translator.processMessage(message)

        verify { listener.auctionClosed() }
    }

    @Test
    fun notifiesBidDetailsWhenPriceMessageReceived() {
        val message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;"
        val listener: AuctionEventListener = mockk(relaxed = true)
        val translator = AuctionMessageTranslator(listener)

        translator.processMessage(message)

        verify { listener.currentPrice(192) }
    }
}