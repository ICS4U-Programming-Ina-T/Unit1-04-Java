import java.util.Scanner;

/**
 * The DiceGame program implements an application that
 * generates a random number, asks the user to guess,
 * and keeps track of the number of guesses.
 *
 * @author  Ina Tolo
 * @version 1.0
 * @since   2022-2-28
 */

class DiceGame {
    /**
     * Declaring constant.
     */
    private static final int MIN_NUM = 1;
    /**
     * Declaring constant.
     */
    private static final int MAX_NUM = 6;

    /**
     * Main entry into program.
     *
     * @param args nothing passed in
     */
    public static void main(String[] args) {
        // declaring variables
        // https://www.javatpoint.com/how-to-generate-random-number-in-java
        final int randomNumber = (int) (Math.random() * (MAX_NUM - MIN_NUM + 1)
                                                         + MIN_NUM);
        int userGuessInt = 0;
        int tries = 0;
        final Scanner sc = new Scanner(System.in);
        String userGuessString;

        // displays opening message
        System.out.println("Today you will try and guess the random number!");
        System.out.println();

        while (userGuessInt != randomNumber) {
            // gets input from the user
            System.out.print("Guess a number between 1 and 6: ");
            userGuessString = sc.nextLine();

            try {
                // converts string input to an integer
                userGuessInt = Integer.parseInt(userGuessString);

                // checks if guess is in valid range
                if (userGuessInt >= MIN_NUM && userGuessInt <= MAX_NUM) {
                    // increments tries
                    tries++;
                    // checks if guess is too low
                    if (userGuessInt < randomNumber) {
                        // displays message that tells user they are wrong
                        System.out.println("You guessed too low.");
                        System.out.println();
                    // checks if guess is too high
                    } else if (userGuessInt > randomNumber) {
                        // displays message that tells user they are wrong
                        System.out.println("You guessed too high.");
                        System.out.println();
                    // checks if guess is correct
                    } else {
                        // displays message to tell user they are correct
                        System.out.println("You are correct!");
                        System.out.println("It took you " + tries + " tries");
                    }
                } else {
                    // displays error message
                    System.out.println("This isn't between 1 and 6. "
                                       + "This won't count.");
                    System.out.println();
                }
            } catch (IllegalArgumentException exception) {
                // catches invalid strings
                System.out.println("This is not an integer!");
                System.out.println();
            }
        }
    }
}
