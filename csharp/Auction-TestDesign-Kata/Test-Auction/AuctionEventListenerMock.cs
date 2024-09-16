using Auction;

namespace Test_Auction_TestDesign_Kata;

public class AuctionEventListenerMock : IAuctionEventListener
{
    public string expectedCall;
    public string actualCall = "";
    private int expectedPrice;
    
    public void ExpectCall(string expectedCall)
    {
        this.expectedCall = expectedCall;
    }
    
    public void ExpectPrice(int price)
    {
        ExpectCall("CurrentPrice");
        this.expectedPrice = price;
    }

    public void AuctionClosed()
    {
        var thisCall = "AuctionClosed";
        if (thisCall != expectedCall)
            throw new Exception("expected call: " + expectedCall + " but instead received call to " + thisCall);
        actualCall = thisCall;
    }

    public void CurrentPrice(int price)
    {
        var thisCall = "CurrentPrice";
        if (thisCall != expectedCall) {
            throw new Exception("expected call: " + expectedCall + " but instead received call to " + thisCall);
        }

        if (expectedPrice != price)
            throw new Exception("expected price: " + expectedPrice + " but instead received " + price);
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

    public void CheckExpectations()
    {
        if (expectedCall != actualCall)
            throw new Exception("Expectations not met. Expected call " + expectedCall + ", but received " + actualCall);
    }
}