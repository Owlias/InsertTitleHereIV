import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goorc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goorc extends Orc
{
    /**
     * Act - do whatever the Goorc wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Goorc() {
        super(7,3,3);
        this.addItem(new Item("Goo Drops",20));
    }
    public void act()
    {
        // Add your action code here.
    }
}
