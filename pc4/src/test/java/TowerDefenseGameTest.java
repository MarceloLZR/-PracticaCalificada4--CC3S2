import org.example.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TowerDefenseGameTest {
    @Test
    public void testTowerAttacksEnemy() {
        // Crear mocks
        Enemy mockEnemy = Mockito.mock(Enemy.class);
        Tower mockTower = Mockito.mock(Tower.class);

        // Configurar el comportamiento del mock
        when(mockEnemy.isAlive()).thenReturn(true);
        when(mockTower.canAttack()).thenReturn(true);

        // Interacción entre objetos
        mockTower.attack(mockEnemy);

        // Verificar la interacción
        verify(mockTower).attack(mockEnemy);
        verify(mockEnemy).takeDamage(anyInt());
    }
    @Test
    public void testGenerateEnemies() {
        // Crear un stub de la clase Wave
        Wave waveStub = new Wave(1) {
            @Override
            public List<Enemy> generateEnemies(int waveNumber) {
                return List.of(new BasicEnemy(), new FastEnemy());
            }
        };

        // Verificar que los enemigos generados sean los esperados
        List<Enemy> enemies = waveStub.generateEnemies(1);
        assertEquals(2, enemies.size());
        assertTrue(enemies.get(0) instanceof BasicEnemy);
        assertTrue(enemies.get(1) instanceof FastEnemy);
    }

}
