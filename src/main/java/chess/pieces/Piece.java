package chess.pieces;

import chess.GameState;
import chess.Player;
import chess.Position;

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

    protected abstract char getIdentifyingCharacter();

    public abstract List<Position> getLegalEndPositions(Position startPosition, GameState gameState);
}
