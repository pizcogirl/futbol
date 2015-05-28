import java.util.ArrayList;

/**
 * Representa un partido que se juega entre dos equipos.
 * 
 * @author Julia Zuara
 * @version (a version number or a date)
 */
public class Partido
{
    // Alineacion del equipo local que juega el partido
    private Alineacion alineacionLocal;
    // Alineacion del equipo visitante en el partido
    private Alineacion alineacionVisitante;

    /**
     * Crea un partido entre los equipos que se pasan como parametros
     * @param local Equipo local del partido
     * @param visitante Equipo visitante del partido
     */
    public Partido(Equipo local, Equipo visitante)
    {
        // initialise instance variables
        this.alineacionLocal = new Alineacion(local);
        this.alineacionVisitante =new Alineacion(visitante);        
    }
    
    /**
     * Muestra las alineaciones de ambos equipos.
     */
    public void mostrarAlineaciones()
    {
        mostrarAlineacionLocal();
        mostrarAlineacionVisitante();
    }

    /**
     * Muestra las alineacion local
     */
    public void mostrarAlineacionLocal()
    {
        // Muestra la información del equipo local
        alineacionLocal.mostrarAlineacion();
    }

    /**
     * Muestra la alineacion visitante
     */
    public void mostrarAlineacionVisitante()
    {
        // Muestra la información del equipo visitante
        alineacionVisitante.mostrarAlineacion();
    }
}
