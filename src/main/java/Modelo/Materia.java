package Modelo;

public class Materia {
    private int id;
    private String nombre;
    private int idEstudiante;

    public Materia() {
    }

    public Materia(int id, String nombre, int idEstudiante) {
        this.id = id;
        this.nombre = nombre;
        this.idEstudiante = idEstudiante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
}
