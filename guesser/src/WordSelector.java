package net.cruciblesoftware.jotto;

import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

class WordSelector {
    static Logger logger = Logger.getLogger(WordSelector.class);

    private Dictionary dict;
    private int wordLength;

    WordSelector(int wordLen) {
        wordLength = wordLen;
        dict = new Dictionary(wordLength);
    }

}
