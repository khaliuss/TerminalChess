package org.example;


import org.example.board.Board;
import org.example.board.BoardConsoleRender;

public class Main {
    static void main() {
        Board board = new Board();
        board.setupDefaultPiecesPosition();
        BoardConsoleRender render = new BoardConsoleRender();

        render.render(board);

    }
}
