package org.sammancoaching

interface AuctionEventListener {
    fun auctionClosed()
    fun currentPrice(price: Int)
    fun auctionFailed()
}