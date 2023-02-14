package org.example;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    //Getters and setters
    public void setDexterity(int dexterity) {this.dexterity = dexterity;}
    public int getDexterity() {return dexterity;}

    public void setIntelligence(int intelligence) {this.intelligence = intelligence;}
    public int getIntelligence() {return intelligence;}

    public void setStrength(int strength) {this.strength = strength;}
    public int getStrength() {return strength;}
}