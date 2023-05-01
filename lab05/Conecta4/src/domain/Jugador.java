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
     * @param name  the name
     * @param color the color
     * @param turno the turno
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
     * @param x the x
     * @param y the y
     */
    public void play(int x, int y) {
        Ficha ficha = new Ficha(x, y, this);
        fichas.add(ficha);
    }

    /**
     * Change color.
     *
     * @param a the a
     */
    public void changeColor(Color a) {
        color = a;
    }

    /**
     * metodo para obtener las fichas del jugador
     *
     * @return fichas fichas
     */
    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    /**
     * metodo para obtener el nombre del jugador
     *
     * @return name name
     */
    public String getName() {
        return name;
    }

    /**
     * metodo para obtener el color del jugador
     *
     * @return color color
     */
    public Color getColor() {
        return color;
    }

    /**
     * metodo para obtener el turno del jugador
     *
     * @return turno turno
     */
    public int getTurno() {
        return turno;
    }

    /**
     * metodo para obtener el puntaje del jugador
     *
     * @return score score
     */
    public int getScore() {
        return fichas.size();
    }

    // METODOS PRIVADOS

}
