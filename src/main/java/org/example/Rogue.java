package org.example;

public class Rogue extends Hero {
    Armor.ArmorType[] armorTypes = {Armor.ArmorType.leather, Armor.ArmorType.mail};
    Weapon.WeaponType[] weaponTypes = {Weapon.WeaponType.dagger, Weapon.WeaponType.sword};

    Rogue(String name) {
        super(name);
        setLevelAttribute(2,6,1);
        setClassName("Rogue");
        setValidArmorTypes(armorTypes);
        setValidArmorTypes(armorTypes);
        setValidWeaponTypes(weaponTypes);
    }
}
