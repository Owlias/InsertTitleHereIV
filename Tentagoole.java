import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tentagoole here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tentagoole extends Enemy
{
    /**
     * Act - do whatever the Tentagoole wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Tentagoole() {
        super(15,6,5,"Melee",15,"OrcScream.mp3",5);
        this.setName("Tentagoole");
        this.addItem(new Item("Orc Toes",50));
    }
    public void act()
    {
        // Add your action code here.
    }
}
