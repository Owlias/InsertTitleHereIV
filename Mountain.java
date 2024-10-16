import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mountain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mountain extends MyWorld
{

    private static int x = 0;
    public boolean moveOn = false; 
    public int segment = 1;
    private boolean buttonsMade = false;
    int rand1 = (int) (Math.random() * 3) + 1;
    int rand2;
    int randx;
    int randy;

    public Mountain()
    {
        this.setBackground(new GreenfootImage("MountainBG.png"));
        this.setUI();
        addObject(P.player, getWidth()/2, getHeight()/2);
        Greenfoot.setSpeed(60);
    }
    public void addGoblin() {
        randx = (int) (Math.random() * 50) + 750;
        randy = (int) (Math.random() * 300) + 150;
        addEnemy(new Goblin(10, 0, 0, 1), randx, randy);
    }
    public void act() {
        Greenfoot.setSpeed(67);
        if(inCombat) {
            checkCombat();
        }
        else {
            moveOn = false;
            removeComButtons();
            removeMagButtons();
        }
        // IF NOT WORK THEN MOVE IF ELSE BACK TO SECOND SPOT
        if(!moveOn && segment == 1) {
            textBox.setText("Hey, there's a cool mountain. There's probably something cooler");
            textBox.setText("at the top! You should definitely climb it.");
            textBox.setText("Nearby, you found a nice set of armor.");
            getPlayer().setArmor(MyWorld.royal);
            moveOn = true;
            segment++;
        }
        if(!moveOn && segment == 2) {
            x = 1;

            addGoblin();
            textBox.setText("On your way to the top, a little goblin stops you!");
            Greenfoot.delay(delay2);
            addGoblin();
            addGoblin();
            textBox.setText("Sorry, a small group of goblins stops you!");
            Greenfoot.delay(delay2);
            addGoblin();
            addGoblin();
            addGoblin();
            textBox.setText("Actually, a medium-sized group of goblins stop you!");
            Greenfoot.delay(delay2);
            addGoblin();
            addGoblin();
            addGoblin();
            textBox.setText("On third thought, it's a decently-sized group of goblins.");
            Greenfoot.delay(delay2);
            addGoblin();
            addGoblin();
            addGoblin();
            addEnemy(new GoblinWarrior(), 800, 300);
            addGoblin();
            addGoblin();
            addGoblin();
            textBox.setText("Oh my god, where are they all coming from?");
            Greenfoot.delay(delay2);
            textBox.setText("Whatever- The goblin squad wants to fight!");
            Greenfoot.delay(delay2);
            startCombat();
            moveOn = true;
            segment++;
        }
        if(!moveOn && segment == 3) {
            if (!buttonsMade) {
                createSteveButtons();
                textBox.setText("You've made it really far and I'm so proud of you.");
                textBox.setText("You sense that your adventure is coming to a close.");
                textBox.setText("Hey, if you have 100 coins, I can heal you. You might need it.");
                buttonsMade = true;
            }
            
        }
        
    }
}
