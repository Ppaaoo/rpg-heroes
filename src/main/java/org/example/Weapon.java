package org.example;

public class Weapon extends Item {
    enum WeaponType {
        axe,
        bow,
        dagger,
        hammer,
        staff,
        sword,
        wand
    }

    private int weaponDamage;
    private WeaponType weaponType;

    public Weapon(WeaponType weapon, int damage) {
        this.weaponType = weapon;
        this.weaponDamage = damage;
    }
    public Weapon(String name, int requiredLevel, Slot slot, WeaponType weaponType, int damage) {
        super(name, requiredLevel, slot);
        this.weaponType = weaponType;
        this.weaponDamage = damage;
    }

    //Setters and getters
    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
    public WeaponType getWeaponType() {
        return weaponType;
    }
}