package be.kdg.model.board;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card extends ImageView {
    private final Image voorkant;
    private final Image achterkant;
    private boolean isOmgedraaid;
    private final int rij;
    private final int kolom;
    private final Speelveld speelveld;

    public Card(int rij, int kolom, Image achterkant, Image voorkant, Speelveld speelveld) {
        super(achterkant);
        this.rij = rij;
        this.kolom = kolom;
        this.voorkant = voorkant;
        this.achterkant = achterkant;
        this.speelveld = speelveld;
        setOnMouseClicked(event -> draaiOm());
    }

    public void draaiOm() {
        if (!isOmgedraaid && speelveld.isZetToegestaan(rij, kolom)) {
            setImage(voorkant);
            isOmgedraaid = true;
            speelveld.registreerKeuze(this);
        }
    }

    public void terugdraaien() {
        setImage(achterkant);
        isOmgedraaid = false;
    }
}
