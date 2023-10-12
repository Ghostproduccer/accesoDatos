package complejos;
public class ComplejoTest {

    static Complejo c1 = new Complejo();
    static Complejo c2 = new Complejo();
    static Complejo resultado = new Complejo();

    public static void main(String[] args) {

        // asignamos los valores de nuestros complejos
        c1.asignar(2, 2);
        c2.asignar(8, 9);

        // los sumamos
        resultado = c1.sumar(c1, c2);

        // mostramos el resultado por consola
        System.out.println("El resultado de sumar los numeros complejos " + c1 + " + " + c2 + " es:");
        resultado.imprimir();

    }

}
