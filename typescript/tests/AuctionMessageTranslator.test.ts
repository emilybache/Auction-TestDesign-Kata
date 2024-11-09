describe('AuctionMessageTranslator tests', () => {
    it('should notify auction closed when close message received', () => {
        const message = 'SOLVersion: 1.1; Event: CLOSE;';
        // TODO: write a test for this message translation
        expect(1).toEqual(2);
    });

    it('should notify bid details when price message received', () => {
        const message = 'SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;';
        // TODO: write a test for this message translation
        expect(1).toEqual(2);
    });
});
