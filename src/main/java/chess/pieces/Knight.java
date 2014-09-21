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
        // remove the ones that are occupied by a piece of the same color or out of bounds
        Iterator<Position> iterator = endPositions.iterator();
        while (iterator.hasNext()) {
            Position endPosition = iterator.next();
            final Piece occupyingPiece = gameState.getPieceAt(endPosition);
            final int row = endPosition.getRow();
            final int col = endPosition.getColumn();
            if (row > Position.MAX_ROW || row < Position.MIN_ROW || col > Position.MAX_COLUMN || col < Position.MIN_COLUMN) {
                iterator.remove();
            } else if (occupyingPiece != null && occupyingPiece.getOwner().equals(this.getOwner())) {
                iterator.remove();
            }
        }

        return endPositions;
    }
}
