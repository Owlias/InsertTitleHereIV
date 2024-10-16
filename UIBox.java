import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UIBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UIBox extends Actor
{
    /**
     * Act - do whatever the UIBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public UIBox() {
        // Set the size of the box
        GreenfootImage img = new GreenfootImage(1700,101);
        img.setColor(Color.BLACK);
        img.drawRect(100,100,1600,100);
        img.setColor(Color.GRAY);
        img.fill();
        setImage(img);
        MyWorld world = (MyWorld) this.getWorld();
    }
}
