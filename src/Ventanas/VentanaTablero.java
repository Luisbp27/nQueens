/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import nreinas.Tablero;

/**
 *
 * @author luisb
 */
public class VentanaTablero extends JFrame {

    private int tamaño;
    private Tablero tablero;
    private static final String RUTA_REINA = "Imagenes/queen.png";

    private JButton[][] casillas;
    private ImageIcon imagen;
    private static final int TAMAÑO_CASILLA = 80;

    public VentanaTablero(int n) {
        super("Juego de las N-Reinas");

        this.tamaño = n;
        this.tablero = new Tablero(tamaño);

        initComponents();
    }

    public VentanaTablero(Tablero tablero, int n) {
        super("Juego de las N-Reinas");

        this.tamaño = n;
        this.tablero = new Tablero(tamaño);

        initComponents();
    }

    private void initComponents() {
        this.setSize(tamaño * TAMAÑO_CASILLA, tamaño * TAMAÑO_CASILLA);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(tamaño, tamaño));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        casillas = new JButton[tamaño][tamaño];
        initTablero(casillas);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("pos x: " + e.getX());
                System.out.println("pos y: " + e.getY());
                solucionTablero(e.getX(), e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("pos x: " + e.getX());
                System.out.println("pos y: " + e.getY());
                solucionTablero(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    private void initTablero(JButton[][] casillas) {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                casillas[i][j] = new JButton();

                // Blanco par, negro impar
                if ((i + j) % 2 == 0) {
                    if (tablero.getValor(i, j) == 0) {
                        casillas[i][j].setBackground(Color.white);
                        imagen = new ImageIcon("imagenes/white.jpg");
                        casillas[i][j].setIcon(imagen);
                    } else {
                        setReina(i, j);
                    }

                } else {
                    if (tablero.getValor(i, j) == 0) {
                        casillas[i][j].setBackground(Color.black);
                        imagen = new ImageIcon("imagenes/black.jpg");
                        casillas[i][j].setIcon(imagen);
                    } else {
                        setReina(i, j);
                    }

                }
            }
        }

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                this.add(casillas[i][j]);

            }

        }
    }

    /**
     * Método que crea un tablero y una solución a partir de la casilla pasada
     * por parámetro
     *
     * @param x
     * @param y
     */
    private void solucionTablero(int x, int y) {
        Tablero tableroAux = new Tablero(tamaño, x, y);
        tablero = tableroAux;
    }

    private void setReina(int x, int y) {
        imagen = new ImageIcon(RUTA_REINA);
        casillas[x][y].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(TAMAÑO_CASILLA - 20, TAMAÑO_CASILLA - 20, Image.SCALE_DEFAULT)));
        casillas[x][y].setOpaque(true);
    }
}
