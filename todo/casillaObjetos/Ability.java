package casillaObjetos;


public class Ability {
    private String nombre;
    private double manaCost;
    private double damage;

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
