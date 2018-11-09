package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

public class RookTest {
    @Test
    void TestiranjeTopa() {
        try {
            Rook b = new Rook("I9", ChessPiece.Color.WHITE);
        } catch(Exception e) {
            // Do nothing
        }
        try{
            Rook b1 = new Rook("E2", ChessPiece.Color.WHITE);
            b1.move("G3");
        }
        catch (Exception e) {
            // Do nothing
        }
        try{
            Rook b1 = new Rook("E2", ChessPiece.Color.WHITE);
            b1.move("I9");
        }
        catch (Exception e) {
            // Do nothing
        }
        try{
            Rook b1 = new Rook("E2", ChessPiece.Color.WHITE);
            b1.move("E5");
        }
        catch (Exception e) {
            // Do nothing
        }
    }
}
