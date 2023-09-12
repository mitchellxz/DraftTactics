package sample;

public class Mage extends Character{
    Mage(String name, double health, double attackDamage, String ability1, String ability2) {
        super(name, health, attackDamage, ability1, ability2);
    }

    // gets the specific ability to be used on opponent
    public void getCharacterAbility(Character character, String ability) {
        switch (getName()) {
            case "Red":
                switch (ability) {
                    case "Fire":
                        ability1Execution(character);
                        character.setHealth(character.getHealth() - (200));
                        break;
                    case "Eruption":
                        ability2Execution(character);
                        character.setHealth(character.getHealth() - 230);
                        break;
                }
                displayNewHealth(character);
                break;
            case "Orange":
                switch (ability) {
                    case "Sunrise":
                        ability1Execution(character);
                        character.setHealth(character.getHealth() - (100));
                        break;
                    case "Sunset":
                        ability2Execution(character);
                        character.setHealth(character.getHealth() - (400));
                        break;
                }
                displayNewHealth(character);
                break;
            case "Teal":
                switch (ability) {
                    case "Wave":
                        ability1Execution(character);
                        character.setHealth(character.getHealth() - (150));
                        break;
                    case "Dive":
                        ability2Execution(character);
                        character.setHealth(character.getHealth() - (270));
                        break;
                }
                displayNewHealth(character);
                break;
            case "Lavender":
                switch (ability) {
                    case "Petals":
                        ability1Execution(character);
                        character.setHealth(character.getHealth() - (120));
                        break;
                    case "Scent":
                        ability2Execution(character);
                        character.setHealth(character.getHealth() - (300));
                        break;
                }
                displayNewHealth(character);
                break;
            default:
                System.out.println("no ability used");
        }
    }

}
