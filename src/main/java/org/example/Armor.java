package org.example;

import java.util.HashMap;

public class Armor extends Item{
    enum ArmorType {
        cloth,
        leather,
        mail,
        plate
    }

    ArmorType armorType;
    HeroAttribute armorAttribute;

    Armor(String name, int requiredLevel, Slot slot) {
        super(name, requiredLevel, slot);
    }

    public ArmorType getArmorType() {
        return armorType;
    }
    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }
    public void setArmorAttribute(HeroAttribute armorAttribute) {
        this.armorAttribute = armorAttribute;
    }
}
