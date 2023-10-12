package institutoBruno;

import java.util.ArrayList;
import java.util.Arrays;

public class AulaBruno { 
    //atributos
    private String sNombre;
    private int iNumEstudiantes;
    private ArrayList<ProfesorBruno> sProfesores;
    private ArrayList<AlumnoBruno> sAlumnos;
    private ArrayList<String> sMaterias;

    /*constructores*/
    public AulaBruno(String paramNombre, ArrayList<ProfesorBruno> paramProfesores, ArrayList<AlumnoBruno> paramAlumnos) throws Exception {
        if (!Arrays.asList(ConstantesBruno.lista_Aulas).contains(paramNombre)) {
            throw new Exception("Error: El nombre del aula no ha sido encontrado.");
        }
        if (paramAlumnos.size() > ConstantesBruno.iMaxEstudiantes) {
            throw new Exception("Error: El número de alumnos excede el límite.");
        }
        this.sNombre = paramNombre;
        this.iNumEstudiantes = paramAlumnos.size();
        this.sProfesores = paramProfesores;
        this.sAlumnos = paramAlumnos;
        this.sMaterias = new ArrayList<String>();

        for (int i=0; i<paramProfesores.size(); i++) {
            sMaterias.add(paramProfesores.get(i).getMateria());
        }
    }
    
    /*metodos*/
    @Override
    public String toString() {
        return "Aula [sNombre=" + sNombre + ", iNumEstudiantes=" + iNumEstudiantes + ", sProfesores=" + sProfesores
                + ", sAlumnos=" + sAlumnos + ", sMaterias=" + sMaterias + "]";
    }

    
}

