package org.example;

public abstract class Hero {
    private String name;
    private int level;
    private int damage;
    private HeroAttribute levelAttribute;
    private Item equipment;
    private Weapons.WeaponType validWeaponTypes;
    private Armor.ArmorType validArmorTypes;

    //Constructor
    public Hero(String name) {
        levelAttribute = new HeroAttribute(1, 1, 1);
        equipment = new Item("item", 1, Item.Slot.weapon);
    }

    abstract void levelUp();

}