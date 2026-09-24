package org.example.board;

import org.example.Color;
import org.example.Coordinates;
import org.example.File;
import org.example.pieces.Piece;


public class BoardConsoleRender {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public void render(Board board) {
        for (int rank = 8; rank > 0; rank--) {
            String line = "";
            for (int file = 0; file < 8; file++) {
                Coordinates coordinates = new Coordinates(File.values()[file], rank);
                if (board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates) + ANSI_RESET;
                } else {
                    line += getPieceRender(board.getPiece(coordinates)) + ANSI_RESET;
                }
            }
            System.out.println(line);
        }
    }


    public String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark) {
        String result = sprite;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }

        return result;
    }


    private String getSpriteForEmptySquare(Coordinates coordinates) {
        return colorizeSprite("   ", Color.WHITE, Board.isSquareDark(coordinates));
    }

    private String getPieceRender(Piece piece) {
        return colorizeSprite(unicodeForPiece(piece), piece.color, Board.isSquareDark(piece.coordinates));
    }

    private String unicodeForPiece(Piece piece) {

        return switch (piece.getClass().getSimpleName()) {
            case "King" -> " ♚ ";
            case "Queen" -> " ♛ ";
            case "Rook" -> " ♜ ";
            case "Bishop" -> " ♝ ";
            case "Knight" -> " ♞ ";
            case "Pawn" -> " ♟ ";
            default -> "0";
        };
    }
}
