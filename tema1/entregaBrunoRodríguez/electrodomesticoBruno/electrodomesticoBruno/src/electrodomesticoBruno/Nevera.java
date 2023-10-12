package electrodomesticoBruno;

public class Nevera extends Electrodomestico {

    private int iCapacidadFrigorifico;
    private int iCapacidadCongelador;
    private double dSonoridadDB;

    // Constructor por defecto
    public Nevera() {
        this.iCapacidadFrigorifico = 300;
        this.iCapacidadCongelador = 100;
        this.dSonoridadDB = 35;
    }

    // constructor 2
    public Nevera(String sMarca, String sModelo, double dPrecio, String sColor, int iPotencia, double dHorasUtilizacion,
            int iDiasUtilizacion, double dPrecioEnergia, int iCapacidadFrigorifico, int iCapacidadCongelador,
            double dSonoridadDB) {
        super(sMarca, sModelo, dPrecio, sColor, iPotencia, dHorasUtilizacion, iDiasUtilizacion, dPrecioEnergia);
        this.iCapacidadFrigorifico = iCapacidadFrigorifico;
        this.iCapacidadCongelador = iCapacidadCongelador;
        this.dSonoridadDB = dSonoridadDB;
    }

    public double consumoAnual() {
        // Calcula el consumo diario en kWh
        double consumoDiarioKWh = (super.getiPotencia() * super.getdHorasUtilizacion()) / 1000;

        // Calcula el consumo anual en kWh
        double consumoAnualKWh = consumoDiarioKWh * super.getiDiasUtilizacion();

        // Calcula el costo anual en euros
        double costoAnualEuros = consumoAnualKWh * super.getdPrecioEnergia();

        // Comprueba si hay que aplicar tasa adicional
        if (iCapacidadFrigorifico > 300 || iCapacidadCongelador > 200) {
            costoAnualEuros += 50;
        }

        return costoAnualEuros;
    }

    public int getiCapacidadFrigorifico() {
        return iCapacidadFrigorifico;
    }

    public void setiCapacidadFrigorifico(int iCapacidadFrigorifico) {
        this.iCapacidadFrigorifico = iCapacidadFrigorifico;
    }

    public int getiCapacidadCongelador() {
        return iCapacidadCongelador;
    }

    public void setiCapacidadCongelador(int iCapacidadCongelador) {
        this.iCapacidadCongelador = iCapacidadCongelador;
    }

    public double getdSonoridadDB() {
        return dSonoridadDB;
    }

    public void setdSonoridadDB(double dSonoridadDB) {
        this.dSonoridadDB = dSonoridadDB;
    }

    @Override
    public String toString() {
        return "Nevera [iCapacidadFrigorifico=" + iCapacidadFrigorifico + ", iCapacidadCongelador="
                + iCapacidadCongelador + ", dSonoridadDB=" + dSonoridadDB + "]";
    }

}