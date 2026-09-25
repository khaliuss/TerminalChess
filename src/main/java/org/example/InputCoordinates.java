package org.example;

import org.example.board.Board;
import org.example.pieces.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {

    private static Scanner scanner = new Scanner(System.in);

    private static Coordinates input() {
        while (true) {
            System.out.println("Please enter coordinates ex: a1");

            String line = scanner.nextLine();

            if (line.length() != 2) {
                System.out.println("Invalid format");
                continue;
            }

            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);

            if (!Character.isLetter(fileChar)) {
                System.out.println("Invalid format");
                continue;
            }

            int rank = Character.getNumericValue(rankChar );
            if (Character.isDigit(rank)) {
                System.out.println("Invalid format");
                continue;
            }

            if (rank < 1 || rank > 8) {
                System.out.println("Invalid format");
                continue;
            }

            File file = File.fromChar(fileChar);
            if (file == null){
                System.out.println("Invalid format");
                continue;
            }

            return new Coordinates(file,rank);
        }
    }

    public static Coordinates inputPieceCoordinates(Color color, Board board ){
        while (true){
            System.out.println("Enter coordinates piece to move");
            Coordinates coordinates = input();

            if (board.isSquareEmpty(coordinates)){
                System.out.println("Empty Square");
                continue;
            }

            Piece piece = board.getPiece(coordinates);
            if (piece.color != color){
                System.out.println("You cant move bot's piece");
                continue;
            }

            Set<Coordinates> availableMoveSquare= piece.getAvailableMoveSquare(board);
            if (availableMoveSquare.isEmpty()){
                System.out.println("Blocked piece!");
                continue;
            }

            return coordinates;
        }
    }

    public static Coordinates inputMoveCoordinates(Set<Coordinates> availableMoveSquare ){
        while (true){
            System.out.println("Here all available coordinates move to: "+availableMoveSquare);
            Coordinates coordinates = input();
            if (!availableMoveSquare.contains(coordinates)){
                System.out.println("You can't move to this place");
                continue;
            }
            return coordinates;
        }
    }


}
