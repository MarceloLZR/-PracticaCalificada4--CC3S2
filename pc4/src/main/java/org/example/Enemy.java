package org.example;

public abstract class Enemy {
    protected int speed;
    protected int health;
    protected int reward;
    protected int positionX;
    protected int positionY;

    public Enemy(int speed, int health, int reward) {
        this.speed = speed;
        this.health = health;
        this.reward = reward;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int getReward() {
        return reward;
    }

    public boolean isAlive() {
        return health > 0;
    }

    // Método para mover al enemigo
    public void move() {
        // Implementación básica de movimiento, por ejemplo, avanzar en el camino
        // Aquí se actualizarían las coordenadas (positionX, positionY) del enemigo
    }
}



