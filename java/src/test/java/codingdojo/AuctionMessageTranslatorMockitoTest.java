package codingdojo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuctionMessageTranslatorMockitoTest {

    @Test
    public void notifiesAuctionClosedWhenCloseMessageReceived() {
        String message = "SOLVersion: 1.1; Event: CLOSE;";

        var listener = mock(AuctionEventListener.class);
        var translator = new AuctionMessageTranslator(listener);

        translator.processMessage(message);

        verify(listener).auctionClosed();
    }

    @Test
    public void notifiesBidDetailsWhenPriceMessageReceived() {
        String message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;";
        var mockListener = mock(AuctionEventListener.class);
        var translator = new AuctionMessageTranslator(mockListener);

        translator.processMessage(message);

        verify(mockListener).currentPrice(192);
    }
}
