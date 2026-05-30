import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Registro {

    private Estudiante estudiante;   // relación "tiene un"
    private String     fecha;
    private String     hora;

    public Registro(Estudiante estudiante) {
        this.estudiante = estudiante;

        this.fecha = LocalDate.now()
                              .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.hora  = LocalTime.now()
                              .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public Estudiante getEstudiante() { return estudiante; }
    public String     getFecha()      { return fecha; }
    public String     getHora()       { return hora; }

    public void mostrarRegistro() {
        System.out.println("  Estudiante : " + estudiante.getNombre()
                           + " (" + estudiante.getCodigoEstudiante() + ")");
        System.out.println("  Fecha      : " + fecha);
        System.out.println("  Hora       : " + hora);
        System.out.println("  Semestre   : " + estudiante.getSemestre());
    }
}
