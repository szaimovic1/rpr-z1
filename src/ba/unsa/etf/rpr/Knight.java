package ba.unsa.etf.rpr;

public class Knight extends  ChessPiece{
    private ChessPiece.Color boja;
    private String pozicija;

    private boolean nedozvoljenaPozicija(String pozicija){
        if(((this.pozicija.charAt(0)+1==pozicija.charAt(0) || this.pozicija.charAt(0)-1==pozicija.charAt(0)) &&
                (this.pozicija.charAt(1)+2==pozicija.charAt(1) || this.pozicija.charAt(1)-2==pozicija.charAt(1)))
            || ((this.pozicija.charAt(1)+1==pozicija.charAt(1) || this.pozicija.charAt(1)-1==pozicija.charAt(1)) &&
                (this.pozicija.charAt(0)+2==pozicija.charAt(0) || this.pozicija.charAt(0)-2==pozicija.charAt(0))))
            return false;                                                //upozorenje-can be simplified..
        return true;                                                     //kako najlakse razmotriti sve kombinacije?????
    }

    Knight(String pozicija, ChessPiece.Color boja){
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
        if(nedozvoljenaPozicija(position))
            throw new IllegalChessMoveException("Nedozvoljena pozicija!\n");
        pozicija=position;
    }

    @Override
    public boolean equals(Object o){
        Knight figura = (Knight) o;
        return (boja==figura.getColor());
    }

    @Override
    public boolean provjeriPutanju(String s){
        return true;
    }
}
