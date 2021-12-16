/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author luisb
 */
public class VentanaInicio extends JFrame {
   
    private JPanel panelTexto;
    
    public VentanaInicio() {
        super("Programa N-Reinas");
        
        initComponents();
    }
    
    private void initComponents() {
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.panelTexto = new JPanel();
    }
}
