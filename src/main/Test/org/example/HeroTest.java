package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    Warrior testWarrior;
    @BeforeEach
    void setup() {
        testWarrior = new Warrior("Steve");
    }
    @Test
    void testCreatingHero() {
        assertEquals("Steve", testWarrior.getName());
        assertEquals(1, testWarrior.getLevel());
        assertEquals(5, testWarrior.getLevelAttribute().getStrength());
        assertEquals(2, testWarrior.getLevelAttribute().getDexterity());
        assertEquals(1, testWarrior.getLevelAttribute().getIntelligence());
    }
    @Test
    void testHeroLevelUp() {
        testWarrior.levelUp();
        assertEquals(2, testWarrior.getLevel());
    }
    @Test
    void testCreateWeapon() {
        Weapon testWeapon = new Weapon("Basic Axe", 1, Item.Slot.weapon, Weapon.WeaponType.axe, 10);
        assertEquals("Basic Axe", testWeapon.getItemName());
        assertEquals(1, testWeapon.getItemRequiredLevel());
        assertEquals(Item.Slot.weapon, testWeapon.getItemSlot());
        assertEquals(Weapon.WeaponType.axe, testWeapon.getWeaponType());
        assertEquals(10, testWeapon.getWeaponDamage());
    }
    @Test
    void testCreateArmor() {
        Armor testArmor = new Armor("Rugged Breast Plate", 1, Item.Slot.body, Armor.ArmorType.plate, 1, 0, 0);
        assertEquals("Rugged Breast Plate", testArmor.getItemName());
        assertEquals(1, testArmor.getItemRequiredLevel());
        assertEquals(Item.Slot.body, testArmor.getItemSlot());
        assertEquals(Armor.ArmorType.plate, testArmor.getArmorType());
        assertEquals(1, testArmor.getArmorAttribute().getStrength());
        assertEquals(0, testArmor.getArmorAttribute().getDexterity());
        assertEquals(0, testArmor.getArmorAttribute().getIntelligence());
    }
    @Test
    void testHeroTotalAttributesNoArmor() {

    }
    @Test
    void testHeroTotalAttributesOneArmor() {

    }
    @Test
    void testHeroTotalAttributesTwoArmor() {

    }
    @Test
    void testHeroTotalAttributesReplaceArmor() {

    }
    //Test too high level and wrong type
    @Test
    void testHeroDamageNoWeaponEquipped() {

    }
    @Test
    void testHeroDamageOneWeaponEquipped() {

    }
    @Test
    void testHeroDamageReplaceWeaponEquipped() {

    }
    //Test too high level and wrong type
    @Test
    void testHeroDamageArmorAndWeaponEquipped() {

    }
    @Test
    void testHeroDisplay() {

    }
}