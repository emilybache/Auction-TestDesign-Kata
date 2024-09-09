import pytest

from auction import *



def test_notifies_auction_closed_when_close_message_received():
    message = "SOLVersion: 1.1; Event: CLOSE;"
    mock = AuctionEventListenerMock()
    target = AuctionMessageTranslator(mock)
    mock.expect_call("auction_closed")

    target.process_message(message)

    mock.check_expectations()


def test_notifies_bid_details_when_price_message_received():
    message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;"
    mock = AuctionEventListenerMock()
    target = AuctionMessageTranslator(mock)
    mock.expect_call_with_args("current_price", 192)

    target.process_message(message)

    mock.check_expectations()


class AuctionEventListenerMock(AuctionEventListener):
    def __init__(self):
        self.expected_args = None
        self.actual_call = None
        self.expected_call = None

    def auction_closed(self):
        self.actual_call = "auction_closed"

    def current_price(self, price):
        self.actual_call = "current_price"
        if price != self.expected_args:
            raise RuntimeError(f"unexpected argument {price}")

    def expect_call(self, call):
        self.expected_call = call

    def check_expectations(self):
        assert self.expected_call == self.actual_call, f"expected call {self.expected_call} not received"

    def expect_call_with_args(self, call, args):
        self.expected_call = call
        self.expected_args = args

