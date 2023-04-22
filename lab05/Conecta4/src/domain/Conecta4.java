package domain;

import java.awt.Color;

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

    public void addJugador(String name, Color color, int turno) throws Conecta4Exception {
        tablero.addJugador(name, color, turno);
    }

    public void play(int x, int y) throws Conecta4Exception {
        boolean ganador = tablero.play(x, y);
        if (ganador && tablero.getTurno() == 0) {
            throw new Conecta4Exception(Conecta4Exception.GANADOR);
        }
    }
}
