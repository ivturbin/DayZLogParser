package dev.turbin.dayzlogparser;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.util.Objects;

public class SceneManager {
    private static Stage stage;

    private static Scene scene1;
    private static Scene scene2;

    private static PlayerLogSceneController playerLogSceneController;

    public static void init(Stage mainStage) throws Exception {
        stage = mainStage;

        // первая сцена
        FXMLLoader loader1 =
                new FXMLLoader(SceneManager.class.getResource("players.fxml"));
        scene1 = new Scene(loader1.load());
        scene1.getStylesheets().add(
                Objects.requireNonNull(SceneManager.class.getResource("style.css")).toExternalForm()
        );
        JMetro jMetro1 = new JMetro(Style.LIGHT);
        jMetro1.setScene(scene1);

        // вторая сцена
        FXMLLoader loader2 =
                new FXMLLoader(SceneManager.class.getResource("playerLog.fxml"));
        scene2 = new Scene(loader2.load());
        playerLogSceneController = loader2.getController();
        JMetro jMetro2 = new JMetro(Style.LIGHT);
        jMetro2.setScene(scene2);

        stage.setScene(scene1);
        stage.setWidth(700);
        stage.setHeight(300);
        stage.show();
    }

    public static void showMain() {
        stage.setScene(scene1);
    }

    public static void showDetailsForPlayer(String id) {

        playerLogSceneController.setLogsForPlayer(id);
        stage.setScene(scene2);
    }
}
