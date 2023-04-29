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
     * @param name
     * @param color
     * @param turno
     * @throws Conecta4Exception
     */
    public void addJugador(String name, Color color, int turno) throws Conecta4Exception {
        tablero.addJugador(name, color, turno);
    }

    /**
     * realiza una jugada
     * 
     * @param x
     * @param y
     * @throws Conecta4Exception
     */
    public void play(int x, int y) throws Conecta4Exception {
        boolean ganador = tablero.play(x, y);
        if (ganador) {
            throw new Conecta4Exception(Conecta4Exception.GANADOR + tablero.getInTurnPlayerName());
        }
    }

    /**
     * retorna las fichas del tablero
     * 
     * @return
     */
    public ArrayList<Ficha> getFichas() {
        return tablero.getFichas();
    }

    /**
     * retorna el nombre del jugador en turno
     * 
     * @return
     */
    public String getNamePlayerInTurn() {
        return tablero.getInTurnPlayerName();
    }

    /**
     * retorna el turno
     * 
     * @return
     */
    public int getTurn() {
        return tablero.getTurno();
    }

}
