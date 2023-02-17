package org.example;

import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
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
        testWarrior.totalAttributes();
        assertEquals(5, testWarrior.totalAttributes().getStrength());
        assertEquals(2, testWarrior.totalAttributes().getDexterity());
        assertEquals(1, testWarrior.totalAttributes().getIntelligence());
    }
    @Test
    void testHeroTotalAttributesOneArmor() throws InvalidArmorException {
        Armor testArmor = new Armor("Leggings of the walking mountain", 1, Item.Slot.legs, Armor.ArmorType.plate, 1,3,1);
        testWarrior.equipArmor(testArmor);
        testWarrior.totalAttributes();
        assertEquals(6, testWarrior.getLevelAttribute().getStrength());
        assertEquals(2, testWarrior.getLevelAttribute().getIntelligence());
        assertEquals(5, testWarrior.getLevelAttribute().getDexterity());
    }
    @Test
    void testHeroTotalAttributesTwoArmor() throws InvalidArmorException {
        Armor testArmor = new Armor("Leggings of the walking mountain", 1, Item.Slot.legs, Armor.ArmorType.plate, 2,3,0);
        Armor testArmorTwo = new Armor("Breast plate of the lonely tiger", 1, Item.Slot.body, Armor.ArmorType.plate, 5,0,1);
        testWarrior.equipArmor(testArmor);
        testWarrior.equipArmor(testArmorTwo);
        testWarrior.totalAttributes();
        assertEquals(12, testWarrior.getLevelAttribute().getStrength());
        assertEquals(5, testWarrior.getLevelAttribute().getDexterity());
        assertEquals(2, testWarrior.getLevelAttribute().getIntelligence());
    }
    @Test
    void testHeroTotalAttributesReplaceArmor() throws InvalidArmorException {
        Armor testArmor = new Armor("Leggings of the walking mountain", 1, Item.Slot.legs, Armor.ArmorType.plate, 2,3,0);
        Armor testArmorTwo = new Armor("Leggings of the lonely tiger", 1, Item.Slot.legs, Armor.ArmorType.plate, 5,0,1);
        testWarrior.equipArmor(testArmor);
        testWarrior.equipArmor(testArmorTwo);
        testWarrior.totalAttributes();
        assertEquals(10, testWarrior.getLevelAttribute().getStrength());
        assertEquals(2, testWarrior.getLevelAttribute().getDexterity());
        assertEquals(2, testWarrior.getLevelAttribute().getIntelligence());
    }
    @Test
    void testArmorRequiredLevelTooHigh() {
        String expected = "equipArmor: Hero level too low";
        Armor testArmor = new Armor("Leggings of the walking mountain", 5, Item.Slot.legs, Armor.ArmorType.plate, 2,3,0);
        InvalidArmorException exception =
                assertThrows(InvalidArmorException.class, () -> testWarrior.equipArmor(testArmor));
        assertEquals(exception.getMessage(), expected);
    }

    @Test
    void testInvalidArmorType() {
        String expected = "equipArmor: This armor cannot be equipped by this hero";
        Armor testArmor = new Armor("Leggings of the walking mountain", 1, Item.Slot.legs, Armor.ArmorType.cloth, 2,3,0);
        InvalidArmorException exception =
                assertThrows(InvalidArmorException.class, () -> testWarrior.equipArmor(testArmor));
        assertEquals(exception.getMessage(), expected);
    }

    @Test
    void testHeroDamageNoWeaponEquipped() {
        assertEquals(1, testWarrior.damage());
    }
    @Test
    void testHeroDamageOneWeaponEquipped() throws InvalidWeaponException {
        Weapon testWeapon = new Weapon("Sword of the rising sun", 1, Item.Slot.weapon, Weapon.WeaponType.sword, 10);
        testWarrior.equipWeapon(testWeapon);
        assertEquals(10.5, testWarrior.damage());
    }
    @Test
    void testHeroDamageReplaceWeaponEquipped() throws InvalidWeaponException {
        Weapon testWeapon = new Weapon("Sword of the rising sun", 1, Item.Slot.weapon, Weapon.WeaponType.sword, 10);
        Weapon testWeaponTwo = new Weapon("Axe of the rising sun", 1, Item.Slot.weapon, Weapon.WeaponType.axe, 20);
        testWarrior.equipWeapon(testWeapon);
        testWarrior.equipWeapon(testWeaponTwo);
        assertEquals(21, testWarrior.damage());
    }
    //Test too high level and wrong type
    @Test
    void testHeroDamageArmorAndWeaponEquipped() throws InvalidWeaponException, InvalidArmorException {
        Weapon testWeapon = new Weapon("Sword of the rising sun", 1, Item.Slot.weapon, Weapon.WeaponType.sword, 10);
        Armor testArmor = new Armor("Leggings of the walking mountain", 1, Item.Slot.legs, Armor.ArmorType.plate, 2,3,0);
        testWarrior.equipWeapon(testWeapon);
        testWarrior.equipArmor(testArmor);
        testWarrior.totalAttributes();
        assertEquals( 10.7, testWarrior.damage());
    }
    @Test
    void testWeaponRequiredLevelTooHigh() {
        String expected = "equipWeapon: Hero level too low";
        Weapon testWeapon = new Weapon("Sword of the rising sun", 5, Item.Slot.weapon, Weapon.WeaponType.sword, 10);
        InvalidWeaponException exception =
            assertThrows(InvalidWeaponException.class, () -> testWarrior.equipWeapon(testWeapon));
        assertEquals(exception.getMessage(), expected);
    }

    @Test
    void testInvalidWeaponType() {
        String expected = "equipWeapon: This weapon cannot be equipped by this hero";
        Weapon testWeapon = new Weapon("Sword of the rising sun", 5, Item.Slot.weapon, Weapon.WeaponType.dagger, 10);
        InvalidWeaponException exception =
            assertThrows(InvalidWeaponException.class, () -> testWarrior.equipWeapon(testWeapon));
        assertEquals(exception.getMessage(), expected);
    }
    @Test
    void testHeroDisplay() {
        String exception = """
                Name: Steve
                Class: Warrior
                Level: 1
                Total strength: 5
                Total dexterity: 2
                Total intelligence: 1
                Damage: 1.0""";
        assertEquals(exception, testWarrior.display().toString());
    }
}