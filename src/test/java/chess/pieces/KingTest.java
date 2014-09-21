package chess;

import chess.pieces.*;

import org.junit.Test;
import static junit.framework.Assert.*;
import java.util.List;

public class KingTest {

    @Test
    public void testGetLegalEndPositions() {
        GameState gameState = new GameState();
        King whiteKing = new King(Player.White);
        Position startPosition = new Position("a4");
        gameState.placePiece(whiteKing, startPosition);
        List<Position> endPositions = whiteKing.getLegalEndPositions(startPosition, gameState);
        assertEquals(5, endPositions.size());

        gameState.reset();
        startPosition = new Position("e1");
        endPositions = whiteKing.getLegalEndPositions(startPosition, gameState);
        assertEquals(0, endPositions.size());
    }
}

