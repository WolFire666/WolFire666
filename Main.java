public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║  SISTEMA DE VERIFICACIÓN DE INGRESO  ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        SistemaAsistencia sistema = new SistemaAsistencia(50);

        Estudiante e1 = new Estudiante("Laura Gómez",    "U001", "EST-001", 3);
        Estudiante e2 = new Estudiante("Carlos Ríos",    "U002", "EST-002", 3);
        Estudiante e3 = new Estudiante("María Morales",  "U003", "EST-003", 4);

        Profesor p1 = new Profesor("Andrés Vargas", "P001",
                                   "PRF-001", "Programación Orientada a Objetos");

        System.out.println("--- Datos cargados ---");
        e1.mostrarInfo();
        System.out.println();
        p1.mostrarInfo();
        System.out.println();

        System.out.println("--- Registro de ingresos ---");
        sistema.registrarAsistencia(e1);
        sistema.registrarAsistencia(e2);
        sistema.registrarAsistencia(e3);

        sistema.registrarAsistencia(e1);

        System.out.println();

        System.out.println("--- Profesor toma asistencia ---");

        p1.tomarAsistencia(sistema, e2);

        sistema.mostrarTodosLosRegistros();

        sistema.buscarPorEstudiante("EST-001");

        System.out.println("\nTotal de asistencias registradas: "
                           + sistema.getTotalRegistros());
    }
}
