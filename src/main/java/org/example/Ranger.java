package org.example;

public class Ranger extends Hero{

    Ranger(String name) {
        super(name);
        setLevelAttribute(1,7,1);
        setClassName("Ranger");
    }
    @Override
    void levelUp() {
        setLevel(getLevel() + 1);
        setLevelAttribute(getLevelAttribute().getStrength() + 1, getLevelAttribute().getDexterity() + 5, getLevelAttribute().getIntelligence() + 1);
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
