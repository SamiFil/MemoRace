package be.kdg.view.game;

import be.kdg.model.board.Card;
import be.kdg.model.board.Speelveld;
import javafx.concurrent.Task;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class GamePresenter {
    private Speelveld speelVeld;
    private Card eersteKeuze;
    private Card tweedeKeuze;

    private int aantalParenGevonden;

    private final GameView view;

    public GamePresenter(GameView view, Speelveld speelVeld) {
        this.view = view;
        this.speelVeld = speelVeld;
        this.aantalParenGevonden = 0;

        addEventHandlers();
    }

    private void addEventHandlers() {
        for (int i = 0; i < speelVeld.getRijen(); i++) {
            for (int j = 0; j < speelVeld.getKolommen(); j++) {
                Card kaart = view.getKaart(i, j);
                kaart.setOnMouseClicked(event -> handleMouseClick(kaart));
            }
        }
    }

    private void handleMouseClick(Card kaart) {
        if (kaart.isOmgedraaid()) {
            return;
        }

        if (eersteKeuze == null) {
            eersteKeuze = kaart;
            eersteKeuze.draaiOm();
        } else if (tweedeKeuze == null) {
            tweedeKeuze = kaart;
            tweedeKeuze.draaiOm();

            checkMatch();
        } else {
            eersteKeuze.draaiOm();
            tweedeKeuze.draaiOm();

            eersteKeuze = kaart;
            tweedeKeuze = null;

            eersteKeuze.draaiOm();
        }
    }

    private void checkMatch() {
        if (speelVeld.isGelijk(eersteKeuze.getRij(), eersteKeuze.getKolom(),
                tweedeKeuze.getRij(), tweedeKeuze.getKolom())) {
            aantalParenGevonden++;

            eersteKeuze.setDisable(true);
            tweedeKeuze.setDisable(true);

            eersteKeuze = null;
            tweedeKeuze = null;
        } else {
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    return null;
                }
            };

            sleeper.setOnSucceeded(event -> {
                eersteKeuze.draaiOm();
                tweedeKeuze.draaiOm();

                eersteKeuze = null;
                tweedeKeuze = null;
            });

            new Thread(sleeper).start();
        }

        if (aantalParenGevonden == speelVeld.getAantalParen()) {
            view.toonGewonnenScherm();
        }
    }
}
