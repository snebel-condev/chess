package chess.pieces;

import chess.GameState;
import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The King class
 */
public class King extends Piece {
    public King(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'k';
    }

    @Override
    public List<Position> getLegalEndPositions(Position startPosition, GameState gameState) {
        List<Position> endPositions = new ArrayList<Position>();
        // TODO: deal with king moving into check
        final char currentCol = startPosition.getColumn();
        final int currentRow = startPosition.getRow();
        endPositions.add(new Position(currentCol, currentRow + 1));
        endPositions.add(new Position(currentCol, currentRow - 1));
        endPositions.add(new Position((char) (currentCol + 1), currentRow));
        endPositions.add(new Position((char) (currentCol - 1), currentRow));
        endPositions.add(new Position((char) (currentCol + 1), currentRow + 1));
        endPositions.add(new Position((char) (currentCol + 1), currentRow - 1));
        endPositions.add(new Position((char) (currentCol - 1), currentRow + 1));
        endPositions.add(new Position((char) (currentCol - 1), currentRow - 1));

        this.removeOutOfBoundsPositions(endPositions);
        this.removeOccupiedPositions(endPositions, gameState);
        return endPositions;
    }
}
