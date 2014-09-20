package chess.pieces;

import chess.Player;

import java.util.Map;

/**
 * The Queen
 */
public class Queen extends Piece{
    public Queen(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'q';
    }

    @Override
    public Map<String, String> getLegalMoves() {
        return null;
    }
}
