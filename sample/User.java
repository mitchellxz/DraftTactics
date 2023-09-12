package sample;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.ArrayList;

public class User {
    private String teamName;
    private Character[] teamList = new Character[3];

    User(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Character[] getTeamList() {
        return teamList;
    }

    public Character getTeamList(int index) {
        return teamList[index];
    }

    public void setTeamList(Character[] teamList) {
        this.teamList = teamList;
    }

    public void setTeamList(Character character, int selectionCounter) {
        this.teamList[selectionCounter] = character;
        this.teamList[selectionCounter].getImage().setDisable(true);
    }

    public void selectCharacter(ArrayList<Character> characterArrayList, int selectionCounter) {
        System.out.println("Select a character");
    }

    // randomly selects a character and makes changes to it. after that, character can no longer be selected
    public void randomlySelectCharacter(ArrayList<Character> characterArrayList, int selectionCounter, ImageView[] enemyTeamImages) {
        ColorAdjust adjustCharacterColor = new ColorAdjust();
        adjustCharacterColor.setSaturation(-1);

        int random = (int)(Math.random()*characterArrayList.size());
        setTeamList(characterArrayList.get(random), selectionCounter);
        getTeamList(selectionCounter).getImage().setEffect(adjustCharacterColor);
        System.out.println("Enemy has selected " + characterArrayList.get(random).getName());
        enemyTeamImages[selectionCounter].setImage(characterArrayList.get(random).getImage().getImage());
        characterArrayList.remove(random);
    }

    public String toString() {
        String fullTeam = "\n" + teamName + "'s team: ";
        for(int i = 0; i < teamList.length; i++) {
            if(i < teamList.length-1) {
                fullTeam += teamList[i].getName() + ", ";
            }
            else {
                fullTeam += teamList[i].getName();
            }
        }
        return fullTeam;
    }
}
