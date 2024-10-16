import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean alive;
    private String name = "Evets";
    private Weapon weapon = MyWorld.stick;
    private Armor armor = MyWorld.rags;
    private int health = 150;
    private int damage;
    private int money = 0;
    private int defense = 0;
    private GreenfootSound scream = new GreenfootSound("PlayerScream.mp3");
    public boolean skipNextAttack = false;

    public ArrayList<Item> inventory = new ArrayList<Item>();
    
//Weapon w, Armor a
    public Player() {
        alive = true;
        //inventory.add("Jar of Pickled Pickles");
    }
    public void act()
    {
        if(this.armor.equals(MyWorld.rags)) {
            this.setImage("RagsNeutral.png");
        }
        else if(this.armor.equals(MyWorld.leather)) {
            this.setImage("LeatherNeutral.png");
        }
        else if(this.armor.equals(MyWorld.wool)) {
            this.setImage("WoolNeutral.png");
        }
        else if(this.armor.equals(MyWorld.chain)) {
            this.setImage("ChainNeutral.png");
        }
        else if(this.armor.equals(MyWorld.plate)) {
            this.setImage("PlateNeutral.png");
        }
        else if(this.armor.equals(MyWorld.knight)) {
            this.setImage("KnightNeutral.png");
        }
        else if(this.armor.equals(MyWorld.royal)) {
            this.setImage("RoyalNeutral.png");
        }
    }

    public void inventory() {
        MyWorld world = (MyWorld) this.getWorld();
        TextBox t = world.getTextBox();
        String text = "";
        if(inventory.size() > 0) {
            t.setText("Your inventory is...");
            for(Item x: inventory) {
                t.setText(x.toString());
            }
        }
        else {
            t.setText("You have no items now. Kill things to get some!");
        }
    }
    public void addItem(Item i) {
        inventory.add(i);
    }
    public void money(int i) {
        MyWorld world = (MyWorld)this.getWorld();
        TextBox t = world.getTextBox();
        if(i >= 0) {
            t.setText("You got " + i + " money!");
            money+=i;
        }
        else {
            t.setText("You lost " + i + " money.");
            money+=i;
        }
        
    }
    
    public int calcDamage(Enemy e) {
        MyWorld world = (MyWorld) this.getWorld();
        TextBox t = world.getTextBox();
        int damOut = 0;
        Random rand = new Random();
        damOut = (int) Math.abs((rand.nextInt(7) + 1)*weapon.getDamage() - (e.getDefense()/2));
        weapon.weaponAbility(damOut,world);
        if(!skipNextAttack) {
            e.reduce(damOut);
            t.setText("You dealt " + damOut + " damage to " + e.getName() + ", " + e.getHealth() + " remaining!");
        }
        else {
            skipNextAttack = false;
        }
        //System.out.println(damOut + " " + e.getName());
        //System.out.println(e.getHealth());
        Greenfoot.delay(5);
        world.enemyAttack();
        return damOut;
    }
    
    public void magicHEAL() {
        MyWorld world = (MyWorld) this.getWorld();
        Random random = new Random();
        int heal = random.nextInt(6) + 2;
        health += heal;
        TextBox t = world.getTextBox();
        t.setText("You healed for " + heal + " health!");
        world.enemyAttack();

    }
    public void magicATTACK(Enemy e) {
        MyWorld world = (MyWorld) this.getWorld();
        int damOut = 0;
        Random rand = new Random();
        damOut = (int) Math.abs((rand.nextInt(7) + 1)*1.1);
        e.reduce(damOut);
        //System.out.println(damOut + " " + e.getName());
        //System.out.println(e.getHealth());
        TextBox t = world.getTextBox();
        t.setText("You cast " + damOut + " damage to " + e.getName() + ", " + e.getHealth() + " remaining!");
        world.enemyAttack();
    }
    public void magicDEFENSE() {
        MyWorld world = (MyWorld) this.getWorld();
        Random random = new Random();
        int def = random.nextInt(3);
        defense += def;
        TextBox t = world.getTextBox();
        t.setText("You defended for " + def + " defence!");
        world.enemyAttack();
    }
    public void resetPlayer() {
        name = "Evets";
        weapon = MyWorld.stick;
        armor = MyWorld.rags;
        health = 150;
        money = 0;
        defense = 0;
    }
    public void heal(int i) {
        health+=i;
    }
    public void reduce(int i)
    {
        health -= i;
        if(health <= 0)
        {
            Greenfoot.setWorld(new DeathScreen());
        }
        if(health <= 0) {
            health = 0;
        }
    }
    public void defend(int d) {
        defense+=d;
    }
    public void reduceMoney(int x) {
        money-=x;
    }
    public boolean getAlive() {
        return alive;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    public int getMoney() {
        return money;
    }
    public int getDefense() {
        return defense + this.armor.getDefense();
    }

    public void setWeapon(Weapon e) {
        weapon = e;
    }
    public void setArmor(Armor e) {
        MyWorld world = (MyWorld) this.getWorld();
        TextBox t = world.getTextBox();
        t.setText("You equip " + e.getType() + "!");
        armor = e;
    }

    public Armor getArmor() {
        return armor;
    }

}