package electrodomesticoBruno;

import java.util.ArrayList;
import java.util.List;

public class ElectrodTest {
    public static void main(String[] args) {

        List listaElectrodomesticos = new ArrayList<>();

        listaElectrodomesticos.add(new Nevera());
        listaElectrodomesticos.add(new Nevera("Sony", "21219", 500, "rojo", 3000, 2, 3, 0.40397, 800, 300, 40));
        listaElectrodomesticos.add(new Televisor());
        listaElectrodomesticos.add(new Televisor("LG", "Luxury", 1800, "negro", 1500, 1.5, 5, 0.40397, 70));

        double consumoAnual = 0;
        double sumaTotalConsumo = 0;
        int orden = 0;

        for (Object object : listaElectrodomesticos) {
            if (object instanceof Nevera) {
                Nevera nevera = (Nevera) object;
                consumoAnual = nevera.consumoAnual();
            } else if (object instanceof Televisor) {
                Televisor tv = (Televisor) object;
                consumoAnual = tv.consumoAnual();
            }
            orden++;
            System.out.println("El consumo anual del elctrodoméstico" + orden + " es: "
                    + String.format("%.2f", consumoAnual) + " euros.");
            sumaTotalConsumo = sumaTotalConsumo + consumoAnual;
        }

        System.out.println("La suma total del consumo anual de todos los electrodomésticos asciende a "
                + String.format("%.2f", sumaTotalConsumo) + " euros.");

    }
}
