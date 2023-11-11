package com.transportesBruno.pojoBruno;

import javax.xml.bind.annotation.*;

//anotaciones
@XmlRootElement(name = "empleado") // el elemento raiz es empleado
@XmlType(propOrder = { "dniEmpleado", "nombreEmpleado", "fechaNacEmpleado", "tlfEmpleado", "salarioEmpleado" })
@XmlAccessorType(XmlAccessType.FIELD)

public class Empleado {
    // atributos
    @XmlAttribute(required = true)
    private Integer id;
    @XmlElement(name = "dni")
    private String dniEmpleado;
    @XmlElement(name = "nombre")
    private String nombreEmpleado;
    @XmlElement(name = "fechaNacimiento")
    private String fechaNacEmpleado;
    @XmlElement(name = "telefono")
    private String tlfEmpleado;
    @XmlElement(name = "salary")
    private double salarioEmpleado;

    // constructores

    public Empleado() {
    }

    public Empleado(Integer id, String dniEmpleado, String nombreEmpleado, String fechaNacEmpleado, String tlfEmpleado,
            double salarioEmpleado) {
        this.id = id;
        this.dniEmpleado = dniEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.fechaNacEmpleado = fechaNacEmpleado;
        this.tlfEmpleado = tlfEmpleado;
        this.salarioEmpleado = salarioEmpleado;
    }

    // getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getFechaNacEmpleado() {
        return fechaNacEmpleado;
    }

    public void setFechaNacEmpleado(String fechaNacEmpleado) {
        this.fechaNacEmpleado = fechaNacEmpleado;
    }

    public String getTlfEmpleado() {
        return tlfEmpleado;
    }

    public void setTlfEmpleado(String tlfEmpleado) {
        this.tlfEmpleado = tlfEmpleado;
    }

    public double getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(double salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }

    // toString
    @Override
    public String toString() {
        return "Empleado [id=" + id + ", dniEmpleado=" + dniEmpleado + ", nombreEmpleado=" + nombreEmpleado
                + ", fechaNacEmpleado=" + fechaNacEmpleado + ", tlfEmpleado=" + tlfEmpleado + ", salarioEmpleado="
                + salarioEmpleado + "]";
    }

}
