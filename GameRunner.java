package BlackJack;

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        
        // Init.
        Scanner in = new Scanner(System.in);
        Deck theDeck = new Deck(1,true);

        // Init the Players.
        Player me = new Player("Tom");
        Player dealer = new Player("Dealer");

        // Deal two Cards to Players.
        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());
        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());

        // Print initial hands.
        System.out.println("\nNew Game: The cards have been dealt...\n");
        me.printHand(true);
        dealer.printHand(false);
        System.out.println("\n");

        // Flag variables for when the players are finished hitting.
        boolean meDone = false;
        boolean dealerDone = false;
        String ans;

        while (!meDone || !dealerDone) {

            // Player's turn.
            if(!meDone) {
                System.out.print("Hit or Stick? (Enter H or S): ");
                ans = in.next();
                System.out.println();

                // If the Player hits
                if (ans.compareToIgnoreCase("H") == 0) {

                    // Add next Card in the Deck and store whether player is bust.
                    meDone = !me.addCard(theDeck.dealNextCard());
                    me.printHand(true);

                } else {
                    meDone = true;
                }
            }

            // Dealer's turn.
            if (!dealerDone) {
                if (dealer.getHandSum() < 17) {
                    
                    System.out.println("The Dealer hits...\n");
                    dealerDone = !dealer.addCard(theDeck.dealNextCard());
                    dealer.printHand(false);

                } else {
                    
                    System.out.println("The Dealer sticks.\n");
                    dealerDone = true;
                }
            }

            System.out.println();
        }

        // Close Scanner.
        in.close();

        // Print final hands.
        me.printHand(true);
        dealer.printHand(true);
        
        int mySum = me.getHandSum();
        int dealerSum = dealer.getHandSum();

        if (mySum > dealerSum && mySum <= 21 || dealerSum >21) {
            System.out.println("YOU WIN!");
        } else {
            System.out.println("Dealer Wins this time! Better luck next time...");
        }
    }
}