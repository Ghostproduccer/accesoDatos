package parkingBruno;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VehiculoBruno {

    // atributos
    private String sMatricula;
    private LocalDateTime dFechaInicio;
    private LocalDateTime dFechaFin;

    // CONSTRUCTOR CON MATRICULA
    public VehiculoBruno(String parMatricula) {
        this.sMatricula = parMatricula;

    }

    // METODOS
    public LocalDateTime getdFechaFin() {
        return dFechaFin;
    }

    public LocalDateTime getdFechaInicio() {
        return dFechaInicio;
    }

    public String getsMatricula() {
        return sMatricula;
    }

    public void setdFechaFin(LocalDateTime dFechaFin) {
        this.dFechaFin = dFechaFin;
    }

    public void setdFechaInicio(LocalDateTime dFechaInicio) {
        this.dFechaInicio = dFechaInicio;
    }

    public void setsMatricula(String sMatricula) {
        this.sMatricula = sMatricula;
    }

    @Override
    public String toString() {
        return "VehiculoBruno{" +
                "sMatricula='" + sMatricula + '\'' +
                ", dFechaInicio=" + dFechaInicio +
                ", dFechaFin=" + dFechaFin +
                '}';
    }

}
