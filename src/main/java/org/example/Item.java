package org.example;

public class Item {
    enum Slot {
        weapon,
        head,
        body,
        legs
    }
    private String name;
    private int requiredLevel;
    private Slot slot;

    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    //Setters and getters
    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setRequiredLevel(int requiredLevel) {this.requiredLevel = requiredLevel;}
    public int getRequiredLevel() {return requiredLevel;}

    public void setSlot(Slot slot) {this.slot = slot;}
    public Slot getSlot() {return slot;}
}