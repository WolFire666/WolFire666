public class Estudiante extends Persona {

    private String codigoEstudiante;
    private int    semestre;

    public Estudiante(String nombre, String id,
                      String codigoEstudiante, int semestre) {
        super(nombre, id);                 // llama al constructor de Persona
        this.codigoEstudiante = codigoEstudiante;
        this.semestre         = semestre;
    }

    public String getCodigoEstudiante() { return codigoEstudiante; }
    public int    getSemestre()         { return semestre; }

    public void registrarIngreso() {
        System.out.println(">> Ingreso registrado para: " + getNombre()
                           + " [" + codigoEstudiante + "]");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("--- Estudiante ---");
        super.mostrarInfo();               // reutiliza el método del padre
        System.out.println("Código   : " + codigoEstudiante);
        System.out.println("Semestre : " + semestre);
    }
}
