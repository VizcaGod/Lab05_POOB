package presentation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

import static jdk.internal.net.http.common.Utils.close;

public class Conecta4GUI extends javax.swing.JFrame {
    private JMenuBar menuB;
    private JMenu opciones;

    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem salvar;
    private JMenuItem salir;

    private JFileChooser choose;
    private JFileChooser chooseSave;

    public Conecta4GUI() {
        setTitle("Conecta 4");
        prepareElements();
        prepareElementsMenu();
        prepareActions();
        prepareElementsBoard();

    }
    public void prepareElements(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);
        setLocationRelativeTo(null);

    }

    public void prepareActions(){
        closeAction();
        prepareActionsMenu();
    }

    private void prepareElementsMenu() {
        menuB = new JMenuBar();
        opciones = new JMenu("Opciones");

        nuevo = new JMenuItem("Nuevo");
        abrir = new JMenuItem("Abrir");
        salvar = new JMenuItem("Salvar");
        salir = new JMenuItem("Salir");

        opciones.add(nuevo);
        opciones.add(abrir);
        opciones.add(salvar);
        opciones.add(salir);
        menuB.add(opciones);

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

    }


    private void prepareElementsBoard(){
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(6,7));
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                JButton button = new JButton();
                button.setBackground(Color.WHITE);
                board.add(button);
            }
        }
        add(board);
    }

    private void confirmClose() {
        int valor = JOptionPane.showConfirmDialog(this, "Desea cerrar la apliacion?", "Advertencia",
                JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void closeAction(){
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

    private void openAction() {
        choose = new JFileChooser();
        choose.setVisible(true);
        int action = choose.showOpenDialog(abrir);
        if (action == JFileChooser.APPROVE_OPTION) {
            File files = choose.getSelectedFile();
            JOptionPane.showMessageDialog(abrir,
                    "El archivo de nombre " + files.getName() + " que trata de abrir en la ruta " + files
                            + "\n NO se pudo abrir ya que esta la funcion se encuentra en construccion.",
                    "Advertencia", JOptionPane.YES_NO_OPTION);
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

    private void refresh(){
        this.repaint();
    }


    public static void main(String[] args) {
        Conecta4GUI conecta4GUI = new Conecta4GUI();
        conecta4GUI.setVisible(true);
    }
}