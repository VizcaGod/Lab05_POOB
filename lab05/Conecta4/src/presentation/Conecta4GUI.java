package presentation;

import java.awt.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

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

    }
    public void prepareElements(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);
        setLocationRelativeTo(null);

    }

    public void prepareActions(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                confirmateClose();
            }
        });

        abrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                openAction();
            }
        });

        salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                saveAction();
            }
        });
    }

    private void confirmateClose() {
        int valor = JOptionPane.showConfirmDialog(this, "�Desea cerrar la apliacion?", "Advertencia",
                JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            System.exit(0);
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

    private void saveAction() {
        chooseSave = new JFileChooser(new File("c:\\"));
        chooseSave.setDialogTitle("Save a File");
        chooseSave.showSaveDialog(null);
    }

    public static void main(String[] args) {
        Conecta4GUI conecta4GUI = new Conecta4GUI();
        conecta4GUI.setVisible(true);
    }
}