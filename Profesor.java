public class Profesor extends Persona {

    private String codigoProfesor;
    private String materia;

    public Profesor(String nombre, String id,
                    String codigoProfesor, String materia) {
        super(nombre, id);
        this.codigoProfesor = codigoProfesor;
        this.materia        = materia;
    }

    public String getCodigoProfesor() { return codigoProfesor; }
    public String getMateria()        { return materia; }

    public void tomarAsistencia(SistemaAsistencia sistema, Estudiante est) {
        sistema.registrarAsistencia(est);
        System.out.println("Asistencia tomada por Prof. " + getNombre()
                           + " en " + materia);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("--- Profesor ---");
        super.mostrarInfo();
        System.out.println("Código  : " + codigoProfesor);
        System.out.println("Materia : " + materia);
    }
}
