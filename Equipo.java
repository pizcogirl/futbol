import java.util.Random;
import java.util.ArrayList;

/**
 * Representa a un equipo.
 * 
 * @author Julia Zuara 
 * @version (a version number or a date)
 */
public class Equipo
{
    // Representa la numeración de los jugadores en el equipo
    private int numeracion;
    // Nombre del equipo
    private String nombre;
    // Jugadores del equipo
    private ArrayList<Jugador> jugadores;
    // Capitan del equipo
    private Capitan capitan;
    // Portero del equipo
    private Portero portero;

    /**
     * Crea un equipo con el nombre introducido y el numero de jugadores indicado. Si se introducen
     * menos de 11 jugadores se cambiara el numero a 11 por defecto.
     */
    public Equipo(String nombre, int numeroJugadores)
    {
        this.nombre = nombre;
        // Debe haber al menos 11 jugadores
        if(numeroJugadores < 11)
        {
            numeroJugadores = 11;
        }
        else if(numeroJugadores > 25)
        {
            numeroJugadores = 25;
        }
        // initialise instance variables
        this.jugadores = new ArrayList<Jugador>();
        numeracion = 1;
        // Crea al portero y añade uno a la numeracion
        this.portero = new Portero(numeracion);
        jugadores.add(portero);
        numeracion++;
        // Crea el resto de jugadores, de forma aleatoria uno es capitan
        Random rand = new Random();
        int indiceCapitan = rand.nextInt(numeroJugadores - 1) + 1;
        for(int i = 0; i < (numeroJugadores -1); i++)
        {
            if(i == indiceCapitan)
            {
                this.capitan = new Capitan(numeracion);
                jugadores.add(capitan);
                numeracion++;
            }
            else
            {
                jugadores.add(new JugadorDeCampo(numeracion));
                numeracion++;
            }
        }
    }

    /**
     * Devuelve el nombre del equipo.
     * @return El nombre del equipo.
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Devuelve el portero del equipo.
     * @return El portero del equipo.
     */
    public Portero getPortero()
    {
        return portero;
    }
    
    /**
     * Devuelve el capitan del equipo.
     * @return El capitan del equipo.
     */
    public Capitan getCapitan()
    {
        return capitan;
    }

    /**
     * Muestra la informacion del equipo.
     */
    public void infoEquipo()
    {
        String mostrar = "\nNombre: " + nombre;
        for(int i = 0; i < jugadores.size(); i++)
        {
            mostrar += "\n" + jugadores.get(i).toString();
        }
        mostrar += "\nValoración media de todo el equipo: " + String.format("%.2f", valoracionMedia());
        System.out.println(mostrar);
    }

    /**
     * Devuelve la plantilla de jugadores
     * @return Una colección de jugadores con la plantilla
     */
    public ArrayList<Jugador> getPlantilla()
    {
        return jugadores;
    }

    /**
     * Calcula la valoración del equipo.
     * @return La valoración del equipo.
     */
    private float valoracionMedia()
    {
        float valoracion = 0;
        for(int i = 0; i < jugadores.size(); i++)
        {
            valoracion += jugadores.get(i).valoracion();
        }
        return (valoracion/jugadores.size());
    }

}
