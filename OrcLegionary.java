import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OrcLegionary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrcLegionary extends Orc
{
    /**
     * Act - do whatever the OrcLegionary wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public OrcLegionary() {
        super(12, 4, 7);
        this.addItem(new Item("Shield Bits",20));
    }
    public void act()
    {
        // Add your action code here.
    }
}
