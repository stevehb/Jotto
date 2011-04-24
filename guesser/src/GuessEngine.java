package net.cruciblesoftware.jotto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

class GuessEngine {
    static Logger logger = Logger.getLogger(GuessEngine.class);

    // need a list of all possible words
    // need a map of words and results
    // need the alphabet with letter status

    WordSelector words;
    int wordLength;

    public GuessEngine(int wordLen) {
        wordLength = wordLen;
        words = new WordSelector(wordLength);
    }

    String getGuess() {
        
        return "guess";
    }


    boolean hasSolution() {
        return true;
    }


    String getSolution() {
        return "solutionz";
    }


    void setMatch(String str, int count) {


    }
}
