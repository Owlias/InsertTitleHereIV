import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Forest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Forest extends MyWorld
{
    //Area 1: The Forest
    private static int x = 0;
    public boolean moveOn = false; 
    public int segment = 1;
    private boolean buttonsMade = false;

    public Forest()
    {
        super();
        this.setBackground(new GreenfootImage("ForestBG.png"));
        this.setUI();
        this.getPlayer().resetPlayer();
        addObject(P.player, getWidth()/2, getHeight()/2);
        
    }
    

    public void act() {
            Greenfoot.setSpeed(67);
            if(!moveOn && segment == 1) {
            textBox.setText("Hello, player! Nice to meet you!");
            textBox.setText("I'm the text box. I'll be your guide on this adventure,");
            textBox.setText("so make sure to read me as you go. I'll display text");
            textBox.setText("from interactions with people you meet, items you find,");
            textBox.setText("and fights like the one you're about to get into.");
            Greenfoot.delay(delay5);
            
            Goblin goblingoon = new GoblinGoon();
            Goblin goblinwarrior = new GoblinWarrior();
            //OrcCaptain orccaptain  = new OrcCaptain();
            addEnemy(goblingoon, 4 * getWidth() / 5, 2 * getHeight() / 5);
            //addEnemy(orccaptain, 4 * getWidth() / 5, (int) (3.4 * getHeight() )/ 5);
            addEnemy(goblinwarrior, 4 * getWidth() / 5, 3 * getHeight() / 5);
            textBox.setText("Yeah, I probably should have told you earlier, but there");
            textBox.setText("are several angry goblins in this forest. Good luck!");
            Greenfoot.delay(delay3);
            startCombat();
            moveOn = true;
            segment++;
        }
        if(inCombat) {
            checkCombat();
        }
        else {
            moveOn = false;
            removeComButtons();
            removeMagButtons();
        }
        if(!moveOn && segment == 2) {
            x = 1;
            textBox.setText("Wow, you're really good! The last player didn't get");
            textBox.setText("as far as you. It looks like there are some things of interest");
            textBox.setText("to check out.");
            Greenfoot.delay(delay3);
            System.out.println(moveOn);
            moveOn = true;
            System.out.println(moveOn);
            segment++;
        }
        if(!moveOn && segment == 3) {
            if (!buttonsMade) {
                createForestButtons();
                buttonsMade = true;
            }
            
        }
        
    }
}
