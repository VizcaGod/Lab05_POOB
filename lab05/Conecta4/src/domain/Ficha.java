package domain;

public class Ficha {
    private int posx, posy;

    public Ficha(int x, int y) {
        posx = x;
        posy = y;
    }

    public int[] getPos() {
        int[] res = { posx, posy };
        return res;
    }
}
