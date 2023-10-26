package institutoBruno;

import java.util.ArrayList;

public class InstitutoTestBruno {

    public static void main(String[] args) {
        try{
        
        ProfesorBruno profeJuan = new ProfesorBruno("Juan",30,"2.6","Base de datos");
        ProfesorBruno profeDavid = new ProfesorBruno("David",35,"2.7","Programación");

        ArrayList<ProfesorBruno> listaProfesores = new ArrayList<ProfesorBruno>();
        ArrayList<ProfesorBruno> listaProfesores2 = new ArrayList<ProfesorBruno>();

        listaProfesores.add(profeJuan);
        listaProfesores2.add(profeDavid);
        
        AlumnoBruno alumnoAna = new AlumnoBruno("Ana", 22, "2.6", 8);
        AlumnoBruno alumnoLuis = new AlumnoBruno("Luis", 28, "2.6", 6);
        AlumnoBruno alumnoCarla = new AlumnoBruno("Carla", 20, "2.6", 8);
        AlumnoBruno alumnoMarta = new AlumnoBruno("Marta", 18, "2.7", 9);
        AlumnoBruno alumnoPedro = new AlumnoBruno("Pedro", 35, "2.7", 5);
        AlumnoBruno alumnoSara = new AlumnoBruno("Sara", 19, "2.7", 3);

        ArrayList<AlumnoBruno> listaAlumnos = new ArrayList<AlumnoBruno>();
        ArrayList<AlumnoBruno> listaAlumnos2 = new ArrayList<AlumnoBruno>();

        listaAlumnos.add(alumnoAna);
        listaAlumnos.add(alumnoLuis);
        listaAlumnos.add(alumnoCarla);
        listaAlumnos2.add(alumnoMarta);
        listaAlumnos2.add(alumnoPedro);
        listaAlumnos2.add(alumnoSara);

        AulaBruno aula26 = new AulaBruno("2.6", listaProfesores, listaAlumnos);
        AulaBruno aula27 = new AulaBruno("2.7", listaProfesores2, listaAlumnos2);
        System.out.println("Aula 2.6: "+aula26);
        System.out.println("Aula 2.7: "+aula27);
    }   
    catch (Exception e) {
        System.out.println(e);
    }

    }
}
