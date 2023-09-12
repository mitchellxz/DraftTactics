package sample;

public class Fighter extends Character{
    Fighter(String name, double health, double attackDamage, String ability1, String ability2) {
        super(name, health, attackDamage, ability1, ability2);
    }

    public void getCharacterAbility(Character character, String ability) {
        switch (getName()) {
            case "Galaxy":
                switch (ability) {
                    case "Star Dust":
                        ability1Execution(character);
                        character.setHealth(character.getHealth() - (57));
                        break;
                    case "Black Hole":
                        ability2Execution(character);
                        character.setHealth(character.getHealth() - (111));
                        break;
                }
                displayNewHealth(character);
                break;
            case "Purple":
                switch (ability) {
                    case "Grape Throw":
                        ability1Execution(character);
                        character.setHealth(character.getHealth() - (25));
                        break;
                    case "Black Eye":
                        ability2Execution(character);
                        character.setHealth(character.getHealth() - (115));
                        break;
                }
                displayNewHealth(character);
                break;
            case "Pink":
                switch (ability) {
                    case "Oink":
                        ability1Execution(character);
                        character.setHealth(character.getHealth() - (35));
                        break;
                    case "Sparkles":
                        ability2Execution(character);
                        character.setHealth(character.getHealth() - (104));
                        break;
                }
                displayNewHealth(character);
                break;
            default:
                System.out.println("no ability used");
        }
    }

}
