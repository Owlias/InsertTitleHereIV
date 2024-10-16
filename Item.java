public class Item {
    private String name;
    private int perChance;

    public Item(String s, int i) {
        name = s;
        perChance = i;
    }

    public String getName() {
        return name;
    }
    public int getChance() {
        return perChance;
    }

    public String toString() {
        return name;
    }
}
