package be.kdg.model.board;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Sami Filjak
 * 23/12/2022
 */
public class Card extends ImageView {
    private final Image voorkant;
    private final Image achterkant;
    private boolean isOmgedraaid;

    public Card(Image achterkant, Image voorkant) {
        super(achterkant);
        this.voorkant = voorkant;
        this.achterkant = achterkant;
        setOnMouseClicked(event -> draaiOm());
    }

    public void draaiOm() {
        if (isOmgedraaid) {
            setImage(achterkant);
        } else {
            setImage(voorkant);
        }
        isOmgedraaid = !isOmgedraaid;
    }
}
