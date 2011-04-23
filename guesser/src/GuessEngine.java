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

    ArrayList<String> words;

    int wordLength;

    public GuessEngine(int wordLen) {
        wordLength = wordLen;
        words = new ArrayList<String>();
        try {
            logger.info("opening the dictionary");
            BufferedReader buff = new BufferedReader(new FileReader("wordlist.txt"));
            logger.info("\treading words of length " + wordLength);
            String line = buff.readLine();
            while(line != null) {
                line = line.trim();
                if(line.length() == wordLength) 
                    words.add(line);
                line = buff.readLine();
            }
            logger.info("\tfound " + words.size() + " words");
        } catch(IOException e) {
            logger.error("failed to open file: " + e);
            return;
        }
        logger.info("finished reading words");
    }

    String getGuess() {
        return words.get(1);
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
