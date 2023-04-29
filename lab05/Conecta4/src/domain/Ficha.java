package domain;

/**
 * The test class Ficha.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version v1.0
 */
public class Ficha {

    private int posx, posy;
    private Jugador jugador;

    /**
     * Constructor para fichas
     * 
     * @param x
     * @param y
     */
    public Ficha(int x, int y, Jugador jugador) {
        posx = x;
        posy = y;
        this.jugador = jugador;
    }

    /**
     * Retorna la posicion de la ficha
     * 
     * @return
     */
    public int[] getPos() {
        int[] res = { posx, posy };
        return res;
    }

    /**
     * metodo para obtener la fila de la ficha
     * 
     * @return
     */
    public int getFila() {
        return posx;
    }

    /**
     * metodo para obtener la columna de la ficha
     * 
     * @return
     */
    public int getColumna() {
        return posy;
    }

    /**
     * metodo para obtener el jugador de la ficha
     * 
     * @return
     */
    public Jugador getJugador() {
        return jugador;
    }
}
