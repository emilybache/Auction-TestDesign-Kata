using Auction;

namespace Test_Auction_TestDesign_Kata;

public class AuctionMessageTranslatorTest
{
    [Fact]
    public void NotifiesAuctionClosedWhenCloseMessageReceived()
    {
        var message = "SOLVersion: 1.1; Event: CLOSE;";
        // TODO: write a test for this message translation
    }

    [Fact]
    public void NotifiesBidDetailsWhenPriceMessageReceived()
    {
        var message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;";
        // TODO: write a test for this message translation
    }
}