package codingdojo;

public interface AuctionEventListener {
    void auctionClosed();
    void currentPrice(int price);
    void auctionFailed();
}
