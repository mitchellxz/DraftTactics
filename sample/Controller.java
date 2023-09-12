/*
Mitchell Ramos
CSC164
4C1
4/28/2021
Final Project
 */
package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Controller {
    private static final int MAX_TEAM_SIZE = 3;
    private int selectionCounter = 0;
    private boolean toBattleOn = false;

    @FXML
    private ImageView character1Image;
    @FXML
    private ImageView character2Image;
    @FXML
    private ImageView character3Image;
    @FXML
    private ImageView character4Image;
    @FXML
    private ImageView character5Image;
    @FXML
    private ImageView character6Image;
    @FXML
    private ImageView character7Image;
    @FXML
    private ImageView character8Image;
    @FXML
    private ImageView character9Image;
    @FXML
    private ImageView character10Image;

    @FXML
    private ImageView userSelection1;
    @FXML
    private ImageView userSelection2;
    @FXML
    private ImageView userSelection3;
    @FXML
    private ImageView enemySelection1;
    @FXML
    private ImageView enemySelection2;
    @FXML
    private ImageView enemySelection3;

    @FXML
    private Button confirmButton;
    @FXML
    private Button toBattle;
    @FXML
    private Text userTeamNameText;
    @FXML
    private Text enemyTeamNameText;

    User user = new User("user");
    User enemy = new User("enemy");

    Mage character1 = new Mage("Red", 2000, 100, "Fire", "Eruption");
    Mage character2 = new Mage("Orange", 2100, 95, "Sunrise", "Sunset");
    Assassin character3 = new Assassin("Green", 1500, 440, "Goo", "Grass Spikes");
    Mage character4 = new Mage("Teal", 1950, 115, "Wave", "Dive");
    Assassin character5 = new Assassin("Sky", 1200, 512, "Fog", "Lightning");
    Fighter character6 = new Fighter("Galaxy", 2600, 200, "Star Dust", "Black Hole");
    Fighter character7 = new Fighter("Purple", 2555, 232, "Grape Throw", "Black Eye");
    Mage character8 = new Mage("Lavender", 2300, 70, "Petals", "Scent");
    Assassin character9 = new Assassin("Lilac", 1600, 400, "Withers", "Pollen");
    Fighter character10 = new Fighter("Pink", 2570, 250, "Oink", "Sparkles");


    Character[] characterArray = {character1, character2, character3, character4, character5, character6, character7,character8, character9, character10};
    ArrayList<Character> characterArrayList = new ArrayList<>(Arrays.asList(characterArray));


    ColorAdjust adjustCharacterColor = new ColorAdjust();
    GaussianBlur hoverOverCharacter = new GaussianBlur();

    Stage stage = new Stage();
    private Parent root;




    public void initialize() {
        character1.setImage(character1Image);
        character2.setImage(character2Image);
        character3.setImage(character3Image);
        character4.setImage(character4Image);
        character5.setImage(character5Image);
        character6.setImage(character6Image);
        character7.setImage(character7Image);
        character8.setImage(character8Image);
        character9.setImage(character9Image);
        character10.setImage(character10Image);

        userTeamNameText.setText(user.getTeamName());
        enemyTeamNameText.setText(enemy.getTeamName());
    }

    // if character1 is clicked on, make character gray + increase size.
    public void setOnMouseClickedCharacter1(MouseEvent mouseEvent) {
        resetAllValuesNonDisabled();
        adjustCharacterColor.setSaturation(-1);
        character1Image.setEffect(adjustCharacterColor);
        character1Image.setFitWidth(176);
        character1Image.setFitHeight(176);
        confirmButton.setVisible(true);
        displayCharacterStats(mouseEvent, character1);
    }

    public void setOnMouseClickedCharacter2(MouseEvent mouseEvent) {
        characterClickedChanges(character2, mouseEvent);
    }

    public void setOnMouseClickedCharacter3(MouseEvent mouseEvent) {
        characterClickedChanges(character3, mouseEvent);
    }

    public void setOnMouseClickedCharacter4(MouseEvent mouseEvent) {
        characterClickedChanges(character4, mouseEvent);
    }

    public void setOnMouseClickedCharacter5(MouseEvent mouseEvent) {
        characterClickedChanges(character5, mouseEvent);
    }

    public void setOnMouseClickedCharacter6(MouseEvent mouseEvent) {
        characterClickedChanges(character6, mouseEvent);
    }

    public void setOnMouseClickedCharacter7(MouseEvent mouseEvent) {
        characterClickedChanges(character7, mouseEvent);
    }

    public void setOnMouseClickedCharacter8(MouseEvent mouseEvent) {
        characterClickedChanges(character8, mouseEvent);
    }

    public void setOnMouseClickedCharacter9(MouseEvent mouseEvent) {
        characterClickedChanges(character9, mouseEvent);
    }

    public void setOnMouseClickedCharacter10(MouseEvent mouseEvent) {
        characterClickedChanges(character10, mouseEvent);
    }

    // makes a character's image black & white
    public void adjustCharacterColorChosen(Character character) {
        adjustCharacterColor.setSaturation(-1);
        character.getImage().setEffect(adjustCharacterColor);
    }

    // resets all characters' values that are not selected + makes changes to the character that is being selected
    public void characterClickedChanges(Character character, MouseEvent mouseEvent) {
        resetAllValuesNonDisabled();
        adjustCharacterColorChosen(character);
        character.getImage().setFitWidth(176);
        character.getImage().setFitHeight(176);
        confirmButton.setVisible(true);
        displayCharacterStats(mouseEvent, character);
    }

    // if user hovers over a character, increase the character's size + add blur effect
    public void onMouseMoved(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();
        if (imageView.getEffect() != adjustCharacterColor) {
            imageView.setEffect(hoverOverCharacter);
            imageView.setFitHeight(176);
            imageView.setFitWidth(176);
        }
    }

    // if user is no longer hovering over a character, set character's size to default + remove effects
    public void onMouseExited(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();
        if (imageView.getEffect() != adjustCharacterColor) {
            imageView.setFitHeight(175);
            imageView.setFitWidth(175);
            imageView.setEffect(null);
        }
    }

    // adds selected character to team. also lets the enemy select a character
    public void onButtonAction(Event event) {
        ImageView[] enemyTeamImages = {enemySelection1, enemySelection2, enemySelection3};

        for(int i = 0; i < characterArrayList.size(); i++) {
            characterChangesOnButtonAction(characterArrayList.get(i),selectionCounter);
        }


        enemy.randomlySelectCharacter(characterArrayList, selectionCounter, enemyTeamImages);
        selectionCounter++;
        confirmButton.setVisible(false);

        if(selectionCounter == MAX_TEAM_SIZE) {
            System.out.println(user);
            System.out.println(enemy);
            confirmButton.setDisable(true);
        }

        readyForBattle();
    }

    // resets all values + effects of characters that arent selected. (can only select 1 character at a time)
    public void resetAllValuesNonDisabled() {
        for (Character character : characterArrayList) {
            // if character is not disabled
            if (!character.getImage().isDisabled()) {
                character.getImage().setEffect(null);
                character.getImage().setFitWidth(175);
                character.getImage().setFitHeight(175);
            }
        }
    }

    // checks which character's image is increased to confirm selection. after confirmed, remove character from list
    public void characterChangesOnButtonAction(Character character, int selectionCounter) {
        if (character.getImage().getFitHeight() > 175) {
            character.getImage().setFitWidth(175);
            character.getImage().setFitHeight(175);
            user.setTeamList(character, selectionCounter);
            characterArrayList.remove(character);
            System.out.println(character.getName() + " has been added to your team!");
            addImageToTeam(character.getImage(), selectionCounter);
        }
    }

    // sends the character's image to the user team shown in the draft (bottom left)
    public void addImageToTeam(ImageView image, int selectionCounter) {
        ImageView[] teamImages = {userSelection1, userSelection2, userSelection3};

        teamImages[selectionCounter].setImage(image.getImage());
    }

    // displays a character's stats (scene). will close if battle scene is open
    public void displayCharacterStats(MouseEvent mouseEvent, Character character) {
        if (!toBattleOn) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("characterStats.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                System.out.println("error!");
            }

            CharacterStatsController statsController = loader.getController();
            statsController.displayStats(character);
            stage.setScene(new Scene(root));
            stage.setTitle("Character Stats");
            stage.show();
            stage.setAlwaysOnTop(true);
            stage.setX(1950);
        }
        else {
            stage.close();
        }

    }

    // if 3 characters have been added to each players' teams, make button visible
    public void readyForBattle() {
        if (selectionCounter == MAX_TEAM_SIZE) {
            toBattle.setVisible(true);
        }
    }

    // closes "characterStats.fxml" scene then switches scenes to battle scene
    public void toBattleOnAction(Event event) throws IOException {
        toBattleOn = true;
        displayCharacterStats(null, null);

        addTeamBuffs(user.getTeamList(), enemy.getTeamList());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("battle.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        BattleController battleController = loader.getController();
        battleController.setTeamImages(user, enemy);
        battleController.battle(user, enemy);

        stage.setScene(scene);
        stage.setTitle("Battle");
        stage.show();


    }

    // adds team buffs to each character in the user's team
    public void addTeamBuffs(Character[] teamList, Character[] enemyList) {
        for (Character character : teamList) {
            character.setHealth(character.getHealth() + Modifier.getTeamHealth());
            character.setAttackDamage(character.getAttackDamage() + Modifier.getTeamAttackDamage());
        }

        // adds team buffs to each character in the enemy's team
        for (Character character : enemyList) {
            character.setHealth(character.getHealth() + Modifier.getEnemyTeamHealth());
            character.setAttackDamage(character.getAttackDamage() + Modifier.getEnemyTeamAttackDamage());
        }
    }
}
