public class SistemaAsistencia {

    private Registro[] registros;
    private int        totalRegistros;
    private int        capacidadMaxima;

    public SistemaAsistencia(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.registros       = new Registro[capacidadMaxima];
        this.totalRegistros  = 0;
    }

    public void registrarAsistencia(Estudiante estudiante) {
        if (totalRegistros >= capacidadMaxima) {
            System.out.println("!! Sistema lleno, no se puede registrar más.");
            return;
        }
        if (yaRegistradoHoy(estudiante)) {
            System.out.println("!! " + estudiante.getNombre()
                               + " ya registró ingreso hoy.");
            return;
        }
        registros[totalRegistros] = new Registro(estudiante);
        totalRegistros++;
        estudiante.registrarIngreso();
    }

    private boolean yaRegistradoHoy(Estudiante estudiante) {
        java.time.LocalDate hoy = java.time.LocalDate.now();
        String fechaHoy = hoy.format(
            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        for (int i = 0; i < totalRegistros; i++) {
            Registro r = registros[i];
            if (r.getEstudiante().getId().equals(estudiante.getId())
                    && r.getFecha().equals(fechaHoy)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarTodosLosRegistros() {
        System.out.println("\n===== REGISTROS DE ASISTENCIA =====");
        if (totalRegistros == 0) {
            System.out.println("  (sin registros aún)");
            return;
        }
        for (int i = 0; i < totalRegistros; i++) {
            System.out.println("Registro #" + (i + 1));
            registros[i].mostrarRegistro();
            System.out.println("-----------------------------------");
        }
        System.out.println("Total registros: " + totalRegistros);
    }

    public void buscarPorEstudiante(String codigoEstudiante) {
        System.out.println("\n== Historial de: " + codigoEstudiante + " ==");
        boolean encontrado = false;
        for (int i = 0; i < totalRegistros; i++) {
            Registro r = registros[i];
            if (r.getEstudiante().getCodigoEstudiante()
                                 .equals(codigoEstudiante)) {
                r.mostrarRegistro();
                System.out.println("---------");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("  Sin registros para ese código.");
        }
    }

    public int getTotalRegistros() { return totalRegistros; }
}
