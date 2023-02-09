package org.example;
import java.util.*;

public abstract class Hero {
    private String name;
    private String className;
    private int level;
    private int damage;
    private HeroAttribute levelAttribute;
    private Item equipment;
    private Weapon.WeaponType[] validWeaponTypes;
    private Armor.ArmorType[] validArmorTypes;

    //Constructor
    public Hero(){}
    public Hero(String name) {
        this.name = name;
        this.className = "default";
        levelAttribute = new HeroAttribute(0, 0, 0);
        equipment = new Item("item", 1, Item.Slot.weapon);
        this.level = 1;
        this.damage = 1;
    }

    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Class: " + getClassName());
        System.out.println("Level: " + getLevel());
        System.out.println("Strength: " + getLevelAttribute().getStrength() + "\nDexterity: " + getLevelAttribute().getDexterity() + "\nIntelligence: " + getLevelAttribute().getIntelligence());
        System.out.println("Damage: " + getDamage());
        for (int i = 0; i < validArmorTypes.length; i++) {
            System.out.println("Armor type " + (i + 1) + ": " + validArmorTypes[i]);
        }
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

    public void setValidArmorTypes(Armor.ArmorType[] armorTypes) {
        this.validArmorTypes = new Armor.ArmorType[armorTypes.length];
        for (int i = 0; i < validArmorTypes.length; i++) {
            this.validArmorTypes[i] = armorTypes[i];
        }
    }
    public Armor.ArmorType[] getValidArmorTypes() {
        return validArmorTypes;
    }

    public void setValidWeaponTypes(Weapon.WeaponType[] weaponTypes) {
        this.validWeaponTypes = new Weapon.WeaponType[weaponTypes.length];
        for (int i = 0; i < validWeaponTypes.length; i++) {
            this.validWeaponTypes[i] = weaponTypes[i];
        }
    }
    public Weapon.WeaponType[] getValidWeaponTypes() {
        return validWeaponTypes;
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