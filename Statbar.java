import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PHealthbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Statbar extends Actor
{
    /**
     * Act - do whatever the Healthbar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String text;
    private int width;
    private int height;
    private Color backgroundColor;
    private Color textColor;
    private Player player;
    
    public Statbar(Player p)
    {
        this.text = "";
        this.width = 200;
        this.height = 30;
        this.backgroundColor = Color.WHITE;
        this.textColor = Color.GREEN;
        this.player = p;
        updateImage();
    }
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(backgroundColor);
        image.fillRect(0, 0, width, height);
        image.setColor(textColor);
        //Adjust below if needed (width and height)
        image.drawString(text, 10, 10);
        setImage(image);
    }

    public void setText(String newText)
    {
        if(newText.equals("")) {
            this.text = "";
        }
        else {
            this.text = newText;
        }
        updateImage();
    }
    public String getText() {
        return text;
    }
    public void act()
    {
        setText(String.valueOf(player.getMoney()) + " Money \n" + player.getWeapon().toString());
        MyWorld world = (MyWorld) this.getWorld();
        if(player.getHealth() <= 0) {
            world.removeObject(this);
        }
    }
}
