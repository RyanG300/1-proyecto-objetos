package casillaObjetos;

public class Character {
    public double mana;
    public String name;
    private int level;
    public double life;
    public double FixedLife;
    public double damage;
    public String element;
    public Ability[] abilities;
    private int deaths;
    private int kills;
    private int towerKills;
    public boolean turnoRealizadoPersonaje=false;

    public Character(String name, int level, double life, double damage, String element, Ability[] abilities,double mana) {
        this.name = name;
        this.level = level;
        this.life = life;
        this.FixedLife = life;
        this.damage = damage;
        this.element = element;
        this.abilities = abilities;
        this.mana = mana;
        this.deaths = 0;
        this.kills = 0;
        this.towerKills = 0;
    }

    public String getElement() {
        return element;
    }

    public double getDamage() {
        return damage;
    }

    public void setLife() { //Para recuperar la vida al revivir
        this.life = this.FixedLife;
    }

    public void TakesDamagePerAttack(double damage) {
        this.life-=damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public int getDeaths() {
        return deaths;
    }

    public void incrementDeaths() {
        this.deaths++;
    }

    public int getKills() {
        return kills;
    }

    public void incrementKills() {
        this.kills++;
    }

    public int getTowerKills() {
        return towerKills;
    }

    public void incrementTowerKills() {
        this.towerKills++;
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

    public double getLife() {
        return life;
    }
}
