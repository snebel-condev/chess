package chess;

import chess.pieces.Pawn;
import chess.pieces.Piece;
import org.junit.Test;
import static junit.framework.Assert.*;
import java.util.List;
import java.util.Map;

public class PawnTest {

    @Test
    public void testGetPossibleEndPositions() {
        Pawn whitePawn = new Pawn(Player.White);
        Position startPosition = new Position('e', 2);
        List<Position> endPositions = whitePawn.getPossibleEndPositions(startPosition);
        assertEquals(endPositions.size(), 4);
        assertTrue(endPositions.contains(new Position('e', 3)));
        assertTrue(endPositions.contains(new Position('e', 4)));
        assertTrue(endPositions.contains(new Position('f', 3)));
        assertTrue(endPositions.contains(new Position('d', 3)));

        Pawn blackPawn = new Pawn(Player.Black);
        // black pawn on the edge
        startPosition = new Position('a', 6);
        endPositions = blackPawn.getPossibleEndPositions(startPosition);
        assertEquals(endPositions.size(), 2);
        assertTrue(endPositions.contains(new Position('a', 5)));
        assertTrue(endPositions.contains(new Position('b', 5)));

        // black pawn on row 2
        startPosition = new Position('e', 2);
        endPositions = blackPawn.getPossibleEndPositions(startPosition);
        assertEquals(endPositions.size(), 3);
        assertTrue(endPositions.contains(new Position('e', 1)));
        assertTrue(endPositions.contains(new Position('f', 1)));
        assertTrue(endPositions.contains(new Position('d', 1)));
    }

    @Test
    public void testGetLegalEndPositions() {
        GameState gameState = new GameState();
        gameState.reset();
        Pawn whitePawn = new Pawn(Player.White);
        Position startPosition = new Position("e2");
        List<Position> endPositions = whitePawn.getLegalEndPositions(startPosition, gameState);

        assertEquals(endPositions.size(), 2);
        assertTrue(endPositions.contains(new Position("e3")));
        assertTrue(endPositions.contains(new Position("e4")));
    }
}