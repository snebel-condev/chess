package chess.pieces;

import chess.GameState;
import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
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
    public List<Position> getPossibleEndPositions(Position start) {
        List<Position> endPositions = new ArrayList<Position>();
        // Possible Moves for Pawns:
        // - 1 space forward
        // - 2 spaces forward if in start position
        // - 1 space diagonally forward if capturing another piece
        final int initialRow = this.getOwner().equals(Player.White) ? 2 : 7;
        final int forwardDirection = this.getOwner().equals(Player.White) ? 1 : -1;
        final int currentRow = start.getRow();
        final char currentCol = start.getColumn();
        final int distanceFromFinalRow = Math.abs(Position.MAX_ROW - currentRow);

        if (distanceFromFinalRow >= 1) {
            endPositions.add(new Position(currentCol, currentRow + forwardDirection));
            if (currentRow == initialRow) {
                endPositions.add(new Position(currentCol, currentRow + 2 * forwardDirection));
            }
            // special case to consider in GameState for pawns: can only move diagonally
            // if capturing. Don't want a piece to know about the GameState, so we
            // add the possible diagonal moves here.
            if (currentCol < Position.MAX_COLUMN) {
                endPositions.add(new Position((char) (currentCol + 1), currentRow + forwardDirection));
            }
            if (currentCol > Position.MIN_COLUMN) {
                endPositions.add(new Position((char) (currentCol - 1), currentRow + forwardDirection));
            }
        }
        return endPositions;
    }

    @Override
    public List<Position> getLegalEndPositions(Position start, GameState gameState) {
        List<Position> endPositions = new ArrayList<Position>();
        final int initialRow = this.getOwner().equals(Player.White) ? 2 : 7;
        final int forwardDirection = this.getOwner().equals(Player.White) ? 1 : -1;
        final int currentRow = start.getRow();
        final char currentCol = start.getColumn();
        final int distanceFromFinalRow = Math.abs(Position.MAX_ROW - currentRow);

        if (distanceFromFinalRow >= 1) { // if not in final row
            Position upOnePosition = new Position(currentCol, currentRow + forwardDirection);
            Position upTwoPosition = new Position(currentCol, currentRow + 2 * forwardDirection);
            if (gameState.getPieceAt(upOnePosition) == null) {
                endPositions.add(upOnePosition);
                // if pawn is in its starting place and the two positions in front are empty
                if (currentRow == initialRow && gameState.getPieceAt(upTwoPosition) == null) {
                    endPositions.add(upTwoPosition);
                }
            }

            if (currentCol < Position.MAX_COLUMN) {
                Position diagonalPosition = new Position((char) (currentCol + 1), currentRow + forwardDirection);
                // if there's an opposite color piece up diagonally...
                Piece diagonalPiece = gameState.getPieceAt(diagonalPosition);
                if (diagonalPiece != null && !diagonalPiece.getOwner().equals(this.getOwner())) {
                    endPositions.add(diagonalPosition);
                }
            }
            if (currentCol > Position.MIN_COLUMN) {
                Position diagonalPosition = new Position((char) (currentCol - 1), currentRow + forwardDirection);
                Piece diagonalPiece = gameState.getPieceAt(diagonalPosition);
                if (diagonalPiece != null && !diagonalPiece.getOwner().equals(this.getOwner())) {
                    endPositions.add(diagonalPosition);
                }
            }
        }

        return endPositions;
    }
}
