package nreinas;

/**
 *
 * @author luisb
 */
public class Tablero {
    
    private final int[][] tablero;
    private final int tamaño;
    
    /**
     * Método constructor de la clase
     * 
     * @param tamaño 
     */
    public Tablero(int tamaño) {
        this.tablero = new int[tamaño][tamaño];
        this.tamaño = tamaño;
        
        initTablero();
        solucion(tablero, tamaño, 0);
    }
    
    /**
     * Método constructor de la clase que crea una solución a partir de una
     * posición pasada por parámetro
     * 
     * @param tamaño
     * @param x
     * @param y 
     */
    public Tablero(int tamaño, int x, int y) {
        this.tablero = new int[tamaño][tamaño];
        this.tamaño = tamaño;
        
        initTablero();
        // Introducimos la primera reina en la posición pasada por paráemetro
        tablero[x][y] = 1;
        solucion(tablero, tamaño, 1);
    }
    
    /**
     * Método que inicializa el tablero
     * 
     */
    private void initTablero() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                this.tablero[i][j] = 0;                
            }     
        }
    }
    
    /**
     * Método recursivo que encuentra la solución implementando backtracking con
     * poda
     * 
     * @param tablero
     * @param n
     * @param reinas
     * @return 
     */
    private boolean solucion(int[][] tablero, int n, int reinas) {
        // Si tenemos todas las reinas colocadas
        if (reinas == n) {
            return true;
        }
        
        // Para toda la matriz, buscamos las combinaciones posibles
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                // Si es posible colocar la reina, lo hace
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
    
    /**
     * Método que comprueba si las reinas pueden matarse entre ellas. Este método
     * es el que realmente realiza la poda
     * 
     * @param tablero
     * @param fila
     * @param columna
     * @return 
     */
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
    
    /**
     * Método que devuelve el contenido del atributo tablero
     * 
     * @param x
     * @param y
     * @return 
     */
    public int getValor(int x, int y) {
        return tablero[x][y];
    }
    
    /**
     * Método que devuelve el contenido del atributo tablero
     * @return 
     */
    public int[][] getTablero() {
        return tablero;
    }
    
    /**
     * Método que devuelve el String del Tablero
     * 
     * @return 
     */
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
