package casillaObjetos;

public class Tower {
    private double resistence;
    public boolean colocado;

    public Tower(double resistence) {
        this.resistence = resistence;
    }

    public void receiveDamage(double damage){
        resistence -= damage;
    }
}
