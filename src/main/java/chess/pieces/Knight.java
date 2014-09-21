package chess.pieces;

import chess.GameState;
import chess.Player;
import chess.Position;

import java.util.*;

/**
 * The Knight class
 */
public class Knight extends Piece {
    public Knight(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'n';
    }

    @Override
    public List<Position> getLegalEndPositions(Position startPosition, GameState gameState) {
        List<Position> endPositions = new ArrayList<Position>();
        // add the positions for 2 over and 1 across in all directions,
        final int currentCol = startPosition.getColumn();
        final int currentRow = startPosition.getRow();
        endPositions.add(new Position((char) (currentCol + 1), currentRow + 2));
        endPositions.add(new Position((char) (currentCol - 1), currentRow + 2));
        endPositions.add(new Position((char) (currentCol + 1), currentRow - 2));
        endPositions.add(new Position((char) (currentCol - 1), currentRow - 2));
        endPositions.add(new Position((char) (currentCol + 2), currentRow + 1));
        endPositions.add(new Position((char) (currentCol + 2), currentRow - 1));
        endPositions.add(new Position((char) (currentCol - 2), currentRow + 1));
        endPositions.add(new Position((char) (currentCol - 2), currentRow - 1));

        this.removeOutOfBoundsPositions(endPositions);
        this.removeOccupiedPositions(endPositions, gameState);
        return endPositions;
    }
}
