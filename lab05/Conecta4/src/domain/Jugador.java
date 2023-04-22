package domain;

import java.util.ArrayList;
import java.awt.Color;

/**
 * The test class Jugador.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version v1.0
 */
public class Jugador {
    private ArrayList<Ficha> fichas;
    private String name;
    private Color color;
    private int turno;

    public Jugador(String name, Color color, int turno) {
        this.name = name;
        this.color = color;
        this.turno = turno;
    }

    public void play(int x, int y) {
        Ficha ficha = new Ficha(x, y);
        fichas.add(ficha);
    }

    public boolean gano(Ficha ficha) {
        boolean res = false;
        int cont = 0;
        int[] guarda = ficha.getPos();
        boolean lookn = false;
        boolean lookph = false;
        boolean looknp = false;
        for (Ficha a : fichas) {

        }
        return res;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getTurno() {
        return turno;
    }

    public int getScore() {
        return fichas.size();
    }

    // METODOS PRIVADOS

    private boolean isThereNext(int[] guarda) {
        boolean res = false;
        for (Ficha a : fichas) {
            if (a.getPos().equals(guarda)) {
                res = true;
            }
        }
        return res;
    }

    private int[] addOne(int[] guarda) {
        int[] res = { guarda[0] + 1, guarda[1] + 1 };
        return res;
    }

    private int[] resOne(int[] guarda) {
        int[] res = { guarda[0] - 1, guarda[1] - 1 };
        return res;
    }
}
