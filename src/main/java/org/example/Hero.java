package org.example;

public abstract class Hero {
    private String name;
    private int level;
    private int damage;
    private HeroAttribute levelAttribute;
    private Item equipment;
    private Weapon validWeaponTypes[];
    private Armor validArmorTypes[];

    //Constructor
    public Hero(String name) {
        levelAttribute = new HeroAttribute(0, 0, 0);
        equipment = new Item("item", 1, Item.Slot.weapon);
        this.level = 1;
        this.damage = 1;
        this.validWeaponTypes[0] = new Weapon(Weapon.WeaponType.dagger, 1);
        this.validArmorTypes[0] = new Armor(Armor.ArmorType.cloth);
    }

    abstract void levelUp();
    abstract void equipArmor();
    abstract void equipWeapon();
    abstract void damage();
    abstract void totalAttributes();
    abstract void display();

}