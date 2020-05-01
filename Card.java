package BlackJack;

// An implementation of a card type.
public class Card {
    
    private Suit mySuit; // Suit of this Card.
    private int myNumber; // Number of this Card. Ace = 1, Jack-King = 11-13.

    /**
     * Card Constructor
     * @param aSuit
     * @param aNumber
     */
    public Card(Suit aSuit, int aNumber) {
        this.mySuit = aSuit;

        if (aNumber >= 1 && aNumber <= 13) {
            this.myNumber = aNumber;
        } else {
            System.err.println(aNumber + " is not a valid nunber");
            System.exit(1);
        }
    }

    /**
     * Return the number of our Card.
     * @return String myNumber.
     */
    public int getNumber() {
        return this.myNumber;
    }

    /**
     * Return a String of the Card.
     * @return String numStr.
     */
    public String toString() {
        
        String numStr = "Error";

        switch(this.myNumber) {
            case 1:
                numStr = "Ace (1)";
                break;
            case 2:
                numStr = "Two (2)";
                break;
            case 3:
                numStr = "Three (3)";
                break;
            case 4:
                numStr = "Four (4)";
                break;
            case 5:
                numStr = "Five (5)";
                break;
            case 6:
                numStr = "Six (6)";
                break;
            case 7:
                numStr = "Seven (7)";
                break;
            case 8:
                numStr = "Eight (8)";
                break;
            case 9:
                numStr = "Nine (9)";
                break;
            case 10:
                numStr = "Ten (10)";
                break;
            case 11:
                numStr = "Jack (11)";
                break;
            case 12:
                numStr = "Queen (12)";
                break;
            case 13:
                numStr = "King (13)";
                break;
        }
        return numStr + " of " + mySuit.toString();
    }

    /**
     * Return the suit of our Card.
     * @return Suit mySuit.
     */
    public Suit getSuit() {
        return this.mySuit;
    }
}