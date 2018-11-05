package ba.unsa.etf.rpr;

public class King extends ChessPiece {
    private Colour boja;
    private String pozicija;

    King(String pozicija, Colour boja) throws IllegalChessMoveException{

        this.boja=boja;
        this.pozicija=pozicija;
    }

    @Override
    public Colour getColour() {
        return boja;
    }

    @Override
    public String getPosition() {
        return pozicija;
    }

    @Override
    public void move(String position) throws IllegalArgumentException {

    }
}
