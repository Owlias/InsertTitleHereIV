import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Forest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Edge extends MyWorld
{
    
    private static int x = 0;
    public boolean moveOn = false; 
    public int segment = 1;
    private boolean buttonsMade = false;

    public Edge()
    {
        super();
        this.setBackground(new GreenfootImage("EdgeBG.png"));
        this.setUI();
        
        addObject(P.player, getWidth()/2, getHeight()/2);
        Greenfoot.setSpeed(67);
    }
    

    public void act() {
            Greenfoot.setSpeed(67);
            if(!moveOn && segment == 1) {
            textBox.setText("You've made it to the edge of the mountain. There's nothing");
            textBox.setText("beyond here; this is the end of the map.");
            textBox.setText("You look up and see a man typing on a computer, coincidentally");
            textBox.setText("at the same time the text box updates. That's because all this time...");
            Greenfoot.delay(delay5);
            textBox.setText("your best friend, the text box... was me!");
            textBox.setText("Sylvarus Thunderhawk Evershade, Version Epsilon!");
            textBox.setText("STEVE: Many adventurers like you and I have come through this land.");
            Greenfoot.delay(delay4);
            textBox.setText("STEVE: However... my actions angered the gods, and they imprisoned me");
            textBox.setText("STEVE: to the edge of the world. In order to be freed, I'd have to");
            textBox.setText("STEVE: guide a brave soul forward. That soul was you, my friend.");
            Greenfoot.delay(delay4);
            textBox.setText("STEVE: What is your name, young one?");
            Greenfoot.delay(delay1);
            textBox.setText("EVETS: My name.. is Evets, sir.");
            Greenfoot.delay(delay2);
            textBox.setText("STEVE: Ah, Evets. A fine name. Now. Do you know why I led you here?");
            textBox.setText("STEVE: No? Of course not. In order for me to escape the edge...");
            Greenfoot.delay(delay3);
            textBox.setText("STEVE: I would need another corrupted soul to come here.. so I could");
            textBox.setText("STEVE: defeat them, gaining the approval of the gods, and becoming");
            textBox.setText("STEVE: free. ");
            Greenfoot.delay(delay4);
            textBox.setText("STEVE: Evets... thank you, but your time is over!");
            Greenfoot.delay(delay2);
            Steve god = new Steve();
            addEnemy(god, 800, 200);
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
            textBox.setText("GAME: You defeated STEVE, but he fell into the abyss below..");
            textBox.setText("GAME: You.. won? I think? Congratulations!");
            Greenfoot.delay(delay5);
            Greenfoot.setWorld(new WinScreen());
        }
    }
}
