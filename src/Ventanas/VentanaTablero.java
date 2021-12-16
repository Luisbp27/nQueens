package Ventanas;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
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
    private static final String RUTA_REINA = "imagenes/reina.png";

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
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                double x = me.getX();
                double y = me.getY();
                
                System.out.println("x: " + x);
                System.out.println("y: " + y);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
    }

    private void initTablero(JButton[][] casillas) {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                casillas[i][j] = new JButton();

                // Blanco par, negro impar
                if ((i + j) % 2 == 0) {
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
        Tablero tableroAux = new Tablero(tamaño, x, y);
        tablero = tableroAux;
    }

    /**
     * Método que coloca una reina en la interfaz gráfica del tablero
     * 
     * @param x
     * @param y 
     */
    private void setReina(int x, int y) {
        imagen = new ImageIcon("imagenes/reina.png");
        casillas[x][y].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(TAMAÑO_CASILLA - 20, TAMAÑO_CASILLA - 20, Image.SCALE_DEFAULT)));
        casillas[x][y].setOpaque(true);
    }
}
