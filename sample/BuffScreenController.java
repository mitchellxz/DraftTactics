package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class BuffScreenController{

    Stage stage = new Stage();
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView attackBuffImage;
    @FXML
    private ImageView healthBuffImage;

    public void attackBuffImageOnClick(MouseEvent mouseEvent) throws IOException {
        Modifier.increaseTeamAttack();
        backToDraftScene(mouseEvent);
    }

    public void healthBuffImageOnClick(MouseEvent mouseEvent) throws IOException {
        Modifier.increaseTeamHealth();
        backToDraftScene(mouseEvent);
    }

    public void backToDraftScene(MouseEvent mouseEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);

        System.out.println("Lives: " + Modifier.getLives());
        stage.setScene(scene);
        stage.show();
    }
}
