import java.util.Random;

/**
 * Representa a un jugador de campo del equipo
 * 
 * @author Julia Zuara
 * @version (a version number or a date)
 */
public class JugadorDeCampo extends Jugador
{
    // Representa la habilidad de pase del jugador
    private int pase;
    // Representa la habilidad de regate del jugador
    private int regate;
    // Representa la habilidad de remate del jugador
    private int remate;

    /**
     * Crea un jugador de campo del equipo.
     * @param dorsal El dorsal del jugador.
     */
    public JugadorDeCampo(int dorsal)
    {
        // initialise instance variables
        super(dorsal);
        Random rand = new Random();
        pase = rand.nextInt(11);
        regate = rand.nextInt(11);
        remate = rand.nextInt(11);
    }

    /**
     * Devuelve el pase del jugador.
     * @return El pase del jugador.
     */
    public int getPase()
    {
        return pase;
    }

    /**
     * Devuelve el regate del jugador.
     * @return El regate del jugador.
     */
    public int getRegate()
    {
        return regate;
    }

    /**
     * Devuelve el remate del jugador.
     * @return El remate del jugador.
     */
    public int getRemate()
    {
        return remate;
    }

    /**
     * Calcula y devuelve la valoración del jugador.
     * @return La valoración del jugador.
     */
    public int valoracion()
    {
        return ((getPase() + getRemate() + getRegate())/3);
    }

    /**
     * Devuelve la información del jugador.
     * @return La información del jugador.
     */
    public String toString()
    {
        return (super.toString() + "\t Pase: " + getPase() + "\tRegate: " + getRegate() + "\tRemate: " + getRemate());
    }
}
