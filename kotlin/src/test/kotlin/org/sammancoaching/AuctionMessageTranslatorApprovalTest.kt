package org.sammancoaching

import org.approvaltests.Approvals
import kotlin.test.Test

class AuctionMessageTranslatorApprovalTest {
    @Test
    fun notifiesAuctionClosedWhenCloseMessageReceived() {
        val spy = StringBuilder()
        val message = "SOLVersion: 1.1; Event: CLOSE;"
        spy.append("Processing event: $message\n")
        val listener = AuctionEventListenerApprovalSpy(spy)
        val translator = AuctionMessageTranslator(listener)

        translator.processMessage(message)

        Approvals.verify(spy)
    }

    @Test
    fun notifiesBidDetailsWhenPriceMessageReceived() {
        val spy = StringBuilder()
        val message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;"
        spy.append("Processing event: $message\n")
        val listener = AuctionEventListenerApprovalSpy(spy)
        val translator = AuctionMessageTranslator(listener)

        translator.processMessage(message)

        Approvals.verify(spy)
    }
}