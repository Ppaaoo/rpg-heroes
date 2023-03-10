package org.example;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;

import java.util.*;

public abstract class Hero {
    private String name;
    private String className;
    private int level;
    private HeroAttribute levelAttribute;
    private Weapon.WeaponType[] validWeaponTypes;
    private Armor.ArmorType[] validArmorTypes;
    private HashMap<Item.Slot, Item> itemHashMap;

    //Constructors
    public Hero(){}
    public Hero(String name) {
        this.name = name;
        this.className = "default";
        levelAttribute = new HeroAttribute(0, 0, 0);
        this.level = 1;
        
        //Empty initialization of HashMap
        itemHashMap = new HashMap<>();
        itemHashMap.put(Item.Slot.weapon, null);
        itemHashMap.put(Item.Slot.head, null);
        itemHashMap.put(Item.Slot.body, null);
        itemHashMap.put(Item.Slot.legs, null);
    }

    public StringBuilder display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ").append(getName()).append("\n");
        stringBuilder.append("Class: ").append(getClassName()).append("\n");
        stringBuilder.append("Level: ").append(getLevel()).append("\n");
        levelAttribute = totalAttributes();
        stringBuilder.append("Total strength: ").append(levelAttribute.getStrength()).append("\n");
        stringBuilder.append("Total dexterity: ").append(levelAttribute.getDexterity()).append("\n");
        stringBuilder.append("Total intelligence: ").append(levelAttribute.getIntelligence()).append("\n");
        stringBuilder.append("Damage: ").append(damage());
        return stringBuilder;
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
    public void equipArmor(Armor armor) throws InvalidArmorException {
        switch (armor.getArmorType()) {
            case cloth -> {
                if (!this.className.equals("Mage")) {
                    throw new InvalidArmorException("equipArmor: This armor cannot be equipped by this hero");
                }
            }
            case leather -> {
                if (!this.className.equals("Ranger") && !this.className.equals("Rogue")) {
                    throw new InvalidArmorException("equipArmor: This armor cannot be equipped by this hero");
                }
            }
            case mail ->  {
                if (!this.className.equals("Ranger") && !this.className.equals("Rogue") && !this.className.equals("Warrior")) {
                    throw new InvalidArmorException("equipArmor: This armor cannot be equipped by this hero");
                }
            }
            case plate -> {
                if (!this.className.equals("Warrior")) {
                    throw new InvalidArmorException("equipArmor: This armor cannot be equipped by this hero");
                }
            }
        }
        if(this.level < armor.getItemRequiredLevel()) {
            throw new InvalidArmorException("equipArmor: Hero level too low");
        }
        switch (armor.getItemSlot()) {
            case weapon -> throw new InvalidArmorException("equipArmor: Invalid slot type");
            case head -> itemHashMap.replace(Item.Slot.head, armor);
            case body -> itemHashMap.replace(Item.Slot.body, armor);
            case legs -> itemHashMap.replace(Item.Slot.legs, armor);
            default -> System.out.println("Unable to equip armor");
        }
    }
    public void equipWeapon(Weapon weapon) throws InvalidWeaponException {
        switch (weapon.getWeaponType()) {
            case staff, wand -> {
                if (!this.className.equals("Mage")) {
                    throw new InvalidWeaponException("equipWeapon: This weapon cannot be equipped by this hero");
                }
            }
            case bow -> {
                if (!this.className.equals("Ranger")) {
                    throw new InvalidWeaponException("equipWeapon: This weapon cannot be equipped by this hero");
                }
            }
            case dagger -> {
                if (!this.className.equals("Rogue")) {
                    throw new InvalidWeaponException("equipWeapon: This weapon cannot be equipped by this hero");
                }
            }
            case sword -> {
                if (!this.className.equals("Rogue") && !this.className.equals("Warrior")) {
                    throw new InvalidWeaponException("equipWeapon: This weapon cannot be equipped by this hero");
                }
            }
            case axe, hammer -> {
                if (!this.className.equals("Warrior")) {
                    throw new InvalidWeaponException("equipWeapon: This weapon cannot be equipped by a Warrior");
                }
            }
        }
        if(this.level < weapon.getItemRequiredLevel()) {
            throw new InvalidWeaponException("equipWeapon: Hero level too low");
        }
        switch (weapon.getItemSlot()) {
            case weapon -> itemHashMap.replace(Item.Slot.weapon, weapon);
            case head, legs, body -> throw new InvalidWeaponException("equipWeapon: Invalid slot type");
            default -> System.out.println("Unable to equip weapon");
        }
    }
    public double damage() {
        double finalDamage = 0;
        if(this.itemHashMap.get(Item.Slot.weapon) == null) {
            finalDamage = 1;
        } else {
            switch (this.className) {
                case "Mage" ->
                        finalDamage = ((Weapon)this.itemHashMap.get(Item.Slot.weapon)).getWeaponDamage() * (1 + ((double)this.levelAttribute.getIntelligence())/100);
                case "Ranger", "Rogue" ->
                        finalDamage = ((Weapon)this.itemHashMap.get(Item.Slot.weapon)).getWeaponDamage() * (1 + ((double)this.levelAttribute.getDexterity())/100);
                case "Warrior" ->
                        finalDamage = ((Weapon)this.itemHashMap.get(Item.Slot.weapon)).getWeaponDamage() * (1 + ((double)this.levelAttribute.getStrength())/100);
            }
        }
        int temp = (int)(finalDamage*100.0);
        finalDamage = ((double)temp)/100.0;
        return finalDamage;
    }
    public HeroAttribute totalAttributes() {
        for (Map.Entry<Item.Slot, Item> entry : itemHashMap.entrySet()) {
            if(entry.getValue() != null) {
                if(entry.getValue().getItemSlot() != Item.Slot.weapon) {
                    this.levelAttribute.setStrength(this.levelAttribute.getStrength() + ((Armor)entry.getValue()).getArmorAttribute().getStrength());
                    this.levelAttribute.setDexterity(this.levelAttribute.getDexterity() + ((Armor)entry.getValue()).getArmorAttribute().getDexterity());
                    this.levelAttribute.setIntelligence(this.levelAttribute.getIntelligence() + ((Armor)entry.getValue()).getArmorAttribute().getIntelligence());
                }
            }
        }
        return this.levelAttribute;
    }
}
