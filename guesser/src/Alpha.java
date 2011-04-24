package net.cruciblesoftware.jotto;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

// Letter frequencies from en.wikipedia.org/wiki/Letter_frequency
enum Alpha {
    A(.08167f), B(.01492f), C(.02782f), D(.04253f), E(.12702f), F(.02228f), 
    G(.02015f), H(.06094f), I(.06966f), J(.00153f), K(.00772f), L(.04025f), 
    M(.02406f), N(.06749f), O(.07507f), P(.01929f), Q(.00095f), R(.05987f), 
    S(.06327f), T(.09056f), U(.02758f), V(.00978f), W(.02360f), X(.00150f),
    Y(.01974f), Z(.00074f);

    // possible states: UNKNOWN, GUESSED, REJECTED, AFFIRMED
    public AlphaState state = AlphaState.UNKNOWN;
    public String letter;
    public float freq;

    Alpha(float f) {
        letter = this.toString().toLowerCase();
        freq = f;
    }

    public boolean isIn(String str) {
        return str.contains(letter);
    }
}
