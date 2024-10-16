import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends MyWorld
{
    //super();
    private UIButton buttonKERMIT = new UIButton("KERMIT");
    private GreenfootImage background = getBackground();
    private boolean onScreen = true;
    public WinScreen() {

        //super(1000, 600, 1);
        super();
        P.areacount = 0;
        Color c = new Color(181,195,6);
        background.setColor(c);
        background.fill();
        //addObject(new WorldObject("Steve.png"),getWidth() / 2, getHeight() / 2 - 150);
        showText("INSERT TITLE HERE IV", getWidth() / 2, getHeight() / 3 +70);
        showText("\"Literally the greatest game of all time\"", getWidth() / 2, getHeight() / 2+70);
        showText("-YOU! (because you won)", getWidth()/2 + 70, getHeight()/2 + 20 + 70);
        showText("Hope you enjoyed...", getWidth()/2 + 70, getHeight()/2 + 60+70);
        showText("oh who am I kidding", getWidth()/2 + 70, getHeight()/2 + 60+90);
        //addObject(P.player,getWidth()/2,getHeight()/2 - 200);
        addObject(buttonKERMIT, getWidth() / 2, 550);
    }
    public void act() {
            for(int i = 0; i < 8; i++) {
                if(i==1)
                    background.setColor(Color.GREEN);
                if(i==2)
                    background.setColor(Color.RED);
                if(i==3)
                    background.setColor(Color.BLUE);
                if(i==4)
                    background.setColor(Color.MAGENTA);
                if(i==5)
                    background.setColor(Color.YELLOW);
                if(i==6)
                    background.setColor(Color.ORANGE);
                if(i==7)
                    background.setColor(Color.CYAN);
        }
    }
}
