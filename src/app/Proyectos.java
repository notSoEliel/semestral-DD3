package app;

public class Proyectos {
    private int proyId;
    private String proyCodigo;
    private String proyNombre;
    private String proyHorasDedicacion;
    private String proyFechaInicio;
    private String proyFechaFin;
    private String proyDescripcion;

    public Proyectos(int proyId, String proyCodigo, String proyNombre, String proyHorasDedicacion, String proyFechaInicio, String proyFechaFin, String proyDescripcion) {
        this.proyId = proyId;
        this.proyCodigo = proyCodigo;
        this.proyNombre = proyNombre;
        this.proyHorasDedicacion = proyHorasDedicacion;
        this.proyFechaInicio = proyFechaInicio;
        this.proyFechaFin = proyFechaFin;
        this.proyDescripcion = proyDescripcion;
    }

    // Getters y setters
    public int getProyId() {
        return proyId;
    }

    public void setProyId(int proyId) {
        this.proyId = proyId;
    }

    public String getProyCodigo() {
        return proyCodigo;
    }

    public void setProyCodigo(String proyCodigo) {
        this.proyCodigo = proyCodigo;
    }

    public String getProyNombre() {
        return proyNombre;
    }

    public void setProyNombre(String proyNombre) {
        this.proyNombre = proyNombre;
    }

    public String getProyHorasDedicacion() {
        return proyHorasDedicacion;
    }

    public void setProyHorasDedicacion(String proyHorasDedicacion) {
        this.proyHorasDedicacion = proyHorasDedicacion;
    }

    public String getProyFechaInicio() {
        return proyFechaInicio;
    }

    public void setProyFechaInicio(String proyFechaInicio) {
        this.proyFechaInicio = proyFechaInicio;
    }

    public String getProyFechaFin() {
        return proyFechaFin;
    }

    public void setProyFechaFin(String proyFechaFin) {
        this.proyFechaFin = proyFechaFin;
    }

    public String getProyDescripcion() {
        return proyDescripcion;
    }

    public void setProyDescripcion(String proyDescripcion) {
        this.proyDescripcion = proyDescripcion;
    }
}
