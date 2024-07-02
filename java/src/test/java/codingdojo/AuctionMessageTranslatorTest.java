package codingdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuctionMessageTranslatorTest {
    @Test
    public void notifiesAuctionClosedWhenCloseMessageReceived() {
        String message = "SOLVersion: 1.1; Event: CLOSE;";
        var mockListener = new MockAuctionEventListener("auctionClosed");
        var translator = new AuctionMessageTranslator(mockListener);

        translator.processMessage(message);

        assertEquals(mockListener.expectedCall, mockListener.actualCall);
    }

    @Test
    public void notifiesBidDetailsWhenPriceMessageReceived() {
        String message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;";
        var mockListener = new MockAuctionEventListener("currentPrice");
        var translator = new AuctionMessageTranslator(mockListener);

        translator.processMessage(message);

        assertEquals(mockListener.expectedCall, mockListener.actualCall);
    }
}

class MockAuctionEventListener implements AuctionEventListener {

    public final String expectedCall;
    public String actualCall;

    public MockAuctionEventListener(String expectedCall) {
        this.expectedCall = expectedCall;
        this.actualCall = "";
    }


    @Override
    public void auctionClosed() {
        String thisCall = "auctionClosed";
        if (!thisCall.equals(expectedCall)) {
            throw new RuntimeException("expected call: " + expectedCall + " but instead received call to " + thisCall);
        }
        actualCall = thisCall;
    }

    @Override
    public void currentPrice(int price) {
        String thisCall = "currentPrice";
        if (!thisCall.equals(expectedCall)) {
            throw new RuntimeException("expected call: " + expectedCall + " but instead received call to " + thisCall);
        }
        actualCall = thisCall;
    }

    @Override
    public void auctionFailed() {
        String thisCall = "auctionFailed";
        if (!thisCall.equals(expectedCall)) {
            throw new RuntimeException("expected call: " + expectedCall + " but instead received call to " + thisCall);
        }
        actualCall = thisCall;
    }

}
