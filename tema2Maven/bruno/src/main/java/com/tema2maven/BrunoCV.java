package com.tema2maven;

import java.util.List;

public class BrunoCV {

    private String nombre;
    private String apellido;
    private String titulo;
    private List<ExperienciaLaboral> experienciaLaboral;
    private List<Educacion> educacion;
    private List<String> habilidades;
    private List<Idioma> idiomas;

    // Getters y setters para todos los campos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<ExperienciaLaboral> getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(List<ExperienciaLaboral> experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public List<Educacion> getEducacion() {
        return educacion;
    }

    public void setEducacion(List<Educacion> educacion) {
        this.educacion = educacion;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    // Clases internas para representar las subestructuras
    public static class ExperienciaLaboral {
        private String puesto;
        private String empresa;
        private String periodo;

        // Getters y setters
        public String getPuesto() {
            return puesto;
        }

        public void setPuesto(String puesto) {
            this.puesto = puesto;
        }

        public String getEmpresa() {
            return empresa;
        }

        public void setEmpresa(String empresa) {
            this.empresa = empresa;
        }

        public String getPeriodo() {
            return periodo;
        }

        public void setPeriodo(String periodo) {
            this.periodo = periodo;
        }

    }

    public static class Educacion {
        private String titulo;
        private String institucion;
        private String año;

        // Getters y setters
        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getInstitucion() {
            return institucion;
        }

        public void setInstitucion(String institucion) {
            this.institucion = institucion;
        }

        public String getAño() {
            return año;
        }

        public void setAño(String año) {
            this.año = año;
        }

    }

    public static class Idioma {
        private String idioma;
        private String nivel;

        // Getters y setters
        public String getIdioma() {
            return idioma;
        }

        public void setIdioma(String idioma) {
            this.idioma = idioma;
        }

        public String getNivel() {
            return nivel;
        }

        public void setNivel(String nivel) {
            this.nivel = nivel;
        }

    }
}