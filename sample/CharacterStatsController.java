package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CharacterStatsController{
    @FXML
    private Text statsName;
    @FXML
    private Text statsHealth;
    @FXML
    private Text statsAD;
    @FXML
    private Text statsAbility1;
    @FXML
    private Text statsAbility2;

    public void displayStats(Character character) {
        statsName.setText(character.getName());
        statsHealth.setText(String.valueOf(character.getHealth()));
        statsAD.setText(String.valueOf(character.getAttackDamage()));
        statsAbility1.setText(character.getAbility1());
        statsAbility2.setText(character.getAbility2());
    }
}
