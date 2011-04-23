package net.cruciblesoftware.jotto;

import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

class WordGuesser {
    static Logger logger = Logger.getLogger(WordGuesser.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("in main()");

        System.out.println("*** WordGuesser ***");
        System.out.println("Choose your word!");

        Scanner in = new Scanner(System.in);
        System.out.print("Enter word length: ");
        int wordLength = in.nextInt();
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
