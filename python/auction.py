
class AuctionEventListener:
    # TODO: add methods here
    pass

    def auction_closed(self):
        pass

    def current_price(self, price):
        pass


class AuctionMessageTranslator:
    def __init__(self, listener: AuctionEventListener):
        self.listener = listener

    def process_message(self, message: str):
        if "CLOSE" in message:
            self.listener.auction_closed()
        elif "PRICE" in message:
            data = self.parse_message_data(message)

            current_price = int(data["CurrentPrice"])
            increment = int(data["Increment"])
            bidder = data["Bidder"]

            self.listener.current_price(current_price)
        else:
            # bug: should notify listener
            pass

    def parse_message_data(self, message):
        data = {}
        for element in message.split(";"):
            if not element:
                continue
            pair = element.split(":")
            data[pair[0].strip()] = pair[1].strip()
        return data

