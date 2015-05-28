import java.util.Random;

/**
 * Representa a un portero del equipo.
 * 
 * @author Julia Zuara
 * @version (a version number or a date)
 */
public class Portero extends Jugador
{
    // Mide la agilidad del portero
    private int agilidad;
    // Mide la fortalieza mental del portero
    private int fortalezaMental;

    /**
     * Crea un jugador portero
     * @param dorsal Numero de dorsal
     */
    public Portero(int dorsal)
    {
        // initialise instance variables
        super(dorsal);
        Random rand = new Random();
        agilidad = rand.nextInt(11);
        fortalezaMental = rand.nextInt(11);
        // El portero siempre es titular
        titular();
    }

    /**
     * Devuelve la agilidad del portero
     * @return La agilidad del portero
     */
    public int getAgilidad()
    {
        return agilidad;
    }

    /**
     * Devuelve la fortaleza mental del portero
     * @return La fortaleza mental del portero
     */
    public int getFortalezaMental()
    {
        return fortalezaMental;
    }

    /**
     * Calcula y devuelve la valoracion del portero
     * @return La valoracion del portero
     */
    public int valoracion()
    {
        return ((getAgilidad() + getFortalezaMental())/2);
    }

    /**
     * Devuelve la información del jugador.
     * @return La información del jugador.
     */
    public String toString()
    {
        return (super.toString() + "\t Agilidad: " + getAgilidad() + "\tFortaleza Mental: " + getFortalezaMental());
    }
}
