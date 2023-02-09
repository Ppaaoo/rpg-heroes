package org.example;

public class Warrior extends Hero {
    Armor.ArmorType[] armorTypes = {Armor.ArmorType.mail, Armor.ArmorType.plate};
    Weapon.WeaponType[] weaponTypes = {Weapon.WeaponType.axe, Weapon.WeaponType.hammer, Weapon.WeaponType.sword};

    Warrior(String name) {
        super(name);
        setLevelAttribute(5,2,1);
        setClassName("Warrior");
        setValidArmorTypes(armorTypes);
        setValidWeaponTypes(weaponTypes);
    }
    @Override
    void levelUp() {
        setLevel(getLevel() + 1);
        setLevelAttribute(getLevelAttribute().getStrength() + 3, getLevelAttribute().getDexterity() + 2, getLevelAttribute().getIntelligence() + 1);
    }

    @Override
    void equipArmor() {

    }

    @Override
    void equipWeapon() {

    }

    @Override
    void doDamage() {

    }

    @Override
    void totalAttributes() {

    }
}
