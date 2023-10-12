package distanciaBruno;

public class Punto {
    private int x;
    private int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //metodo distancia
    public double distancia(Punto otroPunto) {
        int deltaX = this.x - otroPunto.x;
        int deltaY = this.y - otroPunto.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    // método equals
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Punto otroPunto = (Punto) obj;
        return x == otroPunto.x && y == otroPunto.y;
    }

}
