import greenfoot.*;


public class TextBox extends Actor
{
    private String text;
    private int width;
    private int height;
    private Color backgroundColor;
    private Color textColor;
    private String line1 = "";
    private String line2 = "";
    private String line3 = "";
    private String line4 = "";
    private String line5 = "";

    public TextBox(String text, int width, int height, Color backgroundColor, Color textColor)
    {
        this.text = text;
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        updateImage();
    }
    //Updates image
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
    //Sets the text that is displayed in the textbox
    public void setText(String newText)
    {
        if(newText.equals("")) {
            this.text = "";
        }
        else {
            line1 = line2;
            line2 = line3;
            line3 = line4;
            line4 = newText;
            //line4 = line5;
            //line5 = newText;
            this.text = line1 + "\n" + line2 + "\n" + line3 + "\n" + line4; // + "\n" + line5;
        }
        updateImage();
    }
    public String getText() {
        return text;
    }
}