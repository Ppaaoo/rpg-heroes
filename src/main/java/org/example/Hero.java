public class Hero {
    private String name;
    private int level;
    private int damage;
    private HeroAttribute levelAttribute;
    private Item equipment;
    private validWeaponTypes;
    private validArmorTypes;

    //Constructor
    public Hero(String name) {
        levelAttribute = new HeroAttribute(1, 1, 1);
        equipment = new Item()
    }

    public double heroDamage() {

    }
    public void levelUp() {
        this.level += 1;
    }

}