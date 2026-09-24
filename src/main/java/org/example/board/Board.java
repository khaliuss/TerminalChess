package org.example.board;


import org.example.Color;
import org.example.Coordinates;
import org.example.File;
import org.example.pieces.*;

import java.util.HashMap;

public class Board {

    private final HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public void setPieces(Coordinates coordinates,Piece piece) {
        piece.coordinates = coordinates;
        pieces.put(coordinates,piece);
    }

    public void setupDefaultPiecesPosition(){
        defaultPawnPosition();
        defaultRookPosition();
        defaultKnightPosition();
        defaultBishopPosition();
        defaultQueenPosition();
        defaultKingPosition();

    }

    private void defaultQueenPosition() {
        Coordinates whiteQueenCoordinates = new Coordinates(File.D,1);
        setPieces(whiteQueenCoordinates,new Queen(Color.WHITE,whiteQueenCoordinates));

        Coordinates blackQueenCoordinates2 = new Coordinates(File.D,8);
        setPieces(blackQueenCoordinates2,new Queen(Color.BLACK,blackQueenCoordinates2));
    }

    private void defaultKingPosition() {
        Coordinates whiteKingCoordinates = new Coordinates(File.E,1);
        setPieces(whiteKingCoordinates,new King(Color.WHITE,whiteKingCoordinates));

        Coordinates blackKingCoordinates = new Coordinates(File.E,8);
        setPieces(blackKingCoordinates,new King(Color.BLACK,blackKingCoordinates));
    }

    private void defaultBishopPosition() {
        Coordinates whiteBishopCoordinates = new Coordinates(File.C,1);
        setPieces(whiteBishopCoordinates,new Bishop(Color.WHITE,whiteBishopCoordinates));
        Coordinates whiteBishopCoordinates2 = new Coordinates(File.F,1);
        setPieces(whiteBishopCoordinates2,new Bishop(Color.WHITE,whiteBishopCoordinates2));

        Coordinates blackBishopCoordinates = new Coordinates(File.C,8);
        setPieces(blackBishopCoordinates,new Bishop(Color.BLACK,blackBishopCoordinates));
        Coordinates blackBishopCoordinates2 = new Coordinates(File.F,8);
        setPieces(blackBishopCoordinates2,new Bishop(Color.BLACK,blackBishopCoordinates2));
    }

    private void defaultKnightPosition() {
        Coordinates whiteKnightCoordinates = new Coordinates(File.B,1);
        setPieces(whiteKnightCoordinates,new Knight(Color.WHITE,whiteKnightCoordinates));
        Coordinates whiteKnightCoordinates2 = new Coordinates(File.G,1);
        setPieces(whiteKnightCoordinates2,new Knight(Color.WHITE,whiteKnightCoordinates2));

        Coordinates blackKnightCoordinates = new Coordinates(File.B,8);
        setPieces(blackKnightCoordinates,new Knight(Color.BLACK,blackKnightCoordinates));
        Coordinates blackKnightCoordinates2 = new Coordinates(File.G,8);
        setPieces(blackKnightCoordinates2,new Knight(Color.BLACK,blackKnightCoordinates2));
    }


    private void defaultRookPosition() {
        Coordinates whiteRookCoordinates = new Coordinates(File.A,1);
        setPieces(whiteRookCoordinates,new Rook(Color.WHITE,whiteRookCoordinates));
        Coordinates whiteRookCoordinates2 = new Coordinates(File.H,1);
        setPieces(whiteRookCoordinates2,new Rook(Color.WHITE,whiteRookCoordinates2));

        Coordinates blackRookCoordinates = new Coordinates(File.A,8);
        setPieces(blackRookCoordinates,new Rook(Color.BLACK,blackRookCoordinates));
        Coordinates blackRookCoordinates2 = new Coordinates(File.H,8);
        setPieces(blackRookCoordinates2,new Rook(Color.BLACK,blackRookCoordinates2));
    }

    public boolean isSquareEmpty(Coordinates coordinates){
        return !pieces.containsKey(coordinates);
    }

    public Piece getPiece(Coordinates coordinates){
        return pieces.get(coordinates);
    }

    private void defaultPawnPosition() {
        for (File file : File.values()) {
            Coordinates whiteCoordinates = new Coordinates(file,2);
            setPieces(whiteCoordinates,new Pawn(Color.WHITE,whiteCoordinates));

            Coordinates blackCoordinates = new Coordinates(file,7);
            setPieces(blackCoordinates,new Pawn(Color.BLACK,blackCoordinates));
        }

    }


    public static boolean isSquareDark(Coordinates coordinates){
        return ((coordinates.file.ordinal()+1) + coordinates.rank) % 2 == 0;
    }

}
