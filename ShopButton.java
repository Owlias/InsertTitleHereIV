import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Troll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopButton extends Actor
{
    /**
     * Act - do whatever the Troll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private String text;
    private Weapon weapon;
    private int cost;
    private boolean confirm = false;

    public ShopButton(Weapon w, int c) {
        text = w.getType() + " \n(" + c + ")";
        cost = c;
        weapon = w;
        updateImage();
    }
    //Updates image
    private void updateImage() {
        GreenfootImage image = new GreenfootImage(151, 51);
        image.setColor(Color.WHITE);
        image.fillRect(0, 0, 150, 50);
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, 150, 50);
        image.setColor(Color.BLACK);
        image.drawString(text, 20, 25);
        setImage(image);
    } 
    //Code for when you click the button
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) {
            if(!confirm) {
                MyWorld world = (MyWorld) this.getWorld();
                TextBox t = world.getTextBox();
                t.setText("Item:   " + weapon.getType());
                t.setText("Cost:   " + cost);
                t.setText("Confirm purchase?");
                Greenfoot.playSound("PlayerScream.mp3");
                confirm = true;
            }
            else {
                MyWorld world = (MyWorld) this.getWorld();
                TextBox t = world.getTextBox();
                if(world.getPlayer().getMoney()>=cost) {
                    world.getPlayer().reduceMoney(cost);
                    world.getPlayer().setWeapon(weapon);
                    t.setText("You equipped " + weapon.getType() + "!");
                    Greenfoot.playSound("PlayerScream.mp3");
                    confirm = false;
                }
                else {
                    t.setText("Take a gander at the cost. Now take a gander at your money.");
                    t.setText("What made you think you could afford this?");
                }
                
            }
        }
    }
}

