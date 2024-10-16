import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends MyWorld
{
    //super();
    private UIButton buttonSTART = new UIButton("START");
    private UIButton buttonINSTRUCTIONS = new UIButton("INSTRUCTION");
    private UIButton buttonHELP = new UIButton("HELP");
    private GreenfootImage background = getBackground();
    private boolean onScreen = true;
    public TitleScreen()
    {

        //super(1000, 600, 1);
        super();
        P.areacount = 0;
        Color c = new Color(147,233,190);
        background.setColor(c);
        background.fill();
        addObject(new WorldObject("Steve.png"),getWidth() / 2, getHeight() / 2 - 150);
        showText("INSERT TITLE HERE IV", getWidth() / 2, getHeight() / 3 +70);
        showText("\"Literally the greatest game of all time\"", getWidth() / 2, getHeight() / 2+70);
        showText("-Somebody, probably", getWidth()/2 + 70, getHeight()/2 + 20 + 70);
        showText("Sponsored by the Try-Catch Company", getWidth()/2 + 70, getHeight()/2 + 60+70);
        //addObject(P.player,getWidth()/2,getHeight()/2 - 200);
        addObject(buttonSTART, getWidth() / 2, 550);
        addObject(buttonINSTRUCTIONS, getWidth() / 4, 550);
        addObject(buttonHELP, 3 * getWidth() / 4, 550);
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
