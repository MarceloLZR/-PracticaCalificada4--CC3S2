package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wave {
    private List<Enemy> enemies;
    private int waveNumber;

    public Wave(int waveNumber) {
        this.waveNumber = waveNumber;
        this.enemies = generateEnemies(waveNumber);
    }

    public List<Enemy> generateEnemies(int waveNumber) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < waveNumber * 5; i++) {
            enemies.add(new BasicEnemy());
        }
        if (waveNumber % 5 == 0) {
            enemies.add(new BossEnemy());
        }
        return enemies;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public boolean isCleared() {
        return enemies.stream().noneMatch(Enemy::isAlive);
    }
}
