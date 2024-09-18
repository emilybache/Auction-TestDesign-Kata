
class AuctionEventListener:
    # TODO: add methods here
    pass

class AuctionMessageTranslator:
    def __init__(self, listener: AuctionEventListener):
        self.listener = listener

    def process_message(self, message: str):
        if "CLOSE" in message:
            pass
            # bug: should notify listener
        elif "PRICE" in message:
            data = self.parse_message_data(message)

            current_price = int(data["CurrentPrice"])
            increment = int(data["Increment"])
            bidder = data["Bidder"]

            # bug: should notify listener
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

