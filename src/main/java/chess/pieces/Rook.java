package chess.pieces;

import chess.GameState;
import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
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
    public List<Position> getLegalEndPositions(Position startPosition, GameState gameState) {
        List<Position> endPositions = new ArrayList<Position>();
        // a rook can move in 4 possible directions
        for (int i = 1; i < 8; i++) {
            Position position = new Position(startPosition.getColumn(), startPosition.getRow() + i);
            boolean addPosition = addPositionIfValid(endPositions, position, gameState);
            if (!addPosition) { break; }
        }
        for (int i = 1; i < 8; i++) {
            Position position = new Position(startPosition.getColumn(), startPosition.getRow() - i);
            boolean addPosition = addPositionIfValid(endPositions, position, gameState);
            if (!addPosition) { break; }
        }
        for (int i = 1; i < 8; i++) {
            Position position = new Position((char) (startPosition.getColumn() + i), startPosition.getRow());
            boolean addPosition = addPositionIfValid(endPositions, position, gameState);
            if (!addPosition) { break; }
        }
        for (int i = 1; i < 8; i++) {
            Position position = new Position((char) (startPosition.getColumn() - i), startPosition.getRow());
            boolean addPosition = addPositionIfValid(endPositions, position, gameState);
            if (!addPosition) { break; }
        }
        this.removeOutOfBoundsPositions(endPositions);
        return endPositions;
    }

    // has intended side effect of modifying endPositions
    private boolean addPositionIfValid(List<Position> endPositions, Position position, GameState gameState) {
        Piece occupyingPiece = gameState.getPieceAt(position);
        if (occupyingPiece == null) {
            endPositions.add(position);
            return true;
        } else {
            if (!occupyingPiece.getOwner().equals(gameState.getCurrentPlayer())) {
                endPositions.add(position);
            }
            return false;
        }
    }
}
