package be.kdg.model.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Speelveld {
    private int rows;
    private int columns;
    private Card[][] kaarten;
    private int aantalOmgedraaid;
    private Card kaart1;
    private Card kaart2;

    public Speelveld(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        kaarten = new Card[rows][columns];
        aantalOmgedraaid = 0;
    }

    public int getAantalOmgedraaid() {
        return aantalOmgedraaid;
    }

    public void setAantalOmgedraaid(int aantalOmgedraaid) {
        this.aantalOmgedraaid = aantalOmgedraaid;
    }

    public Card getKaart(int row, int column) {
        return kaarten[row][column];
    }

    public void setKaart(int row, int column, Card kaart) {
        kaarten[row][column] = kaart;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String getWaarde(int row, int column) {
        return kaarten[row][column].getWaarde();
    }

    public void setGelijk(int row1, int column1, int row2, int column2) {
        kaarten[row1][column1].setGelijk(true);
        kaarten[row2][column2].setGelijk(true);
    }

    public void setOmgedraaid(int row, int column, boolean omgedraaid) {
        kaarten[row][column].setOmgedraaid(omgedraaid);
    }

    public boolean isOmgedraaid(int row, int column) {
        return kaarten[row][column].isOmgedraaid();
    }

    public boolean isGelijk(int row1, int column1, int row2, int column2) {
        return kaarten[row1][column1].getWaarde().equals(kaarten[row2][column2].getWaarde());
    }

    public boolean isGewonnen() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (!kaarten[row][column].isGelijk()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getRij(Card kaart) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (kaarten[row][column] == kaart) {
                    return row;
                }
            }
        }
        return -1;
    }

    public int getKolom(Card kaart) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (kaarten[row][column] == kaart) {
                    return column;
                }
            }
        }
        return -1;
    }
}
