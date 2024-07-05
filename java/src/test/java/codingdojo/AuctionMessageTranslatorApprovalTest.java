package codingdojo;

import org.junit.jupiter.api.Test;

import static org.approvaltests.Approvals.verify;


public class AuctionMessageTranslatorApprovalTest {
    @Test
    public void notifiesAuctionClosedWhenCloseMessageReceived() {
        String message = "SOLVersion: 1.1; Event: CLOSE;";
        var listener = new AuctionEventListenerApprovalSpy();
        var translator = new AuctionMessageTranslator(listener);

        translator.processMessage(message);

        verify(listener);
    }

    @Test
    public void notifiesBidDetailsWhenPriceMessageReceived() {
        String message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;";
        var listener = new AuctionEventListenerApprovalSpy();
        var translator = new AuctionMessageTranslator(listener);

        translator.processMessage(message);

        verify(listener);
    }

    static class AuctionEventListenerApprovalSpy implements AuctionEventListener {

        String log = "";
        @Override
        public void auctionClosed() {
            log += "auctionClosed";
        }

        @Override
        public void currentPrice(int price) {
            log += "currentPrice " + price;

        }

        @Override
        public void auctionFailed() {
            log += "auctionFailed";
        }

        @Override
        public String toString() {
            return log;
        }
    }
}
