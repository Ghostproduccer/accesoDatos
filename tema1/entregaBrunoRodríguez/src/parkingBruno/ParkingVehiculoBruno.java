package parkingBruno;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingVehiculoBruno implements ParkingBruno {

    // Atributos
    private String sDireccionPark;

    private int iPlazasOcupadas;

    // Constantes
    public static final double dPrecioMinuto = 0.2;

    public static final int iMaximoPlazas = 100;

    // Constructor
    public ParkingVehiculoBruno(String sParamDireccion) {
        this.sDireccionPark = sParamDireccion;
        this.iPlazasOcupadas = 0;
    }

    @Override
    public boolean hayPlaza() {
        // TODO Auto-generated method stub
        boolean bHayPlaza;
        if (iPlazasOcupadas <= iMaximoPlazas) {

            bHayPlaza = true;

        } else {

            bHayPlaza = false;

        }

        return bHayPlaza;

    }

    @Override
    public void aparcaCoche(VehiculoBruno vBruno) {

        boolean bPlaza = this.hayPlaza();

        if (bPlaza) {

            this.iPlazasOcupadas += this.iPlazasOcupadas;
            vBruno.setdFechaInicio(LocalDateTime.now());

            System.out.println("Coche aparcado");

        } else {
            System.out.println("No es posible aparcar, Parking lleno.");
        }

    }

    @Override
    public void sacaCoche(VehiculoBruno vBruno) {

        if (vBruno.getdFechaInicio() != null) {

            this.iPlazasOcupadas -= this.iPlazasOcupadas;

            vBruno.setdFechaFin(LocalDateTime.now());

            System.out.println("Coche fuera del parking");

        } else {
            System.out.println("el coche no esta aparcado.");
        }

    }

    @Override
    public double getFactura(VehiculoBruno vBruno) throws Exception {

        try {
            long lMinutosTranscurridos = vBruno.getdFechaInicio().until(vBruno.getdFechaFin(), ChronoUnit.MINUTES);
            double dImporteTotal = dPrecioMinuto * lMinutosTranscurridos;
            return dImporteTotal;

        } catch (Exception e) {
            throw new Exception("Error al sacar la factura" + e.getMessage());
        }

    }

}
