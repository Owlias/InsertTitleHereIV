import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/*I'm Teresa, a recruiter from Michael Page, and we've noticed that your background and resume have been recommended by several online recruitment agencies. That's why we want to offer you a part-time job that you can do in your free time. Our job is simple: we just review apps for the App Store. There is no time limit and you can complete the assessment at home. Daily commissions range from $300 to $1,000, and all payments are made on the same day. You can collect your commission immediately after each day's work. If you would like to participate, please contact us via WhatsApp +12095284681
(Note: You must be over 18 years old)*/
public class WolfDen extends MyWorld
{
    private static int x = 0;
    public boolean moveOn = false; 
    public int segment = 1;
    private boolean buttonsMade = false;

    public WolfDen() {
        this.setBackground(new GreenfootImage("WolfDenBG.png"));
        this.setUI();
        addObject(P.player, getWidth()/2, getHeight()/2);
        
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
            textBox.setText("You enter the wolf den. As the name implies, there are wolves.");
            textBox.setText("Lots of them.");
            moveOn = true;
            segment++;
        }
        if(!moveOn && segment == 2) {
            x = 1;
            
            
            moveOn = true;
            segment++;
        }
        if(!moveOn && segment == 3) {
            if (!buttonsMade) {
                createDenButtons();
                buttonsMade = true;
            }
            
        }
        
    }

}
