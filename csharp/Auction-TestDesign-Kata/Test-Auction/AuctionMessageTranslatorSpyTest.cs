using Auction;

namespace Test_Auction_TestDesign_Kata;

using Moq;

public class AuctionMessageTranslatorSpyTest
{
    [Fact]
    public void NotifiesAuctionClosedWhenCloseMessageReceived()
    {
        var message = "SOLVersion: 1.1; Event: CLOSE;";
        var mockListener = new Mock<IAuctionEventListener>();
        var translator = new AuctionMessageTranslator(mockListener.Object);

        translator.ProcessMessage(message);

        mockListener.Verify(m => m.AuctionClosed());
    }    
    
    [Fact]
    public void NotifiesBidDetailsWhenPriceMessageReceived()
    {
        var message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;";
        var mockListener = new Mock<IAuctionEventListener>();
        var translator = new AuctionMessageTranslator(mockListener.Object);

        translator.ProcessMessage(message);

        mockListener.Verify(m => m.CurrentPrice(192));
    }
}