package net.cruciblesoftware.jotto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

class Dictionary {
    static Logger logger = Logger.getLogger(Dictionary.class);

    public class Word {
        public String word;
        public int freq;
        public boolean used;
    }
    public ArrayList<Word> wordList;
    private int wordLength;

    public Dictionary(int wordLen) {
        wordLength = wordLen;
        wordList = new ArrayList<Word>();
        try {
            logger.info("creating the dictionary");
            BufferedReader buff = new BufferedReader(new FileReader("wordlist.txt"));
            logger.info("\treading words of length " + wordLength);
            String line = buff.readLine();
            String[] pair;
            Word w;
            while(line != null) {
                line = line.trim();
                pair = line.split(",");
                if(pair.length != 2) {
                    logger.warn("ERROR: found unparsable line " + line);
                    line = buff.readLine();
                    continue;
                }
                if(pair[0].length() == wordLength) {
                    w = new Word();
                    w.word = pair[0];
                    w.freq = Integer.parseInt(pair[1]);
                    w.used = false;
                    wordList.add(w);
                }
                line = buff.readLine();
            }
            logger.info("\tfound " + wordList.size() + " words");
        } catch(IOException e) {
            logger.error("failed to open file: " + e);
            return;
        }
        logger.info("finished reading words");
    }
}
