import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Troll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldObject extends Actor
{
    /**
     * Act - do whatever the Troll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Class for making an object for background purposes
    public WorldObject(String name) {
        this.setImage(name);
    }
    //Never used, but just in case
    public void switchSprite(String name) {
        this.setImage(name);
    }
    public void act()
    {
        // Add your action code here.
    }

}

