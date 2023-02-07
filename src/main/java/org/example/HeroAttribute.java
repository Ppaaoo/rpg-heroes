

public class HeroAttribute {
    private int strength = 0;
    private int dexterity = 0;
    private int intelligence = 0;

    public HeroAttribute(int strengt, int dexterity, int intelligence) {
        this.strength = strengt;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void setDexterity(int dexterity) {this.dexterity = dexterity;}
    public void setIntelligence(int intelligence) {this.intelligence = intelligence;}
    public void setStrength(int strength) {this.strength = strength;}
}