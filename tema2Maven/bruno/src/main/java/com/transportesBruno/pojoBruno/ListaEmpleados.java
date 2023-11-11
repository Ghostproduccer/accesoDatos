package com.transportesBruno.pojoBruno;

import java.util.ArrayList;
import java.util.List;

public class ListaEmpleados {
    private List<Empleado> listaEmpleados = new ArrayList<>();

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

}
