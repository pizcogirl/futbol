import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * Write a description of class Alineacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alineacion
{
    // Guarda el equipo sobre el que se hace la alineacion
    private Equipo equipo;
    // Titulares en esta alineacion
    private ArrayList<Jugador> titulares;
    // Suplentes en esta alineacion
    private ArrayList<Jugador> suplentes;
    // Numero de jugadores titulares
    public static final int NUM_TITULARES = 11;

    /**
     * Crea un objeto alinieacion del equipo dado.
     * @param equipo El equipo del que se va a hacer la alineacion.
     */
    public Alineacion(Equipo equipo)
    {
        // initialise instance variables
        this.titulares = new ArrayList<Jugador>();
        this.suplentes = new ArrayList<Jugador>();
        this.equipo = equipo;
        // Genera unos titulares
        Random rand = new Random();
        if(rand.nextBoolean())
        {
            asignarTitularesAleatorio();
        }
        else
        {
            asignarTitularesValoracion();
        }
        // Los añade a las listas de titulares y suplentes
        aniadirListas();
        // Desmarca los titulares
        quitarTitulares();
    }

    /**
     * Muestra por pantalla la información de la alineacion.
     */
    public void mostrarAlineacion()
    {
        // Muestra la información de la alineacion
        String mostrar = "\n" + equipo.getNombre();
        mostrar += "\nTitulares:";
        // Muestra los titulares
        for(int i = 0; i < titulares.size(); i++)
        {
            mostrar += "\n" + (titulares.get(i).toString());
        }
        mostrar += "\nMedia de valoración del equipo titular: " + String.format("%.2f", valoracionMedia());
        mostrar += "\nReservas:";
        // Muestra los reservas
        for(int i = 0; i < suplentes.size(); i++)
        {
            mostrar += "\n" + (suplentes.get(i).toString());
        }
        System.out.println(mostrar);
    }

    /**
     * Asigna los titulares del equipo de forma aleatoria.
     */
    private void asignarTitularesAleatorio()
    {
        // Restan 9 puestos de titulares, desordena los que quedan y va asignando 
        // la posicion de titular de forma aleatoria
        int indice = 0;
        // Crea un array temporal para sacar los titulares
        ArrayList<Jugador> temporal = new ArrayList<Jugador>(equipo.getPlantilla());
        // Elimina al portero y al capitan de la copia del arraylist
        temporal.remove(equipo.getPortero());
        temporal.remove(equipo.getCapitan());
        // Desordeno los jugadores que quedan
        Collections.shuffle(temporal);
        Iterator<Jugador> it = temporal.iterator();
        // itera hasta cojer 9 más
        int num = (NUM_TITULARES - 2);
        while(indice < num && it.hasNext())
        {  
            // Coge el jugador, lo pone como titular, lo elimina
            Jugador jugador = it.next();
            jugador.titular();
            it.remove();
            indice++;
        } 
    }

    /**
     * Asigna los titulares del equipo en funcion de su valoración.
     */
    private void asignarTitularesValoracion()
    {
        // Restan 9 puestos de titulares,genera una copia del resto de titulares
        // y los ordena en funcion de su valoracion
        int indice = 0;
        // Crea un array temporal para sacar los titulares
        ArrayList<Jugador> temporal = new ArrayList<Jugador>(equipo.getPlantilla());
        // Elimina al portero y al capitan de la copia del arraylist
        temporal.remove(equipo.getPortero());
        temporal.remove(equipo.getCapitan());
        // Desordeno los jugadores que quedan
        Collections.sort(temporal);
        Iterator<Jugador> it = temporal.iterator();
        // itera hasta cojer 9 más
        int num = (NUM_TITULARES - 2);
        while(indice < num && it.hasNext())
        {  
            // Coge el jugador, lo pone como titular, lo elimina
            Jugador jugador = it.next();
            jugador.titular();
            it.remove();
            indice++;
        } 
    }

    /**
     * Recorre la plantilla y los coloca en la lista necesaria.
     */
    private void aniadirListas()
    {
        // Recorre los jugadores y va añadiendo a cada lado
        ArrayList<Jugador> temporal = new ArrayList<Jugador>(equipo.getPlantilla());
        // Elimina al portero y al capitan de la copia del arraylist y los coloca como primeros
        titulares.add(equipo.getPortero());
        titulares.add(equipo.getCapitan());
        temporal.remove(equipo.getPortero());
        temporal.remove(equipo.getCapitan());
        // Recorre la lista y los añade a la lista que corresponda
        for(int i = 0; i < temporal.size(); i++)
        {
            Jugador jugador = temporal.get(i);
            if(jugador.isTitular())
            {
                titulares.add(jugador);
            }
            else
            {
                suplentes.add(jugador);
            }
        }
    }

    /**
     * Calcula la valoración del equipo titular.
     * @return La valoración del equipo.
     */
    private float valoracionMedia()
    {
        float valoracion = 0;
        for(int i = 0; i < titulares.size(); i++)
        {
            valoracion += titulares.get(i).valoracion();
        }
        return (valoracion/titulares.size());
    }

    /**
     * Cancela las titularidades de los jugadores.
     */
    private void quitarTitulares()
    {
        Jugador jugador;
        for(int i = 0; i < titulares.size(); i++)
        {
            jugador = titulares.get(i);
            if(!(jugador instanceof Capitan || jugador instanceof Portero))
            {
                jugador.suplente();
            }
        }
    }
}
