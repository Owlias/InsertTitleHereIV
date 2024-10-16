import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import static java.lang.Math.atan2;

import java.util.*;
/**
 * Write a description of class RedTroll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Steve extends Enemy
{
    
    /**
     * Act - do whatever the RedTroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Steve() {
        super(300,15,15,"e",6,"AbominationScream.mp3",45);
        this.setName("Steve, Emperor of the Title");
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
            int howl = rando.nextInt(6)+1;
            if(howl == 1 || howl == 2) {
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
            if(howl == 3) {
                MyWorld world = (MyWorld) this.getWorld();
                TextBox t = world.getTextBox();
                Random randp = new Random();
                int randx;
                int randy;
                randx = (int) (Math.random() * 50) + 750;
                randy = (int) (Math.random() * 300) + 150;
                int whaHowl = randp.nextInt(101)+1;
                t.setText("Steve calls for support!");
                if(whaHowl <= 10) {
                    //Tentagoole
                    world.addEnemy(new CrazyPineapplePete(), randx, randy);
                    t.setText("He summoned... Pineapple Pete???");
                }
                else if(whaHowl <= 50) {
                    //Goorc
                    world.addEnemy(new RedTroll(), randx, randy);
                    t.setText("He summoned a Red Troll. It looks ready to hit you!");
                }
                else {
                    //Gooblin
                    world.addEnemy(new Direwolf(), randx, randy);
                    t.setText("He summoned a Direwolf. It looks ready to howl!");
                }
            }
            if(howl == 4) {
                MyWorld world = (MyWorld) this.getWorld();
                TextBox t = world.getTextBox();
                t.setText("Steve heals 30 health!");
                this.reduce(-30);

            }
            if(howl == 5) {
                MyWorld world = (MyWorld) this.getWorld();
                TextBox t = world.getTextBox();
                t.setText("Steve calls upon divine wrath! He screamed, dealing 1 damage.");
                Greenfoot.playSound("PlayerScream.mp3");
                P.player.reduce(1);
            }
        }
        catch (Exception E) {
        }
    }
        
}