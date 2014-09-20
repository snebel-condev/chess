package chess.pieces;

import chess.Player;

import java.util.Map;

/**
 * The 'Bishop' class
 */
public class Bishop extends Piece {
    public Bishop(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'b';
    }

    @Override
    public Map<String, String> getLegalMoves() {
        return null;
    }
}
