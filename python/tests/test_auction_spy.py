from unittest import mock

from auction import AuctionMessageTranslator, AuctionEventListener


def test_notifies_auction_closed_when_close_message_received():
    message = "SOLVersion: 1.1; Event: CLOSE;"
    spy = mock.Mock(AuctionEventListener)
    target = AuctionMessageTranslator(spy)

    target.process_message(message)

    spy.auction_closed.assert_called_once()


def test_notifies_bid_details_when_price_message_received():
    message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;"
    spy = mock.Mock(AuctionEventListener)
    target = AuctionMessageTranslator(spy)

    target.process_message(message)

    spy.current_price.assert_called_with(192)
