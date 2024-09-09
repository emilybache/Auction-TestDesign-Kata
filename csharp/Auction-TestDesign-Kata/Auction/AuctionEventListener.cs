namespace Auction;

public interface AuctionEventListener
{
    void AuctionClosed();
    void CurrentPrice(int price);
    void AuctionFailed();
}