package domain;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Jugador> jugadores;
    private int turno;

    public Tablero() {
        jugadores = new ArrayList<Jugador>();
        turno = 0;
    }

    public boolean play(int x, int y) {
        int[] val = { x, y };
        boolean gano = false;
        Ficha fichab = null;
        for (Jugador a : jugadores) {
            for (Ficha b : a.getFichas()) {
                if (val.equals(b.getPos()))
                    ; // NO_PUEDES_EN_MISMA_POSICION
                if (x == b.getPos()[0] && y == b.getPos()[1] - 1)
                    fichab = b;
            }
        }
        if (fichab != null) {
            jugadores.get(turno).play(x, y);
            ;

        } else {
            // NO_SE_PUEDE_COLOCAR_AQUI
        }
        return gano;
    }

    // METODOS PRIVADOS

}
