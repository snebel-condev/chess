package chess;

import chess.pieces.Pawn;
import chess.pieces.Piece;
import org.junit.Test;
import static junit.framework.Assert.*;
import java.util.List;
import java.util.Map;

public class PawnTest {

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

        startPosition = new Position("h3");
        gameState.placePiece(whitePawn, startPosition);
        gameState.placePiece(new Pawn(Player.Black), new Position("h4"));
        endPositions = whitePawn.getLegalEndPositions(startPosition, gameState);
        assertEquals(endPositions.size(), 0);
    }
}