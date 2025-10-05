package org.sammancoaching

import kotlin.test.Test

class AuctionMessageTranslatorTest {
    @Test
    fun notifiesAuctionClosedWhenCloseMessageReceived() {
        val message = "SOLVersion: 1.1; Event: CLOSE;"
        // TODO: write a test for this message translation
    }

    @Test
    fun notifiesBidDetailsWhenPriceMessageReceived() {
        val message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;"
        // TODO: write a test for this message translation
    }
}