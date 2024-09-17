package casillaObjetos;

public class casilla {
    public int id=0; // (0) casilla vacia, (1) personaje, (2) torre
    public int[] cords;
    public boolean canMove;

    public casilla(int x,int y){
        cords=new int[]{x,y};
        canMove=false;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}
}
