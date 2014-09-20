package chess.pieces;

import chess.Player;

import java.util.Map;

/**
 * The 'Rook' class
 */
public class Rook extends Piece {

    public Rook(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'r';
    }

    @Override
    public Map<String, String> getLegalMoves() {
        return null;
    }
}
