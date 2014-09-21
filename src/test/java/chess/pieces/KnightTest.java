package chess;

import chess.pieces.*;

import org.junit.Test;
import static junit.framework.Assert.*;
import java.util.List;

public class KnightTest {
    @Test
    public void testGetLegalEndPositions() {
        GameState gameState = new GameState();
        gameState.reset();
        Knight blackKnight = new Knight(Player.Black);
        Position startPosition = new Position("g8");

        List<Position> endPositions = blackKnight.getLegalEndPositions(startPosition, gameState);
        assertEquals(endPositions.size(), 2);
        assertTrue(endPositions.contains(new Position("h6")));
        assertTrue(endPositions.contains(new Position("f6")));
    }
}