import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

import java.util.*;

//Ok so we didn't have the patience to go through here and add comments to all of the 100+ sections of our code.
// Lets be honest, you wouldn't have read them anyway. Most of this stuff is quite self explanatory by either the dialogue that goes with it or names of methods.
/*
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//the main class that we used as variable storage.

//Cited here for ease of access, in multiple places we open a link (UIButton primarily), here is the link to that tutorial we used: https://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button


public class MyWorld extends World
{ //More counter buttons
    public ArrayList<Enemy> eList = new ArrayList<Enemy>();
    public static boolean inCombat = true;
    public static boolean buttonExist = true;
    public int towerfought = 0;
    public int shouted = 0;
    public int rockcount = 0;
    public int screamcount = 0;
    //Counter variables for UIButton
    public static boolean skipTurn = false;
    public int housecount = 0;
    public int toiletcount = 0;
    public boolean shopOpen = false;
    public int rocksfought = 0;
    public int tubcount = -1;
    public int shroomcount = 0;
    public int slots = 0;
    public boolean hasTicket = false;
    public int doorcount = 0;
    public int wolfcount = 0;
    public int kisscount = 0;
    public boolean stolewolf = false;
    public boolean kissedwolf = false;
    public boolean healed = false;
    //Positioning variables
    public static final int atkx = 70;
    public static final int magx = 195;
    public static final int actx = 320;
    public static final int itemx = 445;
    public static final int actiony = 575;
    //More buttons!
    public static UIButton buttonATTACK = new UIButton("ATTACK");
    public static UIButton buttonMAGIC = new UIButton("MAGIC");
    public static UIButton buttonACT = new UIButton("SCREAM");
    public static UIButton buttonITEM = new UIButton("RUN");
    public static Backpack backpack = new Backpack();
    //Delays
    /* public final int delay1 = 75;
    public final int delay2 = 100;
    public final int delay3 = 200;
    public final int delay4 = 350;
    public final int delay5 = 500; */
    public final int delay1 = 200;
    public final int delay2 = 300;
    public final int delay3 = 600;
    public final int delay4 = 1000;
    public final int delay5 = 1500;
    public static int stage = 3;
    public boolean hasEaten = false;

    public WorldObject angryrock = new WorldObject("AngryRock.png");
    public String rockStr = "RICK THE ROCK: STOP IT!";
    public WorldObject pineapplehouse = new WorldObject("House.png");
    public WorldObject pineapplepete = new WorldObject("PineapplePete.png");
    //More buttons?
    public static UIButton buttonMAGATK = new UIButton("CAST");
    public static UIButton buttonMAGDEF = new UIButton("PROTECT");
    public static UIButton buttonMAGHEAL = new UIButton("HEAL");
    public static UIButton buttonMAGBACK = new UIButton("BACK");
    //All weapons
    public static Weapon rubberband = new Weapon("Rubber Band",0.1);
    public static Weapon stick = new Weapon("Stick",1.5);
    public static Weapon lotteryTicket = new Weapon("Lottery Ticket",1.0);
    public static Weapon board = new Weapon("Wooden Board",2.0);
    public static Weapon shortsword = new Weapon("Shortsword",3.5);
    public static Weapon mace = new Weapon("Mace",5.0);
    public static Weapon longsword = new Weapon("Longsword",4.0);
    public static Weapon reaver = new Weapon("Shadowflame Reaver", 6.0);
    public static Weapon dawnblade = new Weapon("Celestial Dawnblade", 6.0);
    public static Weapon stormcaller = new Weapon("Stormcaller's Wrath",6.0);
    public static Weapon ebonheart = new Weapon("Ebonheart Halberd",6.0);
    public static Weapon frostbound = new Weapon("Frostbound Scimitar",6.0);
    public static Weapon seventh = new Weapon("Seventh Scythe",6.5);
    public static Weapon weaponofpowerandspecialthingsthatiscapableofkillingmanythingsthatarebigandscaryandposeathreattoyouradventureeventhoughyouareprobablypowerfulenoughtodefeatthemanyway = new Weapon("Weapon of Power and Special Things that is Capable of Killing Many Things that are Big and Scary and Pose a Threat to your Adventure Even Though You Are Probably Powerful Enough to Defeat Them Anyway",30.0);
    public static Weapon polio = new Weapon("Jaundice 2: Polio", 5.0);
    //All armors
    public static Armor rags = new Armor("Ragged Rags", 6);
    public static Armor leather = new Armor("Leather Armor", 7);
    public static Armor wool = new Armor("Woolen Clothing", 8);
    public static Armor chain = new Armor("Chain Armor", 9);
    public static Armor plate = new Armor("Steel Plate", 11);
    public static Armor knight = new Armor("Knight's Armor", 9);
    public static Armor royal = new Armor("Royal Robes", 12);

    //All buttons
    public static UIButton buttonTOILET = new UIButton("TOILET");
    public static UIButton buttonTOWER = new UIButton("TOWER");
    public static UIButton buttonHOUSE = new UIButton("HOUSE");
    public static UIButton buttonROCK = new UIButton("ROCK");
    
    public static UIButton buttonSHOUT = new UIButton("SHOUT");
    public static UIButton buttonMUSHROOM = new UIButton("MUSHROOM");
    public static UIButton buttonBATHTUB = new UIButton("BATHTUB");
    public static UIButton buttonROCKS = new UIButton("ROCKS");

    public static UIButton buttonHOWL = new UIButton("HOWL");
    public static UIButton buttonSEARCH = new UIButton("SEARCH");
    public static UIButton buttonDOOR = new UIButton("DOOR");
    public static UIButton buttonSLOTS = new UIButton("SLOTS");

    public static UIButton buttonHEAL1 = new UIButton("HEAL(100)");
    public static UIButton buttonHEAL2 = new UIButton("HEAL(100)");
    public static UIButton buttonADVANCE1 = new UIButton("ADVANCE");
    public static UIButton buttonADVANCE2 = new UIButton("ADVANCE");

    public static UIBox box = new UIBox();
    public static TextBox textBox = new TextBox("", 450, 80, Color.WHITE, Color.BLACK);

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {  
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000,600,1);
        //Greenfoot.setWorld(new TitleScreen());
    }
    //creates the games UI
    public void setUI() {
        addObject(box, 350, 550);
        addObject(textBox, 750, 550);
        addObject(new PHealthbar(this.getPlayer()),80,525);
        addObject(new WorldObject("Heart.png"),50,525);
        addObject(new Statbar(P.player), 260,525);
        addObject(backpack, 30, 30);
    }
    //returns the textbox in the ui
    public TextBox getTextBox() {
        return textBox;
    }
    //returns the player for use in other methods
    public Player getPlayer() {
        return P.player;
    }
    public Enemy getCurEnm() {
        try {return eList.get(0);}
        catch (Exception e) {
            return null;
        }
    }
    //possibly unused method but we have it just in case
    public void changeCurEnm(int x) {
        Enemy temp = eList.get(0);
        Enemy temp1 = eList.get(x);
        eList.set(0,temp1);
        eList.set(x,temp);
    }
    // returns the list of enemies
    public ArrayList<Enemy> getEList() {
        return eList;
    }
    // adds an enemy to the scenario
    public void addEnemy(Enemy e, int x, int y) {
        eList.add(e);
        addObject(e, this.getWidth(), y);
        for(int i = this.getWidth(); i >= x; i--) {
            e.setLocation(i,y);
            Greenfoot.delay(1);
        }
        if(inCombat == false) {
            buttonExist = true;
            addComButtons(); 
            yesCombat();
        }
        addObject(new Healthbar(e),x-5, y-27);
    }
    // removes an enemy from  the scenario
    public void removeEnemy(Enemy e) {
        for(int i = 0; i < eList.size(); i++) {
            if(e.equals(eList.get(i))) {
                eList.remove(i);
                break;
            }
        }
        if(eList.size() == 0) {
            noCombat();
        }
        removeObject(e);
    }
    // allows enemies to attack
    public void enemyAttack() {
        for(int i = 0; i < eList.size(); i++) {
            eList.get(i).attack();
            Greenfoot.delay(5);
        }
    }
    // turns off combat mode
    public void noCombat() {
        inCombat = false;
    }
    // turns on combat mode
    public void yesCombat() {
        inCombat = true;
    }
    // adds the UI and starts combat
    public void startCombat() {
        yesCombat();
        buttonExist = true;
        addComButtons();
    }
    // checks if the player is in combat
    public void checkCombat() {
        if(inCombat) {
            if(buttonExist == false) {
                buttonExist = true;
                addComButtons();
            }
        }
        else {
            removeComButtons();
            removeMagButtons();
        }
    }
    // removes the combat buttons
    public void removeComButtons() {
        removeObject(buttonATTACK);
        removeObject(buttonMAGIC);
        removeObject(buttonACT);
        removeObject(buttonITEM);
    }
    // adds the combat buttons
    public void addComButtons() {
        addObject(buttonATTACK, atkx, actiony);
        addObject(buttonMAGIC, magx, actiony);
        addObject(buttonACT, actx, actiony);
        addObject(buttonITEM, itemx, actiony);
    }
    // removes the magic sub buttons
    public void removeMagButtons() {
        removeObject(buttonMAGATK);
        removeObject(buttonMAGDEF);
        removeObject(buttonMAGHEAL);
        removeObject(buttonMAGBACK);
    }
    // adds the magic buttons
    public void addMagButtons() {
        addObject(buttonMAGATK, atkx, actiony);
        addObject(buttonMAGDEF, magx, actiony);
        addObject(buttonMAGHEAL, actx, actiony);
        addObject(buttonMAGBACK, itemx, actiony);
    }
    // adds the forest buttons
    public void createForestButtons() {
        addObject(buttonTOWER, atkx, actiony);
        addObject(buttonTOILET, magx, actiony);
        addObject(buttonHOUSE, actx, actiony);
        addObject(buttonROCK, itemx, actiony);

    }
    // removes the forest buttons
    public void removeForestButtons() {
        removeObject(buttonTOWER);
        removeObject(buttonTOILET);
        removeObject(buttonHOUSE);
        removeObject(buttonROCK);
    }
    // creates the cave buttons
    public void createCaveButtons() {
        addObject(buttonSHOUT, atkx, actiony);
        addObject(buttonMUSHROOM, magx, actiony);
        addObject(buttonBATHTUB, actx, actiony);
        addObject(buttonROCKS, itemx, actiony);
    }
    // removes the cave buttons
    public void removeCaveButtons() {
        removeObject(buttonSHOUT);
        removeObject(buttonMUSHROOM);
        removeObject(buttonBATHTUB);
        removeObject(buttonROCKS);
    }
    // creates the den buttons
    public void createDenButtons() {
        addObject(buttonHOWL, atkx, actiony);
        addObject(buttonSEARCH, magx, actiony);
        addObject(buttonDOOR, actx, actiony);
        addObject(buttonSLOTS, itemx, actiony);
    }
    // removes the den buttons
    public void removeDenButtons() {
        removeObject(buttonHOWL);
        removeObject(buttonSEARCH);
        removeObject(buttonDOOR);
        removeObject(buttonSLOTS);
    }
    // creates a couple buttons for the end of the game
    public void createSteveButtons() {
        addObject(buttonHEAL1, atkx, actiony);
        addObject(buttonHEAL2, magx, actiony);
        addObject(buttonADVANCE1, actx, actiony);
        addObject(buttonADVANCE2, itemx, actiony);
    }
    // removes those end game buttons
    public void removeSteveButtons() {
        removeObject(buttonHEAL1);
        removeObject(buttonHEAL2);
        removeObject(buttonADVANCE1);
        removeObject(buttonADVANCE2);
    }
    //}
    /*public void act() {
        if(inCombat) {
            if(buttonExist == false) {
                addObject(buttonATTACK, atkx, actiony);
                addObject(buttonMAGIC, magx, actiony);
                addObject(buttonACT, actx, actiony);
                addObject(buttonITEM, itemx, actiony);
            }
        }
        else {
            removeObject(buttonATTACK);
            removeObject(buttonMAGIC);
            removeObject(buttonACT);
            removeObject(buttonITEM);
        }
    }*/
}