package casillaObjetos;

public class Character {
    public double mana;
    private String name;
    private int level;
    double life;
    private double damage;
    private String element;
    private Ability[] abilities;
    public Character(String name, int level, double life, double damage, String element, Ability[] abilities) {
        this.name = name;
        this.level = level;
        this.life = life;
        this.damage = damage;
        this.element = element;
        this.abilities = abilities;
    }

    public String getElement() {
        return element;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void attack(Character enemy) {
        enemy.life -= this.damage;
    }

    public void move(String direction) {
        // falta agregar lógica de movimiento
    }

    public void useAbility(int abilityIndex, Character enemy){
        // falta agregar lógica
    }

    public void levelUp(){
        this.level++;
        this.damage *= 1.25;
    }
}
