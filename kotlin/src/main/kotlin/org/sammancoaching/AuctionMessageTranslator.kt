package org.sammancoaching


class AuctionMessageTranslator(val listener: AuctionEventListener) {

    fun processMessage(message: String) {
        if (message.contains("CLOSE")) {
            // bug: should notify listener
        } else if (message.contains("PRICE")) {
            val data = HashMap<String, String>()
            for (element in message.split(";")) {
                val pair = element.split(":")
                data[pair[0].trim()] = pair[1].trim()
            }
            val currentPrice = data.get("CurrentPrice")!!.toInt()
            val increment = data.get("Increment")!!.toInt()
            val bidder = data.get("Bidder")

            // bug: should notify listener
        } else {
            // bug: should notify listener
        }
    }
}