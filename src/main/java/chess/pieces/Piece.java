package chess.pieces;

import chess.GameState;
import chess.Player;
import chess.Position;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A base class for chess pieces
 */
public abstract class Piece {
    private final Player owner;

    protected Piece(Player owner) {
        this.owner = owner;
    }

    public char getIdentifier() {
        char id = getIdentifyingCharacter();
        if (owner.equals(Player.White)) {
            return Character.toLowerCase(id);
        } else {
            return Character.toUpperCase(id);
        }
    }

    public Player getOwner() {
        return owner;
    }

    public List<Position> removeOutOfBoundsPositions(List<Position> endPositions) {
        Iterator<Position> iterator = endPositions.iterator();
        while (iterator.hasNext()) {
            Position endPosition = iterator.next();
            final int row = endPosition.getRow();
            final int col = endPosition.getColumn();
            if (row > Position.MAX_ROW || row < Position.MIN_ROW || col > Position.MAX_COLUMN || col < Position.MIN_COLUMN) {
                iterator.remove();
            }
        }
        return endPositions;
    }

    public void removeOccupiedPositions(List<Position> endPositions, GameState gameState) {
        Iterator<Position> iterator = endPositions.iterator();
        while (iterator.hasNext()) {
            final Piece occupyingPiece = gameState.getPieceAt(iterator.next());
            if (occupyingPiece != null && occupyingPiece.getOwner().equals(this.getOwner())) {
                iterator.remove();
            }
        }
    }

    protected abstract char getIdentifyingCharacter();

    public abstract List<Position> getLegalEndPositions(Position startPosition, GameState gameState);
}
