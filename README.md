Auction Test Design Kata
========================

There are bugs in the code, clearly marked. Write tests that expose the bugs.

Next Steps
----------
Write tests for a new message similar to "CLOSE", which additionally tells you the reserve price on the item was not met, so it was not sold. The listener should be notified both that the auction closed, but also the reserve price. Sample message:

	SOLVersion: 1.1; Event: CLOSE; ReservePrice: 200;

Acknowledgements
----------------
This is inspired by the example in the book "Growing Object Oriented Software, Guided by Tests" by Steve Freeman and Nat Pryce
