import pytest

from auction import *


def test_notifies_auction_closed_when_close_message_received():
    message = "SOLVersion: 1.1; Event: CLOSE;"
    # TODO: write a test for this message translation


def test_notifies_bid_details_when_price_message_received():
    message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;"
    # TODO: write a test for this message translation
