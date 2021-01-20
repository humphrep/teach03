package humphreys;


import com.google.gson.Gson;

import java.util.Scanner;
import java.util.Map;

public class Main {

    //Scanner in order to take user input
    private static final Scanner scanner = new Scanner( System.in );

    public static void main(String[] args) {
        Gson g = new Gson();

        //Collect the information to create the Player
        System.out.print("Enter the players name: ");
        String name = scanner.next();
        System.out.print("Enter the players Health: ");
        Integer health = scanner.nextInt();
        System.out.print("Enter the players Gold: ");
        Integer gold = scanner.nextInt();
        System.out.print("Enter the players Mana: ");
        Integer mana = scanner.nextInt();

        //Create the Player
        Player player = new Player(name, health, gold, mana);

        //Get the equipment list
        boolean continueEntering = true;
        String eq;
        Integer price;
        while (continueEntering){
            System.out.print("Enter the equipment name (or quit to quit): ");
            eq = scanner.next();
            if (eq.equals("quit")) {
                continueEntering = false;
            } else {
                System.out.print("Enter the equipment price: ");
                price = scanner.nextInt();
                player.addEquipment(eq, price);
            }
        }

        //Create the game
        Game game = new Game(player);

        //Save the Game
        game.saveGame();

        String fileName = "player.json";

        //Load the Game into a new Game class
        Game game2 = game.loadGame(fileName);

        // Compare the two Game Classes
        game.player.displayPlayer();
        game2.player.displayPlayer();

    }
}

