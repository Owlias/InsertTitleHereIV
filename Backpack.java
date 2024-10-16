import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Troll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Backpack extends Actor
{
    /**
     * Act - do whatever the Troll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */


    //Backpack stuff
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) {
            MyWorld world = (MyWorld) this.getWorld();
            P.player.inventory();
            Greenfoot.playSound("thunk.mp3");
        }
    }

}

