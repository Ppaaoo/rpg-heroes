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

    //Constructors
    public Item() {
        this.name = "DefaultItem";
        this.requiredLevel = 1;
        this.slot = Slot.weapon;
    }
    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    //Setters and getters
    public void setItemName(String name) {this.name = name;}
    public String getItemName() {return name;}

    public void setItemRequiredLevel(int requiredLevel) {this.requiredLevel = requiredLevel;}
    public int getItemRequiredLevel() {return requiredLevel;}

    public void setItemSlot(Slot slot) {this.slot = slot;}
    public Slot getItemSlot() {return slot;}
}