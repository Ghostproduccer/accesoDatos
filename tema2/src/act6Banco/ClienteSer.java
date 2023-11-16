package act6Banco;

import java.io.Serializable;
import java.sql.Date;

public class ClienteSer implements Serializable {
    private String dni;
    private String Nombre;
    private Date fechaNacimiento;
    private double saldo;
    
    public Cliente(String dni, String nombre, Date fechaNacimiento, double saldo) {
        this.dni = dni;
        Nombre = nombre;
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
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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
        return "Cliente [dni=" + dni + ", Nombre=" + Nombre + ", fechaNacimiento=" + fechaNacimiento + ", saldo="
                + saldo + "]";
    }

    
    
}
