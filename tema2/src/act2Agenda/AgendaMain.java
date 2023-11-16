package act2Agenda;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class AgendaMain {
    public static void main(String[] args) throws IOException {

        AgendaBruno agenda = new AgendaBruno("tema2\\src\\act2Agenda\\Agenda.txt");
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
                    ContactoBruno contact = new ContactoBruno(name, phone);
                    agenda.getContacts().add(contact);
                    agenda.saveContacts();
                    System.out.println("Nuevo contacto añadido.");
                    break;
                case 2:
                    System.out.print("Buscar: ");
                    String search = scanner.nextLine();
                    for (ContactoBruno c : agenda.getContacts()) {
                        if (c.getName().equalsIgnoreCase(search)) {
                            System.out.println(c.getName() + ": " + c.getPhone());
                        }
                    }
                    break;
                case 3:
                    Collections.sort(agenda.getContacts());
                    for (ContactoBruno c : agenda.getContacts()) {
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
