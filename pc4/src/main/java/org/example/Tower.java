package org.example;

import org.example.Enemy;

import java.util.List;

public abstract class Tower {
    protected int damage;
    protected int range;
    protected int fireRate;
    protected int cooldown;

    public Tower(int damage, int range, int fireRate) {
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
        this.cooldown = 0;
    }

    public boolean canAttack() {
        return cooldown == 0;
    }

    public void attack(List<Enemy> enemies) {
        if (canAttack()) {
            for (Enemy enemy : enemies) {
                // Calcular la distancia al enemigo
                double distance = Math.sqrt(Math.pow(enemy.getPositionX() - this.positionX, 2) +
                        Math.pow(enemy.getPositionY() - this.positionY, 2));

                // Si el enemigo está dentro del alcance
                if (distance <= range) {
                    enemy.takeDamage(damage);
                    System.out.println("Tower atacó a un enemigo. Vida restante del enemigo: " + enemy.getHealth());
                }
            }
            cooldown = fireRate;
        }
    }

    public void tick() {
        if (cooldown > 0) {
            cooldown--;
        }
    }

    public int getRange() {
        return range;
    }

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract void setPosition(int x, int y);
    public abstract void upgrade(); // Método para mejorar la torre
}
