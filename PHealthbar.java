import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PHealthbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PHealthbar extends Actor
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
    
    public PHealthbar(Player p)
    {
        this.text = "";
        this.width = 50;
        this.height = 20;
        this.backgroundColor = Color.BLACK;
        this.textColor = Color.RED;
        this.player = p;
        updateImage();
    }

    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setFont(new Font("Arial", 10));
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
        setText(String.valueOf(player.getHealth()));
        MyWorld world = (MyWorld) this.getWorld();
        if(player.getHealth() <= 0) {
            world.removeObject(this);
        }
    }
}
