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

    Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, int strength, int dexterity, int intelligence) {
        super(name, requiredLevel, slot);
        this.armorAttribute = new HeroAttribute(strength, dexterity, intelligence);
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
