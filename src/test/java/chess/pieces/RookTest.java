package chess;

import chess.GameState;
import chess.pieces.*;

import org.junit.Test;
import static junit.framework.Assert.*;
import java.util.List;

public class RookTest {

    @Test
    public void testGetLegalEndPositions() {
        GameState gameState = new GameState();
        gameState.reset();
        Rook whiteRook = new Rook(Player.White);
        Position startPosition = new Position("e4");
        gameState.placePiece(whiteRook, new Position("e4"));

        List<Position> endPositions = whiteRook.getLegalEndPositions(startPosition, gameState);
        assertEquals(11, endPositions.size());
    }

}
