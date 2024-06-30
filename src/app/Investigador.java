package app;

import java.util.LinkedList;

public class Investigador {
    private int inveId;
    private String inveNombre;
    private String inveArea;
    private String inveCodigo;
    private LinkedList<Publicaciones> publicaciones;

    public Investigador(int inveId, String inveNombre, String inveArea, String inveCodigo,
            LinkedList<Publicaciones> publicaciones) {
        this.inveId = inveId;
        this.inveNombre = inveNombre;
        this.inveArea = inveArea;
        this.inveCodigo = inveCodigo;
        this.publicaciones = publicaciones;
    }
}
