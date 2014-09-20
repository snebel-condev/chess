package chess.pieces;

import chess.Player;

import java.util.Map;

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
    public Map<String, String> getLegalMoves() {
        return null;
    }
}
