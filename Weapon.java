import greenfoot.*;
import java.util.*;
//This is the weapon class. Damage and weapon type are two variables used to create a weapon object.
public class Weapon
{
    private String type;
    private double damage;
    public Weapon(String s, double d) {
        type = s;
        damage = d;
    }
    //Gets type of weapon (never used to my knowledge)
    public String getType() {
        return type;
    }
    //Gets damage of weapon
    public double getDamage() {
        return damage;
    }
    public String toString() {
        return type;
    }
    
    public void weaponAbility(int damOut, MyWorld world) {
        TextBox t = world.getTextBox();
        Player p = world.getPlayer();
        if(this.equals(MyWorld.rubberband)) {
            //Elasticity. Chance to fling enemies out of combat on hit, after which they will immediately move back and resume combat. Basically just wastes your time.
            t.setText("You ask the enemy to hold onto the rubber band for a second.");
            t.setText("They hesitently agree, and you walk backwards with the other end of");
            t.setText("the rubber band. When it becomes too hard to pull backwards, you let go.");
            Greenfoot.delay(world.delay3);
            Greenfoot.playSound("RubberBandSound.mp3");
            t.setText("Ouch. You just launched the enemy into orbit.");
            t.setText("They flew so far that they went around the planet and landed in front of you.");
            Greenfoot.delay(world.delay3);
            t.setText("Fantastic! Aside from a minor mark, you accomplished nothing at all.");
        }
        if(this.equals(MyWorld.stick)) {
            //Nothing!
            t.setText("The stick stares your enemy to death. Just kidding.");
            Greenfoot.playSound("StickSound.mp3");
        }
        if(this.equals(MyWorld.board)) {
            //Boredom. Chance to cause enemies to get bored and not attack on their turn. 
            Random rand = new Random();
            int x = rand.nextInt(101)+1;
            if(x<=15) {
                MyWorld.skipTurn = true;
                t.setText("The board's boredom boards the enemy's bord consciousness, making them border!");
                Greenfoot.playSound("BoardSound.mp3");
            }
            else {
                t.setText("The board shoots the enemy an intense glare.");
            }
        }
        if(this.equals(MyWorld.lotteryTicket)) {
            //Lottery. 10 random effects.
            Random rand = new Random();
            int x = rand.nextInt(11)+1;
            if(x == 1) {
                t.setText("You win the lottery....... of death!");
                t.setText("Take 5 damage.");
                p.reduce(5);
                Greenfoot.playSound("StickSound.mp3");
            }
            else if(x == 2) {
                t.setText("You win the lottery....... of salmon!");
                t.setText("You obtain a fish.");
                p.addItem(new Item("Fresh Fish",10));
                Greenfoot.playSound("StickSound.mp3");
            }
            else if(x == 3) {
                t.setText("You win the lottery....... of nothing!");
                Greenfoot.playSound("StickSound.mp3");
            }
            else if(x == 4) {
                t.setText("You win the lottery....... of life!");
                p.heal(5);
                Greenfoot.playSound("StickSound.mp3");
            }
            else if(x == 5) {
                t.setText("You win the lottery....... of sad fish!");
                t.setText("You obtain a sad fish.");
                p.addItem(new Item("Sad Fish",10));
                Greenfoot.playSound("StickSound.mp3");
            }
            else if(x == 6) {
                int randx;
                int randy;
                randx = (int) (Math.random() * 50) + 750;
                randy = (int) (Math.random() * 300) + 150;
                t.setText("You win the lottery....... of a goblin!");
                t.setText("You obtain a goblin.");
                world.addEnemy(new GoblinGoon(), randx, randy);
                Greenfoot.playSound("StickSound.mp3");
            }
            else {
                t.setText("The lottery ticket bugged.");
            }
        }
        if(this.equals(MyWorld.shortsword)) {
            //Shortsword: Defence. Gain a temporary defence bonus on hit.
            t.setText("Your defensive stature gives you a defense boost!");
            Greenfoot.playSound("ShortswordSound.mp3");
            p.defend(2);
        }
        if(this.equals(MyWorld.mace)) {
            //Armour Breaking. Causes subsequent attacks to deal 20% more damage for a few turns.

            t.setText("You shatter pieces of the enemy's armor with your mace!");
            Greenfoot.playSound("MaceSound.mp3");
            t.setText("...but that would be too strong, so you actually didn't.");
        }
        if(this.equals(MyWorld.longsword)) {
            //Length. Hits all enemies in an encounter.
            t.setText("The comically long longsword sweeps the battlefield, hitting every enemy!");
            Greenfoot.playSound("LongswordSound.mp3");
            for(int i = 1; i < world.getEList().size(); i++) {
                world.getEList().get(i).reduce(damOut);
            }
        }
        if(this.equals(MyWorld.reaver)) {
            //Shadow Ignition. Causes enemies to take small damage over time for the rest of the encounter.
            boolean attackAgain = true;
            while(attackAgain) {
                Random rand = new Random();
                int y = rand.nextInt(4) + 1;
                if(y == 1) {
                    t.setText("The Shadowflame Reaver erupts in a glorious blaze, attacking your enemies again!");
                    Greenfoot.playSound("ReaverSound.mp3");
                    try {
                        world.getPlayer().calcDamage(world.getCurEnm());
                    }
                    catch(Exception E) {
                        t.setText("Unfortunately, there's no one left to hit.");
                    }
                    
                }
                else {
                    attackAgain = false;
                    t.setText("The Shadowflame Reaver's explosive abilities are ready to shine...");
                }
            }
            
        }
        if(this.equals(MyWorld.dawnblade)) {
            //Divine Punishment. Reduces enemy attack power on hit.
            t.setText("The Dawnblade's holy light weakens your enemy's attack!");
            Greenfoot.playSound("DawnSound.mp3");
            world.getCurEnm().reduceAttack(3);
            for(int i = 1; i < world.getEList().size(); i++) {
                world.getCurEnm().reduceAttack(3);
                world.getEList().get(i).reduce(damOut);
            }
        }
        if(this.equals(MyWorld.stormcaller)) {
            Enemy temp = world.getCurEnm();
            //Lightning Shock. Does an additional hit of flat damage.
            t.setText("The Stormcaller calls in a storm to smite your enemies!");
            Greenfoot.playSound("StormcallerSound.mp3");
            WorldObject bolt = new WorldObject("Bolt.png");
            world.addObject(bolt, world.getCurEnm().getX(), world.getCurEnm().getY()+30);
            boolean check = true;
            while(check) {
                bolt.setLocation(bolt.getX(),bolt.getY()-1);
                if(bolt.getY() == world.getCurEnm().getY()) {
                    check = false;
                }
            }
            world.getCurEnm().reduce(10);
            t.setText("The bolt dealt 10 damage! " + temp.getHealth() + " remaining.");
            Greenfoot.delay(world.delay1);
            world.removeObject(bolt);   
            if(temp.getHealth() <= 0) {
                world.getPlayer().skipNextAttack = true;
            }
        }
        if(this.equals(MyWorld.ebonheart)) {
            //Ebon Fury. Lifesteal.
            int x = Math.abs((damOut)/4);
            t.setText("The Ebonheart Halberd steals " + x + " of the enemy's lifeforce!");
            Greenfoot.playSound("EbonheartSound.mp3");
            world.getPlayer().heal(x);
        }
        if(this.equals(MyWorld.frostbound)) {
            //Glaciation. Chance to freeze enemies, causing them to be unable to act for a turn and guaranteeing max damage on the next attack against them.
            Random rand = new Random();
            int x = rand.nextInt(101)+1;
            if(x<=40) {
                t.setText("The Frostbound Scimitar's icy powers deal 20 extra damage and");
                t.setText("freeze your enemy, skipping their turn!");
                Greenfoot.playSound("FrostboundSound.mp3");
                MyWorld.skipTurn = true;
                for(int i = 1; i < world.getEList().size(); i++) {
                    world.getEList().get(i).reduce(8);
                }
            }
        }
        if(this.equals(MyWorld.weaponofpowerandspecialthingsthatiscapableofkillingmanythingsthatarebigandscaryandposeathreattoyouradventureeventhoughyouareprobablypowerfulenoughtodefeatthemanyway)) {
            //Killingness Power. Chance to ohko self on hit.
            Random rand = new Random();
            int x = rand.nextInt(101)+1;
            if(x==1) {
                t.setText("This weapon's raw power overwhelms your mortal vessel...");
                p.reduce(1);
                t.setText("Oh, nevermind. You took 1 damage.");
            }
        }
        if(this.equals(MyWorld.polio)) {
            //Polio. You can't move.
        }
    }
}