package casillaObjetos;

public class Tower {
    public int id;
    private double resistence;
    public boolean colocado;

    public Tower(double resistence,int id) {
        this.resistence = resistence;
        this.id = id;
    }

    public void receiveDamage(double damage){
        resistence -= damage;
    }
}
