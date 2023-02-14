package org.example;

public class Ranger extends Hero{
    Armor.ArmorType[] armorTypes = {Armor.ArmorType.leather, Armor.ArmorType.mail};
    Weapon.WeaponType[] weaponTypes = {Weapon.WeaponType.bow};

    Ranger(String name) {
        super(name);
        setLevelAttribute(1,7,1);
        setClassName("Ranger");
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
