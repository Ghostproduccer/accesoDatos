package electrodomesticoBruno;

public class Electrodomestico {

    private String sMarca;
    private String sModelo;
    private double dPrecio;
    private String sColor;
    private int iPotencia;
    private double dHorasUtilizacion;
    private int iDiasUtilizacion;
    private double dPrecioEnergia;

    // constructor por defecto
    public Electrodomestico() {
        this.sMarca = "Bosch";
        this.sModelo = "7200";
        this.dPrecio = 400;
        this.sColor = "gris";
        this.iPotencia = 2300;
        this.dHorasUtilizacion = 1;
        this.iDiasUtilizacion = 3;
        this.dPrecioEnergia = 0.40397;
    }

    // constructor con marca modelo y precio
    public Electrodomestico(String marca, String modelo, double precio) {
        this.sMarca = marca;
        this.sModelo = modelo;
        this.dPrecio = precio;
        this.sColor = "gris";
        this.iPotencia = 2300;
        this.dHorasUtilizacion = 1;
        this.iDiasUtilizacion = 3;
        this.dPrecioEnergia = 0.40397;
    }

    // constructor con todos los atributos como parámetro
    public Electrodomestico(String sMarca, String sModelo, double dPrecio, String sColor, int iPotencia,
            double dHorasUtilizacion, int iDiasUtilizacion, double dPrecioEnergia) {
        this.sMarca = sMarca;
        this.sModelo = sModelo;
        this.dPrecio = dPrecio;
        this.sColor = sColor;
        this.iPotencia = iPotencia;
        this.dHorasUtilizacion = dHorasUtilizacion;
        this.iDiasUtilizacion = iDiasUtilizacion;
        this.dPrecioEnergia = dPrecioEnergia;
    }

    // metodos
    public double consumoAnual() {
        // Calcula el consumo diario en kWh
        double consumoDiarioKWh = (iPotencia * dHorasUtilizacion) / 1000;

        // Calcula el consumo anual en kWh
        double consumoAnualKWh = consumoDiarioKWh * iDiasUtilizacion;

        // Calcula el costo anual en euros
        double costoAnualEuros = consumoAnualKWh * dPrecioEnergia;

        return costoAnualEuros;
    }

    @Override
    public String toString() {
        return "Electrodomestico [sMarca=" + sMarca + ", sModelo=" + sModelo + ", dPrecio=" + dPrecio + ", sColor="
                + sColor + ", iPotencia=" + iPotencia + ", dHorasUtilizacion=" + dHorasUtilizacion
                + ", iDiasUtilizacion=" + iDiasUtilizacion + ", dPrecioEnergia=" + dPrecioEnergia + "]";
    }

    public String getsMarca() {
        return sMarca;
    }

    public void setsMarca(String sMarca) {
        this.sMarca = sMarca;
    }

    public String getsModelo() {
        return sModelo;
    }

    public void setsModelo(String sModelo) {
        this.sModelo = sModelo;
    }

    public double getdPrecio() {
        return dPrecio;
    }

    public void setdPrecio(double dPrecio) {
        this.dPrecio = dPrecio;
    }

    public String getsColor() {
        return sColor;
    }

    public void setsColor(String sColor) {
        this.sColor = sColor;
    }

    public int getiPotencia() {
        return iPotencia;
    }

    public void setiPotencia(int iPotencia) {
        this.iPotencia = iPotencia;
    }

    public double getdHorasUtilizacion() {
        return dHorasUtilizacion;
    }

    public void setdHorasUtilizacion(double dHorasUtilizacion) {
        this.dHorasUtilizacion = dHorasUtilizacion;
    }

    public int getiDiasUtilizacion() {
        return iDiasUtilizacion;
    }

    public void setiDiasUtilizacion(int iDiasUtilizacion) {
        this.iDiasUtilizacion = iDiasUtilizacion;
    }

    public double getdPrecioEnergia() {
        return dPrecioEnergia;
    }

    public void setdPrecioEnergia(double dPrecioEnergia) {
        this.dPrecioEnergia = dPrecioEnergia;
    }

}
