package nreinas;

/**
 *
 * @author luisb
 */
public class Tablero {
    
    private int[][] tablero;
    private int tamaño;
    
    public Tablero(int tamaño) {
        this.tablero = new int[tamaño][tamaño];
        this.tamaño = tamaño;
        
        initTablero();
        solucion(tablero, tamaño, 0);
    }
    
    public Tablero(int tamaño, int x, int y) {
        this.tablero = new int[tamaño][tamaño];
        this.tamaño = tamaño;
        
        initTablero();
        // Introducimos la primera reina en la posición pasada por paráemetro
        tablero[x][y] = 1;
        solucion(tablero, tamaño, 1);
    }
    
    private void initTablero() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                this.tablero[i][j] = 0;                
            }     
        }
    }
    
    private boolean solucion(int[][] tablero, int n, int reinas) {
        if (reinas == n) {
            return true;
        }
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (esPosible(tablero, i, j)) {
                    tablero[i][j] = 1;
                    
                    if (solucion(tablero, n, reinas + 1)) {
                        return true;
                    }
                    
                    tablero[i][j] = 0;
                }
            }
        }
            
        return false;
    }
    
    public boolean esPosible(int[][] tablero, int fila, int columna) {
        // Observamos las columnas
        for (int i = 0; i < this.tamaño; i++) {          
            if (tablero[i][columna] == 1) {
                return false;
            }
        }
        
        // Observamos las filas
        for (int i = 0; i < this.tamaño; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }
        
        // Observamos la diagonal sube
        for (int i = -fila; i < -fila + this.tamaño; i++) {
            if (fila + i >= 0 && fila + i < this.tamaño && columna - i >= 0 && columna - i < this.tamaño) {
                if (tablero[fila + i][columna - i] == 1) {
                    return false;
                }
            }
        }
        
        // Observamos la diagonal que baja
        for (int i = -fila; i < -fila + this.tamaño; i++) {
            if (fila + i >= 0 && fila + i < this.tamaño && columna + i >= 0 && columna + i < this.tamaño) {
                if (tablero[fila + i][columna + i] == 1) {
                    return false;
                }
            }
        }
         
        return true;
    }
    
    public int getValor(int x, int y) {
        return tablero[x][y];
    }
    
    @Override
    public String toString() {
        String s = "";
        
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                s += tablero[i][j] + "  ";
            }
            s += "\n";
        }
        
        return s;
    }
}
