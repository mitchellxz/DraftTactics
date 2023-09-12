package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Modifier {
    static private int lives = setLives();
    static private double teamAttackDamage = 0;
    static private double teamHealth = 0;
    static private double enemyTeamAttackDamage = 0;
    static private double enemyTeamHealth = 0;

    public static int setLives() {
        File inputFile = new File("src/sample/lives.txt");
        try {
            Scanner fileReader = new Scanner(inputFile);
            return fileReader.nextInt();
        } catch (Exception e) {
            System.out.println("Can't find: " + inputFile);
        }
        return 1;
    }

    public static double getTeamAttackDamage() {
        return teamAttackDamage;
    }

    public static void increaseTeamAttack() {
        double increaseAttack = Math.random() * 30;
        teamAttackDamage += increaseAttack;
        System.out.println("\nTeam attack increased by " + increaseAttack + "!\n");
    }

    public static double getTeamHealth() {
        return teamHealth;
    }

    public static void increaseTeamHealth() {
        double increaseHealth = Math.random() * 100;
        teamHealth += increaseHealth;
        System.out.println("\nTeam health increased by " + increaseHealth + "!\n");

    }

    public static double getEnemyTeamAttackDamage() {
        return enemyTeamAttackDamage;
    }

    public static void increaseEnemyTeamAttack() {
        double increaseAttack = Math.random() * 30;
        enemyTeamAttackDamage += increaseAttack;
        System.out.println("\nEnemy team attack increased by " + increaseAttack + "!\n");
    }

    public static double getEnemyTeamHealth() {
        return enemyTeamHealth;
    }

    public static void increaseEnemyTeamHealth() {
        double increaseHealth = Math.random() * 100;
        enemyTeamHealth += increaseHealth;
        System.out.println("\nEnemy team health increased by " + increaseHealth + "!\n");

    }

    public static int getLives() {
        return lives;
    }

    public static void decreaseLives() {
        lives--;
    }
}
