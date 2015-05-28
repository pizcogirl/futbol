import java.util.Random;

/**
 * Crea el capitan del equipo
 * 
 * @author Julia Zuara
 * @version (a version number or a date)
 */
public class Capitan extends JugadorDeCampo
{
    // Representa el liderazgo del capitan
    private int liderazgo;

    /**
     * Crea el capitan del equipo.
     * @param dorsal El dorsal del jugador.
     */
    public Capitan(int dorsal)
    {
        // initialise instance variables
        super(dorsal);
        Random rand = new Random();
        liderazgo = rand.nextInt(6);
        titular();
    }

    /**
     * Devuelve el liderazgo del jugador.
     * @return El liderazgo del jugador.
     */
    public int getLiderazgo()
    {
        return liderazgo;
    }
    
    /**
     * Calcula y devuelve la valoración del jugador.
     * @return La valoración del jugador.
     */
    public int valoracion()
    {
        return (super.valoracion() + getLiderazgo());
    }
    
    /**
     * Devuelve la información del jugador.
     * @return La información del jugador.
     */
    public String toString()
    {
        return (super.toString() + "\tLiderazgo: " + getLiderazgo());
    }
}
