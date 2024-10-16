import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wolf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wolf extends Enemy
{
    /**
     * Act - do whatever the Wolf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Wolf(int a, int b, int c) {
        super(a,b,c,"Melee",50,"WolfSound.mp3",10);
        this.setName("Wolf");
    }
    public Wolf() {
        super(20,10,10,"Melee",50,"WolfSound.mp3",10);
        this.setName("Wolf");
    }
    public void act()
    {
        
    }
}
