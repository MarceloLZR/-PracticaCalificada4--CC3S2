import org.example.FakeScoreDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeScoreDatabaseTest {
    // Uso del fake en pruebas
    @Test
    public void testSaveScore() {
        FakeScoreDatabase fakeDb = new FakeScoreDatabase();
        fakeDb.saveScore(100);

        assertEquals(100, fakeDb.getScore());
    }

}
