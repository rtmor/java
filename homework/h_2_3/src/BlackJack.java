import java.util.Random;

/**
 * This class will take in three cards as input and will output the recommended
 * action. Valid inputs are the numbers 2 through 9, then the letters J, Q, K,
 * and A to signify the Jack, Queen, King, and Ace of any suit respectively.
 * 
 * @author jcovey
 *
 */
public class BlackJack {

    public static void main(String[] args) {

        String cards[] = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2" };
        Random shuffler = new Random();

        // Let's examine 10 hands
        for (int i = 0; i < 10; i++) {

            // Get random input values
            String dCard = cards[shuffler.nextInt(cards.length)];
            String pCard1 = cards[shuffler.nextInt(cards.length)];
            String pCard2 = cards[shuffler.nextInt(cards.length)];

            // Output the cards dealt
            System.out.printf("Your hand: %s %s with Dealer showing: %s\n", pCard1, pCard2, dCard);

            // Calculate move and output result
            String output = CalculateMove(dCard, pCard1, pCard2);
            System.out.println("Your move: " + output);
            System.out.println();

        }
    }

    private static String CalculateMove(String dCard, String pCard1, String pCard2) {

        // Default return value
        String output = "Invalid Output";

        // Set up some variables to hold the actual numerical values of the
        // cards and of the hand. Sometimes we will want to use the actual
        // names of the cards but other times it will be more useful to use
        // their values.
        int pCard1Value = ComputeCardValue(pCard1);
        int pCard2Value = ComputeCardValue(pCard2);
        int dCardValue = ComputeCardValue(dCard);
        int cardsum = pCard1Value + pCard2Value;

        // ************ BEGIN WRITING YOU CODE HERE ******************* //

        if ((pCard1Value != 11 && pCard2Value != 11) && (pCard1Value != pCard2Value)) {
            switch (dCardValue) {
            case 2: {
                if (cardsum <= 9) {
                    output = "Hit";
                } else if (cardsum == 10 || cardsum == 11) {
                    output = "Double down";
                } else {
                    output = "Stand";
                }
                break;
            }
            case 3: {
                if (cardsum <= 8) {
                    output = "Hit";
                } else if (cardsum >= 9 && cardsum <= 11) {
                    output = "Double down";
                } else if (cardsum == 12) {
                    output = "Hit";
                } else {
                    output = "Stand";
                }
                break;
            }
            case 4:
            case 5:
            case 6: {
                if (cardsum <= 8) {
                    output = "Hit";
                } else if (cardsum >= 9 && cardsum <= 11) {
                    output = "Double down";
                } else {
                    output = "Stand";
                }
                break;
            }
            case 7:
            case 8: {
                if (cardsum <= 9) {
                    output = "Hit";
                } else if (cardsum == 10 || cardsum == 11) {
                    output = "Double down";
                } else if (cardsum >= 12 && cardsum <= 16) {
                    output = "Hit";
                } else {
                    output = "Stand";
                }
                break;
            }
            case 9: {
                if (cardsum <= 9) {
                    output = "Hit";
                } else if (cardsum == 10 || cardsum == 11) {
                    output = "Double down";
                } else if (cardsum >= 12 && cardsum <= 15) {
                    output = "Hit";
                } else if (cardsum == 16) {
                    output = "Surrender if able to, otherwise hit";
                } else {
                    output = "Stand";
                }
                break;
            }
            case 10: {
                if (cardsum <= 10) {
                    output = "Hit";
                } else if (cardsum == 11) {
                    output = "Double down";
                } else if (cardsum >= 12 && cardsum <= 14) {
                    output = "Hit";
                } else if (cardsum == 15 || cardsum == 16) {
                    output = "Surrender if able to, otherwise hit";
                } else {
                    output = "Stand";
                }
                break;
            }
            case 11: {
                if (cardsum <= 15) {
                    output = "Hit";
                } else if (cardsum == 16) {
                    output = "Surrender if able to, otherwise hit";
                } else {
                    output = "Stand";
                }
                break;
            }
            }
        } else if (pCard1Value != pCard2Value) {
            switch (dCardValue) {
            case 2: {
                if (cardsum >= 18) {
                    output = "Stand";
                } else {
                    output = "Hit";
                }
                break;
            }
            case 3: {
                if (cardsum >= 19) {
                    output = "Stand";
                } else if (cardsum >= 17) {
                    output = "Double Down";
                } else {
                    output = "Hit";
                }
                break;
            }
            case 4: {
                if (cardsum >= 19) {
                    output = "Stand";
                } else if (cardsum >= 15) {
                    output = "Double down";
                } else {
                    output = "Hit";
                }
                break;
            }
            case 5:
            case 6: {
                if (cardsum >= 19) {
                    output = "Stand";
                } else {
                    output = "Double down";
                }
                break;
            }
            case 7:
            case 8: {
                if (cardsum >= 18) {
                    output = "Stand";
                } else {
                    output = "Hit";
                }
                break;
            }
            case 9:
            case 10:
            case 11: {
                if (cardsum >= 19) {
                    output = "Stand";
                } else {
                    output = "Hit";
                }
                break;
            }
            }
        } else {
            switch (dCardValue) {
            case 2: {
                if (cardsum == 21 || cardsum == 16 || cardsum == 18 || cardsum == 14) {
                    output = "Split";
                } else if (cardsum == 20) {
                    output = "Stand";
                } else if (cardsum == 10) {
                    output = "Double Down";
                } else {
                    output = "Hit";
                }
                break;
            }
            case 3: {
                if (cardsum == 21 || cardsum == 16 || cardsum == 18 || cardsum == 14 || cardsum == 12) {
                    output = "Split";
                } else if (cardsum == 20) {
                    output = "Stand";
                } else if (cardsum == 10) {
                    output = "Double down";
                } else {
                    output = "Hit";
                }
                break;
            }
            case 4:
            case 5:
            case 6: {
                if (cardsum == 21 || cardsum == 16 || cardsum == 18 || cardsum == 14 || cardsum == 12 || cardsum == 6
                        || cardsum == 4) {
                    output = "Split";
                } else if (cardsum == 20) {
                    output = "Stand";
                } else if (cardsum == 10) {
                    output = "Double Down";
                } else {
                    output = "Hit";
                }
                break;
            }
            case 7: {
                if (cardsum == 20 || cardsum == 18) {
                    output = "Stand";
                } else if (cardsum == 10) {
                    output = "Double down";
                } else if (cardsum == 12 || cardsum == 8) {
                    output = "Hit";
                } else {
                    output = "Split";
                }
                break;
            }
            case 8:
            case 9: {
                if (cardsum == 22 || cardsum == 16 || cardsum == 18) {
                    output = "Split";
                } else if (cardsum == 20) {
                    output = "Stand";
                } else if (cardsum == 10) {
                    output = "Double down";
                } else {
                    output = "Hit";
                }
                break;
            }
            case 10:
            case 11: {
                if (cardsum == 22 || cardsum == 16) {
                    output = "Split";
                } else if (cardsum == 20 || cardsum == 18) {
                    output = "Stand";
                } else {
                    output = "Hit";
                }
                break;
            }
            }
        }

        // ************ END WRITING YOU CODE HERE ******************* //

        // Return the output
        return output;

    }

    /**
     * This method computes the numerical value of a card that is dealt.
     * 
     * @param card The string representation of the card
     * @return The numerical value of the card
     */
    public static int ComputeCardValue(String card) {
        if (card.equalsIgnoreCase("A")) {
            return 11;
        } else if (card.equalsIgnoreCase("K") || card.equalsIgnoreCase("Q") || card.equalsIgnoreCase("J")) {
            return 10;
        } else {
            return Integer.parseInt(card);
        }
    }
}