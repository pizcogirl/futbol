import java.util.Random;

/**
 * Representa a un jugador del equipo.
 * 
 * @author Julia Zuara 
 * @version (a version number or a date)
 */
public abstract class Jugador implements Comparable<Jugador>
{
    // Nombre del jugador
    private String nombre;
    // Edad del jugador
    private int edad;
    // Estado de forma del jugador
    private int forma;
    // Dorsal del jugador
    private int dorsal;
    // Si es titular, true, si es suplente, false
    private boolean titular;
    // Posibles nombres para los jugadores
    public static final String NOMBRES[] = {"Ramon", "Pedro", "Juan", "Mario", "Marcos", "Miguel", "Luis", "Carlos",
       "Jose Ramon", "Federico", "Alberto", "Roberto", "Ruben", "Guillermo", "Hector",
           "Mario", "Felipe", "Manuel", "Tomas", "Agustin", "Jose Manuel", "Juan Jesus",
       "Pepe", "Ricardo", "Fernando", "Antonio", "Jose Alberto", "Jose Luis", "David",
       "Emilio", "Cesar", "German", "Raul", "Pablo"};


    /**
     * Crea un jugador.
     * @param dorsal El dorsal del jugador.
     */
    public Jugador(int dorsal)
    {
       Random rand = new Random();
       edad = rand.nextInt(23) + 18;
       forma = rand.nextInt(11);
       nombre = NOMBRES[rand.nextInt(NOMBRES.length)];
       titular = false;
       this.dorsal = dorsal;
    }
    /**
     * Devuelve el nombre del jugador.
     * @return El nombre del jugador.
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Devuelve la edad del jugador.
     * @return La edad del jugador.
     */
    public int getEdad()
    {
        return edad;
    }
    
    /**
     * Devuelve la forma del jugador.
     * @return La forma del jugador.
     */
    public int getForma()
    {
        return forma;
    }
    
    /**
     * Devuelve el dorsal del jugador.
     * @return El dorsal del jugador.
     */
    public int getDorsal()
    {
        return dorsal;
    }
    
    /**
     * Devuelve si el jugador es o no titular.
     * @returns true si es titular, false sino.
     */
    public boolean isTitular()
    {
        return titular;
    }
    
    /**
     * Cambia el estado del jugador a titular.
     */
    public void titular()
    {
        titular = true;
    }
    
    /**
     * Cambia el estado del jugador a suplente.
     */
    public void suplente()
    {
        titular = false;
    }
    
    /**
     * Calcula la valoracion del jugador.
     */
    public abstract int valoracion();
    
        /**
     * Devuelve la información del jugador.
     * @return La información del jugador.
     */
    public String toString()
    {
        String texto;
        if(nombre.length() > 6)
        {
            texto = ("Dorsal " + getDorsal() + ".\t" + getNombre() + "(" + getEdad() + " anos)" + "\tForma: " + getForma());
        }
        else
        {
            texto = ("Dorsal " + getDorsal() + ".\t" + getNombre() + "(" + getEdad() + " anos)" + "\t\tForma: " + getForma());
        }
        return texto;
    }

    // Metodo para comparar los jugadores en funcion de su valoracion
       public int compareTo(Jugador d){
      int diferencia = this.valoracion() - d.valoracion();        
      return diferencia;
   }
}
