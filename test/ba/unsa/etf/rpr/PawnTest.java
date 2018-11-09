package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @org.junit.jupiter.api.Test
    void move1() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("E4")
        );
    }

    @Test
    void testiranjePjesaka() {
        try {
            Pawn b = new Pawn("I9", ChessPiece.Color.WHITE);
        } catch(Exception e) {
            // Do nothing
        }
        try{
            Pawn b1 = new Pawn("E2", ChessPiece.Color.WHITE);
            b1.move("G3");
        }
        catch (Exception e) {
            // Do nothing
        }
        try{
            Pawn b1 = new Pawn("E2", ChessPiece.Color.WHITE);
            b1.move("I9");
        }
        catch (Exception e) {
            // Do nothing
        }
        try{
            Pawn b1 = new Pawn("D7", ChessPiece.Color.BLACK);
            b1.move("D5");
        }
        catch (Exception e) {
            // Do nothing
        }
    }
}