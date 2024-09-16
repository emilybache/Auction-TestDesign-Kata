using Auction;

namespace Test_Auction_TestDesign_Kata;

public class AuctionMessageTranslatorMockTest
{
    [Fact]
    public void NotifiesAuctionClosedWhenCloseMessageReceived()
    {
        var message = "SOLVersion: 1.1; Event: CLOSE;";
        var mockListener = new AuctionEventListenerMock();
        mockListener.ExpectCall("AuctionClosed");
        var translator = new AuctionMessageTranslator(mockListener);

        translator.ProcessMessage(message);

        mockListener.CheckExpectations();
    }    
    
    [Fact]
    public void NotifiesBidDetailsWhenPriceMessageReceived()
    {
        var message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;";
        var mockListener = new AuctionEventListenerMock();
        mockListener.ExpectPrice(192);
        var translator = new AuctionMessageTranslator(mockListener);

        translator.ProcessMessage(message);
        
        mockListener.CheckExpectations();
    }
}