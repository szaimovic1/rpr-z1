package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void move() {
        Knight k = new Knight("B1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("C3")
        );

    }

    @Test
    void testiranjeKonja() {
        try {
            Knight b = new Knight("I9", ChessPiece.Color.WHITE);
        } catch(Exception e) {
            // Do nothing
        }
        try{
            Knight b1 = new Knight("E2", ChessPiece.Color.WHITE);
            b1.move("H3");
        }
        catch (Exception e) {
            // Do nothing
        }
        try{
            Knight b1 = new Knight("E2", ChessPiece.Color.WHITE);
            b1.move("I9");
        }
        catch (Exception e) {
            // Do nothing
        }
        try{
            Knight b1 = new Knight("E2", ChessPiece.Color.WHITE);
            b1.move("F4");
            System.out.println(b1.getPosition());
        }
        catch (Exception e) {
            // Do nothing
        }
    }
}