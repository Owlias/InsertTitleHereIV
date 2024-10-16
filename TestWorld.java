import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Forest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends MyWorld
{

    //Test world for testing
    public TestWorld()
    {
        //super(1000, 600, 1);
        addObject(box, 350, 550);
        addObject(textBox, 750, 550);
        textBox.setText("");
        
        
        //add(new TextButton("A Button").addClickAction(m -> System.out.println("Click")), 0.5, 0.5);
        Goblin goblin = new GoblinGoon();
        Goblin goblin2 = new GoblinWarrior();
        Goblin goblin3 = new GoblinWizard();
        Orc orc = new Orc(2,2,2);

        Enemy foot = new Enemy(1,1,1,"e",3,"death.mp3",1);
        addObject(P.player, getWidth()/2, getHeight()/2);
        addEnemy(goblin2, 600, 300);
        addEnemy(goblin3, 650, 250);
        addEnemy(goblin, 650, 350);
        addEnemy(orc, 700,300); 
        
        addObject(buttonATTACK, 70, 550);
        addObject(buttonMAGIC, 195, 550);
        addObject(buttonACT, 320, 550);
        addObject(buttonITEM, 445, 550);
    }
}
