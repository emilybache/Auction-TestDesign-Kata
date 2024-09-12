namespace Auction;

public class AuctionMessageTranslator(IAuctionEventListener listener)
{
    public void ProcessMessage(string message)
    {
        if (message.Contains("CLOSE"))
        {
            listener.AuctionClosed();
        }
        else if (message.Contains("PRICE"))
        {
            var data = ParseMessage(message);


            var currentPrice = int.Parse(data["CurrentPrice"]);
            var increment = int.Parse(data["Increment"]);
            var bidder = data["Bidder"];

            listener.CurrentPrice(currentPrice);
        }
        else
        {
            listener.AuctionFailed();
        }
    }

    private static Dictionary<string, string> ParseMessage(string message)
    {
        var data = new Dictionary<string, string>();
        foreach (var element in message.Split(";", StringSplitOptions.RemoveEmptyEntries))
        {
            var pair = element.Split(":");
            data[pair[0].Trim()] = pair[1].Trim();
        }

        return data;
    }
}