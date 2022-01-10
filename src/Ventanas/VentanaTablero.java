package Ventanas;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import nreinas.Tablero;

/**
 *
 * @author luisb
 */
public class VentanaTablero extends JFrame {

    private final int tamaño;
    private final Tablero tablero;
    private final boolean solucionar;

    private JButton[][] casillas;
    private ImageIcon imagen;
    private static final int CASILLA = 80;

    /**
     * Método constructor de la clase
     * 
     * @param n 
     */
    public VentanaTablero(int n) {
        super("Juego de las N-Reinas");

        this.tamaño = n;
        this.tablero = new Tablero(tamaño);
        this.solucionar = false;

        initComponents();
    }

    /**
     * Método constructor de la clase
     * 
     * @param tablero
     * @param n 
     */
    public VentanaTablero(Tablero tablero, int n) {
        super("Juego de las N-Reinas");

        this.tamaño = n;
        this.tablero = tablero;
        this.solucionar = true;

        initComponents();
    }

    /**
     * Método que establece los componentes necesarios de la ventana
     * 
     */
    private void initComponents() {
        this.setSize(tamaño * CASILLA + 16, tamaño * CASILLA + 39);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(tamaño, tamaño));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Creamos una matriz de botones
        casillas = new JButton[tamaño][tamaño];
        initTablero();

        // Listener de la matriz de botones para registrar que botón se ha pulsado
        // y realizar las correspondientes acciones
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                casillas[i][j].addActionListener((ActionEvent ae) -> {
                    JButton boton = (JButton) ae.getSource();
                    int x = boton.getX() / 78;
                    int y = boton.getY() / 75;

                    solucionTablero(x, y);
                });
            }
        }
    }

    /**
     * Método que construye el tablero y visualiza las reinas
     * 
     */
    private void initTablero() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                casillas[i][j] = new JButton();

                // Si solucionar == true, directamente coloca las reinas
                if (solucionar && tablero.getValor(i, j) == 1) {
                    imagen = new ImageIcon("imagenes/reina.png");
                    casillas[i][j].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(CASILLA - 20, CASILLA - 20, Image.SCALE_DEFAULT)));
                    casillas[i][j].setOpaque(true);
                }
                // Blanco par, negro impar
                else if ((i + j) % 2 == 0) {
                    imagen = new ImageIcon("imagenes/white.jpg");
                    casillas[i][j].setIcon(imagen);

                } else {
                    imagen = new ImageIcon("imagenes/black.jpg");
                    casillas[i][j].setIcon(imagen);
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
        this.setVisible(false);

        VentanaTablero ventanaTablero = new VentanaTablero(new Tablero(tamaño, y, x), tamaño);
        ventanaTablero.setVisible(true);
    }
}
