package org.example;
import java.util.*;

public abstract class Hero {
    private String name;
    private String className;
    private int level;
    private int damage;
    private HeroAttribute levelAttribute;
    private Item equipment;
    private Weapon validWeaponTypes[];
    private Armor.ArmorType validArmorTypes[];

    //Constructor
    public Hero(){}
    public Hero(String name) {
        this.name = name;
        this.className = "default";
        levelAttribute = new HeroAttribute(0, 0, 0);
        equipment = new Item("item", 1, Item.Slot.weapon);
        this.level = 1;
        this.damage = 1;
        //this.validWeaponTypes[0] = new Weapon(Weapon.WeaponType.dagger, 1);
        //this.validArmorTypes[0] = Armor.ArmorType.cloth;
    }

    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Class: " + getClassName());
        System.out.println("Level: " + getLevel());
        System.out.println("Strength: " + getLevelAttribute().getStrength() + "\nDexterity: " + getLevelAttribute().getDexterity() + "\nIntelligence: " + getLevelAttribute().getIntelligence());
        System.out.println("Damage: " + getDamage());
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

    public void setValidArmorTypes(Armor.ArmorType validArmorTypes) {
        this.validArmorTypes[0] = validArmorTypes;
    }
    public Armor.ArmorType[] getValidArmorTypes() {
        return validArmorTypes;
    }

    public void setLevelAttribute(int strength, int dexterity, int intelligence) {
        levelAttribute.setStrength(strength);
        levelAttribute.setDexterity(dexterity);
        levelAttribute.setIntelligence(intelligence);
    }
    public HeroAttribute getLevelAttribute() {
        return levelAttribute;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    public String getClassName() {
        return className;
    }

    abstract void levelUp();
    abstract void equipArmor();
    abstract void equipWeapon();
    abstract void doDamage();
    abstract void totalAttributes();
}