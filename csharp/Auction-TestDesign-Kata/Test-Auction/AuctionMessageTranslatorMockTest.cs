using Auction;

namespace Test_Auction_TestDesign_Kata;

public class AuctionMessageTranslatorMockTest
{
    [Fact]
    public void NotifiesAuctionClosedWhenCloseMessageReceived()
    {
        var message = "SOLVersion: 1.1; Event: CLOSE;";
        var mockListener = new AuctionEventListenerMock("auctionClosed");
        var translator = new AuctionMessageTranslator(mockListener);

        translator.ProcessMessage(message);

        Assert.Equal(mockListener.expectedCall, mockListener.actualCall);
    }    
    
    [Fact]
    public void NotifiesBidDetailsWhenPriceMessageReceived()
    {
        var message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;";
        var mockListener = new AuctionEventListenerMock("currentPrice");
        var translator = new AuctionMessageTranslator(mockListener);

        translator.ProcessMessage(message);

        Assert.Equal(mockListener.expectedCall, mockListener.actualCall);
    }
}