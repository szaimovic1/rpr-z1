package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

public class BishopTest {
    @Test
    void testForBishop() {
        try {
            Bishop b = new Bishop("I9", ChessPiece.Color.WHITE);
        } catch(Exception e) {
            // Do nothing
        }
        try{
            Bishop b1 = new Bishop("E2", ChessPiece.Color.WHITE);
            b1.move("H3");
        }
        catch (Exception e) {
            // Do nothing
        }
        try{
            Bishop b1 = new Bishop("E2", ChessPiece.Color.WHITE);
            b1.move("I9");
        }
        catch (Exception e) {
            // Do nothing
        }
        try{
            Bishop b1 = new Bishop("E2", ChessPiece.Color.WHITE);
            b1.move("F3");
        }
        catch (Exception e) {
            // Do nothing
        }
    }
}
