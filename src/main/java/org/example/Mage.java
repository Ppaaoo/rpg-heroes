package org.example;

public class Mage extends Hero {
    Armor.ArmorType[] armorTypes = {Armor.ArmorType.cloth};
    Weapon.WeaponType[] weaponTypes = {Weapon.WeaponType.staff, Weapon.WeaponType.wand};

    Mage(String name) {
        super(name);
        setLevelAttribute(1, 1, 8);
        setClassName("Mage");
        setValidArmorTypes(armorTypes);
        setValidWeaponTypes(weaponTypes);
    }
}
