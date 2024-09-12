using Auction;

namespace Test_Auction_TestDesign_Kata;

public class AuctionEventListenerApprovalSpy : IAuctionEventListener
{
    private string log = "";

    public void AuctionClosed()
    {
        log += "auctionClosed";
    }

    public void CurrentPrice(int price)
    {
        log += "currentPrice " + price;
    }

    public void AuctionFailed()
    {
        log += "auctionFailed";
    }

    public override string ToString()
    {
        return log;
    }
}