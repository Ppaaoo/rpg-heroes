package org.example;

public class Main {
    public static void main(String[] args) {
        Mage testMage = new Mage("Judy");
        Armor testShorts = new Armor("Basic shorts", 1, Item.Slot.legs, Armor.ArmorType.cloth);
        Armor testHat = new Armor("Basic hat", 1, Item.Slot.head, Armor.ArmorType.leather);
        Armor testShirt = new Armor("Basic shirt", 1, Item.Slot.body, Armor.ArmorType.cloth);
        Weapon testWeapon = new Weapon("Basic wand", 1, Item.Slot.weapon, Weapon.WeaponType.wand, 1);
        testMage.levelUp();
        testMage.equipArmor(testShorts);
        testMage.equipArmor(testHat);
        testMage.equipArmor(testShirt);
        testMage.equipWeapon(testWeapon);
        testMage.display();
    }
}