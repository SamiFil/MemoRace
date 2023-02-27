package be.kdg.model.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Speelveld {
    private final int dimensie;
    private final Card[][] kaarten;
    private Card geselecteerdeKaart;

    public Speelveld(int dimensie) {
        this.dimensie = dimensie;
        this.kaarten = new Card[dimensie][dimensie];
        vulSpeelveld();
    }

    private void vulSpeelveld() {
        List<Integer> waardes = new ArrayList<>();
        for (int i = 0; i < dimensie * dimensie / 2; i++) {
            waardes.add(i);
            waardes.add(i);
        }
        Collections.shuffle(waardes);
        for (int i = 0; i < dimensie; i++) {
            for (int j = 0; j < dimensie; j++) {
                int waarde = waardes.remove(0);
                kaarten[i][j] = new Card(waarde);
            }
        }
    }

    public Card getKaart(int rij, int kolom) {
        return kaarten[rij][kolom];
    }

    public void draaiKaartOm(Card kaart) {
        if (geselecteerdeKaart == null) {
            geselecteerdeKaart = kaart;
        } else {
            if (geselecteerdeKaart.getWaarde() == kaart.getWaarde()) {
                geselecteerdeKaart.setGelijk(true);
                kaart.setGelijk(true);
            }
            geselecteerdeKaart.setOmgedraaid(false);
            kaart.setOmgedraaid(false);
            geselecteerdeKaart = null;
        }
        kaart.setOmgedraaid(true);
    }

    public boolean isGewonnen() {
        for (int i = 0; i < dimensie; i++) {
            for (int j = 0; j < dimensie; j++) {
                if (!kaarten[i][j].isGelijk()) {
                    return false;
                }
            }
        }
        return true;
    }
}
