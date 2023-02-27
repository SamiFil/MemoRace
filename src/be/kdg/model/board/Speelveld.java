package be.kdg.model.board;

import java.util.ArrayList;

/**
 * Sami Filjak
 * 23/12/2022
 */
public class Speelveld {
    private ArrayList<Card> board;
    private Pion pion;
    private Dobbelsteen dobbelsteen;
    private int numberMatchedCards;
    private int numFailedAttempts;

    public Speelveld(ArrayList<Card> board, Pion pion, Dobbelsteen dobbelsteen, int numberMatchedCards, int numFailedAttempts) {
        this.board = board;
        this.pion = pion;
        this.dobbelsteen = dobbelsteen;
        this.numberMatchedCards = numberMatchedCards;
        this.numFailedAttempts = numFailedAttempts;
    }
    private boolean isSolved(boolean isSolved) {
    return isSolved;
    }
    private void resetBoard() {

    }
    private void resetMatched() {

    }
    private void resetFailedAttempts() {

    }
    private void resetNumberMatchedCards() {

    }
    private void showBoard() {

    }
    private void timer() {

    }
}
