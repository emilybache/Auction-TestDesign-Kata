namespace Auction;

public class AuctionMessageTranslator(AuctionEventListener listener)
{
    private readonly AuctionEventListener _listener = listener;

    public void ProcessMessage(string message)
    {
        if (message.Contains("CLOSE"))
        {
            // bug: should notify listener
        }
        else if (message.Contains("PRICE"))
        {
            var data = new Dictionary<string, string>();
            foreach (var element in message.Split(";", StringSplitOptions.RemoveEmptyEntries))
            {
                var pair = element.Split(":");
                data[pair[0].Trim()] = pair[1].Trim();
            }

            var currentPrice = int.Parse(data["CurrentPrice"]);
            var increment = int.Parse(data["Increment"]);
            var bidder = data["Bidder"];

            // bug: should notify listener
        }
        else
        {
            // bug: should notify listener
        }
    }
}