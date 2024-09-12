namespace Auction;

public interface IAuctionEventListener
{
    void AuctionClosed();
    void CurrentPrice(int price);
    void AuctionFailed();
}