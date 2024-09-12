using Auction;

namespace Test_Auction_TestDesign_Kata;

public class AuctionEventListenerMock : IAuctionEventListener
{
    public string expectedCall;
    public string actualCall = "";

    public AuctionEventListenerMock(string expectedCall)
    {
        this.expectedCall = expectedCall;
    }

    public void AuctionClosed()
    {
        var thisCall = "auctionClosed";
        if (thisCall != expectedCall)
            throw new Exception("expected call: " + expectedCall + " but instead received call to " + thisCall);
        actualCall = thisCall;
    }

    public void CurrentPrice(int price)
    {
        var thisCall = "currentPrice";
        if (thisCall != expectedCall) {
            throw new Exception("expected call: " + expectedCall + " but instead received call to " + thisCall);
        }
        actualCall = thisCall;
    }

    public void AuctionFailed()
    {
        String thisCall = "auctionFailed";
        if (thisCall != expectedCall) {
            throw new Exception("expected call: " + expectedCall + " but instead received call to " + thisCall);
        }
        actualCall = thisCall;
    }
}