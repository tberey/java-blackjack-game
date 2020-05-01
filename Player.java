package BlackJack;

// Implementation of a blackjack player and dealer.
public class Player {
    
    private String name; // Player's name.
    private int numCards; // Number of Cards in Player's hand.

    // We should never have more than 10 Cards. This is needed to be specified as we're using an Array (set the length, which is 10 in this case).
    private Card[] hand = new Card[10]; // Player's Cards in hand.

    /**
     * Player constructor.
     * @param aName (Player's chosen name)
     */
    public Player(String aName) {

        this.name = aName; // Set Player's name.
        this.emptyHand(); // Set a Player's hand to empty/null.
    }

    // Reset and empty Player's hand, to have no cards.
    public void emptyHand() {
        for (int c = 0; c < 10; c++) { // The max cards we could ever have is 10, so iterate 10 times.
            this.hand[c] = null;
        }
        this.numCards = 0;
    }

    /**
     * 
     * @param aCard (the card to add to hand).
     * @return (whether the sum of new hand is below or equal to 21 (blackjack)).
     */
    public boolean addCard(Card aCard) {

        // Print error if we already have the max number of cards.
        if (this.numCards == 10) {
            System.err.printf("%s's hand already has 10 cards. " + "Cannot add another/\n", this.name);
            System.exit(1);
        }

        // Add new card in next slot and increment number of cards counter.
        this.hand[this.numCards] = aCard;
        this.numCards++;

        return (this.getHandSum() <= 21);
    }

    public int getHandSum() {
        int handSum = 0;
        int cardNum;
        int numAces = 0;

        // Calc each Cards weight to the total hand value.
        for (int c = 0; c < this.numCards; c++) {

            // Get the number for the current card
            cardNum = this.hand[c].getNumber();

            if (cardNum == 1) { // Ace.
                numAces++;
                handSum +=11;
            } else if (cardNum > 10) { // Jack, Queen, King.
                handSum += 10;
            } else { // Number Cards.
                handSum += cardNum;
            }
        }

        // If hand contains aces and sum of hand is > 21, set some or all of the Aces to 1, (instead of 11).
        while (handSum > 21 && numAces > 0) {
            handSum -=10;
            numAces--;
        }

        return handSum;
    }

    /**
     * Print the cards in the player's hand.
     * @param showFirstCard (whether to show first card, if it is the dealer's hand).
     */
    public void printHand(boolean showFirstCard) {
        System.out.printf("%s's cards:\n", this.name);

        for (int c = 0; c < this.numCards; c++) {
            if (c == 0 && !showFirstCard) {
                System.out.println("  [HIDDEN CARD]");
            } else {
                System.out.printf("  %s\n", this.hand[c].toString());
            }
        }
        System.out.println();
    }
}