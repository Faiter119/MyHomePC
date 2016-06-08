import java.awt.Dimension;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
 
/*
Bugs fixed: enemy health, (I was subtracting the hit, but then checking if the subtracted health is less than the hit), not being able to see monster health (fixed by generating spawn before printing), added loads of comments, added theamount of steps to death, changed exp to give you the healAmount = to enemy health
Fixed not displaying health left (it would say "you have 99 left as opposed to you have 99 health left)
added: lots of dialog fixes, tells you when you leave the chest
fixed Dying during movement or from a chest doesnt display any death dialog
//added stat info on movement and battle
fixed a bunch of spacing mistakes
//Fixed chest randomly not picking anything - case 0
fixed potion not displaying when drinnk (only displayed when you healed over max health - order of code
fixed leave chest/no option - it was in the switch
added buttons to all yes,no
added random enemy names
fixed negative health (after getting hit, set health to 0 in <1)
make the game more smooth (fewer dialog boxes, more console)
added TRUE RANDOM GENERATED exit that doesnt change
CONVERTED TO BUTTONS
//The health prints before you use a potion so like it says you have 12 health after healing 10 hp when it should say 22
 * made exit button work by checking if input = -1 then if it is system.exit
 *fixed battle method -potion breaking battle, run not working in battle
 * ADDED MAXIMUM MOVEMENT
 *
 // fix potion triggering stuff, run not displaying, level system
  * Health on potion now displays over
 
 
add enemies killed
  *
  *
  *
//To do: different enemies, Scale exp to level and enemies
add classes
different attacks
graphics
sound
ARRAY to truly random generate monster spawns and chest
*/

public class Dungeon {

    static int health = 100;
    static int gold = 0;
    static int exp = 0;
    static int playerChosenDirection;
    static int monsterAt;
    static int chestAt;
    static int shopAt;
    static int enemyHealth;
    static int potion = 3;
    static int healAmount;
    static char userInput = 0;
    static int buttonInput;
    static boolean die = false;
    static boolean chest;
    static int chestLoot;
    static int chestGold;
    static int chestPotion;
    static int chestTrap;
    static int chestNothing;
    static int level = 1;
    static int amountNorth = 0;
    static int amountEast = 0;
    static int amountStep = 0;
    static boolean leave;
    static int expToLevel;
    static int exitNorth = (int) Math.floor(Math.random() * 20 - 10); // -15-
    // +15
    static int exitEast = (int) Math.floor(Math.random() * 20 - 10); // -15 -
    // +15

    public static void main(String[] args) {
        /*
         * JOptionPane.showMessageDialog(null, "Welcome.");
         * JOptionPane.showMessageDialog(null,
         * "You are in a dungeon and slowly bleeding out with every step that you take."
         * ); JOptionPane.showMessageDialog(null, "You have 3 health potions.");
         * JOptionPane.showMessageDialog(null,
         * "You have the choice of going (N)orth, (E)ast, (S)outh or (W)est or using a (P)otion"
         * ); JOptionPane.showMessageDialog(null,
         * "Good luck! Monsters have a chance of spawning and a chance of dropping a health potion and give exp and gold. You may also find a chest with loot or a shop."
         * );
         *
         *
         */

        while (health > 0) {

            do {

                String[] options = new String[] { "Go North", "Go East", "Go South", "Go West", "Drink a potion" }; // ,"Go
                // South","Go
                // West","Drink
                // a
                // potion"
                UIManager.put("OptionPane.minimumSize", new Dimension(300, 300));
                int buttonInput = JOptionPane.showOptionDialog(null,
                        "Which way do you go?" + "\n\n" + "Health: " + health + "\n" + "Potions: " + potion + "\n"
                                + "Exp: " + exp + "/" + expToLevel + "\n" + "Level: " + level + "\n" + "Gold: " + gold
                                + "\n" + "Location: " + amountNorth + ", " + amountEast + "\n" + "Steps: " + amountStep
                                + "\n\n",
                        "Wandering!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, // the
                        // titles
                        // of
                        // buttons
                        options[0]); // default button title
                if (buttonInput == -1) { // x button
                    System.exit(0);
                }


                else if (buttonInput == 0 && amountNorth<=10) { //north
                    if (amountNorth==10){
                        System.out.println("You can not go that way");
                        JOptionPane.showMessageDialog(null,"You can not go that way"); break;}
                    amountStep++;
                    amountNorth++;
                    System.out.println("You went north. You are now at " + amountNorth + ", " + amountEast + ".");

                }

                else if (buttonInput == 1 && amountEast<=10) { //east
                    if (amountEast==10){
                        System.out.println("You can not go that way");
                        JOptionPane.showMessageDialog(null,"You can not go that way"); break;}
                    amountStep++;
                    amountEast++;
                    System.out.println("You went east. You are now at " + amountNorth + ", " + amountEast + ".");
                    //ADD METHOD
                } else if (buttonInput == 2) { //south
                    if (amountNorth==-10){
                        System.out.println("You can not go that way");
                        JOptionPane.showMessageDialog(null,"You can not go that way");
                        break;}
                    amountStep++;
                    amountNorth--;
                    System.out.println("You went south. You are now at " + amountNorth + ", " + amountEast + ".");
                } else if (buttonInput == 3) { //west
                    if (amountEast==-10){
                        System.out.println("You can not go that way");
                        JOptionPane.showMessageDialog(null,"You can not go that way");
                        break;}
                    amountStep++;
                    amountEast--;
                    System.out.println("You went west. You are now at " + amountNorth + ", " + amountEast + ".");

                } else if (buttonInput == 4) { //potion
                    if (potion > 0) { // if you have a potion
                        potion--; // remove 1 potion
                        healAmount = (int) ((Math.random() * 16) + 10); // heal
                        // 10-25
                        health += healAmount; // heal from potion
                        if (health > 100) { // cant go over max health
                            health = 100;
                        }
                        System.out.println("You drink a potion. It heals " + healAmount + " health. You have " + potion
                                + " potions left.");
                        JOptionPane.showMessageDialog(null, "You drink a potion. It heals " + healAmount
                                        + " health. You have " + potion + " potions left.", "Potion!",
                                JOptionPane.PLAIN_MESSAGE);

                    } else if (potion == 0) {
                        System.out.println("You have 0 potions to drink.");
                        JOptionPane.showMessageDialog(null, "You have no potions to drink.", "Potion!",
                                JOptionPane.PLAIN_MESSAGE);
                    }}}

            while (buttonInput != 0 && buttonInput != 1 && buttonInput != 2 && buttonInput != 3);


            playerChosenDirection = Move(buttonInput);

            monsterAt = (int) Math.floor(Math.random() * 5); // 20%
            chestAt = (int) Math.floor(Math.random() * 7); // 17%
            shopAt = (int) Math.floor(Math.random() * 10); // 11%
            // 42% of nothing

            if (amountNorth == exitNorth && amountEast == exitEast) {

                System.out.println("You found an exit at " + amountNorth + ", " + amountEast + "!");
                JOptionPane.showMessageDialog(null, "You found an exit at " + amountNorth + ", " +amountEast+ "!", "Exit!",
                        JOptionPane.PLAIN_MESSAGE);
                leave();
            } else if (playerChosenDirection == monsterAt) {

                String[] enemyNames = { "Goblin", "Skeleton", "Ghost", "Zombie", "Banshee", "Vampire", "Dragon",
                        "Spider", "Slime", "Rat", "Bear" };
                Random rnd = new Random();
                String enemyName = enemyNames[rnd.nextInt(11)];
                enemyHealth = (int) ((Math.random() * 10) + 10); // create enemy

                System.out.println(enemyName + " found at " + amountNorth + ", " + amountEast + ".");
                JOptionPane.showMessageDialog(null,
                        "You encounter a " + enemyName + ". It has " + enemyHealth + " health. ", "Battle!",
                        JOptionPane.PLAIN_MESSAGE);
                battle(enemyName); // start battle
            } else {

                if (playerChosenDirection == chestAt) {
                    System.out.println("You found a chest.");
                    JOptionPane.showMessageDialog(null, "You found a chest!", "Chest!", JOptionPane.PLAIN_MESSAGE);

                    chest();
                } else if (gold > 10) {
                    if (buttonInput != 4 && playerChosenDirection == shopAt) {
                        System.out.println("You found a shop.");
                        JOptionPane.showMessageDialog(null, "You found a shop!", "Shop!", JOptionPane.PLAIN_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Do you buy a potion for 10 gold?", "Shop!",
                                JOptionPane.PLAIN_MESSAGE);
                        shop();
                    }
                } else {
                    // continue wandering
                }

            }

        }
    }








    private static int Move(int buttonInput) {
        return 0;
    }

    public static void chest() {

        Object[] options = { "Open it", "Leave it" };
        int input = JOptionPane.showOptionDialog(null,
                "Do you want to open it?" + "\n\nHealth: " + health + "\n" + "Potions: " + potion + "\n\n", "Chest!",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, // the
                // titles
                // of
                // buttons
                options[0]); // default button title
        if (input == -1) { // x button
            System.exit(0);
        }
        if (input == JOptionPane.YES_OPTION) {
            int loot = (int) (Math.random() * 5);

            switch (loot) {

                case 0:

                    gold += (int) (Math.random() * 6 + 5);
                    System.out.println("You found some gold! You now have " + gold + " gold.");
                    JOptionPane.showMessageDialog(null, "You found some gold! You now have " + gold + " gold.", "Chest!",
                            JOptionPane.PLAIN_MESSAGE);

                    break;

                case 1:

                    potion++;
                    System.out.println("You found a potion!");
                    JOptionPane.showMessageDialog(null, "You found a potion! You now have " + potion + " potions.",
                            "Chest!", JOptionPane.PLAIN_MESSAGE);

                    break;

                case 2:
                    int chestHit = (int) (Math.random() * 16 + 10);
                    health -= chestHit; // hit 10-25
                    if (health < 0) {
                        health = 0; // Can't go negative health
                    }
                    System.out.println("Oh no! The chest was trapped. You took " + chestHit + " damage... You now have "
                            + health + " health.");
                    JOptionPane.showMessageDialog(null, "Oh no! The chest was trapped. You took " + chestHit
                            + " damage... You now have " + health + " health.", "Chest!", JOptionPane.PLAIN_MESSAGE);
                    if (health < 1) {

                        die = true; // dead
                        System.out.println("Oh dear, you are dead!");
                        JOptionPane.showMessageDialog(null, "Oh dear, you are dead!", "You died!",
                                JOptionPane.PLAIN_MESSAGE);
                        System.out.println("You die with " + exp + " exp and " + gold + " gold.");
                        JOptionPane.showMessageDialog(null, "You die with " + exp + " exp and " + gold + " gold.");
                        System.out.println("You died at " + amountNorth + ", " + amountEast + ".");
                        JOptionPane.showMessageDialog(null, "You died at " + amountNorth + ", " + amountEast + ".",
                                "You died!", JOptionPane.PLAIN_MESSAGE);
                        System.out.println("You lived for " + amountStep + " steps.");
                        JOptionPane.showMessageDialog(null, "You lived for " + amountStep + " steps.", "You died!",
                                JOptionPane.PLAIN_MESSAGE);
                        System.exit(0);
                    }
                    break;

                case 3:

                    System.out.println("No loot from that chest.");
                    JOptionPane.showMessageDialog(null, "You found nothing...", "Chest!", JOptionPane.PLAIN_MESSAGE);

                    break;

                case 4:

                    System.out.println("No loot from that chest.");
                    JOptionPane.showMessageDialog(null, "You found nothing...", "Chest!", JOptionPane.PLAIN_MESSAGE);

                    break;

            }

        } else {

            System.out.println("You decide to leave the chest.");
            JOptionPane.showMessageDialog(null, "You decide to leave the chest.", "Chest!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void battle(String enemyName)
    // level doesnt work, potion doesnt, run doesnt (technically)
    {
        int hit;
        int giveGold = (int) (Math.random() * 10 + 1);
        // int giveExp = (int) (Math.random() * 10 + 1);

        if (health > 0) { // check you're alive.
            String[] options = new String[] { "Attack", "Defend", "Drink a potion", "Run" };

            int buttonInput = JOptionPane.showOptionDialog(null, "What do you do?"

                            + "\n\n" + // stats display
                            enemyName + " health: " + enemyHealth + "\n\n" + "Health: " + health + "\n" + "Level: " + level
                            + "\n" + "Potions: " + potion + "\n\n", "Battle!", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, // the titles of
                    // buttons
                    options[0]);
            if (buttonInput == -1) { // x button
                System.exit(0);
            }
            if (buttonInput == 0) { // attack
                hit = (int) (Math.random() * 6 * .5 * level + 2); // your damage
                // - 1/2
                // level + 1
                // - 6 + 2;
                enemyHealth -= hit;

                if (enemyHealth <= 0) { // hit high enough to kill the enemy
                    System.out.println("You hit " + hit + " damage and kill the " + enemyName + "!");
                    JOptionPane.showMessageDialog(null, "You hit " + hit + " damage and kill the " + enemyName + "!",
                            "Battle!", JOptionPane.PLAIN_MESSAGE);

                    gold += giveGold; // gives player gold

                    exp += 10;// gives player exp
                    System.out.println("You found " + giveGold + " gold and gained 10 exp.");
                    JOptionPane.showMessageDialog(null, "You gained 10 exp and found " + gold + " gold.", "Loot!",
                            JOptionPane.PLAIN_MESSAGE);
                    // System.out.println("You now have a total of " + exp + "
                    // exp and " + gold + " gold.");
                    // JOptionPane.showMessageDialog(null, "You now have " + exp
                    // + " exp and " + gold + " gold.", "Loot!",
                    // JOptionPane.PLAIN_MESSAGE);
                    int potionDrop = (int) (Math.random() * 10); // 1 / 10
                    if (potionDrop == 0) {
                        potion++; // gain a potion
                        System.out.println("You gained a potion! You now have " + potion + " potions.");
                        JOptionPane.showMessageDialog(null, "You gained a potion! You now have " + potion + " potions.",
                                "Loot!", JOptionPane.PLAIN_MESSAGE);
                    }
                    level(); // after seeing what you get, show the level
                } else { // continue the battle
                    System.out.println(
                            "You hit " + hit + " damage. The " + enemyName + " now has " + enemyHealth + " health.");
                    JOptionPane.showMessageDialog(null,
                            "You hit " + hit + " damage. The " + enemyName + " now has " + enemyHealth + " health.",
                            "Battle!", JOptionPane.PLAIN_MESSAGE);

                    hit = (int) ((Math.random() * 8) + 2);
                    health -= hit; // enemy hits you back
                    if (health < 0) {
                        health = 0; // Can't go negative health
                    }
                    System.out.println("The " + enemyName + " retaliates with " + hit + " damage. Your health is now "
                            + health + ".");
                    JOptionPane.showMessageDialog(null,
                            "The " + enemyName + " retaliates with a " + hit + ". Your health is now " + health + ".",
                            "Battle!", JOptionPane.PLAIN_MESSAGE);
                    if (health < 1) { // dead

                        die = true; // dead
                        System.out.println("Oh dear, you are dead!"); // Runescape
                        // reference
                        JOptionPane.showMessageDialog(null, "Oh dear, you are dead!", "You died!",
                                JOptionPane.PLAIN_MESSAGE);
                        System.out.println("You die with " + exp + " exp and " + gold + " gold.");
                        JOptionPane.showMessageDialog(null, "You died with " + exp + " exp and " + gold + " gold.",
                                "You died!", JOptionPane.PLAIN_MESSAGE);
                        System.out.println("You died at " + amountNorth + ", " + amountEast + ".");
                        JOptionPane.showMessageDialog(null, "You died at " + amountNorth + ", " + amountEast + ".",
                                "You died!", JOptionPane.PLAIN_MESSAGE);
                        System.out.println("You lived for " + amountStep + " steps.");
                        JOptionPane.showMessageDialog(null, "You lived for " + amountStep + " steps.", "You died!",
                                JOptionPane.PLAIN_MESSAGE);
                        System.exit(0);
                    } else {

                        battle(enemyName); // battle isn't over because you're
                        // both alive
                    }
                }
            } else if (buttonInput == 1) { // defend

                hit = (int) ((Math.random() * 5)); // enemy hits half of normal
                // because defending mode.

                health -= hit;
                if (health < 0)
                    health = 0; // Can't go negative health

                System.out.println("You took " + hit + " damage! Your health is now " + health + ".");
                JOptionPane.showMessageDialog(null, "You took " + hit + " damage! Your health is now " + health + ".",
                        "Battle!", JOptionPane.PLAIN_MESSAGE);
                if (health < 1) { // dead

                    die = true; // dead
                    System.out.println("Oh dear, you are dead!"); // Runescape
                    // reference
                    JOptionPane.showMessageDialog(null, "Oh dear, you are dead!", "You died!",
                            JOptionPane.PLAIN_MESSAGE);
                    System.out.println("You die with " + exp + " exp and " + gold + " gold.");
                    JOptionPane.showMessageDialog(null, "You died with " + exp + " exp and " + gold + " gold.",
                            "You died!", JOptionPane.PLAIN_MESSAGE);
                    System.out.println("You died at " + amountNorth + ", " + amountEast + ".");
                    JOptionPane.showMessageDialog(null, "You died at " + amountNorth + ", " + amountEast + ".",
                            "You died!", JOptionPane.PLAIN_MESSAGE);
                    System.out.println("You lived for " + amountStep + " steps.");
                    JOptionPane.showMessageDialog(null, "You lived for " + amountStep + " steps.", "You died!",
                            JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                } else {
                    battle(enemyName);
                }
                battle(enemyName); // battle continues

            } else if (buttonInput == 2) {

                if (potion > 0) { // checks if you actually have a potion
                    potion--; // remove 1 potion
                    healAmount = (int) ((Math.random() * 16) + 10); // generate
                    // random heal
                    // amount
                    // between 10-25

                    health += healAmount; // heal from potion
                    if (health > 100) {
                        health = 100; // Can't go over max health
                    }
                    System.out.println("You drink a potion. It heals " + healAmount + " health. You have " + potion
                            + " potions left.");
                    JOptionPane.showMessageDialog(null, "You drink a potion. It heals " + healAmount
                            + " health. You have " + potion + " potions left.", "Battle!", JOptionPane.PLAIN_MESSAGE);

                    hit = (int) ((Math.random() * 6 + 2)); // enemy hit on you
                    // after
                    // potion
                    health -= hit; // enemy hits you back
                    if (health < 0) {
                        health = 0; // Can't go negative health
                    }
                    System.out.println(
                            "The " + enemyName + " hits you with a " + hit + ". Your health is now " + health + ".");
                    JOptionPane.showMessageDialog(null,
                            "The " + enemyName + " hits you with a " + hit + ". Your health is now " + health + ".",
                            "Battle!", JOptionPane.PLAIN_MESSAGE);
                    if (health < 1) { // dead

                        die = true; // dead
                        System.out.println("Oh dear, you are dead!"); // Runescape
                        // reference
                        JOptionPane.showMessageDialog(null, "Oh dear, you are dead!", "You died!",
                                JOptionPane.PLAIN_MESSAGE);
                        System.out.println("You die with " + exp + " exp and " + gold + " gold.");
                        JOptionPane.showMessageDialog(null, "You died with " + exp + " exp and " + gold + " gold.",
                                "You died!", JOptionPane.PLAIN_MESSAGE);
                        System.out.println("You died at " + amountNorth + ", " + amountEast + ".");
                        JOptionPane.showMessageDialog(null, "You died at " + amountNorth + ", " + amountEast + ".",
                                "You died!", JOptionPane.PLAIN_MESSAGE);
                        System.out.println("You lived for " + amountStep + " steps.");
                        JOptionPane.showMessageDialog(null, "You lived for " + amountStep + " steps.", "You died!",
                                JOptionPane.PLAIN_MESSAGE);
                        System.exit(0);
                    } else {
                        battle(enemyName);
                    }
                } else { // if you don't have more than 0 potions, don't heal
                    System.out.println("You have 0 potions to drink.");
                    JOptionPane.showMessageDialog(null, "You have no potions to drink.", "Battle!",
                            JOptionPane.PLAIN_MESSAGE);
                    battle(enemyName);

                }
                battle(enemyName);
            } else if (buttonInput == 3)

            { // run
                int runChance = (int) (Math.random() * 2); // 50/50 chance of
                // escape
                if (runChance == 0) {
                    // successful escape, battle over and continues adventure
                    System.out.println("You successfully escape!");
                    JOptionPane.showMessageDialog(null, "You successfully escape!", "Escape!",
                            JOptionPane.PLAIN_MESSAGE);

                }

                else

                { // unsuccessful escape
                    hit = (int) ((Math.random() * 11) + 6); // enemy hit between
                    // 10-20
                    health -= hit; // so you get hit
                    if (health < 0)
                        health = 0; // Can't go negative health

                    System.out.println("You try to escape but are too slow. The " + enemyName + " hits you for a " + hit
                            + ". You now have " + health + " health.");
                    JOptionPane
                            .showMessageDialog(null,
                                    "You try to escape but are too slow. The " + enemyName + " hits you for a " + hit
                                            + ". You now have " + health + " health.",
                                    "Battle!", JOptionPane.PLAIN_MESSAGE);
                    if (health < 1) { // dead

                        die = true; // dead
                        System.out.println("Oh dear, you are dead!"); // Runescape
                        // reference
                        JOptionPane.showMessageDialog(null, "Oh dear, you are dead!", "You died!",
                                JOptionPane.PLAIN_MESSAGE);
                        System.out.println("You die with " + exp + " exp and " + gold + " gold.");
                        JOptionPane.showMessageDialog(null, "You died with " + exp + " exp and " + gold + " gold.",
                                "You died!", JOptionPane.PLAIN_MESSAGE);
                        System.out.println("You died at " + amountNorth + ", " + amountEast + ".");
                        JOptionPane.showMessageDialog(null, "You died at " + amountNorth + ", " + amountEast + ".",
                                "You died!", JOptionPane.PLAIN_MESSAGE);
                        System.out.println("You lived for " + amountStep + " steps.");
                        JOptionPane.showMessageDialog(null, "You lived for " + amountStep + " steps.", "You died!",
                                JOptionPane.PLAIN_MESSAGE);
                        System.exit(0);
                    } else {
                        battle(enemyName); // battle continues
                    }
                }
            }

            else if (health < 1) { // dead

                die = true; // dead
                System.out.println("Oh dear, you are dead!"); // Runescape
                // reference
                JOptionPane.showMessageDialog(null, "Oh dear, you are dead!", "You died!", JOptionPane.PLAIN_MESSAGE);
                System.out.println("You die with " + exp + " exp and " + gold + " gold.");
                JOptionPane.showMessageDialog(null, "You died with " + exp + " exp and " + gold + " gold.", "You died!",
                        JOptionPane.PLAIN_MESSAGE);
                System.out.println("You died at " + amountNorth + ", " + amountEast + ".");
                JOptionPane.showMessageDialog(null, "You died at " + amountNorth + ", " + amountEast + ".", "You died!",
                        JOptionPane.PLAIN_MESSAGE);
                System.out.println("You lived for " + amountStep + " steps.");
                JOptionPane.showMessageDialog(null, "You lived for " + amountStep + " steps.", "You died!",
                        JOptionPane.PLAIN_MESSAGE);
                System.exit(0);

            }
        }
    }

    public static void level() { // level up; more efficient way?

        // JOptionPane.showMessageDialog(null, "You are level " + level + ".");
        // System.out.println("Level " + level + ".");

        switch (level) {

            case 0:
                if (exp < 20)

                    expToLevel = 20;
            case 1:
                if (exp == 20)
                    expToLevel = 40;
                break;
            case 2:
                if (exp >= 40)
                    level++;
                expToLevel = 80;
                break;
            case 3:
                if (exp >= 40)
                    level++;
                expToLevel = 80;
                break;
            case 4:
                if (exp >= 80)
                    level++;
                expToLevel = 160;
                break;
            case 5:
                if (exp >= 160)
                    expToLevel = 320;
                level++;
                break;
            case 6:
                if (exp >= 320)
                    level++;
                expToLevel = 640;
                break;

            default:
                break;
        }
    }

    public static void leave() { // leave the dungeon; beating the game really

        Object[] options = { "Leave now", "Don't leave" };
        int input = JOptionPane.showOptionDialog(null,
                "Would you like to leave now?" + "\n\nHealth: " + health + "\n" + "Potions: " + potion + "\n" + "Exp: "
                        + exp + "/" + expToLevel + "\n" + "Level: " + level + "\n" + "Gold: " + gold + "\n"
                        + "Location: " + amountNorth + ", " + amountEast + "\n" + "Steps: " + amountStep + "\n\n",
                "Exit!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (input == -1) { // x button
            System.exit(0);
        }
        if (input == JOptionPane.YES_OPTION) {

            leave = true;
            System.out.println("You leave with " + exp + " exp and " + gold + " gold.");
            JOptionPane.showMessageDialog(null, "You leave with " + exp + " exp and " + gold + " gold.");
            System.out.println("You took " + amountStep + " steps to find the exit.");
            JOptionPane.showMessageDialog(null, "You took " + amountStep + " steps to find the exit.");
            System.out.println("Your exit was at " + amountNorth + ", " + amountEast);
            JOptionPane.showMessageDialog(null, ("Your exit was at " + amountNorth + ", " + amountEast));
            System.exit(0);
        } else {
            leave = false; // go back to wandering
            System.out.println("You decide to remain in the dungeon");
            JOptionPane.showMessageDialog(null, "You decide to remain in the dungeon", "Exit!",
                    JOptionPane.PLAIN_MESSAGE);
        }

    }

    public static void shop() { // Finding a shop
        Object[] options = { "Buy a potion", "Don't buy a potion" };
        int input = JOptionPane.showOptionDialog(null,
                "Would you like to buy a potion?" + "\n\nHealth: " + health + "\nPotions: " + potion + "\nGold: " + gold
                        + "\n",
                "Shop!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do

                options, // the titles of buttons
                options[0]); // default button title);
        if (input == -1) { // x button
            System.exit(0);
        }
        if (input == JOptionPane.YES_OPTION) {
            gold -= 10; // take away 10 gold and buy a potion
            potion++;
            System.out.println("You buy a potion.");
            JOptionPane.showMessageDialog(null,
                    "You buy a potion. You now have " + potion + " potions and " + gold + " gold left.", "Shop!",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            System.out.println("You decide to not buy a potion");
            JOptionPane.showMessageDialog(null, "You decide to not buy a potion.", "Shop!", JOptionPane.PLAIN_MESSAGE);
        }
    }
}