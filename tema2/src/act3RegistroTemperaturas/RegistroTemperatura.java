package act3RegistroTemperaturas;


public class RegistroTemperatura {
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


    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public String getFecha() {
        return fecha;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public int getTempMaxima() {
        return tempMaxima;
    }


    public void setTempMaxima(int tempMaxima) {
        this.tempMaxima = tempMaxima;
    }


    public int getTempMinima() {
        return tempMinima;
    }


    public void setTempMinima(int tempMinima) {
        this.tempMinima = tempMinima;
    }


    @Override
    public String toString() {
        return ciudad + "\t" + "Fecha= "+fecha + "\t" + "Máxima= "+tempMaxima + "\t" +"Mínima="+ tempMinima;
    }
}