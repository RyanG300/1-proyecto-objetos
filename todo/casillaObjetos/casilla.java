package casillaObjetos;

public class casilla {
    public int id=0; // (0) casilla vacia, (1) personaje, (2) torre
    public int[] cords;
    public boolean EnMovimiento;
    public Character personajeDentro;
    public Tower torreDentro;
    public boolean bajoAtaque =false;
    public boolean  habilidad1BajoAtaque=false;
    public boolean  habilidad2BajoAtaque=false;

    public casilla(int x,int y){
        cords=new int[]{x,y};
        EnMovimiento =false;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public void moveOrDelete(int nuevaId){

    }

}
