package humphreys;

import java.util.Map;
import java.util.HashMap;

public class Player {
    private String name;
    private Integer health;
    private Integer gold;
    private Integer mana;
    private Map<String, Integer> equipment;

    /**
     * Loads the Game data from a file
     * @param name
     * @param health
     * @param gold
     * @param mana
     */
    public Player(String name, Integer health, Integer gold, Integer mana) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.mana = mana;
        this.equipment = new HashMap<>();
    }

    /**
     * Displays the Player information to the console
     */
    public void displayPlayer(){
        System.out.printf("Player name: %s%n", this.name );
        System.out.printf("Player Health: %d%n", this.health );
        System.out.printf("Player Gold: %d%n", this.gold );
        System.out.printf("Player Mana: %d%n", this.mana );
        this.equipment.forEach((k, v) -> System.out.printf("%s: $%d%n", k, v));
        System.out.println("===================================");
    }

    /**
     * Adds the equipment and cost to the equipment Map
     * @param equipmentName
     * @param cost
     */
    public void addEquipment(String equipmentName, Integer cost){
        this.equipment.put(equipmentName, cost);
    }

}
