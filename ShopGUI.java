import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Troll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopGUI extends Actor
{
    /**
     * Act - do whatever the Troll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    //All shop buttons
    private int stage;
    private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
    private ShopButton button1 = new ShopButton(MyWorld.board, 30);
    private ShopButton button2 = new ShopButton(MyWorld.shortsword, 40);
    private ShopButton button3 = new ShopButton(MyWorld.mace, 50);
    private ShopButton button4 = new ShopButton(MyWorld.rubberband, 1);
    private ShopButton button5 = new ShopButton(MyWorld.longsword, 75);
    private ShopButton button6 = new ShopButton(MyWorld.lotteryTicket,30);
    private ShopButton button7 = new ShopButton(MyWorld.reaver,200);
    private ShopButton button8 = new ShopButton(MyWorld.dawnblade,225);
    private ShopButton button9 = new ShopButton(MyWorld.stormcaller,250);
    private ShopButton button10 = new ShopButton(MyWorld.ebonheart, 200);
    private ShopButton button11 = new ShopButton(MyWorld.frostbound,275);
    private ShopButton button12 = new ShopButton(MyWorld.weaponofpowerandspecialthingsthatiscapableofkillingmanythingsthatarebigandscaryandposeathreattoyouradventureeventhoughyouareprobablypowerfulenoughtodefeatthemanyway, 1500);
    public ShopGUI(int stage) {
        this.stage = stage;
        updateImage();
    }
    //Creates shop buttons
    public void createButtons(MyWorld world) {
        
        if(stage>=1) {
            world.addObject(button1, 330, 125);
            world.addObject(button2, 500, 125);
            world.addObject(button3, 670, 125);
        }
        if(stage>=2) {
            world.addObject(button4, 330, 185);
            world.addObject(button5, 500, 185);
            world.addObject(button6, 670, 185);
        }
        if(stage>=3) {
            world.addObject(button7, 330, 245);
            world.addObject(button8, 500, 245);
            world.addObject(button9, 670, 245);
            world.addObject(button10, 330, 305);
            world.addObject(button11, 500, 305);
            world.addObject(button12, 670, 305);
        }
        //MyWorld world = (MyWorld) this.getWorld();
        
    }
    //removes all shop buttons
    public void removeButtons(MyWorld world) {
        world.removeObject(button1);
        world.removeObject(button2);
        world.removeObject(button3);
        world.removeObject(button4);
        world.removeObject(button4);
        world.removeObject(button5);
        world.removeObject(button6);
        world.removeObject(button7);
        world.removeObject(button8);
        world.removeObject(button9);
        world.removeObject(button10);
        world.removeObject(button11);
        world.removeObject(button12);
    }
    //updates image for drawing
    private void updateImage() {
        GreenfootImage image = new GreenfootImage(501, 401);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, 500, 401);
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, 500, 401);
        image.setColor(Color.BLACK);
        setImage(image);
    } 
    //Nothing!
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) {
            MyWorld world = (MyWorld) this.getWorld();
            
            
        }
    }

}

