package casillaObjetos;


public class Ability {
    public String nombre;
    public double manaCost;
    public double damage;

    public Ability(String nombre, double manaCost, double damage) {
        this.nombre = nombre;
        this.manaCost = manaCost;
        this.damage = damage;
    }
    public void useAbility(Character attacker, Character target) {
        if (attacker.mana >= manaCost){
            attacker.mana -= manaCost;
            target.life -= damage;
        }
    }
}
