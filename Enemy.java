import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String name;
    private int health = 0;
    private int armor = 0;
    private int attack = 0;
    private String attackType;
    private int speed = 0;
    private boolean alive = true;
    private String deathSound;
    private int coins;
    private ArrayList<Item> drops = new ArrayList<Item>();
    
    public Enemy(int h, int a, int atk, String aT, int s, String dS, int m) {
        name = "Enemy";
        health = h;
        armor = a;
        attack = atk;
        attackType = aT;
        speed = s;
        alive = true;
        deathSound = dS;
        coins = m;
    }
    
    
    public void death() {
        MyWorld world = (MyWorld)this.getWorld();
        Player p = world.getPlayer();
        p.money(coins);
        alive = false;
        for(Item i : drops) {
            this.dropItem(i);
        }
        Greenfoot.playSound(deathSound);
        world.removeEnemy(this);
    }
    
    public int getHealth() {
        return health;
    }
    public String getName() {
        return name;
    }
    public void setName(String s) {
        name = s;
    }
    public void setHealth(int s) {
        health = s;
    }
    public void reduce(int i)
    {
        try {
            MyWorld world = (MyWorld) this.getWorld();
            health -= i;
            if(health <= 0)
            {
                this.death();
            }
            if(health <= 0) {
                health = 0;
            }
        }
        catch(Exception E) {
        }
        
    }
    public int getDefense() {
        return armor;
    }
    public void attack() {
        if(MyWorld.skipTurn == true) {
            MyWorld.skipTurn = false;
            return;
        }
        try {
            MyWorld world = (MyWorld) this.getWorld();
            Player p = world.getPlayer();
            int damOut = 0;
            Random rand = new Random();
            damOut = Math.abs(rand.nextInt(10) + 1 - p.getDefense());
            if(attack == 0) {
                damOut *= 0;
            }
            p.reduce(damOut);
            //System.out.println(damOut + " " + p.getName());
            //System.out.println(p.getHealth());
            TextBox t = world.getTextBox();
            t.setText("You were dealt " + damOut + " damage, " + p.getHealth() + " remaining!");
        }
        catch (Exception E) {
        }
    }
    public void castHealth() {
        Random random = new Random();
        MyWorld world = (MyWorld) this.getWorld();
        for(int i = 0; i < world.getEList().size(); i++) {
            int e = random.nextInt(3)+1;
            world.getEList().get(i).heal(e);
            TextBox t = world.getTextBox();
            t.setText("The enemy healed " + world.getEList().get(i).getName() + " for " + e + " health!" );
        }
    }
    public void addItem(Item i) {
        drops.add(i);
    }
    public void setMoney(int x) {
        coins = x;
    }
    public void dropItem(Item i) {
        MyWorld world = (MyWorld) this.getWorld();
        TextBox t = MyWorld.textBox;
        Random random = new Random();
        int didDrop = random.nextInt(101) + 1;
        if(didDrop <= i.getChance()) {
            t.setText("ITEM DROP: " + i.getName());
            world.getPlayer().addItem(i);
        }
    }
    public void reduceAttack(int x) {
        if(attack >=0) {
            attack -= x;
            if(attack <0) {
                attack = 0;
            }
        }
        
    }

    public void heal(int x) {
        health += x;
    }
    
    public void act()
    {
        if(true) {
            
        }
    }
}
