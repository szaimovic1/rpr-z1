package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

public class QueenTest {
    @Test
    void tetsiranjeKraljice() {
        try {
            Queen b = new Queen("I9", ChessPiece.Color.WHITE);
        } catch(Exception e) {
            // Do nothing
        }
        try{
            Queen b1 = new Queen("E2", ChessPiece.Color.WHITE);
            b1.move("G3");
        }
        catch (Exception e) {
            // Do nothing
        }
        try{
            Queen b1 = new Queen("E2", ChessPiece.Color.WHITE);
            b1.move("I9");
        }
        catch (Exception e) {
            // Do nothing
        }
    }
}
