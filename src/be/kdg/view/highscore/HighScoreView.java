package be.kdg.view.highscore;

import be.kdg.model.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;

/**
 * Sami Filjak
 * 15/02/2023
 */
public class HighScoreView extends VBox {
    private VBox box1;
    private VBox box2;
    private Button back;
    private Label highScore;
    private HBox box3;
    private TableView<Player> table;
    private TableColumn<Player, String> name;
    private ArrayList<Player> highscores;


    public HighScoreView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    private void initialiseNodes() {
        back = new Button("Back");
        highScore = new Label("HIGHSCORE");
        TableView<Player> table = new TableView<>();
        TableColumn<Player, String> name = new TableColumn<>("Player Name");
        highscores = new ArrayList<Player>();

    }



    public Label getHighScore() {
        return highScore;
    }



    public Button getBack() {
        return back;
    }



    private void layoutNodes() {
        name.setCellValueFactory(new PropertyValueFactory<>("naam"));
        TableColumn<Player, Integer> matched = new TableColumn<>("Matched Cards");
        matched.setCellValueFactory(new PropertyValueFactory<>("amountOfWonCards"));
        table.getColumns().addAll(name, matched);
        table.getItems().addAll(highscores);
        back.setPrefSize(50, 30);
        highScore.setFont(Font.font("Verdana", 31));
        getChildren().addAll(highScore, table, back);
        setAlignment(Pos.TOP_CENTER);
        setLayoutY(40);
        setSpacing(20);
    }
}
