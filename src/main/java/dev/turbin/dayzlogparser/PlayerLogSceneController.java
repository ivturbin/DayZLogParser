package dev.turbin.dayzlogparser;

import dev.turbin.dayzlogparser.model.PlayerLog;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class PlayerLogSceneController {

    @FXML
    private TableView<PlayerLog> logTable;

    public void setLogsForPlayer(String id) {
        logTable.setItems(FXCollections.observableArrayList(FileProcessor.getPlayerLogs(id)));
    }

    public void onBackButtonClick() {
        SceneManager.showMain();
    }
}
