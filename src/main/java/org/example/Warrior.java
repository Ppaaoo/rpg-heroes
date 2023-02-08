package org.example;

public class Warrior extends Hero {

    Warrior(String name) {
        super(name);
        setLevelAttribute(5,2,1);
        setClassName("Warrior");
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
