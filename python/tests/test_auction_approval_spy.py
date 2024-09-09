from approvaltests import verify

from auction import AuctionMessageTranslator, AuctionEventListener


class AuctionEventListenerApprovalSpy(AuctionEventListener):

    def __init__(self):
        self.log = ""

    def __repr__(self):
        return self.log

    def auction_closed(self):
        self.log += "auction_closed"

    def current_price(self, price):
        self.log += f"current_price({price})"


def test_notifies_auction_closed_when_close_message_received():
    message = "SOLVersion: 1.1; Event: CLOSE;"
    spy = AuctionEventListenerApprovalSpy()
    target = AuctionMessageTranslator(spy)

    target.process_message(message)

    verify(spy)


def test_notifies_bid_details_when_price_message_received():
    message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;"
    spy = AuctionEventListenerApprovalSpy()
    target = AuctionMessageTranslator(spy)

    target.process_message(message)

    verify(spy)
