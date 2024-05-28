package Principal;

import Dao.EstudianteDao;
import Dao.MateriaDao;
import Dao.FechaInscripcionDao;
import Modelo.Estudiante;
import Modelo.Materia;
import Modelo.FechaInscripcion;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EjercicioJDBC {
    public static void main(String[] args) throws SQLException {
        EstudianteDao estudianteDAO = new EstudianteDao();
        MateriaDao materiaDAO = new MateriaDao();
        FechaInscripcionDao fechaInscripcionDAO = new FechaInscripcionDao();
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 12) {
            System.out.println("Menu Principal:");
            System.out.println("1. Ver Estudiantes");
            System.out.println("2. Agregar Estudiante");
            System.out.println("3. Actualizar Estudiante");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Ver Materias");
            System.out.println("6. Agregar Materia");
            System.out.println("7. Actualizar Materia");
            System.out.println("8. Eliminar Materia");
            System.out.println("9. Ver Inscripciones");
            System.out.println("10. Agregar Inscripción");
            System.out.println("11. Eliminar Inscripción");
            System.out.println("12. Salir");
            System.out.print("Elija una opcion: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    try {
                        List<Estudiante> estudiantes = estudianteDAO.selectAll();
                        for (Estudiante e : estudiantes) {
                            System.out.println(e.getNombre() + "\n" + e.getApellido() + "\n" + e.getEmail() + "\n" + e.getId());
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Apellido: ");
                    String apellido = scanner.next();
                    System.out.print("Email: ");
                    String email = scanner.next();
                    Estudiante estudiante = new Estudiante(0, nombre, apellido, email);
                    try {
                        estudianteDAO.insert(estudiante);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.print("ID del Estudiante a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    System.out.print("Nuevo Nombre: ");
                    nombre = scanner.next();
                    System.out.print("Nuevo Apellido: ");
                    apellido = scanner.next();
                    System.out.print("Nuevo Email: ");
                    email = scanner.next();
                    estudiante = new Estudiante(idActualizar, nombre, apellido, email);
                    try {
                        estudianteDAO.update(estudiante);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.print("ID del Estudiante a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    try {
                        estudianteDAO.delete(idEliminar);
                        System.out.println("Estudiante eliminado...");
                    } catch (SQLException e) {
                        System.out.println("No se puede eliminar por que tiene una Inscripcion en una materia");
                    }
                    break;
                case 5:
                    try {
                        List<Materia> materias = materiaDAO.selectAll();
                        for (Materia m : materias) {
                            System.out.println("Id Materia: " + m.getId() + "\n "+ "Nombre Materia" + m.getNombre());
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.print("Nombre: ");
                    String nombreMateria = scanner.next();
                    Materia materia = new Materia(0, nombreMateria);
                    try {
                        materiaDAO.insert(materia);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.print("ID de la Materia a actualizar: ");
                    int idMateriaActualizar = scanner.nextInt();
                    System.out.print("Nuevo Nombre: ");
                    nombreMateria = scanner.next();
                    materia = new Materia(idMateriaActualizar, nombreMateria);
                    try {
                        materiaDAO.update(materia);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    System.out.print("ID de la Materia a eliminar: ");
                    int idMateriaEliminar = scanner.nextInt();
                    try {
                        materiaDAO.delete(idMateriaEliminar);
                        System.out.println("Materia eliminada...");
                    } catch (SQLException e) {
                        System.out.println("No se puede eliminar por que tiene una incrpcion con un alumno");
                    }
                    break;
                case 9:
                    List<FechaInscripcion> inscripciones = fechaInscripcionDAO.selectAll();
                    for (FechaInscripcion fi : inscripciones) {
                        System.out.println("Id Fecha " + fi.getId() +"\n" + "Estudiante id: " + fi.getIdEstudiante() + "\n" + "Materia id: " + fi.getIdMateria() + "\n" + "Fecha incripcion: " + fi.getFecha());
                    }
                    break;
                case 10:
                    System.out.print("ID del Estudiante: ");
                    int idEstudiante = scanner.nextInt();
                    System.out.print("ID de la Materia: ");
                    int idMateria = scanner.nextInt();
                    System.out.print("Fecha (yyyy-mm-dd): ");
                    String fechaStr = scanner.next();
                    Date fecha = Date.valueOf(fechaStr);
                    FechaInscripcion fechaInscripcion = new FechaInscripcion(0, idEstudiante, idMateria, fecha);
                    fechaInscripcionDAO.insert(fechaInscripcion);
                    break;
                case 11:
                    System.out.print("ID de la Inscripción a eliminar: ");
                    int idInscripcionEliminar = scanner.nextInt();
                    fechaInscripcionDAO.delete(idInscripcionEliminar);
                    System.out.println("Fecha Eliminada");
                    break;
                case 12:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }
}
