/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nreinas;

import Ventanas.VentanaTablero;
import java.util.Scanner;

/**
 *
 * @author luisb
 */
public class NReinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Introduce la dimensión del tablero: ");
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        
        Tablero tablero = new Tablero(n);
        VentanaTablero ventanaTablero = new VentanaTablero(tablero, n);
        
        ventanaTablero.setVisible(true);
    }
    
}
