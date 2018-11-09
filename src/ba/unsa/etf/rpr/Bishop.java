package ba.unsa.etf.rpr;

public class Bishop extends ChessPiece{
    private ChessPiece.Color boja;
    private String pozicija;

    @Override
    public boolean nedozvoljenaPozicija(String pozicija){
        if(this.pozicija.charAt(1)+(this.pozicija.charAt(0)-pozicija.charAt(0))==pozicija.charAt(1))
            return false;
        return true;                                                                 //da li je ovim regulisan i - ?????
    }

    Bishop(String pozicija, ChessPiece.Color boja){
        if(nepostojecaPozicija(pozicija))
            throw new IllegalArgumentException("Nepostojeća pozicija!\n");
        this.boja=boja;
        this.pozicija=pozicija;
    }

    @Override
    public ChessPiece.Color getColor() {
        return boja;
    }

    @Override
    public String getPosition() {
        return pozicija;
    }

    @Override
    public void move(String position) throws IllegalChessMoveException{
        if(nepostojecaPozicija(position))
            throw new IllegalArgumentException("Nepostojeća pozicija!\n");
        if(this.nedozvoljenaPozicija(position))
            throw new IllegalChessMoveException("Nedozvoljena pozicija!\n");
        pozicija=position;
    }

    @Override
    public boolean equals(Object o){
        Bishop figura = (Bishop) o;
        return (boja==figura.getColor());
    }

    /*@Override
    public boolean provjeriPutanju(String s){
        return true;
    }*/
}
