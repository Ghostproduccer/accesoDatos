package electrodomesticoBruno;

public class Televisor extends Electrodomestico {

    private int iResolucion;

    // constructor por defecto
    public Televisor() {
        this.iResolucion = 40;
    }

    // constructor2
    public Televisor(String sMarca, String sModelo, double dPrecio, String sColor, int iPotencia,
            double dHorasUtilizacion, int iDiasUtilizacion, double dPrecioEnergia, int iResolucion) {
        super(sMarca, sModelo, dPrecio, sColor, iPotencia, dHorasUtilizacion, iDiasUtilizacion, dPrecioEnergia);
        this.iResolucion = iResolucion;
    }

    public double consumoAnual() {
        // Calcula el consumo diario en kWh
        double consumoDiarioKWh = (super.getiPotencia() * super.getdHorasUtilizacion()) / 1000;

        // Calcula el consumo anual en kWh
        double consumoAnualKWh = consumoDiarioKWh * super.getiDiasUtilizacion();

        // Calcula el costo anual en euros
        double costoAnualEuros = consumoAnualKWh * super.getdPrecioEnergia();

        // Comprueba si hay que aplicar tasa adicional
        if (iResolucion > 50) {
            costoAnualEuros += 30;
        }

        return costoAnualEuros;
    }

    public int getiResolucion() {
        return iResolucion;
    }

    public void setiResolucion(int iResolucion) {
        this.iResolucion = iResolucion;
    }

    @Override
    public String toString() {
        return "Televisor [iResolucion=" + iResolucion + "]";
    }

}
