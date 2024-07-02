package codingdojo;

import org.junit.jupiter.api.Test;

public class AuctionMessageTranslatorTest {
    @Test
    public void notifiesAuctionClosedWhenCloseMessageReceived() {
        String message = "SOLVersion: 1.1; Event: CLOSE;";
        // TODO: write a test for this message translation
    }

    @Test
    public void notifiesBidDetailsWhenPriceMessageReceived() {
        String message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;";
        // TODO: write a test for this message translation
    }
}

