import greenfoot.*;
import java.util.*;
public class Armor
{
    private String type;
    private int defense;
    public Armor (String t, int d)
    {
        type = t;
        defense = d;
    }
    // Armor rags = new Armor("Ragged Rags", 1);
    // Armor cloth = new Armor("Tattered Cloth", 2);
    // Armor leather = new Armor("Leather Tunic", 4);
    // Armor chain = new Armor("Chainmail Armor", 7);
    // Armor steel = new Armor("Steel Plate", 10);
    // public void equip(Armor a, Player p)
    // {
    //     p.setArmor(a);
    // }
    //Returns defense
    public int getDefense() {
        return defense;
    }
    //Returns type
    public String getType()
    {
        return type;
    }
    
}
