package act6Banco;

import java.io.Serializable;

public class ClienteSer implements Serializable {
    private String dni;
    private String nombre;
    private String fechaNacimiento;
    private double saldo;

    public ClienteSer(String dni, String nombre, String fechaNacimiento, double saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente [dni=" + dni + ", Nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", saldo="
                + saldo + "]";
    }

}
