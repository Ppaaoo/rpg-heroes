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

    /*@Override
    void doDamage() {

    }*/

    @Override
    void totalAttributes() {

    }
}
