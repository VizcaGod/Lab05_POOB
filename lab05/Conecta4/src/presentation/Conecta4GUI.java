package presentation;

import javax.swing.*;

import domain.Conecta4;
import domain.Conecta4Exception;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Conecta4GUI extends javax.swing.JFrame {

    private Conecta4 juego;

    private Color background;

    // ATRIBUTOS GRAFICOS
    private JMenuBar menuB;
    private JMenu opciones;
    private JMenu edit;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem salvar;
    private JMenuItem salir;
    private JMenuItem cambiarColorTablero;
    private JMenuItem cambiarColorFichas1;
    private JMenuItem cambiarColorFichas2;
    private JPanel board;

    private JFileChooser choose;
    private JFileChooser chooseSave;
    // private JMenuItem cambiarColor;

    public Conecta4GUI() {
        setTitle("Conecta 4");
        prepareElements();
        prepareElementsMenu();
        prepareActions();
        prepareElementsBoard();

    }

    public void prepareElements() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width / 2, screenSize.height / 2);
        setLocationRelativeTo(null);
        juego = new Conecta4();
        background = Color.WHITE;
        try {
            juego.addJugador("J1", Color.BLUE, 0);
            juego.addJugador("J2", Color.RED, 1);
        } catch (Conecta4Exception e) {

        }

    }

    public void prepareActions() {
        closeAction();
        prepareActionsMenu();
    }

    private void prepareElementsMenu() {
        menuB = new JMenuBar();
        edit = new JMenu("Editar");
        opciones = new JMenu("Opciones");

        nuevo = new JMenuItem("Nuevo");
        abrir = new JMenuItem("Abrir");
        salvar = new JMenuItem("Salvar");
        salir = new JMenuItem("Salir");

        // cambiarColor = new JMenuItem("Cambiar Color");
        cambiarColorTablero = new JMenuItem("Color del Tablero");
        cambiarColorFichas1 = new JMenuItem("Color de las fichas del jugador 1");
        cambiarColorFichas2 = new JMenuItem("Color de las fichas del jugador 2");

        opciones.add(nuevo);
        opciones.add(abrir);
        opciones.add(salvar);
        opciones.add(salir);
        menuB.add(opciones);

        edit.add(cambiarColorFichas1);
        edit.add(cambiarColorFichas2);
        edit.add(cambiarColorTablero);

        menuB.add(edit);

        setJMenuBar(menuB);
    }

    private void prepareActionsMenu() {
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                confirmClose();
            }
        });

        abrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                openActiont();
            }
        });

        salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                saveAction();
            }
        });

        nuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                newAction();
            }
        });

        cambiarColorFichas1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                changeColorActionJ1();
            }
        });

        cambiarColorFichas2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                changeColorActionJ2();
            }
        });

        cambiarColorTablero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                changeColorAction();
            }
        });

    }

    private void newAction() {
        int valor = JOptionPane.showConfirmDialog(this, "Desea crear un nuevo juego?", "Advertencia",
                JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            board.removeAll();
            prepareElementsBoard();
        }
    }

    private void prepareElementsBoard() {
        board = new JPanel();
        board.setLayout(new GridLayout(7, 8));
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 7; j++) {
                JButton button = new JButton();
                int x = i;
                int y = j;
                button.setBackground(checkIfContainsChip(i, j));
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        try {
                            jugar(x, y);
                            button.setBackground(getInTurnColor());
                            changeTurn();
                            button.repaint();
                            revalida();
                        } catch (Conecta4Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                });
                board.add(button);
            }
        }
        add(board);
    }

    public void jugar(int x, int y) throws Conecta4Exception {
        juego.play(x, y);
    }

    public void changeTurn() {
        juego.changeTurn();
    }

    public Color getInTurnColor() {
        return juego.getInTurnColor();
    }

    public void revalida() {
        revalidate();
        refresh();
    }

    private Color checkIfContainsChip(int x, int y) {
        Color res = background;
        for (int i = 0; i < juego.getFichas().size(); i++) {
            if (juego.getFichas().get(i).getFila() == x && juego.getFichas().get(i).getColumna() == y) {
                res = juego.getFichas().get(i).getColor();
            }
        }
        return res;
    }

    private void confirmClose() {
        int valor = JOptionPane.showConfirmDialog(this, "Desea cerrar la apliacion?", "Advertencia",
                JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void closeAction() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmClose();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openActiont() {
        choose = new JFileChooser();
        int valor = choose.showOpenDialog(this);
        if (valor == JFileChooser.APPROVE_OPTION) {
            File file = choose.getSelectedFile();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();
                while (linea != null) {
                    System.out.println(linea);
                    linea = br.readLine();
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveAction() {
        chooseSave = new JFileChooser(new File("c:\\"));
        chooseSave.setDialogTitle("Save a File");
        chooseSave.showSaveDialog(null);
    }

    private void refresh() {
        this.repaint();
    }

    private void changeColorAction() {
        Color color = JColorChooser.showDialog(this, "Seleccione un color", Color.BLACK);
        background = color;
        if (juego.getAllTurns() > 1) {
            JOptionPane.showMessageDialog(null, "No es posible cambiar de color, solo puedes antes del primer turno");
        } else {
            Component[] components = board.getComponents();
            for (Component component : components) {
                if (component instanceof JButton) {
                    JButton button = (JButton) component;
                    button.setBackground(background);
                    refresh();
                }

            }
        }
    }

    private void changeColorActionJ1() {
        Color color = JColorChooser.showDialog(this, "Seleccione un color", Color.BLACK);
        try {
            juego.changeColor(color, 1);
        } catch (Conecta4Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        Component[] components = board.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                remove(component);
            }
        }
        revalidate();
        refresh();
    }

    private void changeColorActionJ2() {
        Color color = JColorChooser.showDialog(this, "Seleccione un color", Color.BLACK);
        try {
            juego.changeColor(color, 2);

        } catch (Conecta4Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        for (Component component : board.getComponents()) {
            if (component instanceof JButton) {
                remove(component);
            }

        }
        revalidate();
        refresh();
    }

    public static void main(String[] args) {
        Conecta4GUI conecta4GUI = new Conecta4GUI();
        conecta4GUI.setVisible(true);
    }
}