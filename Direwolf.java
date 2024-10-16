import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Direwolf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Direwolf extends Wolf
{
    /**
     * Act - do whatever the Direwolf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Direwolf() {
        super(30,15,4);
        this.setName("Direwolf");
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
            int goo = rando.nextInt(5)+1;
            if(goo == 1 || goo == 2 || goo == 3) {
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
            if(goo == 4) {
                MyWorld world = (MyWorld) this.getWorld();
                TextBox t = world.getTextBox();
                Random randp = new Random();
                int randx;
                int randy;
                t.setText("The Direwolf howls, calling 2 wolf cubs!");
                randx = (int) (Math.random() * 50) + 750;
                randy = (int) (Math.random() * 300) + 150;
                world.addEnemy(new WolfCub(), randx, randy);
                randx = (int) (Math.random() * 50) + 750;
                randy = (int) (Math.random() * 300) + 150;
                world.addEnemy(new WolfCub(), randx, randy);
                
            }
        }
        catch (Exception E) {
        }
    }
}
