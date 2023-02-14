package org.example;
import java.util.*;

public abstract class Hero {
    private String name;
    private String className;
    private int level;
    private int damage;
    private HeroAttribute levelAttribute;
    private Weapon.WeaponType[] validWeaponTypes;
    private Armor.ArmorType[] validArmorTypes;
    private HashMap<Item.Slot, Item> itemHashMap;

    //Constructor
    public Hero(){}
    public Hero(String name) {
        this.name = name;
        this.className = "default";
        levelAttribute = new HeroAttribute(0, 0, 0);
        this.level = 1;
        this.damage = 1;
        
        //Empty initialization of HashMap
        itemHashMap = new HashMap<>();
        itemHashMap.put(Item.Slot.weapon, null);
        itemHashMap.put(Item.Slot.head, null);
        itemHashMap.put(Item.Slot.body, null);
        itemHashMap.put(Item.Slot.legs, null);
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
        System.out.println("\nItems equipped: ");
        for (Map.Entry<Item.Slot, Item> entry : itemHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getItemName());
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
        System.arraycopy(armorTypes, 0, this.validArmorTypes, 0, validArmorTypes.length);
    }
    public Armor.ArmorType[] getValidArmorTypes() {
        return validArmorTypes;
    }

    public void setValidWeaponTypes(Weapon.WeaponType[] weaponTypes) {
        this.validWeaponTypes = new Weapon.WeaponType[weaponTypes.length];
        System.arraycopy(weaponTypes, 0, this.validWeaponTypes, 0, validWeaponTypes.length);
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

    public void levelUp() {
        System.out.println("This classname in levelup: " + this.className);
        switch (this.className) {
            case "Mage" ->
                    this.setLevelAttribute(this.levelAttribute.getStrength() + 1, this.levelAttribute.getDexterity() + 1, this.levelAttribute.getIntelligence() + 5);
            case "Ranger" ->
                    this.setLevelAttribute(this.levelAttribute.getStrength() + 1, this.levelAttribute.getDexterity() + 5, this.levelAttribute.getIntelligence() + 1);
            case "Rogue" ->
                    this.setLevelAttribute(this.levelAttribute.getStrength() + 1, this.levelAttribute.getDexterity() + 4, this.levelAttribute.getIntelligence() + 1);
            case "Warrior" ->
                    this.setLevelAttribute(this.levelAttribute.getStrength() + 3, this.levelAttribute.getDexterity() + 2, this.levelAttribute.getIntelligence() + 1);
        }
        this.level += 1;
    }
    public void equipArmor(Armor armor) {
        boolean isInvalid = false;
        for (Armor.ArmorType validArmorType : this.validArmorTypes) {
            if (validArmorType != armor.getArmorType()) {
                System.out.println("Invalid armor type");
                isInvalid = true;
            }
        }
        if(this.level <= armor.getItemRequiredLevel()) {
            System.out.println("Level too low");
            isInvalid = true;
        }
        if(!isInvalid) {
            switch (armor.getItemSlot()) {
                case weapon -> System.out.println("Not an armor type");
                case head -> itemHashMap.replace(Item.Slot.head, armor);
                case body -> itemHashMap.replace(Item.Slot.body, armor);
                case legs -> itemHashMap.replace(Item.Slot.legs, armor);
                default -> System.out.println("Unable to equip armor");
            }
        }
    }
    public void equipWeapon(Weapon weapon) {
        boolean isInvalid = true;
        for (Weapon.WeaponType validWeaponType : this.validWeaponTypes) {
            if (validWeaponType == weapon.getWeaponType()) {
                isInvalid = false;
                break;
            }
        }
        if(!isInvalid) {
            switch (weapon.getItemSlot()) {
                case weapon -> itemHashMap.replace(Item.Slot.weapon, weapon);
                case head, legs, body -> System.out.println("Not a weapon type");
                default -> System.out.println("Unable to equip weapon");
            }
        }
    }
    public double damage() {
        return this.itemHashMap.get(Item.Slot.weapon).getItemRequiredLevel();
    }
    abstract void totalAttributes();
}