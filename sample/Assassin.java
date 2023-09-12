package sample;

public class Assassin extends Character{
    Assassin(String name, double health, double attackDamage, String ability1, String ability2) {
        super(name, health, attackDamage, ability1, ability2);
    }

    // uses an ability based on the name & ability of the character
    public void getCharacterAbility(Character character, String ability) {
        switch (getName()) {
            case "Green":
                switch (ability) {
                    case "Goo":
                        ability1Execution(character);
                        character.setHealth(character.getHealth() - (50));
                        break;
                    case "Grass Spikes":
                        ability2Execution(character);
                        character.setHealth(character.getHealth() - (200));
                        break;
                }
                displayNewHealth(character);
                break;
            case "Sky":
                switch (ability) {
                    case "Fog":
                        ability1Execution(character);
                        character.setHealth(character.getHealth() - (75));
                        break;
                    case "Lightning":
                        ability2Execution(character);
                        character.setHealth(character.getHealth() - (150));
                        break;
                }
                displayNewHealth(character);
                break;
            case "Lilac":
                switch (ability) {
                    case "Withers":
                        ability1Execution(character);
                        character.setHealth(character.getHealth() - (100));
                        break;
                    case "Pollen":
                        ability2Execution(character);
                        character.setHealth(character.getHealth() - (125));
                        break;
                }
                displayNewHealth(character);
                break;
            default:
                System.out.println("no ability used");
        }
    }

}
