package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    ChessPiece() {}
//Za slučaj pozicije van raspoloživih pozicija. Provjera je ista za sve figure.
    boolean nepostojecaPozicija(String position){
        if(position.length()<=1) return true;
        if(position.charAt(0) < 'A' || (position.charAt(0)  > 'H' && position.charAt(0) < 'a')
                || position.charAt(0) > 'h')
            return true;
        if(position.charAt(1)  < '1' || position.charAt(1) > '8')
            return true;
        return false;
    }
//Za izvedene klase je implementirana na specifičan način...
    @Override
    public abstract boolean equals(Object o);
    public enum Color{
        BLACK, WHITE
    }
    public abstract String getPosition();
    public abstract Color getColor();
    public abstract void move(String position) throws IllegalChessMoveException;
//Provjera da li figura može biti na određenoj poziciji.
    public abstract boolean nedozvoljenaPozicija(String pozicija);
}
