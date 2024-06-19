package org.example;

import java.util.List;
import java.util.ArrayList;

public class Game {
    private Map map;
    private Player player;
    private List<Wave> waves;
    private List<Tower> towers;
    private int currentWave;

    public Game(Map map, Player player) {
        this.map = map;
        this.player = player;
        this.waves = new ArrayList<>();
        this.towers = new ArrayList<>();
        this.currentWave = 0;
        startNextWave();
    }

    public void placeTower(Tower tower, int x, int y) {
        if (map.getCell(x, y) == ' ') {
            towers.add(tower);
            map.setCell(x, y, 'T'); // Marcamos la posicion de la torre
            System.out.println("Torre " + tower.getClass().getSimpleName() + " colocada en (" + x + ", " + y + ")");
        } else {
            System.out.println("No se puede colocar la torre en (" + x + ", " + y + ")");
        }
    }

    public void startNextWave() {
        currentWave++;
        waves.add(new Wave(currentWave));
        System.out.println("Oleada " + currentWave + " iniciada");
    }

    public void gameTick() {
        // Mueve enemigos, ataca torres y maneja la lógica del juego.
        List<Enemy> enemies = waves.get(currentWave - 1).getEnemies();

        // TTorre Ataca
        for (Tower tower : towers) {
            for (Enemy enemy : enemies) {
                if (enemy.isAlive()) {
                    tower.attack(enemy);
                }
            }
            tower.tick();
        }

        // Verficca si la oleada ha sido limpiada
        if (waves.get(currentWave - 1).isCleared()) {
            startNextWave();
        }

        // actualiza la puntuacion y vida de la base
        for (Enemy enemy : enemies) {
            if (!enemy.isAlive()) {
                player.addScore(enemy.getReward());
            } else if (enemy.getHealth() > 0 && enemyHasReachedBase(enemy)) {
                player.deductBaseHealth(10);
            }
        }


        displayGameState();
    }

    private boolean enemyHasReachedBase(Enemy enemy) {
        // Verificamos si un enemigo llego a la base
        return false;
    }

    private void displayGameState() {
        System.out.println("Estado del juego:");
        map.display();
        System.out.println("Puntuación: " + player.getScore());
        System.out.println("Vida de la base: " + player.getBaseHealth());
    }

    public static void main(String[] args) {
        char[][] initialGrid = {
                {' ', ' ', 'C', ' ', ' '},
                {' ', 'C', ' ', ' ', ' '},
                {'C', ' ', ' ', 'C', 'B'},
                {' ', ' ', 'C', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '}
        };

        Map map = new Map(initialGrid);
        Player player = new Player();
        Game game = new Game(map, player);

        game.placeTower(new CannonTower(), 3, 4);
        game.startNextWave();

        while (player.getBaseHealth() > 0) {
            game.gameTick();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Juego terminado. Puntuación final: " + player.getScore());
    }
}

