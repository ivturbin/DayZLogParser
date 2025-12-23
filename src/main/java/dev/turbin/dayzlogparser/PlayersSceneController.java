package dev.turbin.dayzlogparser;

import dev.turbin.dayzlogparser.model.PlayerLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.nio.file.Paths;

public class PlayersSceneController {

    @FXML
    private TextField textField;

    @FXML
    private Button startButton;

    @FXML
    private TableView<PlayerLog> playersTable;

    @FXML
    protected void onStartButtonClick() {

        String fromTextField = textField.getText();
        ObservableList<PlayerLog> playerLogs;

        if (!fromTextField.isEmpty()) {
            playerLogs =
                    FXCollections.observableArrayList(
                            FileProcessor.getEveryPlayerLastLog(Paths.get(fromTextField)).values()
                    );
        } else {
            textField.setText(" ");
            playerLogs = FXCollections.observableArrayList(
                    FileProcessor.getEveryPlayerLastLog(Paths.get(System.getProperty("user.dir") + "/logs")).values()
            );
        }

        textField.setDisable(true);
        startButton.setDisable(true);
        startButton.setText("Всосано.");
        playersTable.setItems(playerLogs);
    }

    @FXML
    private void onTableDoubleClick(MouseEvent event) {

        if (event.getClickCount() == 2) {

            PlayerLog selectedItem = playersTable.getSelectionModel().getSelectedItem();
            if (selectedItem == null) {
                return;
            }

            SceneManager.showDetailsForPlayer(selectedItem.getId());
        }
    }
}