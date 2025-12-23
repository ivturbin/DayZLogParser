package dev.turbin.dayzlogparser;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        stage.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("BvVmvC5.png")).toString()));
        stage.setTitle("Парсер логов DayZ");

        SceneManager.init(stage);

    }

    public static void main(String[] args) {
        launch();
    }
}