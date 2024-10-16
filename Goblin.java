import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goblin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Goblin extends Enemy
{
    private GreenfootSound scream = new GreenfootSound("GoblinScream.mp3");
    /**
     * Act - do whatever the Goblin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Goblin(int a, int b, int c, int d) {
        super(a,b,c,"G",d,"GoblinScream.mp3",4);
        this.setName("Goblin");
        this.addItem(new Item("Goblin Flesh",50));
        this.addItem(new Item("Mace Shard",2));
    }
    public void act()
    {
        if(Greenfoot.mouseMoved(this)) {
            //death();
        }
    }
    public void turn() {
        Greenfoot.playSound("GoblinScream.mp3");
        death();
    }

    

    

    /*public void gAttack(Player p) {
        int random = (int) (Math.random() * 6) + 1;
        int damage = random - p.getArmor().getDefense();
        if (damage <= 0) {
            damage = 0;
        }
        p.reduce(damage);
    }
    */

    
}
