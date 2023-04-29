package domain;

import java.util.ArrayList;
import java.awt.Color;

/**
 * The class Jugador.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version v1.0
 */
public class Jugador {
    private ArrayList<Ficha> fichas;
    private String name;
    private Color color;
    private int turno;

    /**
     * metodo constructor para la clase Jugador
     * 
     * @param name
     * @param color
     * @param turno
     */
    public Jugador(String name, Color color, int turno) {
        fichas = new ArrayList<Ficha>();
        this.name = name;
        this.color = color;
        this.turno = turno;
    }

    /**
     * metodo para poder jugar
     * 
     * @param x
     * @param y
     */
    public void play(int x, int y) {
        Ficha ficha = new Ficha(x, y, this);
        fichas.add(ficha);
    }

    /**
     * metodo para obtener las fichas del jugador
     * 
     * @return
     */
    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    /**
     * metodo para obtener el nombre del jugador
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * metodo para obtener el color del jugador
     * 
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * metodo para obtener el turno del jugador
     * 
     * @return
     */
    public int getTurno() {
        return turno;
    }

    /**
     * metodo para obtener el puntaje del jugador
     * 
     * @return
     */
    public int getScore() {
        return fichas.size();
    }

    // METODOS PRIVADOS

}
