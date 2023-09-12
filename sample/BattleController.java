package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class BattleController {
    private int userScore = 0;
    private int enemyScore = 0;
    private boolean runGame = true;
    private int roundNum = 0;

    ColorAdjust adjustCharacterColor = new ColorAdjust();

    @FXML
    private ImageView userCharacter1;
    @FXML
    private ImageView userCharacter2;
    @FXML
    private ImageView userCharacter3;

    @FXML
    private ImageView enemyCharacter1;
    @FXML
    private ImageView enemyCharacter2;
    @FXML
    private ImageView enemyCharacter3;

    @FXML
    private Text round1Winner;
    @FXML
    private Text round2Winner;
    @FXML
    private Text round3Winner;

    @FXML
    private Text result;

    @FXML
    private Button toBuffs;

    Stage stage = new Stage();
    private Scene scene;
    private Parent root;

    // for battle (visual)
    public void setTeamImages(User user, User enemy) {
        userCharacter1.setImage(user.getTeamList(0).getImage().getImage());
        enemyCharacter1.setImage(enemy.getTeamList(0).getImage().getImage());

        userCharacter2.setImage(user.getTeamList(1).getImage().getImage());
        enemyCharacter2.setImage(enemy.getTeamList(1).getImage().getImage());

        userCharacter3.setImage(user.getTeamList(2).getImage().getImage());
        enemyCharacter3.setImage(enemy.getTeamList(2).getImage().getImage());

    }

    // will continue running until all characters have finished battling. entire battle takes place here
    public void battle(User user, User enemy) {
        do {
            // chooses a random # to determine who attacks
            switch (whoAttacks()) {
                case 0 -> userAttacks(user, enemy, roundNum);
                case 1 -> enemyAttacks(enemy, user, roundNum);
            }

            // if the user's character from any round is dead, increase the enemy's score
            if (user.getTeamList(roundNum).isDead(user.getTeamList(roundNum))) {

                // display who wins based on the round #
                switch (roundNum) {
                    case 0 -> {
                        round1Winner.setText(enemy.getTeamList(roundNum).getName() + " Wins!");
                        userCharacter1.setEffect(getAdjustCharacterColor());
                    }
                    case 1 -> {
                        round2Winner.setText(enemy.getTeamList(roundNum).getName() + " Wins!");
                        userCharacter2.setEffect(getAdjustCharacterColor());
                    }
                    case 2 -> {
                        round3Winner.setText(enemy.getTeamList(roundNum).getName() + " Wins!");
                        userCharacter3.setEffect(getAdjustCharacterColor());
                    }
                }
                roundNum++;
                enemyScore++;
            }

            // if the enemy's character from any round is dead, increase the user's score
            else if (enemy.getTeamList(roundNum).isDead(enemy.getTeamList(roundNum))) {

                // display who wins based on the round #
                switch (roundNum) {
                    case 0 -> {
                        round1Winner.setText(user.getTeamList(roundNum).getName() + " Wins!");
                        enemyCharacter1.setEffect(getAdjustCharacterColor());
                    }
                    case 1 -> {
                        round2Winner.setText(user.getTeamList(roundNum).getName() + " Wins!");
                        enemyCharacter2.setEffect(getAdjustCharacterColor());
                    }
                    case 2 -> {
                        round3Winner.setText(user.getTeamList(roundNum).getName() + " Wins!");
                        enemyCharacter3.setEffect(getAdjustCharacterColor());
                    }
                }
                roundNum++;
                userScore++;
            }

            // game ends once all rounds have been played out
            if (roundNum == 3) {
                runGame = false;
            }
        } while (runGame);

        result = getResult(userScore, enemyScore);
    }

    // chooses a random # to determine what attack will be executed by the user
    public void userAttacks(User user, User enemy, int roundNum) {
        switch (attackType()) {
            case 0 -> user.getTeamList(roundNum).attack(enemy.getTeamList(roundNum));
            case 1 -> user.getTeamList(roundNum).useAbility(enemy.getTeamList(roundNum));
            case 2 -> System.out.println(user.getTeamList(roundNum).getName() + " Has missed!");
        }
    }

    // chooses a random # to determine what attacks will be executed by the enemy
    public void enemyAttacks(User enemy, User user, int roundNum) {
        switch (attackType()) {
            case 0 -> enemy.getTeamList(roundNum).attack(user.getTeamList(roundNum));
            case 1 -> enemy.getTeamList(roundNum).useAbility(user.getTeamList(roundNum));
            case 2 -> System.out.println(enemy.getTeamList(roundNum).getName() + " Has missed!");
        }
    }

    // for characters that lose their battle
    public ColorAdjust getAdjustCharacterColor() {
        adjustCharacterColor.setSaturation(-.9);
        return adjustCharacterColor;
    }

    // displays the final result + removes a life if user loses
    public Text getResult(int userScore, int enemyScore) {
        if (userScore < enemyScore) {
            Modifier.decreaseLives();
        }
        result.setText("Result: " + userScore + "-" + enemyScore);
        return result;
    }

    public int attackType() {
        return (int) (Math.random()*3);
    }

    public int whoAttacks() {
        return (int) (Math.random()*2);
    }

    public int chooseRandomBuffEnemy() {
        return (int) (Math.random() * 2);
    }

    public void toBuffsOnAction(Event event) throws IOException {
        if (Modifier.getLives() > 0 && userScore >= 2) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("buffScreen.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Buffs");
            stage.show();
        }
        else if (Modifier.getLives() > 0) {
            switch (chooseRandomBuffEnemy()) {
                case 0 -> Modifier.increaseEnemyTeamAttack();
                case 1 -> Modifier.increaseEnemyTeamHealth();
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            System.out.println("Lives: " + Modifier.getLives());
            stage.setScene(scene);
            stage.setTitle("Draft");
            stage.show();
        }
        else {
            System.out.println("you lose");
        }
    }
}
