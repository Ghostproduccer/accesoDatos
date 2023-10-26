package act2Agenda;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class AgendaMain {
    public static void main(String[] args) throws IOException {

        Agenda agenda = new Agenda("src\\agenda\\Agenda.txt");
        agenda.loadContacts();
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 4) {
            System.out.println("1-Nuevo contacto");
            System.out.println("2-Buscar por nombre");
            System.out.println("3-Mostrar todos");
            System.out.println("4-Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    if (agenda.getContacts().size() == agenda.getMAX_CONTACTS()) {
                        System.out.println("La agenda está llena.");
                        break;
                    }
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    if (agenda.contactExists(name)) {
                        System.out.println("El contacto ya existe.");
                        break;
                    }
                    System.out.print("Teléfono: ");
                    String phone = scanner.nextLine();
                    Contacto contact = new Contacto(name, phone);
                    agenda.getContacts().add(contact);
                    agenda.saveContacts();
                    break;
                case 2:
                    System.out.print("Buscar: ");
                    String search = scanner.nextLine();
                    for (Contacto c : agenda.getContacts()) {
                        if (c.getName().contains(search)) {
                            System.out.println(c.getName() + ": " + c.getPhone());
                        }
                    }
                    break;
                case 3:
                    Collections.sort(agenda.getContacts());
                    for (Contacto c : agenda.getContacts()) {
                        System.out.println(c.getName() + ": " + c.getPhone());
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
