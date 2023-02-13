package org.example;

public class Armor extends Item{
    enum ArmorType {
        cloth,
        leather,
        mail,
        plate
    }

    ArmorType armorType;
    HeroAttribute armorAttribute;

    Armor(String name, int requiredLevel, Slot slot, ArmorType armorType) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
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
