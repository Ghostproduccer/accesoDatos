package complejos;
public class Complejo {

    private double dPReal;
    private double dPImag;

    public Complejo() {
        this.dPReal = 0;
        this.dPImag = 0;
    }

    public double getdPReal() {
        return dPReal;
    }

    public void setdPReal(double dPReal) {
        this.dPReal = dPReal;
    }

    public double getdOImag() {
        return dPImag;
    }

    public void setdOImag(double dPImag) {
        this.dPImag = dPImag;
    }

    @Override
    public String toString() {
        return "Complejo [Parte Real=" + dPReal + ", Parte Imaginaria=" + dPImag + "]";
    }

    public void asignar(double x, double y) {
        this.dPReal = x;
        this.dPImag = y;
    }

    public Complejo sumar(Complejo c1, Complejo c2) {

        double newPReal;
        double newPImag;
        Complejo resultado = new Complejo();

        newPReal = c1.dPReal + c2.dPReal;
        newPImag = c1.dPImag + c2.dPImag;
        resultado.asignar(newPReal, newPImag);

        return resultado;
    }

    public void imprimir() {
        System.out.println(this.toString());
    }

}
