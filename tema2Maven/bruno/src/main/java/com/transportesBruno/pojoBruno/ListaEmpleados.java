package com.transportesBruno.pojoBruno;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

//anotaciones
@XmlRootElement(name = "empleados") // el elemento raiz es empleados
@XmlAccessorType(XmlAccessType.FIELD)

public class ListaEmpleados {
    // atributos
    @XmlElement(name = "empleado")
    private List<Empleado> empleados;

    // getters setters
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    // toString
    @Override
    public String toString() {
        return "ListaEmpleados [empleados=" + empleados + "]";
    }

}
