package domain;

import java.awt.Color;
import java.util.ArrayList;

/**
 * The test class Conecta4.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version v1.0
 */
public class Conecta4 {
    private Tablero tablero;

    /**
     * Constructor para la clase Conecta4
     */
    public Conecta4() {
        tablero = new Tablero();
    }

    /**
     * agrega a un jugador a conecta4
     *
     * @param name  the name
     * @param color the color
     * @param turno the turno
     * @throws Conecta4Exception the conecta 4 exception
     */
    public void addJugador(String name, Color color, int turno) throws Conecta4Exception {
        tablero.addJugador(name, color, turno);
    }

    /**
     * realiza una jugada
     *
     * @param x the x
     * @param y the y
     * @throws Conecta4Exception the conecta 4 exception
     */
    public void play(int x, int y) throws Conecta4Exception {
        boolean ganador = tablero.play(x, y);
        if (ganador) {
            throw new Conecta4Exception(Conecta4Exception.GANADOR + tablero.getInTurnPlayerName());
        }
    }

    /**
     * Change turn.
     */
    public void changeTurn() {
        tablero.changeTurn();
    }

    /**
     * cambia el color de un jugador en especifico
     *
     * @param a       the a
     * @param jugador the jugador
     * @throws Conecta4Exception the conecta 4 exception
     */
    public void changeColor(Color a, int jugador) throws Conecta4Exception {
        tablero.changeColor(a, jugador);
    }

    /**
     * Gets in turn color.
     *
     * @return the in turn color
     */
    public Color getInTurnColor() {
        return tablero.getInTurnColor();
    }

    /**
     * retorna las fichas del tablero
     *
     * @return fichas fichas
     */
    public ArrayList<Ficha> getFichas() {
        return tablero.getFichas();
    }

    /**
     * retorna el nombre del jugador en turno
     *
     * @return name player in turn
     */
    public String getNamePlayerInTurn() {
        return tablero.getInTurnPlayerName();
    }

    /**
     * retorna el turno
     *
     * @return turn turn
     */
    public int getTurn() {
        return tablero.getTurno();
    }

    /**
     * Gets all turns.
     *
     * @return the all turns
     */
    public int getAllTurns() {
        return tablero.getTurnoT();
    }
}
