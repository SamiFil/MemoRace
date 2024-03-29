package be.kdg.view.start;

import be.kdg.view.game.GamePresenter;
import be.kdg.view.game.GameView;
import be.kdg.view.settings.SettingsPresenter;
import be.kdg.view.settings.SettingsView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Sami Filjak
 * 16/02/2023
 */
//public class StartPresenter {
//public StartView startView;
//private int counter = 0;
//
//
//    public StartPresenter(StartView startView) {
//        this.startView = startView;
//        addEventHandlers();
//    }
//    private void addEventHandlers() {
//        startView.getAddPlayers().setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                TextField textField = new TextField();
//                textField.setMaxWidth(150);
//                textField.setPromptText("Player " + (++counter));
//                textField.setOnAction(event -> {
//                    String playerName = textField.getText();
//                    startView.playerNames.add(playerName);
//                });
//startView.getChildren().add(textField);
//            }
//
//        });
//        startView.getStart().setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                GameView gameView = new GameView();
//                GamePresenter gamePresenter = new GamePresenter(gameView);
//                startView.getScene().setRoot(gameView);
//
//            }
//        });
//    }
//}
public class StartPresenter {
    private StartView startView;
    private GameView gameView;
    private GamePresenter gamePresenter;

    public StartPresenter(StartView startView) {
        this.startView = startView;
        this.gameView = new GameView();
        this.gamePresenter = new GamePresenter(gameView);
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        startView.getStart().setOnAction(event -> {
            setGameScene();
        });
    }

    private void setGameScene() {
        Scene scene = new Scene(gameView);
        Stage stage = (Stage) startView.getScene().getWindow();
        stage.setScene(scene);
    }
}
