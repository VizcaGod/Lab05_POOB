package domain;

import java.util.ArrayList;
import java.awt.Color;

/**
 * The test class Tablero.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version v1.0
 */
public class Tablero {
    private ArrayList<Jugador> jugadores;
    private int turno;

    public Tablero() {
        jugadores = new ArrayList<Jugador>();
        turno = 0;
    }

    public void addJugador(String name, Color color, int turno) throws Conecta4Exception {
        isThereSame(color);
        Jugador j = new Jugador(name, color, turno);
        jugadores.add(j);
    }

    public boolean play(int x, int y) throws Conecta4Exception {
        int[] val = { x, y };
        boolean gano = false;
        Ficha fichab = null;
        for (Jugador a : jugadores) {
            for (Ficha b : a.getFichas()) {
                if (val.equals(b.getPos()))
                    throw new Conecta4Exception(Conecta4Exception.NO_PUEDES_EN_MISMA_POSICION); // NO_PUEDES_EN_MISMA_POSICION
                if (x == b.getPos()[0] && y == b.getPos()[1] - 1 || y == 7)
                    fichab = b;
            }
        }
        if (fichab != null) {
            jugadores.get(turno).play(x, y);
            ;

        } else {
            // NO_SE_PUEDE_COLOCAR_AQUI
        }

        changeTurn();
        return gano;
    }

    public void changeTurn() {
        if (turno == 1) {
            turno = 0;
        }
        turno += 1;
    }

    public String getInTurnPlayerName() {
        String res = "falla";
        if (turno == 0) {
            res = jugadores.get(0).getName();
        }
        if (turno == 1) {
            res = jugadores.get(1).getName();
        }
        return res;
    }

    /**
     * retorna el turno actual
     * 
     * @return
     */
    public int getTurno() {
        return turno;
    }

    // METODOS PRIVADOS
    private void isThereSame(Color color) throws Conecta4Exception {
        for (Jugador a : jugadores) {
            if (a.getColor() == color) {
                throw new Conecta4Exception(Conecta4Exception.NO_PUEDE_TENER_MISMOS_COLORES);
            }
        }
    }
}
