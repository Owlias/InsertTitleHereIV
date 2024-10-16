import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeathScreen extends MyWorld
{
    //super();
    private GreenfootImage background = getBackground();
    private boolean onScreen = true;
    public DeathScreen()
    {

        //super(1000, 600, 1);
        super();
        
        Color c = new Color(215,215,48);
        background.setColor(Color.RED);
        background.fill();
        Random rand = new Random();
        int g = rand.nextInt(12) + 1;
        String x = "";
        if(g == 1) {
            x = "Skill issue";
        }
        else if(g == 2) {
            x = "Rigged";
        }
        else if(g == 3) {
            x = "I hate this";
        }
        else if(g == 4) {
            x = "I'm too childish to finish a video game";
        }
        else if(g == 5) {
            x = "Next: Insert Title XVIII";
        }
        else if(g == 6) {
            x = "womp womp";
        }
        else if(g == 7) {
            x = "Las Aventuras de Rataldo";
        }
        else if(g == 8) {
            x = "I kill things";
        }
        else if(g == 9) {
            x = "Quick, hide the bodies...";
        }
        else if(g == 10) {
            x = "We should give up, it's time to make tic tac toe";
        }
        else if(g == 11) {
            x = "You are not the sharpest crayon in the box";
        }
        showText("INSERT TITLE HERE IV", getWidth() / 2, getHeight() / 3);
        showText("\"" + x + "\"", getWidth() / 2, getHeight() / 2);
        showText("-You, probably", getWidth()/2 + 70, getHeight()/2 + 20);
        showText("You died, next time try harder.", getWidth()/2 + 70, getHeight()/2 + 60);
    }
    public void act() {

    }
}
