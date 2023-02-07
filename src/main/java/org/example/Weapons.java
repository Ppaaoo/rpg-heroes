package org.example;

public class Weapons {
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

    public Weapons(WeaponType weaponType, int damage) {
        this.weaponType = weaponType;
        this.weaponDamage = damage;
    }
}