package org.example;

public class Rogue extends Hero {

    Rogue(String name) {
        super(name);
        setLevelAttribute(2,6,1);
        setClassName("Rogue");
    }
    @Override
    void levelUp() {
        setLevel(getLevel() + 1);
        setLevelAttribute(getLevelAttribute().getStrength() + 1, getLevelAttribute().getDexterity() + 4, getLevelAttribute().getIntelligence() + 1);
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
