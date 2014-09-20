package chess.pieces;

import chess.Player;

import java.util.Map;

/**
 * The Pawn
 */
public class Pawn extends Piece {
    public Pawn(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'p';
    }

    @Override
    public Map<String, String> getLegalMoves() {
        return null;
    }
}
