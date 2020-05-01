package BlackJack;

import java.util.Random;

// Implementation of a Deck of Cards. Constructor overloading (2 or more constructors).
public class Deck {
    
    private Card[] myCards; // Array of Cards in the deck, where the top Card is the first index (0).
    private int numCards; // Number of Cards left in the deck.

    /**
     * Default constructor, to set a single standard 52 card deck, without any shuffling.
     */
    public Deck() {
        // Call second Constructor, with supplied default args.
        this(1, false);
    }

    /**
     * Constructor that defines the number of decks (i.e. how many sets of 52 Cards are in the deck), and whether to shuffle cards.
     * @param numDecks (Number of individual decks in this deck).
     * @param shuffle (Whether to shuffle or not).
     */
    public Deck(int numDecks, boolean shuffle) {
        this.numCards = numDecks * 52;
        this.myCards = new Card[this.numCards];

        // Init Card index.
        int c = 0;

        // For each Deck
        for (int d = 0; d < numDecks; d++) {

            // For each Suit
            for (int s = 0; s < 4; s++) {

                // For each number.
                for (int n = 1; n <= 13; n++) {

                    // Add the new Card to the Deck.
                    this.myCards[c] = new Card(Suit.values()[s], n);
                    c++;
                }
            }
        }

        // Shuffle if necessary.
        if (shuffle) {
            this.shuffle();
        }
    }


    // Shuffle deck by randomly swapping pairs of cards enough times.
    public void shuffle() {
        
        Random rng = new Random(); // Init random number generator.

        // Temporary card for used in the swapping mechanics.
        Card temp;

        int j;
        for (int i = 0; i < this.numCards; i++) { // Loop through all Cards.
            
            // Get a random card j, to swap i's value with.
            j = rng.nextInt(this.numCards);

            // Do swap (for every Card).
            temp = this.myCards[i];
            this.myCards[i] = this.myCards[j];
            this.myCards[j] = temp;
        }

    }

    /**
     * Deal the next Card from the top of the Deck.
     * @return top (the dealt card).
     */
    public Card dealNextCard() {

        // Get top card.
        Card top = this.myCards[0];

        // Move all subsequent cards to the left, by one index, (to fill in the gap of removed Card, since we're using Array).
        for (int c = 1; c < this.numCards; c++) {
            this.myCards[c-1] = this.myCards[c];
        }
        this.myCards[this.numCards-1] = null;

        this.numCards--;// Now we can decrease number of cards in Array Deck, without losing the end Card.

        return top;
    }

    public void printDeck(int numToPrint) {
        for (int c = 0; c < numToPrint; c++) {
            System.out.printf("% 3d/%d %s\n", c+1, this.numCards, this.myCards[c].toString());
        }
        System.out.printf("\t[%d other]\n", this.numCards-numToPrint);
    }
}