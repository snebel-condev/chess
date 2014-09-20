package chess.pieces;

import chess.GameState;
import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
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
    public List<Position> getPossibleEndPositions(Position position) {
        List<Position> endPositions = new ArrayList<Position>();
        return endPositions;
    }

    @Override
    public List<Position> getLegalEndPositions(Position startPosition, GameState gameState) {
        List<Position> endPositions = new ArrayList<Position>();
        return endPositions;
    }
}
