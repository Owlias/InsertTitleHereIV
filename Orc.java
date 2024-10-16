import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orc extends Enemy
{
    /**
     * Act - do whatever the Orc wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Orc(int a, int b, int c) {
        super(a,b,c,"Melee",15,"OrcScream.mp3",5);
        this.setName("Orc");
        this.addItem(new Item("Orc Toes",50));
    }
    
    public void act()
    {
        if(Greenfoot.mouseMoved(this)) {
            //death();
        }
    }
}
