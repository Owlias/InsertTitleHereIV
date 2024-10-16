import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Healthbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healthbar extends Actor
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
    private Enemy enemy;
    
    public Healthbar(Enemy e)
    {
        this.text = "";
        this.width = 30;
        this.height = 10;
        this.backgroundColor = Color.GRAY;
        this.textColor = Color.BLACK;
        this.enemy = e;
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
            this.text = newText + "\n" + this.getText();
        }
        updateImage();
    }
    public String getText() {
        return text;
    }
    public void act()
    {
        setText(String.valueOf(enemy.getHealth()));
        MyWorld world = (MyWorld) this.getWorld();
        if(enemy.getHealth() <= 0) {
            world.removeObject(this);
        }
    }
}
