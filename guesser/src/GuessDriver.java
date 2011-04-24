package net.cruciblesoftware.jotto;

import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

class GuessDriver {
    static Logger logger = Logger.getLogger(GuessDriver.class);

    public static final int MIN_LETTERS = 3;
    public static final int MAX_LETTERS = 6;

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("in main()");

        System.out.println("*** WordGuesser ***");
        System.out.println("Choose your word!");

        Scanner in = new Scanner(System.in);
        System.out.print("Enter word length: ");
        int wordLength = in.nextInt();
        if(wordLength < MIN_LETTERS || wordLength > MAX_LETTERS) {
            System.out.println("Word length must be between " + MIN_LETTERS + " and " + MAX_LETTERS);
            return;
        }
        GuessEngine ge = new GuessEngine(wordLength);

        String guess;
        int nMatch;
        boolean guessAgain = true;
        while(guessAgain) {
            guess = ge.getGuess();
            System.out.println("System guesses: " + guess);
            System.out.print("Enter number of matching letters: ");
            nMatch = in.nextInt();
            ge.setMatch(guess, nMatch);

            if(ge.hasSolution()) {
                guessAgain = false;
            }
        }
        System.out.println("System's solution: " + ge.getSolution());
        System.out.println("*** GAME OVER ***");
        logger.info("exiting main()");
    }
}
