package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Draft");
        primaryStage.setScene(new Scene(root, 1910, 1068));
        primaryStage.setResizable(false);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
