package ba.unsa.etf.rpr;
import ba.unsa.etf.rpr.Board;

public class Queen extends ChessPiece {
    private Color boja;
    private String pozicija;

    @Override
    public boolean nedozvoljenaPozicija(String pozicija){
        if(this.pozicija.charAt(0)==pozicija.charAt(0)
                || this.pozicija.charAt(1)==pozicija.charAt(1)
          || (this.pozicija.charAt(1)+(this.pozicija.charAt(0)-pozicija.charAt(0))==pozicija.charAt(1)))
            return false;                                                             //valja to skontat...
        return true;                                                                 //da li je ovim regulisan i - ?????
    }

    Queen(String pozicija, Color boja){
        if(nepostojecaPozicija(pozicija))
            throw new IllegalArgumentException("Nepostojeća pozicija!\n");
        this.boja=boja;
        this.pozicija=pozicija;
    }

    @Override
    public Color getColor() {
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
        Queen figura = (Queen)o;
        return (boja==figura.getColor());
    }

    /*@Override
    public boolean provjeriPutanju(String s) {
        char i;
        if (pozicija.charAt(0) == s.charAt(0))
            for (i = (char)(pozicija.charAt(1) + 1); i < s.charAt(1); i++)
                if (Board::praznaPozicija(pozicija.charAt(0)+Character.toString(i)))
        return false;
        //if()
        return true;
    }*/
}
