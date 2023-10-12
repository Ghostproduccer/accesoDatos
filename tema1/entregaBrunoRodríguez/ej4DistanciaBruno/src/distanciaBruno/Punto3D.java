package distanciaBruno;
public class Punto3D extends Punto {
    private int z;

    public Punto3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    //metodo distancia
    public double distancia(Punto3D otroPunto3D) {

            Punto3D punto3D = otroPunto3D;
            int deltaX = this.getX() - punto3D.getX();
            int deltaY = this.getY() - punto3D.getY();
            int deltaZ = this.z - punto3D.getZ();
            return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ); 

    }

    public int getZ() {
        return z;
    }

    //metodo equals
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Punto3D otroPunto = (Punto3D) obj;
        return z == otroPunto.z;
    }
}
