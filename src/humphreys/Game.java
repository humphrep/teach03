package humphreys;

import com.google.gson.Gson;

import java.io.*;


public class Game {
    Player player;

    public Game(Player player) {
        this.player = player;
    }

    /**
     * Saves the Game data to a file
     *
     */
    public void saveGame() {
        Gson gson = new Gson();
        String json = gson.toJson(this.player);

        try {
            File myObj = new File("player.json");

            //See if we can create the file, if True the file was created
            // if false the file already exists, otherwise it will throw an exception
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            //Write the json data to the file, will over write the file if it already existed
            FileWriter myWriter = new FileWriter("player.json");
            myWriter.write(json);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    /**
     * Loads the Game data from a file
     * @param filename
     */
    public static Game loadGame(String filename) {

        Gson gson = new Gson();

        // Open the file and read the json data, assigning it to a member of the
        //  Player class
        try (Reader reader = new FileReader(filename)) {

            // Convert JSON File to Java Object
            Player player = gson.fromJson(reader, Player.class);

            return new Game(player);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
