package parkingBruno;

public class ParkingTestBruno {

    public static void main(String[] args) throws Exception {
        
        //creamos 4 nuevos vehiculos
        VehiculoBruno brunoMovil1 = new VehiculoBruno("3434DFG");
        VehiculoBruno brunoMovil2 = new VehiculoBruno("7465GHJ");
        VehiculoBruno brunoMovil3 = new VehiculoBruno("9674JHY");
        VehiculoBruno brunoMovil4 = new VehiculoBruno("3728RVU");

        //creamos un parking
        ParkingVehiculoBruno parking1 = new ParkingVehiculoBruno("Avenida de los poblados 36");

        //aparcamos los coches
        parking1.aparcaCoche(brunoMovil1);
        parking1.aparcaCoche(brunoMovil2);
        parking1.aparcaCoche(brunoMovil3);
        parking1.aparcaCoche(brunoMovil4);

        //esperamos 2 min
        Thread.sleep(2 * 60 * 1000);

        //sacamos los coches del parking
        parking1.sacaCoche(brunoMovil1);
        parking1.sacaCoche(brunoMovil2);
        parking1.sacaCoche(brunoMovil3);
        parking1.sacaCoche(brunoMovil4);

        //calculamos la factura
        System.out.println("La factura de "+brunoMovil1.toString()+" asciende a "+parking1.getFactura(brunoMovil1)+" euros.");
        System.out.println("La factura de "+brunoMovil2.toString()+" asciende a "+parking1.getFactura(brunoMovil2)+" euros.");
        System.out.println("La factura de "+brunoMovil3.toString()+" asciende a "+parking1.getFactura(brunoMovil3)+" euros.");
        System.out.println("La factura de "+brunoMovil4.toString()+" asciende a "+parking1.getFactura(brunoMovil4)+" euros.");
        
    }
    
}
