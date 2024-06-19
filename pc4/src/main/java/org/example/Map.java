package org.example;

public class Map {
    private static final char EMPTY_CELL = ' ';
    private static final char PATH_CELL = 'C';
    private static final char BASE_CELL = 'B';

    private char[][] grid;

    public Map(char[][] initialGrid) {
        this.grid = initialGrid;
    }

    public char getCell(int x, int y) {
        return grid[x][y];
    }

    public void setCell(int x, int y, char value) {
        grid[x][y] = value;
    }

    public int getWidth() {
        return grid.length;
    }

    public int getHeight() {
        return grid[0].length;
    }

    public void display() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValidPosition(int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false; // Fuera de los límites del mapa
        }
        return grid[x][y] == EMPTY_CELL; // La posición está vacía y disponible para una torre
    }

    public boolean isPath(int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false; // Fuera de los límites del mapa
        }
        return grid[x][y] == PATH_CELL; // La posición es un camino por donde pueden moverse los enemigos
    }

    public boolean isBase(int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false; // Fuera de los límites del mapa
        }
        return grid[x][y] == BASE_CELL; // La posición es la base a la que deben llegar los enemigos
    }
}
