package be.kdg.view.game;

import be.kdg.model.board.Card;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class GameView extends Group {
    private Card[][] cards;
    private HBox hBox;
    private VBox vBox;
    private Image achtergrond;
    private Image achterkant;
    private Image[] voorkant;
    private Label test;

    private void initialiseNodes() {
        cards = new Card[4][4];
        hBox = new HBox();
        vBox = new VBox();
        achterkant = new Image("/cards/back.png");
        voorkant = new Image[8];
        test = new Label("Test");
    }


    private void layoutNodes() {
        for (int i = 0; i < voorkant.length; i++) {
            voorkant[i] = new Image("/cards/" + i + ".png");
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Card card = new Card(achterkant, voorkant[4]);
                card.setTranslateX(i * card.getWidth());
                card.setTranslateY(j * card.getHeight());
                getChildren().add(card);
                cards[i][j] = card;
            }
        }
    }
    }

