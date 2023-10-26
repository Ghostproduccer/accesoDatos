package act3RegistroTemperaturas;

import java.io.Serializable;

public class RegistroTemperatura implements Serializable {
    private String ciudad;
    private String fecha;
    private int tempMaxima;
    private int tempMinima;

    public RegistroTemperatura(String ciudad, String fecha, int tempMaxima, int tempMinima) {
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.tempMaxima = tempMaxima;
        this.tempMinima = tempMinima;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getTempMaxima() {
        return tempMaxima;
    }

    public int getTempMinima() {
        return tempMinima;
    }

    @Override
    public String toString() {
        return ciudad + "\t" + fecha + "\t" + tempMaxima + "\t" + tempMinima;
    }
}