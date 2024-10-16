import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class OrcCaptain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrcCaptain extends Orc
{
    /**
     * Act - do whatever the OrcCaptain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public OrcCaptain() {
        super(15, 3, 3);
        this.addItem(new Item("Shattered Salmon Feet",20));
    }
     public void attack() {
        try {
            MyWorld world = (MyWorld) this.getWorld();
            Player p = world.getPlayer();
            int damOut = 0;
            Random rand = new Random();
            damOut = Math.abs(rand.nextInt(10) + 1);
            this.castHealth();
            System.out.println(damOut + " " + p.getName());
            System.out.println(p.getHealth());
            TextBox t = world.getTextBox();
            t.setText("You were dealt " + damOut + " damage, " + p.getHealth() + " remaining!");
        }
        catch (Exception E) {
        }
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
