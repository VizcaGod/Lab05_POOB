package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;

/**
 * The test class Tablero.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version v1.0
 */
public class Tablero {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Ficha> fichas;
    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private int turno;
    private int turnoT;

    /**
     * Constructor para la clase tablero
     */
    public Tablero() {
        jugadores = new ArrayList<Jugador>();
        fichas = new ArrayList<Ficha>();
        turno = 0;
        turnoT = 1;
    }

    public void changeColor(Color a, int jugador) throws Conecta4Exception {
        if (turnoT == 1) {
            for (Jugador xd : jugadores) {
                if (a == xd.getColor()) {
                    throw new Conecta4Exception(Conecta4Exception.NO_PUEDE_TENER_MISMOS_COLORES);
                }
            }
            jugadores.get(jugador - 1).changeColor(a);
            Jugador c = jugadores.get(jugador - 1);
            for (Ficha b : fichas) {
                if (b.getJugador().equals(c)) {
                    b.changeColor(a);
                }
            }
        } else {
            throw new Conecta4Exception(Conecta4Exception.NO_PUEDE_CAMBIAR_DE_COLOR);
        }
    }

    /**
     * metodo para agregar un jugador
     * 
     * @param name
     * @param color
     * @param turno
     * @throws Conecta4Exception
     */
    public void addJugador(String name, Color color, int turno) throws Conecta4Exception {
        isThereSame(color);
        Jugador j = new Jugador(name, color, turno);
        jugadores.add(j);
    }

    /**
     * metodo para realizar una jugada
     * 
     * @param x
     * @param y
     * @return
     * @throws Conecta4Exception
     */
    public boolean play(int x, int y) throws Conecta4Exception {
        int[] val = { x, y };
        boolean gano = false;
        Ficha fichab = null;
        boolean xd = false;
        for (Jugador a : jugadores) {
            if (a.getFichas().size() != 0 || turnoT > 1) {
                for (Ficha b : a.getFichas()) {
                    if (Arrays.equals(val, b.getPos())) {

                        throw new Conecta4Exception(Conecta4Exception.NO_PUEDES_EN_MISMA_POSICION); // NO_PUEDES_EN_MISMA_POSICION
                    }
                    if (x == b.getPos()[0] - 1 && y == b.getPos()[1] || x == 6)
                        fichab = b;
                }
            } else {
                if (x == 6)
                    xd = true;

            }
        }
        if (fichab != null || xd) {
            jugadores.get(turno).play(x, y);
        } else {

            throw new Conecta4Exception(Conecta4Exception.NO_SE_PUEDE_COLOCAR_AQUI); // NO_SE_PUEDE_COLOCAR_AQUI
        }
        combinarFichas();

        try {
            gano = winning(fichas, this);
        } catch (Exception e) {

        }
        return gano;
    }

    /**
     * metodo para cambiar turno
     */
    public void changeTurn() {
        if (turno == 1) {
            turno = 0;
        } else {
            turno += 1;
        }
        turnoT += 1;
    }

    public int getTurnoT() {
        return turnoT;
    }

    /**
     * metodo para verificar si alguien ha ganado
     * 
     * @param chips
     * @param board
     * @return
     */
    public static boolean winning(ArrayList<Ficha> chips, Tablero board) {
        for (Ficha chip : chips) {
            int row = chip.getFila();
            int col = chip.getColumna();
            Jugador player = chip.getJugador();

            // Check for horizontal win
            int count = 1;
            for (int i = col + 1; i < board.getColumnas(); i++) {
                Ficha nextChip = board.getFicha(row, i);
                if (nextChip != null && nextChip.getJugador() == player) {
                    count++;
                } else {
                    break;
                }
            }
            if (count > 4) {
                return true;
            }

            // Check for vertical win
            count = 1;
            for (int i = row + 1; i < board.getFilas(); i++) {
                Ficha nextChip = board.getFicha(i, col);
                if (nextChip != null && nextChip.getJugador() == player) {
                    count++;
                } else {
                    break;
                }
            }
            if (count > 4) {
                return true;
            }

            // Check for diagonal win (up-right)
            count = 1;
            for (int i = row + 1, j = col + 1; i < board.getFilas() && j < board.getColumnas(); i++, j++) {
                Ficha nextChip = board.getFicha(i, j);
                if (nextChip != null && nextChip.getJugador() == player) {
                    count++;
                } else {
                    break;
                }
            }
            if (count > 4) {
                return true;
            }

            // Check for diagonal win (up-left)
            count = 1;
            for (int i = row + 1, j = col - 1; i < board.getFilas() && j >= 0; i++, j--) {
                Ficha nextChip = board.getFicha(i, j);
                if (nextChip != null && nextChip.getJugador() == player) {
                    count++;
                } else {
                    break;
                }
            }
            if (count > 4) {
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para obtener el nombre del jugador en turno
     * 
     * @return
     */
    public String getInTurnPlayerName() {
        String res = jugadores.get(turno).getName();
        return res;
    }

    public Color getInTurnColor() {
        Color res = jugadores.get(turno).getColor();
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

    /**
     * metodo para obtener todos los turnos
     * 
     * @return
     */
    public int getTurnosTotales() {
        return turnoT;
    }

    // METODOS PRIVADOS

    /**
     * metodo para verificar si existe un mismo jugador
     * 
     * @param color
     * @throws Conecta4Exception
     */
    private void isThereSame(Color color) throws Conecta4Exception {
        for (Jugador a : jugadores) {
            if (a.getColor() == color) {
                throw new Conecta4Exception(Conecta4Exception.NO_PUEDE_TENER_MISMOS_COLORES);
            }
        }
    }

    /**
     * metodo para combinar fichas
     */
    private void combinarFichas() {
        for (Jugador a : jugadores) {
            fichas.addAll(a.getFichas());
        }
    }

    /**
     * metodo para obtener las filas del tablero
     * 
     * @return
     */
    private int getFilas() {
        return FILAS;
    }

    /**
     * metodo para obtener una ficha en especifico
     * 
     * @param row
     * @param i
     * @return
     */
    private Ficha getFicha(int row, int i) {
        Ficha res = null;
        for (Ficha a : fichas) {
            int[] xd = a.getPos();
            if (((xd[0] == row) && (xd[1] == i))) {
                res = a;
            }
        }
        return res;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    /**
     * metodo para obtener las columnas del tablero
     * 
     * @return
     */
    private int getColumnas() {
        return COLUMNAS;
    }
}
