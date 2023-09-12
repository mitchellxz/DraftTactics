package sample;

import javafx.scene.image.ImageView;

public class Character {
    private String name;
    private double health;
    private String ability1;
    private String ability2;
    private double attackDamage;
    private ImageView image;

    Character(String name, double health, double attackDamage, String ability1, String ability2) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.ability1 = ability1;
        this.ability2 = ability2;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public String getAbility1() {
        return ability1;
    }

    public void setAbility1(String ability1) {
        this.ability1 = ability1;
    }

    public String getAbility2() {
        return ability2;
    }

    public void setAbility2(String ability2) {
        this.ability2 = ability2;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public void attack(Character character) {
        System.out.println(name + " has attacked " + character.getName() + "!");
        character.setHealth(character.getHealth() - attackDamage);
        System.out.println(character.getName() + "'s health: " + character.getHealth() + " (-" + attackDamage + ")");
    }

    // uses ability 1 or 2
    public void useAbility(Character character) {
        switch (ability1Ability2()) {
            case 1:
                getCharacterAbility(character, getAbility1());
                break;
            case 2:
                getCharacterAbility(character, getAbility2());
                break;
        }
    }

    public void getCharacterAbility(Character character, String ability) {
        System.out.println("Character class");
    }

    public boolean isDead(Character character) {
        if (character.getHealth() <= 0) {
            System.out.println("/=/=/=/\n" + character.getName() + " is dead!\n/=/=/=/");
            return true;
        }
        return false;
    }

    // gets the specific ability to be used on opponent
    public int ability1Ability2() {
        return (int)(Math.random()*2);
    }

    public void ability1Execution(Character character) {
        System.out.println(getName() + " used " + getAbility1() + " on " + character.getName());
    }

    public void ability2Execution(Character character) {
        System.out.println(getName() + " used " + getAbility2() + " on " + character.getName());
    }

    public void displayNewHealth(Character character) {
        System.out.println(character.getName() + "'s health: " + character.getHealth());
    }
}
