package chess.pieces;

import chess.Player;

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
    public Map<String, String> getLegalMoves() {
        return null;
    }
}
