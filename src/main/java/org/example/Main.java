package org.example;

import org.w3c.dom.ranges.Range;

public class Main {
    public static void main(String[] args) {
        Mage testMage = new Mage("Judy");
        testMage.levelUp();
        testMage.display();
        System.out.println("\n");
        Ranger testRanger = new Ranger("Stewart");
        testRanger.display();
    }
}