import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OrcKnight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrcKnight extends Orc
{
    /**
     * Act - do whatever the OrcKnight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public OrcKnight() {
        super(10, 5, 5);
        this.addItem(new Item("Longsword Fragment",20));
    }
    public void act()
    {
        // Add your action code here.
    }
}
