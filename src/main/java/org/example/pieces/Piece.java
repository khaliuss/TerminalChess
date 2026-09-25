package org.example.pieces;

import org.example.Color;
import org.example.Coordinates;
import org.example.board.Board;

import java.util.HashSet;
import java.util.Set;

public abstract class Piece {
    public final Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }

    public Set<Coordinates> getAvailableMoveSquare(Board board){

        Set<Coordinates> result = new HashSet<>();

        for(CoordinatesShift shift : getPieceMove()){
            if (coordinates.canShift(shift)){
                Coordinates newCoordinates = coordinates.shift(shift);

                if (isSquareAvailableForMove(newCoordinates,board)){
                    result.add(newCoordinates);
                }
            }
        }

        return result;
    }

    private boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        return board.isSquareEmpty(coordinates) || board.getPiece(coordinates).color != color ;
    }

    protected abstract Set<CoordinatesShift> getPieceMove();

}
