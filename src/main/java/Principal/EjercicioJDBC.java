package Principal;

import Dao.EstudianteDao;
import Dao.MateriaDao;
import Modelo.Estudiante;
import Modelo.Materia;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EjercicioJDBC {
    public static void main(String[] args) {
        EstudianteDao estudianteDAO = new EstudianteDao();
        MateriaDao materiaDAO = new MateriaDao();
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 9) {
            System.out.println("Menu Principal:");
            System.out.println("1. Ver Estudiantes");
            System.out.println("2. Agregar Estudiante");
            System.out.println("3. Actualizar Estudiante");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Ver Materias");
            System.out.println("6. Agregar Materia");
            System.out.println("7. Actualizar Materia");
            System.out.println("8. Eliminar Materia");
            System.out.println("9. Salir");
            System.out.print("Elija una opcion: ");
            option = scanner.nextInt();

            try {
                switch (option) {
                    case 1:
                        List<Estudiante> estudiantes = estudianteDAO.selectAll();
                        for (Estudiante e : estudiantes) {
                            System.out.println(e.getNombre() + "\n"+ e.getApellido() + "\n" + e.getEmail()+ "\n" + e.getId());
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
                        estudianteDAO.insert(estudiante);
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
                        estudianteDAO.update(estudiante);
                        break;
                    case 4:
                        System.out.print("ID del Estudiante a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        estudianteDAO.delete(idEliminar);
                        break;
                    case 5:
                        List<Materia> materias = materiaDAO.selectAll();
                        for (Materia m : materias) {
                            System.out.println(m.getNombre()+ "\n" + m.getIdEstudiante()+ "\n" + m.getId());
                        }
                        break;
                    case 6:
                        System.out.print("Nombre de la Materia: ");
                        String nombreMateria = scanner.next();
                        System.out.print("ID del Estudiante: ");
                        int idEstudiante = scanner.nextInt();
                        Materia materia = new Materia(0, nombreMateria, idEstudiante);
                        materiaDAO.insert(materia);
                        break;
                    case 7:
                        System.out.print("ID de la Materia a actualizar: ");
                        int idActualizarMateria = scanner.nextInt();
                        System.out.print("Nuevo Nombre: ");
                        nombreMateria = scanner.next();
                        System.out.print("Nuevo ID de Estudiante: ");
                        idEstudiante = scanner.nextInt();
                        materia = new Materia(idActualizarMateria, nombreMateria, idEstudiante);
                        materiaDAO.update(materia);
                        break;
                    case 8:
                        System.out.print("ID de la Materia a eliminar: ");
                        int idEliminarMateria = scanner.nextInt();
                        materiaDAO.delete(idEliminarMateria);
                        break;
                    case 9:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
