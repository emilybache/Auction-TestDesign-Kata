package org.sammancoaching

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.assertEquals
import kotlin.test.Test


class AuctionMessageTranslatorMockTest {
    @Test
    fun notifiesAuctionClosedWhenCloseMessageReceived() {
        val message = "SOLVersion: 1.1; Event: CLOSE;"
        var mockListener = AuctionEventListenerMock("auctionClosed");
        var translator = AuctionMessageTranslator(mockListener);

        translator.processMessage(message);

        assertEquals(mockListener.expectedCall, mockListener.actualCall);
    }

    @Test
    fun notifiesBidDetailsWhenPriceMessageReceived() {
        val message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;"
        var mockListener = AuctionEventListenerMock("currentPrice");
        var translator = AuctionMessageTranslator(mockListener);

        translator.processMessage(message);

        assertEquals(mockListener.expectedCall, mockListener.actualCall);
    }

    @Test
    fun notifiesAuctionClosedWhenCloseMessageReceivedMockk() {
        val message = "SOLVersion: 1.1; Event: CLOSE;"

        val listener: AuctionEventListener = mockk()
        val translator = AuctionMessageTranslator(listener)
        every { listener.auctionClosed() }.returns(Unit)

        translator.processMessage(message)

        verify { listener.auctionClosed() }
        confirmVerified(listener)
    }

    @Test
    fun notifiesBidDetailsWhenPriceMessageReceivedMockk() {
        val message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;"
        val listener: AuctionEventListener = mockk()
        val translator = AuctionMessageTranslator(listener)
        every { listener.currentPrice(192) }.returns(Unit)

        translator.processMessage(message)

        verify{ listener.currentPrice(192) }
        confirmVerified(listener)
    }
}