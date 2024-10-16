import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import static java.lang.Math.atan2;

import java.util.*;
/**
 * Write a description of class RedTroll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Abomination extends Enemy
{
    
    /**
     * Act - do whatever the RedTroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Abomination() {
        super(66,6,6,"e",6,"AbominationScream.mp3",30);
        this.setName("???CREATURE???");
    }
    public void act()
    {
        // Add your action code here.
    }
    // the abominations unique attack
    public void attack() {
        if(MyWorld.skipTurn == true) {
            MyWorld.skipTurn = false;
            return;
        }
        try {
            Random rando = new Random();
            int goo = rando.nextInt(5)+1;
            if(goo == 1 || goo == 2) {
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
            if(goo == 3) {
                MyWorld world = (MyWorld) this.getWorld();
                TextBox t = world.getTextBox();
                Random randp = new Random();
                int randx;
                int randy;
                randx = (int) (Math.random() * 50) + 750;
                randy = (int) (Math.random() * 300) + 150;
                int whaGoo = randp.nextInt(101)+1;
                t.setText("The Abomination roars...");
                if(whaGoo <= 10) {
                    //Tentagoole
                    world.addEnemy(new Tentagoole(), randx, randy);
                    t.setText("It summoned a Goo Tentacle. A tentagoole?");
                }
                else if(whaGoo <= 50) {
                    //Goorc
                    world.addEnemy(new Goorc(), randx, randy);
                    t.setText("It summoned a Goo Orc. Goorc?");
                }
                else {
                    //Gooblin
                    world.addEnemy(new Gooblin(), randx, randy);
                    randx = (int) (Math.random() * 50) + 750;
                    randy = (int) (Math.random() * 300) + 150;
                    world.addEnemy(new Gooblin(), randx, randy);
                    t.setText("It summoned two Goo Goblins. Gogoblins. Gooblins?");
                }
            }
            if(goo == 4) {
                MyWorld world = (MyWorld) this.getWorld();
                TextBox t = world.getTextBox();
                t.setText("The Abomination heals 10 health!");
                this.reduce(-10);

            }
        }
        catch (Exception E) {
        }
    }
        
}