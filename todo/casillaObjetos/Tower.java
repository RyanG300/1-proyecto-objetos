package casillaObjetos;

public class Tower {
    private double resistence;

    public Tower(double resistence) {
        this.resistence = resistence;
    }

    public void receiveDamage(double damage){
        resistence -= damage;
    }
}
