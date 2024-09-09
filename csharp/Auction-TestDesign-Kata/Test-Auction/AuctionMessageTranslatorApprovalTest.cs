using Auction;
using System.Threading.Tasks;
using VerifyXunit;
using Xunit;

namespace Test_Auction_TestDesign_Kata;

public class AuctionMessageTranslatorApprovalTest
{
    [Fact]
    public Task NotifiesAuctionClosedWhenCloseMessageReceived()
    {
        var message = "SOLVersion: 1.1; Event: CLOSE;";
        var listener = new AuctionEventListenerApprovalSpy();
        var translator = new AuctionMessageTranslator(listener);

        translator.processMessage(message);

        return Verifier.Verify(listener.ToString());
    }    
    
    [Fact]
    public Task NotifiesBidDetailsWhenPriceMessageReceived()
    {
        var message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;";
        var listener = new AuctionEventListenerApprovalSpy();
        var translator = new AuctionMessageTranslator(listener);

        translator.processMessage(message);

        return Verifier.Verify(listener.ToString());
    }
}