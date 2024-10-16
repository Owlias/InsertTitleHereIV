import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Town here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Town extends MyWorld
{   //All shop buttons
    public static UIButton buttonSHOP = new UIButton("SHOP");
    public static UIButton buttonCRAFT = new UIButton("CRAFT");
    public static UIButton buttonRESTAURANT = new UIButton("EAT");
    public static UIButton buttonCONTINUE = new UIButton("CONTINUE");
    private static int x = 0;
    public boolean moveOn = false; 
    public int segment = 1;
    
    /**
     * Constructor for objects of class Town.
     * 
     */
    public Town()
    {
        this.setBackground(new GreenfootImage("TownBG.png"));
        this.setUI();
        addObject(P.player, getWidth()/2 -400 , getHeight()/2);
        P.areacount++;
        this.hasEaten = false;
    }
    //Creates the buttons
    public void createChoiceButtons() {
        addObject(buttonSHOP, atkx, actiony);
        addObject(buttonCRAFT, magx, actiony);
        addObject(buttonRESTAURANT, actx, actiony);
        addObject(buttonCONTINUE, itemx, actiony);
    }
    //Text for when you enter the town
    public void act() {
        if(!moveOn && segment == 1) {
            moveOn = false;
            segment++;
        }
        if(!moveOn && segment == 2) {
            x = 1;
            textBox.setText(" ");
            textBox.setText("Welcome to the town!");
            Greenfoot.delay(delay1);
            textBox.setText("Here you can shop...");
            Greenfoot.delay(delay1);
            textBox.setText("...or craft...");
            Greenfoot.delay(delay1);
            textBox.setText("...or eat until you die!");
            Greenfoot.delay(delay1);
            textBox.setText("Your choice! Press continue when you're ready to leave.");
            Greenfoot.delay(delay1);
            moveOn = false;
            segment++;
        }
        if(!moveOn && segment == 3) {
            if(P.player.getHealth() > 160) {
                textBox.setText("What do you think you're doing there?");
                textBox.setText("No. This is not allowed. Take some damage.");
                P.player.reduce(P.player.getHealth() - 160);
                textBox.setText("That's better, Jack- oh wait wrong one...");
            }
            createChoiceButtons();
        }
        
    }
}
