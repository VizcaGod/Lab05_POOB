package domain;

/**
 * The test class Ficha.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version v1.0
 */
public class Ficha {
    private int posx, posy;

    /**
     * Constructor para fichas
     * 
     * @param x
     * @param y
     */
    public Ficha(int x, int y) {
        posx = x;
        posy = y;
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
}
