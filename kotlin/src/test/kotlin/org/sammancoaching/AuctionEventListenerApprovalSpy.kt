package org.sammancoaching

internal class AuctionEventListenerApprovalSpy(val log: StringBuilder) : AuctionEventListener {
    override fun auctionClosed() {
        log.append("auctionClosed")
    }

    override fun currentPrice(price: Int) {
        log.append("currentPrice " + price)
    }

    override fun auctionFailed() {
        log.append("auctionFailed")
    }

    override fun toString(): String {
        return log.toString()
    }
}