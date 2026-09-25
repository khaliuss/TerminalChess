package org.example.pieces;

import org.example.Color;
import org.example.Coordinates;

import java.util.Set;

public class King extends Piece{
    public King(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMove() {
        return Set.of();
    }
}
