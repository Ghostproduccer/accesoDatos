package act2Agenda;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class AgendaBruno {

    private final int MAX_CONTACTS = 20;
    private String FILE_PATH = "";
    private ArrayList<ContactoBruno> contacts = new ArrayList<>();

    

    public AgendaBruno(String fILE_PATH) {
        FILE_PATH = fILE_PATH;
    }

    public void loadContacts() throws IOException {
        try {
            BufferedReader br =new BufferedReader(new FileReader(new File(FILE_PATH)));
            String line = "";

            try {
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String name = parts[0];
                    String phone = parts[1];
                    ContactoBruno contact = new ContactoBruno(name, phone);
                    this.contacts.add(contact);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            br.close();
        } catch (FileNotFoundException e) {
            // No hay datos guardados.
        }
    }

    public void saveContacts() throws IOException {
        try {
            BufferedWriter bw =new BufferedWriter(new FileWriter(new File(FILE_PATH)));
            for (ContactoBruno c : contacts) {
                bw.write(c.getName() + "," + c.getPhone()+"\n");
            }
            bw.close();
        } catch (FileNotFoundException e) {
            // No se puede guardar la agenda.
        }
    }

    public boolean contactExists(String name) {
        for (ContactoBruno c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<ContactoBruno> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<ContactoBruno> contacts) {
        this.contacts = contacts;
    }

    public int getMAX_CONTACTS() {
        return MAX_CONTACTS;
    }

}
