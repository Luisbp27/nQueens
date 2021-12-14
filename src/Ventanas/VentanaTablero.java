/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.GridLayout;
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
    private static final String RUTA_IMAGEN = "Imagenes/queen.png";
    
    private JButton[][] casillas;
    private ImageIcon imagen;
    private static final int TAMAÑO_CASILLA = 80;
    
    public VentanaTablero(int n) {
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
        
        this.imagen = new ImageIcon(RUTA_IMAGEN);
    }
}
