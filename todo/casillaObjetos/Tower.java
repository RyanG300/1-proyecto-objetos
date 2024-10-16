package casillaObjetos;

public class Tower {
    public int id;
    public double resistence;
    public boolean colocado;
    public boolean destroyed=false;

    public Tower(double resistence,int id) {
        this.resistence = resistence;
        this.id = id;
    }

    public void receiveDamage(double damage){
        resistence -= damage;
    }

    public void setDestroyed(){
        this.destroyed = true;
    }

}
