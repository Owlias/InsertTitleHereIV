import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class RedTroll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrazyPineapplePete extends Enemy
{
    /**
     * Act - do whatever the RedTroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CrazyPineapplePete() {
        super(32,3,2,"e",1,"TrollScream.mp3",15);
    }
    public void act()
    {
        // Add your action code here.
    }
    public void attack() {
        if(MyWorld.skipTurn == true) {
            MyWorld.skipTurn = false;
            return;
        }
        try {
            Random rando = new Random();
            int pete = rando.nextInt(5)+1;
            if(pete == 1 || pete == 2) {
                MyWorld world = (MyWorld) this.getWorld();
                Player p = world.getPlayer();
                int damOut = 0;
                Random rand = new Random();
                damOut = Math.abs(rand.nextInt(10) + 1 - p.getDefense());
                p.reduce(damOut);
                System.out.println(damOut + " " + p.getName());
                System.out.println(p.getHealth());
                TextBox t = world.getTextBox();
                t.setText("You were dealt " + damOut + " damage, " + p.getHealth() + " remaining!");
            }
            if(pete == 3) {
                MyWorld world = (MyWorld) this.getWorld();
                TextBox t = world.getTextBox();
                t.setText("Crazy Pineapple Pete squirts pineapple juice into your eyes, weakening you!");
            }
            if(pete == 4) {
                MyWorld world = (MyWorld) this.getWorld();
                TextBox t = world.getTextBox();
                t.setText("Crazy Pineapple Pete eats a pineapple whole, healing 5 health!");
                this.reduce(-5);

            }
        }
        catch (Exception E) {
        }
    }
}
