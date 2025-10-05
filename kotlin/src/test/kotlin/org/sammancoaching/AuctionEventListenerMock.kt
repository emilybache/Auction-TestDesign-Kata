package org.sammancoaching

internal class AuctionEventListenerMock(val expectedCall: String?) : AuctionEventListener {
    var actualCall: String? = ""


    public override fun auctionClosed() {
        val thisCall = "auctionClosed"
        if (thisCall != expectedCall) {
            throw RuntimeException("expected call: " + expectedCall + " but instead received call to " + thisCall)
        }
        actualCall = thisCall
    }

    public override fun currentPrice(price: Int) {
        val thisCall = "currentPrice"
        if (thisCall != expectedCall) {
            throw RuntimeException("expected call: " + expectedCall + " but instead received call to " + thisCall)
        }
        actualCall = thisCall
    }

    public override fun auctionFailed() {
        val thisCall = "auctionFailed"
        if (thisCall != expectedCall) {
            throw RuntimeException("expected call: " + expectedCall + " but instead received call to " + thisCall)
        }
        actualCall = thisCall
    }
}